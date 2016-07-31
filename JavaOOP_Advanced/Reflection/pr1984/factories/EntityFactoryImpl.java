package pr1984.factories;

import pr1984.annotations.Inject;
import pr1984.factories.interfaces.EntityFactory;
import pr1984.models.interfaces.Entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EntityFactoryImpl implements EntityFactory {

    private static final String ENTITY_PATH = "pr1984.models.";

    private String id;
    private String name;
    private Integer income;
    private Integer turnover;
    private Integer revenue;

    @Override
    @SuppressWarnings("unchecked")
    public Entity createEntity(String[] args) throws ReflectiveOperationException {
        this.initializeInnerValues(args);
        Entity entity;
        Class<Entity> entityClass = (Class<Entity>) Class.forName(ENTITY_PATH + args[0]);
        Constructor ctorObservable = entityClass.getDeclaredConstructor();
        entity = (Entity) ctorObservable.newInstance();
        this.injectDependencies(entity, entityClass);
        return entity;
    }

    private void initializeInnerValues(String[] args) {
        this.id = args[1];
        this.name = args[2];
        switch (args.length) {
            case 4:
                this.income = Integer.valueOf(args[3]);
                break;
            case 5:
                this.turnover = Integer.valueOf(args[3]);
                this.revenue = Integer.valueOf(args[4]);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void clearValues() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            field.set(this, null);
        }
    }

    private void injectDependencies(Entity observable, Class<Entity> observableClass) throws
            IllegalAccessException {

        Field[] entityFields = observableClass.getDeclaredFields();
        Field[] theseFields = this.getClass().getDeclaredFields();
        Field[] entityParentFields = observableClass.getSuperclass().getDeclaredFields();

        this.injectParentFields(observable, theseFields, entityParentFields);
        this.injectEntityFields(observable, entityFields, theseFields);

        this.clearValues();
    }

    private void injectParentFields(Entity observable, Field[] theseFields, Field[] entityParentFields) throws
            IllegalAccessException {
        entityParentFields[0].setAccessible(true);
        entityParentFields[1].setAccessible(true);
        entityParentFields[0].set(observable, theseFields[1].get(this));
        entityParentFields[1].set(observable, theseFields[2].get(this));
    }

    private void injectEntityFields(Entity observable, Field[] observableFields, Field[] theseFields) throws
            IllegalAccessException {
        for (Field entityField : observableFields) {
            if (!entityField.isAnnotationPresent(Inject.class)) {
                continue;
            }

            entityField.setAccessible(true);
            for (Field thisClassField : theseFields) {
                if (thisClassField.getType().equals(entityField.getType()) &&
                        thisClassField.getName().equals(entityField.getName())) {

                    thisClassField.setAccessible(true);
                    entityField.set(observable, thisClassField.get(this));
                }
            }
        }
    }
}
