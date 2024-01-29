package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {

    @InjectMocks
    private Employees component;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private BankService bankService;

    @Test
    public void givenOneEmployee_whenPayingEmployee_thenReturnTrue() {
        List<Employee> employeesList = new ArrayList<>();
        Employee employee1 = new Employee("1", 1000);
        employeesList.add(employee1);
        when(employeeRepository.findAll()).thenReturn(employeesList);
        doNothing().when(bankService).pay(eq("1"), eq(1000.0));
        int payments = component.payEmployees();
        assertEquals(1, payments);
        assertTrue(employee1.isPaid());
    }

    @Test
    public void givenEmployeesExist_whenNotPaying_thenReturnFalse() {
        List<Employee> employeesList = new ArrayList<>();
        Employee employee2 = new Employee("2", 1500);
        employeesList.add(employee2);
        when(employeeRepository.findAll()).thenReturn(employeesList);
        doThrow(new RuntimeException("Payment failed")).when(bankService).pay(eq("2"), eq(1500.0));
        int payments = component.payEmployees();
        assertEquals(0, payments);
        assertFalse(employee2.isPaid());
    }

}
