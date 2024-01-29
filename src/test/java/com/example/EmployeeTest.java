package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

        private Employee employee;

        @BeforeEach
        void setUp() {
            employee = new Employee("123", 50000.0);
        }

        @Test
        @DisplayName("getId")
        void getId() {
            assertEquals("123", employee.getId());
        }

        @Test
        @DisplayName("setId")
        void setId() {
            employee.setId("456");
            assertEquals("456", employee.getId());
        }

        @Test
        @DisplayName("getSalary")
        void getSalary() {
            assertEquals(50000.0, employee.getSalary());
        }

        @Test
        @DisplayName("setSalary")
        void setSalary() {
            employee.setSalary(30000.0);
            assertEquals(30000.0, employee.getSalary());
        }

        @Test
        @DisplayName("isPaid")
        void isPaid() {
            assertFalse(employee.isPaid());
        }

        @Test
        @DisplayName("setPaid")
        void setPaid() {
            employee.setPaid(true);
            assertTrue(employee.isPaid());
        }

        @Test
        @DisplayName("toString")
        void testToString() {
            assertEquals("Employee [id=123, salary=50000.0]", employee.toString());
        }

        @Test
        @DisplayName("testDefaultConstructor")
        void testDefaultConstructor() {
            Employee defaultEmployee = new Employee("", 0.0);
            assertNotNull(defaultEmployee);
        }



}