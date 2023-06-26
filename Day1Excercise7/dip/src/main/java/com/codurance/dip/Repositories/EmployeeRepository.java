package com.codurance.dip.Repositories;

import com.codurance.dip.Entities.Employee.Employee;

import java.time.MonthDay;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesBornOn(MonthDay monthDay);
}
