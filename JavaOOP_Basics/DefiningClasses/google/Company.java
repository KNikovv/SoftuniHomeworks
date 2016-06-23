package google;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company(String companyName, String companyDepartment, double salary) {
        this.setCompanyName(companyName);
        this.setCompanyDepartment(companyDepartment);
        this.setSalary(salary);
    }

    public String getCompanyName() {
        return companyName;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    private void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder companyBuilder = new StringBuilder();
        companyBuilder.append("Company:\n");
        if(this.getCompanyName()!=""){
            companyBuilder.append(String.format("%s %s %.2f\n",this.getCompanyName(),this.getCompanyDepartment(),this.getSalary()));
        }
        String companyOutput = companyBuilder.toString();
        return companyOutput;
    }
}
