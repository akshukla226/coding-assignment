package org.example.service;
import org.example.model.Employee;
import org.example.reader.CsvReader;
import org.example.reader.EmployeeDataReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class OrganizationAuditorTest {
    private OrganizationAuditor auditor;
    List<String> result;
    @BeforeEach
    void setUp() throws Exception {
        File file = new File("src/main/resources/employees.csv");
        EmployeeDataReader reader = new CsvReader();
        List<Employee> employees = reader.readFile(file.getAbsolutePath());
        auditor = new OrganizationAuditor(employees);
        result = auditor.getEmployeesReportingChain(employees);
    }

    @Test
    void testUnderpaidManagersShouldReturnNonNullList() {
        List<Employee> result = auditor.getUnderpaidManagers();
        assertNotNull(result, "Underpaid managers list should not be null");
    }

    @Test
    void testOverpaidManagersShouldReturnNonNullList() {
        List<Employee> result = auditor.getOverpaidManagers();
        assertNotNull(result, "Overpaid managers list should not be null");
    }

    @Test
    void testReportingChainShouldReturnNonNullList() {
        assertNotNull(result, "Employees with long reporting chains list should not be null");
    }

    @Test
    void testWithEmptyDatasetShouldReturnEmptyResults() {
        OrganizationAuditor emptyAuditor = new OrganizationAuditor(List.of());
        assertNotNull(emptyAuditor.getUnderpaidManagers(), "Should return empty list, not null");
        assertTrue(emptyAuditor.getUnderpaidManagers().isEmpty(), "Expected empty list for underpaid managers");
        assertNotNull(emptyAuditor.getOverpaidManagers(), "Should return empty list, not null");
        assertTrue(emptyAuditor.getOverpaidManagers().isEmpty(), "Expected empty list for overpaid managers");
    }
}
