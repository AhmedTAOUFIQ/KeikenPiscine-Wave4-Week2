package com.codurance.ocp;

public class Manager extends Employee{
    private int bonus;

    Manager(int salary, EmployeeType type, int bonus) {
        super(salary, type);
        this.bonus=bonus;
    }
    @Override
    public int payAmount() {
        return super.payAmount() + bonus;
    }
}
