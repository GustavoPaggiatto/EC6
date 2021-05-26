/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Domain.Entities.Matter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class MatterBusinessTest {
    
    public MatterBusinessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MatterBusiness.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Matter model = null;
        MatterBusiness instance = new MatterBusiness();
        instance.insert(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MatterBusiness.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Matter model = null;
        MatterBusiness instance = new MatterBusiness();
        instance.update(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCode method, of class MatterBusiness.
     */
    @Test
    public void testGetByCode() throws Exception {
        System.out.println("getByCode");
        int code = 0;
        MatterBusiness instance = new MatterBusiness();
        Matter expResult = null;
        Matter result = instance.getByCode(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
