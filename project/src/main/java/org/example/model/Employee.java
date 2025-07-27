package org.example.model;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private double salary;
    private Integer managerId;
    private double payGap;

    public Employee() {
        // Default constructor
    }

    public Employee(Integer id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getPayGap() {
        return payGap;
    }

    public void setPayGap(double payGap) {
        this.payGap = payGap;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + firstName + " " + lastName +
                ", salary=" + salary +
                ", managerId=" + managerId +
                '}';
    }
}
