package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BankserviceTdTest {

    private BankserviceTd bankServiceTd;
    private Employees component;
    @Mock
    EmployeeRepository employeeRepositoryMock;
    @BeforeEach
    void setUp() {
        bankServiceTd = new BankserviceTd();
        component = new Employees(employeeRepositoryMock, bankServiceTd);

    }

    @Test
    public void givenEmployeeList_whenPayEmployeesCalled_thenReturnTrue() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001", 50000.0));
        employees.add(new Employee("002", 60000.0));
        employees.add(new Employee("003", 70000.0));
        Mockito.when(employeeRepositoryMock.findAll()).thenReturn(employees);
        component.payEmployees();
        assertTrue(bankServiceTd.isPayMethodCalled());
    }
    @Test
    public void givenNothing_whenPayEmployeesCalled_thenReturnFalse() {
        assertFalse(bankServiceTd.isPayMethodCalled());
    }

    @Test
    public void givenEmptyEmployeeList_whenPayEmployeesCalled_thenReturnFalse() {
        Mockito.when(employeeRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        Employees emptyComponent = new Employees(employeeRepositoryMock, bankServiceTd);
        int payments = emptyComponent.payEmployees();
        assertEquals(0, payments);
    }
}