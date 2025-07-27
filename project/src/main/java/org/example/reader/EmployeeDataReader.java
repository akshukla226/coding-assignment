package org.example.reader;
import  org.example.model.Employee;
import java.util.*;

public interface EmployeeDataReader {
    List<Employee> readFile(String path) throws Exception;
}
