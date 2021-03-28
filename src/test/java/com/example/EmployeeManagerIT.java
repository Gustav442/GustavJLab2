package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeManagerIT {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    BankService bankService = new TestBankService();
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

    @BeforeEach
    void setUp() {
        employeeRepository.employees.add(new Employee("Erik", 23.0));
        employeeRepository.employees.add(new Employee("Gunilla", 22.0));
        employeeRepository.employees.add(new Employee("Patrik", 21.0));

    }


    @Test
    @DisplayName("test payEmployees inMemoryVersion ")
    void testInMemoryVersionPayEmployees() {
        int expected = employeeManager.payEmployees();
        assertEquals(expected, 3);
    }


    @Test
    @DisplayName("test save method. ")
    void testSaveMethod() {
        employeeRepository.save(new Employee("Frank", 19.0));

        int expected = employeeManager.payEmployees();

        assertEquals(expected, 4);
    }
}