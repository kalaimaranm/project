package com.bassure.springboot.demo.service;

import com.bassure.springboot.demo.model.Department;
import com.bassure.springboot.demo.repository.DepartmentRespository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentServiceImplTest {

    public DepartmentServiceImplTest() {

    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

//    public void 
//    /**
//     * Test of getDepartment method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testGetDepartment() {
//        System.out.println("getDepartment");
//        long id = 0L;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        Optional<Department> expResult = null;
//        Optional<Department> result = instance.getDepartment(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllepartment method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testGetAllepartment() {
//        System.out.println("getAllepartment");
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        List<Department> expResult = null;
//        List<Department> result = instance.getAllepartment();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteDepartment method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testDeleteDepartment() {
//        System.out.println("deleteDepartment");
//        Long id = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.deleteDepartment(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addDepartment method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testAddDepartment() {
//        System.out.println("addDepartment");
//        Department department = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        Department expResult = null;
//        Department result = instance.addDepartment(department);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateDepartment method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testUpdateDepartment() {
//        System.out.println("updateDepartment");
//        Long id = null;
//        Department department = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        Department expResult = null;
//        Department result = instance.updateDepartment(id, department);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDepartmentByName method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testGetDepartmentByName() {
//        System.out.println("getDepartmentByName");
//        String name = "";
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        Department expResult = null;
//        Department result = instance.getDepartmentByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDepartmentCount method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testGetDepartmentCount() {
//        System.out.println("getDepartmentCount");
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        int expResult = 0;
//        int result = instance.getDepartmentCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDepartmentRespository method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testGetDepartmentRespository() {
//        System.out.println("getDepartmentRespository");
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        DepartmentRespository expResult = null;
//        DepartmentRespository result = instance.getDepartmentRespository();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDepartmentRespository method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testSetDepartmentRespository() {
//        System.out.println("setDepartmentRespository");
//        DepartmentRespository departmentRespository = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        instance.setDepartmentRespository(departmentRespository);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object o = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.equals(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of canEqual method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testCanEqual() {
//        System.out.println("canEqual");
//        Object other = null;
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.canEqual(other);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class DepartmentServiceImpl.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        DepartmentServiceImpl instance = new DepartmentServiceImpl();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
