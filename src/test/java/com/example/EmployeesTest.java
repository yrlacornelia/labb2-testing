package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {

    private EmployeeRepository employeeRepository;
    private BankserviceTd bankServiceStub;
    private Employees employees;
    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        bankServiceStub = new BankserviceTd();
        employees = new Employees(employeeRepository, bankServiceStub);

    }
    @Test
    public void givenOneEmployee_whenPayingEmployee_thenReturnTrue() {
        List<Employee> employeesList = new ArrayList<>();
      bankServiceStub.setShouldThrowException(false);
        employeesList.add(new Employee("1", 1000));
        when(employeeRepository.findAll()).thenReturn(employeesList);
        int payments = employees.payEmployees();
        assertEquals(1, payments);
        assertTrue(employeesList.get(0).isPaid());
    }


    @Test
    @DisplayName("Payment not successful")
    void paymentNotSuccessfulWhenBankMethodStubDoesNotThrowException() {

        List<Employee> employeeList = Arrays.asList(
                new Employee("1", 25000.0),
                new Employee("2", 30000.0)
        );

        when(employeeRepository.findAll()).thenReturn(employeeList);
        bankServiceStub.setShouldThrowException(true);

        employees.payEmployees();

        for (Employee employee : employeeList) {
            assertFalse(employee.isPaid());
        }
    }

}
