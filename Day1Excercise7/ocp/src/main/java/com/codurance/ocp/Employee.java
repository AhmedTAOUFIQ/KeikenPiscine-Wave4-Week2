package com.codurance.ocp;

public class Employee {

    private int salary;
    private EmployeeType type;

    Employee(int salary, EmployeeType type) {
        this.salary = salary;
        this.type = type;
    }

    public int payAmount() {
                return salary;
    }

}