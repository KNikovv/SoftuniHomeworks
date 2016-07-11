package exam.components;

public abstract class GeneralComponent {

    private String name;
    private String type;

    protected GeneralComponent(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setType(String type) {
        this.type = type;
    }
}
