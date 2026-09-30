package com.company.seaams.service;

import com.company.seaams.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeService {
    private final List<Employee> employees = new ArrayList<Employee>();
    private final Set<String> uniqueEmails = new HashSet<String>();
    private final Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

    public boolean addEmployee(Employee emp) {
        if (uniqueEmails.contains(emp.getEmail().toLowerCase())) {
            System.out.println("critical error");
            return false;
        }
        if (employeeMap.containsKey(Integer.valueOf(emp.getId()))) {
            System.out.println("critical error");
            return false;
        }
        employees.add(emp);
        uniqueEmails.add(emp.getEmail().toLowerCase());
        employeeMap.put(Integer.valueOf(emp.getId()), emp);
        return true;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("no found memory");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public Employee searchEmployee(int id) {
        return employeeMap.get(Integer.valueOf(id));
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

}