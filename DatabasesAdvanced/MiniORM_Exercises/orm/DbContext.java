package orm;

import java.sql.SQLException;

public interface DbContext {

    <E> boolean persist(E entity) throws SQLException, IllegalAccessException;

    <E> Iterable<E> find(Class<E> table) throws IllegalAccessException,
            SQLException,
            InstantiationException;

    <E> Iterable<E> find(Class<E> table, String where) throws
            SQLException,
            IllegalAccessException,
            InstantiationException;

    <E> E findFirst(Class<E> table) throws IllegalAccessException,
            SQLException,
            InstantiationException;

    <E> E findFirst(Class<E> table, String where) throws
            SQLException,
            IllegalAccessException,
            InstantiationException;

    <E> void deleteObjById(Class<E> table,long id) throws SQLException;
}
