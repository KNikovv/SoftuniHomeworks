package google;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.setParentName(parentName);
        this.setParentBirthday(parentBirthday);
    }
    public String getParentName() {
        return parentName;
    }

    private void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    private void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
    @Override
    public String toString() {
        StringBuilder parentBuilder = new StringBuilder();
        parentBuilder.append(String.format("%s %s\n",this.getParentName(),this.getParentBirthday()));
        String parentOutput = parentBuilder.toString();
        return parentOutput;
    }
}
