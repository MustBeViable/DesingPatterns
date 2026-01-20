public class Main {
    public static void main(String[] args) {

        Department organization = new Department("Organization");

        organization.addEmployee("Alice", 3200.00);
        organization.addEmployee("Bob", 2800.00);
        organization.addEmployee("Charlie", 4100.50);

        organization.addDepartment("IT");
        organization.addDepartment("HR");
        organization.addDepartment("Sales");

        System.out.println("=== TOTAL SALARY (Organization) ===");
        System.out.println(organization.currentSalary());

        System.out.println("\n=== STRUCTURE (Organization as XML) ===");
        System.out.println(organization.printStructure(0));

        System.out.println("\n=== REMOVE EMPLOYEE: Bob ===");
        boolean removedBob = organization.removeEmployee("Bob");
        System.out.println("Removed Bob: " + removedBob);

        System.out.println("\n=== REMOVE DEPARTMENT: HR ===");
        boolean removedHr = organization.removeDepartment("HR");
        System.out.println("Removed HR: " + removedHr);

        System.out.println("\n=== TOTAL SALARY AFTER REMOVALS ===");
        System.out.println(organization.currentSalary());

        System.out.println("\n=== STRUCTURE AFTER REMOVALS (XML) ===");
        System.out.println(organization.printStructure(0));

        Organization itDept = new Department("IT_Department_Test");
        Employee dana = itDept.addEmployee("Dana", 5000.00);
        Organization secDept = itDept.addDepartment("Security");
        secDept.addEmployee("Richard", 6500.00);
        secDept.addEmployee(dana.getName(), dana.currentSalary());


        System.out.println("\n=== TOTAL SALARY (IT_Department_Test) ===");
        System.out.println(itDept.currentSalary());

        System.out.println("\n=== STRUCTURE (IT_Department_Test as XML) ===");
        System.out.println(itDept.printStructure(0));

        System.out.println("\n=== REMOVE EMPLOYEE: Dana (IT_Department_Test) ===");
        System.out.println("Removed Dana: " + itDept.removeEmployee("Dana"));

        System.out.println("\n=== REMOVE DEPARTMENT: Security (IT_Department_Test) ===");
        System.out.println("Removed Security: " + itDept.removeDepartment("Security"));

        System.out.println("\n=== TOTAL SALARY (IT_Department_Test) AFTER REMOVALS ===");
        System.out.println(itDept.currentSalary());

        System.out.println("\n=== STRUCTURE (IT_Department_Test) AFTER REMOVALS ===");
        System.out.println(itDept.printStructure(0));
    }
}
