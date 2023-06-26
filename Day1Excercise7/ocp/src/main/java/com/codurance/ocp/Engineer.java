package com.codurance.ocp;

public class Engineer extends Employee{
    Engineer(int salary, int bonus, EmployeeType type) {
        super(salary, bonus, type);
    }
    public int payAmount() {
                return super.payAmount();

        }
    }
