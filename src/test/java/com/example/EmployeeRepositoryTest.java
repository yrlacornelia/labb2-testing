package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryTest {
    @Mock
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("givenEmployeesList_WhenFindAllIsCalled_ReturnTrue")
    void givenEmployeesList_WhenFindAllIscalled_ThenReturnTrue() {
        List<Employee> employees = Arrays.asList(
                new Employee("1", 5000),
                new Employee("2", 6000)
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> actualEmployees = employeeRepository.findAll();

        assertEquals(employees, actualEmployees);
    }
    @Test
    @DisplayName("givenEmptyEmployeesList_WhenFindAllIsCalled_ReturnFalse")
    void givenEmptyEmployeesList_WhenFindAllIsCalled_ReturnFalse() {
        List<Employee> employees = List.of();
        when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
        List<Employee> actualEmployees = employeeRepository.findAll();
        assertEquals(employees, actualEmployees);
    }


    //givenEmployee_whenSaveMethodIsCalled_thenReturnTrue
    @Test
    @DisplayName("givenEmployee_whenSaveMethodIsCalled_thenReturnTrue")
    void givenEmployeeWhenSaveMethodIsCalledThenReturnTrue() {
        Employee employeeToSave = new Employee("2", 6000);
        when(employeeRepository.save(employeeToSave)).thenReturn(employeeToSave);
        Employee savedEmployee = employeeRepository.save(employeeToSave);
        verify(employeeRepository, times(1)).save(employeeToSave);
        assertEquals(employeeToSave, savedEmployee);
    }


}