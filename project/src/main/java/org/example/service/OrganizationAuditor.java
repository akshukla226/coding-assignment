package org.example.service;
import org.example.model.Employee;
import java.util.*;

public class OrganizationAuditor implements OrgAuditor {
    private List<Employee> employees;
    public OrganizationAuditor(List<Employee> employees) {
        this.employees = employees;
    }
    public List<Employee> getUnderpaidManagers() {
        List<Employee> underpaid = new ArrayList<Employee>();
        for (Employee manager : employees) {
            List<Employee> subs = getDirectSubordinates(manager.getId());
            if (!subs.isEmpty()) {
                double avg = averageSalary(subs);
                if (manager.getSalary() < avg * 1.2) {
                    manager.setPayGap(avg*1.2-manager.getSalary());
                    underpaid.add(manager);

                }
            }
        }
        return underpaid;
    }

    public List<Employee> getOverpaidManagers() {
        List<Employee> overpaid = new ArrayList<Employee>();
        for (Employee manager : employees) {
            List<Employee> subs = getDirectSubordinates(manager.getId());
            if (!subs.isEmpty()) {
                double avg = averageSalary(subs);
                if (manager.getSalary() > avg * 1.5) {
                    manager.setPayGap(manager.getSalary()-avg*1.5);
                    overpaid.add(manager);
                }
            }
        }
        return overpaid;
    }
    //Get direct subordinates of a manager
    private List<Employee> getDirectSubordinates(Integer managerId) {
        List<Employee> subs = new ArrayList<Employee>();
        for (Employee emp : employees) {
            if (managerId != null && managerId.equals(emp.getManagerId())) {
                subs.add(emp);
            }
        }
        return subs;
    }

    //Find employee by ID
    private Employee findById(Integer id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Calculate average salary
    private double averageSalary(List<Employee> employees) {
        double total = 0.0;
        if (employees == null || employees.isEmpty())
            return 0.0;
        for (Employee e : employees) {
            total += e.getSalary();
        }
        return total / employees.size();
    }
    // Find how many managers between employee and CEO
    public List<String> getEmployeesReportingChain(List<Employee> employees) {
        List<String> reportingChain = new ArrayList<String>();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            int depth = 0;
            Integer managerId = e.getManagerId();

            while (managerId != null) {
                Employee manager = null;

                // Linear search for manager in the list
                for (int j = 0; j < employees.size(); j++) {
                    if (employees.get(j).getId() == managerId.intValue()) {
                        manager = employees.get(j);
                        break;
                    }
                }
                if (manager == null) break;

                depth++;
                managerId = manager.getManagerId();
            }
            if (depth > 4) {
                reportingChain.add("Employee " + e.getFullName() + " (ID: " + e.getId() + ") has " + depth + " managers above.");
            }
        }
        return reportingChain;
    }


}
