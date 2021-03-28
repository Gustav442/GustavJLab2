package com.example;

import org.assertj.core.error.ShouldBeFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;

class EmployeeManagerTest {


    @Test
    @DisplayName("test")
    void testEmployeeDouble() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();

        var allEmployees = employeeRepository.findAll();

        var actual = allEmployees.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(new Employee("Gustav", 24.0).getId());


    }

    @Test
    @DisplayName("Test mocking")
    void testMocking() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        var allEmployees = employeeRepository.findAll();

        var actual = allEmployees.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(new Employee("Gustav", 24.0).getId());


    }

    @Test
    @DisplayName("test getSalary ")
    void testgetSalary() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        var allEmployees = employeeRepository.findAll().get(0).getSalary();


        assertTrue(employeeRepository.findAll().get(0).getSalary() == 24.0);

    }

    @Test
    @DisplayName("test setSalary ")
    void testsetSalary() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        employeeRepository.findAll().get(0).setSalary(25.0);


        assertTrue(employeeRepository.findAll().get(0).getSalary() == 25.0);
    }

    @Test
    @DisplayName("test isPaid ")
    void testisPaid() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        var paid = employeeRepository.findAll().get(0).isPaid();


        assertFalse(paid);
    }

    @Test
    @DisplayName("test setPaid ")
    void testsetPaid() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        employeeRepository.findAll().get(0).setPaid(true);


        assertTrue(employeeRepository.findAll().get(0).isPaid());
    }

    @Test
    @DisplayName("test setId ")
    void testsetId() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        employeeRepository.findAll().get(0).setId("Erik");


        assertTrue(employeeRepository.findAll().get(0).getId().equals("Erik"));

    }

    @Test
    @DisplayName("test toString ")
    void testtoString() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        employeeRepository.findAll().get(0).toString();


        assertTrue(employeeRepository.findAll().get(0).toString().equals("Employee id: " + "Gustav" + " salary: " + 24.0));


    }

    @Test
    @DisplayName("test payEmployees")
    void testpayEmployees() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 24.0),
                new Employee("Jessica", 24.0),
                new Employee("Tahar", 24.0)));

        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        int expected = employeeManager.payEmployees();



        assertEquals(expected, 2);



    }

}