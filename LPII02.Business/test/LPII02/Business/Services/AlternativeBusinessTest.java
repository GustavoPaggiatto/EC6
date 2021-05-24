/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Domain.Entities.Alternative;
import LPII02.Domain.Entities.Question;
import java.util.List;
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
public class AlternativeBusinessTest {
    
    public AlternativeBusinessTest() {
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
     * Test of insert method, of class AlternativeBusiness.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Alternative model = null;
        AlternativeBusiness instance = new AlternativeBusiness();
        instance.insert(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AlternativeBusiness.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Alternative model = null;
        AlternativeBusiness instance = new AlternativeBusiness();
        instance.update(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AlternativeBusiness.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Alternative model = null;
        AlternativeBusiness instance = new AlternativeBusiness();
        instance.delete(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByQuestion method, of class AlternativeBusiness.
     */
    @Test
    public void testGetByQuestion() throws Exception {
        System.out.println("getByQuestion");
        Question model = null;
        AlternativeBusiness instance = new AlternativeBusiness();
        List<Alternative> expResult = null;
        List<Alternative> result = instance.getByQuestion(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
