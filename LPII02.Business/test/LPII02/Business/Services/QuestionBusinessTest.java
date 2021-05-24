/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

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
public class QuestionBusinessTest {
    
    public QuestionBusinessTest() {
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
     * Test of get method, of class QuestionBusiness.
     */
    @Test
    public void testGet_0args() {
        System.out.println("get");
        QuestionBusiness instance = new QuestionBusiness();
        List<Question> expResult = null;
        List<Question> result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class QuestionBusiness.
     */
    @Test
    public void testGet_int() {
        System.out.println("get");
        int id = 0;
        QuestionBusiness instance = new QuestionBusiness();
        Question expResult = null;
        Question result = instance.get(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class QuestionBusiness.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Question model = null;
        QuestionBusiness instance = new QuestionBusiness();
        instance.insert(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class QuestionBusiness.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Question model = null;
        QuestionBusiness instance = new QuestionBusiness();
        instance.update(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class QuestionBusiness.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Question model = null;
        QuestionBusiness instance = new QuestionBusiness();
        instance.delete(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
