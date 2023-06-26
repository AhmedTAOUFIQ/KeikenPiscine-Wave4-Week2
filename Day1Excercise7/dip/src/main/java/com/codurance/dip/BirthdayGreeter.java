package com.codurance.dip;

import com.codurance.dip.Entities.Clock.Clock;
import com.codurance.dip.Entities.Clock.ClockInterface;
import com.codurance.dip.Entities.Email.Email;
import com.codurance.dip.Entities.Email.EmailInterface;
import com.codurance.dip.Entities.EmailSender.EmailSender;
import com.codurance.dip.Entities.EmailSender.EmailSenderInterface;
import com.codurance.dip.Entities.Employee.Employee;
import com.codurance.dip.Repositories.EmployeeRepository;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final ClockInterface clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        EmailSenderInterface emailSender = new EmailSender();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> emailSender.send((Email) email));
    }

    private EmailInterface emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        EmailInterface email = new Email(employee.getEmail(), "Happy birthday!", message);

        return (Email) email;
    }

}