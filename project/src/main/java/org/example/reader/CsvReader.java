package org.example.reader;
import org.example.model.Employee;
import java.io.*;
import java.util.*;

public class CsvReader implements EmployeeDataReader {
    public List<Employee> readFile(String path) throws Exception {
        List<Employee> employees = new ArrayList<Employee>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine(); // Skip header

        while ((line = reader.readLine()) != null) {
            String[] empAttributes = line.split(",");
            int id = Integer.parseInt(empAttributes[0]);
            String firstName = empAttributes[1];
            String lastName = empAttributes[2];
            double salary = Double.parseDouble(empAttributes[3]);
            Integer managerId = (empAttributes.length > 4 && empAttributes[4].trim().length() > 0) ?
                    Integer.parseInt(empAttributes[4].trim()) : null;
            employees.add(new Employee(id, firstName, lastName, salary, managerId));
        }
        reader.close();
        return employees;
    }
}

