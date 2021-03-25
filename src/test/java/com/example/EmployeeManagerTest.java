package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

}