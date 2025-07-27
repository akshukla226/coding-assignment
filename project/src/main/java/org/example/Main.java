package org.example;
import org.example.model.Employee;
import org.example.reader.CsvReader;
import org.example.reader.EmployeeDataReader;
import org.example.service.OrgAuditor;
import org.example.service.OrganizationAuditor;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Load employees data
            File file = new File("src/main/resources/employees.csv");
            EmployeeDataReader reader = new CsvReader();
            List<Employee> employees = reader.readFile(file.getAbsolutePath());

            // Perform analysis
            OrgAuditor auditor = new OrganizationAuditor(employees);

            System.out.println("=== Underpaid Managers ===");
            for (Employee e : auditor.getUnderpaidManagers()) {
                System.out.println(e.getFullName() + " earns less than they should and by " + e.getPayGap());
            }

            System.out.println("\n=== Overpaid Managers ===");
            for (Employee e : auditor.getOverpaidManagers()) {
                System.out.println(e.getFullName() + " earns more than they should and by " + e.getPayGap());
            }

            System.out.println("\n=== Employees with More than 4 managers ===");
            List<String> reportingChain=auditor.getEmployeesReportingChain(employees);
            for(String e:reportingChain){
                System.out.println(e);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
