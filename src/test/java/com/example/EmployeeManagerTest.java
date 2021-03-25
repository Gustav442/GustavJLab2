package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        assertThat(actual).containsExactly(new Employee("Gustav", 250000.0).getId());


    }

    @Test
    @DisplayName("Test mocking")
    void testMocking() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee( "Gustav", 250000.0),
                new Employee("Jessica", 25000.0),
                new Employee("Tahar", 25000.0)));

        var allEmployees = employeeRepository.findAll();

        var actual = allEmployees.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(new Employee("Gustav", 250000.0).getId());


    }
}