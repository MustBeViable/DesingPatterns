public interface Organization {

    /**
     * Method to get correct indentation.
     * @param level is the multiplier how deep indentation is
     * @return 2 spaces times level (repeat is a String object method)
     */

    static String indent(int level) {
        return "  ".repeat(level);
    }
    String getName();
    Employee addEmployee(String name, double salary);
    boolean removeEmployee(String name);
    Department addDepartment(String name);
    boolean removeDepartment(String name);
    double currentSalary();
    String printStructure(int level);

}
