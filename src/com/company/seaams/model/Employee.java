package com.company.seaams.model;


public class Employee extends Person {
    private String email;
    private double salary;
    private String department;
    private String status;
    private String country;

    {
        this.status = "ACTIVE";
        this.country = "INDIA";

    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(int id, String name, String email, double salary, String department) {
        super(id, name);
        this.email = email;
        this.salary = salary;
        this.department = department;

    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public String getCountry() {
        return country;

    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Employee emp = (Employee) obj;
        return this.id == emp.id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return String.format("EmpID:%-6d|Name:%-10s|Email:%-22s|Dept:%-8s|Slary:$%-9.2f|[%s-%s]", id, name, email,
                department, salary, status, country);

    }

}
