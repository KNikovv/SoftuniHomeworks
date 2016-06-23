package google;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.setChildName(childName);
        this.setChildBirthday(childBirthday);
    }

    public String getChildName() {
        return childName;
    }

    private void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    private void setChildBirthday(String childBirthday) {
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        StringBuilder childBuilder = new StringBuilder();
        childBuilder.append(String.format("%s %s\n",this.getChildName(),this.getChildBirthday()));
        String childOutput = childBuilder.toString();
        return childOutput;
    }
}
