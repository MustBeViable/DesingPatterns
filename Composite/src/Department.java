import java.util.ArrayList;
import java.util.Iterator;

public class Department implements Organization {
    private final String NAME;
    private final ArrayList<Organization> childNodes = new ArrayList<>();

    public Department(String name) {
        this.NAME = name;
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public Employee addEmployee(String name, double salary) {
        Employee newEmployee = new Employee(name, salary);
        childNodes.add(newEmployee);
        return newEmployee;
    }

    @Override
    public boolean removeEmployee(String name) {
        for (Organization node : childNodes) {
            if (node instanceof Department) {
                boolean found = node.removeEmployee(name);
                if (found) {
                    return true;
                }
            }
            if (node.getName().equals(name) && node instanceof Employee) {
                this.childNodes.remove(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public Department addDepartment(String name) {
        Department newDepartment = new Department(name);
        this.childNodes.add(newDepartment);
        return newDepartment;
    }

    @Override
    public boolean removeDepartment(String name) {
        for (Organization node : childNodes) {
            if (node.getName().equals(name) && node instanceof Department) {
                this.childNodes.remove(node);
                return true;
            }
            if (node instanceof Department) {
                boolean found = node.removeDepartment(name);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double currentSalary() {
        double totalSalary = 0.0;
        for (Organization node : childNodes) {
            if (node instanceof Department) {
                totalSalary += node.currentSalary();
            }
            else {
                totalSalary += node.currentSalary();
            }
        }
        return totalSalary;
    }


    @Override
    public String printStructure(int level) {
        StringBuilder xml = new StringBuilder();
        xml.append(Organization.indent(level)).append("<" + this.NAME + ">\n");

        for (Organization node : childNodes) {
            xml.append(node.printStructure(level + 1));
        }

        xml.append(Organization.indent(level)).append("</" + this.NAME + ">\n");
        return xml.toString();
    }
}
