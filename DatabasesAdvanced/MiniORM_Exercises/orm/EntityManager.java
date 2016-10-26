package orm;

import persistance.Column;
import persistance.Entity;
import persistance.Id;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class EntityManager implements DbContext, AutoCloseable {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <E> boolean persist(E entity) throws SQLException, IllegalAccessException {
        this.doCreate(entity);
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        return value == null || (Long) value <= 0 ?
                this.doInsert(entity) :
                this.doUpdate(entity);
    }


    @Override
    public <E> Iterable<E> find(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException {
        return this.find(table, "1");
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where) throws SQLException, IllegalAccessException,
            InstantiationException {
        String select = "SELECT * FROM " + this.getTableName(table) + " WHERE " + where;

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<E> entities = new LinkedList<E>();
        while (resultSet.next()) {
            E entity = table.newInstance();
            this.fillEntity(entity, resultSet);
            entities.add(entity);
        }
        resultSet.close();
        statement.close();
        return entities;
    }

    @Override
    public <E> E findFirst(Class<E> table) throws IllegalAccessException, SQLException, InstantiationException {

        Iterator<E> e = this.find(table, "1 LIMIT 1").iterator();

        return e.next();
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException,
            InstantiationException {
        Iterator<E> e = this.find(table, where + " LIMIT 1").iterator();

        return e.next();
    }

    @Override
    public <E> void deleteObjById(Class<E> table, long id) throws SQLException {
        String delete = "DELETE FROM " + this.getTableName(table) + " WHERE id = " + id;

        Statement statement = this.connection.createStatement();
        statement.executeUpdate(delete);

        statement.close();
    }

    private <E> void fillEntity(E entity, ResultSet resultSet) throws IllegalAccessException,
            SQLException {

        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            String dbType = this.getTypeAsDbType(field);
            field.set(entity, dbType.equals("TINYINT") ?
                    (resultSet.getBoolean(fieldName))
                    : resultSet.getObject(fieldName));
        }
    }

    private <E> String getTableName(Class<E> entity) {
        String tableName = entity.getSimpleName();

        if (entity.isAnnotationPresent(Entity.class)) {
            Entity e = entity.getAnnotation(Entity.class);
            tableName = e.name();
        }

        return tableName;
    }

    private String getFieldName(Field field) {
        String fieldName = field.getName();

        if (field.isAnnotationPresent(Column.class)) {
            Column c = field.getAnnotation(Column.class);
            fieldName = c.name();
        }

        return fieldName;
    }

    private Field getId(Class c) {
        Field idField = Arrays.stream(c.getDeclaredFields())
                .filter(p -> p.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        return idField;
    }

    private <E> boolean doCreate(E entity) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(
                "CREATE TABLE IF NOT EXISTS %s (", this.getTableName(entity.getClass())));

        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            String dbType = this.getTypeAsDbType(field);
            builder.append("`").append(fieldName).append("`").append(" ").append(dbType).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(");");

        return this.connection.prepareStatement(builder.toString()).execute();
    }

    private <E> boolean doInsert(E entity) throws IllegalAccessException, SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("INSERT INTO %s (", this.getTableName(entity.getClass())));

        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder values = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Id.class)) {
                String fieldName = this.getFieldName(field);
                Object value = field.get(entity);
                builder.append("`").append(fieldName).append("`").append(", ");
                if (value instanceof Date) {
                    value = new SimpleDateFormat("yyyy-MM-dd").format(value);
                }
                if (value instanceof Boolean) {
                    value = (Boolean) value ? 1 : 0;
                }
                values.append("'").append(value).append("'").append(", ");
            }
        }
        builder.setLength(builder.length() - 2);
        builder.append(") VALUES (");
        values.setLength(values.length() - 2);
        values.append(");");
        builder.append(values);

        return this.connection.prepareStatement(builder.toString()).execute();
    }

    private <E> boolean doUpdate(E entity) throws IllegalAccessException, SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("UPDATE %s", this.getTableName(entity.getClass())));

        builder.append(" SET ");
        Field[] fields = entity.getClass().getDeclaredFields();
        String where = " WHERE ";
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            Object value = field.get(entity);
            if (field.isAnnotationPresent(Id.class)) {
                where += fieldName + " = " + value;
                continue;
            }

            value = value instanceof Date ?
                    new SimpleDateFormat("yyyy-MM-dd").format(value) :
                    value;
            value = value instanceof Boolean ? ((Boolean) value ? 1 : 0) : value;

            builder.append("`").append(fieldName).append("`").append(" = ")
                    .append("'").append(value).append("'").append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(where);

        return this.connection.prepareStatement(builder.toString()).execute();
    }

    private String getTypeAsDbType(Field field) {
        field.setAccessible(true);
        if (field.isAnnotationPresent(Id.class)) {
            return "BIGINT PRIMARY KEY AUTO_INCREMENT";
        }
        switch (field.getType().getSimpleName().toLowerCase()) {
            case "int":
                return "INT";
            case "long":
                return "LONG";
            case "date":
                return "DATE";
            case "string":
                return "VARCHAR(50)";
            case "boolean":
                return "TINYINT";
            default:
                throw new NotImplementedException();
        }
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
