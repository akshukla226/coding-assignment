package org.example.service;

import org.example.model.Employee;

import java.util.List;

public interface OrgAuditor {
    List<Employee> getUnderpaidManagers();
    List<Employee> getOverpaidManagers();
    List<String> getEmployeesReportingChain(List<Employee> employees);
}

