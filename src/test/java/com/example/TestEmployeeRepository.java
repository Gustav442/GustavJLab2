package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {

        return List.of(new Employee( "Gustav", 250000.0),
                new Employee("Jessica", 25000.0),
                new Employee("Tahar", 25000.0));



    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}



