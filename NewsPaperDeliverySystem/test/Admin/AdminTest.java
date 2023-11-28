/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Admin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cianf
 */
public class AdminTest {
    
    public AdminTest() {
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

    /**
     * Test of validateAdminUsername method, of class Admin.
     */
    @Test
    public void testValidateAdminUsername() throws Exception {
        System.out.println("validateAdminUsername");
        String adminUsername = "";
        Admin instance = new Admin();
        boolean expResult = false;
        boolean result = instance.validateAdminUsername(adminUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateAdminPassword method, of class Admin.
     */
    @Test
    public void testValidateAdminPassword() throws Exception {
        System.out.println("validateAdminPassword");
        String adminPassword = "";
        Admin instance = new Admin();
        boolean expResult = false;
        boolean result = instance.validateAdminPassword(adminPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateAdminID method, of class Admin.
     */
    @Test
    public void testValidateAdminID() throws Exception {
        System.out.println("validateAdminID");
        String idNum = "";
        Admin instance = new Admin();
        boolean expResult = false;
        boolean result = instance.validateAdminID(idNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Admin.
     */
    @Test
    public void testGetUsername() throws NewsagentExceptionHandler {
        System.out.println("getUsername");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Admin.
     */
    @Test
    public void testSetUsername() throws NewsagentExceptionHandler {
        System.out.println("setUsername");
        String username = "";
        Admin instance = new Admin();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() throws NewsagentExceptionHandler {
        System.out.println("getPassword");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() throws NewsagentExceptionHandler {
        System.out.println("setPassword");
        String password = "";
        Admin instance = new Admin();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Admin.
     */
    @Test
    public void testGetId() throws NewsagentExceptionHandler {
        System.out.println("getId");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Admin.
     */
    @Test
    public void testSetId() throws NewsagentExceptionHandler {
        System.out.println("setId");
        String id = "";
        Admin instance = new Admin();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
