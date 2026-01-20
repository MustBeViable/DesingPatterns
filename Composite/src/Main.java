public class Main {
    public static void main(String[] args) {

        Department organization = new Department("COMPANY");
        Organization management = organization.addDepartment("MANAGEMENT");

        management.addEmployee("Elon", 100000.00);

        Organization itDept = organization.addDepartment("IT");
        Department hrDept = organization.addDepartment("HR");
        Department salesDept = organization.addDepartment("SALES");


        Organization alice = itDept.addEmployee("Alice", 3200.00);
        Employee bob = hrDept.addEmployee("Bob", 2800.00);
        salesDept.addEmployee("Charlie", 4100.50);


        System.out.println("=== Salaries ===");
        double total = alice.currentSalary() + bob.currentSalary() + 100000.00 + 4100.50;
        System.out.println("Total salary should be:");
        System.out.printf("%.2f + %.2f + %.2f + %.2f = %.2f%n\n", alice.currentSalary(), bob.currentSalary(), 100000.00, 4100.50, total);
        System.out.println("Total salary is: ");
        System.out.println(organization.currentSalary());
        System.out.println("It salary is: ");
        System.out.println(itDept.currentSalary());

        System.out.println("\n=== CURRENT STRUCTURE ===");
        System.out.println(organization.printStructure(0));

        System.out.println("\n=== STRUCTURE WITHOUT BOB ===");
        boolean removedBob = organization.removeEmployee("Bob");
        System.out.println("Removed Bob: " + removedBob);
        System.out.println(organization.printStructure(0));

        System.out.println("\n=== REMOVE DEPARTMENT: SALES ===");
        boolean removedSales = organization.removeDepartment("SALES");
        System.out.println("Removed SALES: " + removedSales);
        System.out.println(organization.printStructure(0));

        System.out.println("\n=== TOTAL SALARY AFTER REMOVALS ===");
        System.out.println("Total salary should be:");
        total = 100000.00 + alice.currentSalary();
        System.out.printf("%.2f + %.2f = %.2f%n\n",alice.currentSalary(), 100000.00, total);
        System.out.println(organization.currentSalary());

        //Demonstration on creating new departments and stuff.
        Department devDept = organization.addDepartment("SOFTWARE_DEVELOPMENT");
        Employee dana = devDept.addEmployee("Dana", 5000.00);
        Organization opsDept = devDept.addDepartment("DEVOPS");
        opsDept.addEmployee("Richard", 6500.00);
        opsDept.addEmployee(dana.getName(), dana.currentSalary());

        System.out.println("\n=== TOTAL SALARY (SOFTWARE_DEVELOPMENT) ===");
        System.out.println(devDept.currentSalary());

        System.out.println("\n=== STRUCTURE (SOFTWARE_DEVELOPMENT) ===");
        System.out.println(devDept.printStructure(0));

        System.out.println("\n=== STRUCTURE ORGANISATION ===");
        System.out.println(organization.printStructure(0));
    }
}
