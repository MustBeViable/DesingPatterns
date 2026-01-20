public class Employee implements Organization{
    private final String NAME;
    private double salary;

    public Employee(String name, double salary) {
        this.NAME = name;
        this.salary = salary;
    }


    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public Employee addEmployee(String name, double salary) {
        return null;
    }

    @Override
    public boolean removeEmployee(String name) {
        return false;
    }

    @Override
    public Department addDepartment(String name) {
        return null;
    }

    @Override
    public boolean removeDepartment(String name) {
        return false;
    }

    @Override
    public double currentSalary() {
        return this.salary;
    }

    @Override
    public String printStructure(int level) {
        StringBuilder xml = new StringBuilder();
        xml.append(Organization.indent(level)).append("<employee>\n");
        xml.append(Organization.indent(level + 1)).append("<name>").append(NAME).append("</name>\n");
        xml.append(Organization.indent(level + 1)).append("<salary>").append(salary).append("</salary>\n");
        xml.append(Organization.indent(level)).append("</employee>\n");
        return xml.toString();
    }
}
