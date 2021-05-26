/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Domain.Entities.Course;
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
public class CourseBusinessTest {
    
    public CourseBusinessTest() {
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
     * Test of formatDuration method, of class CourseBusiness.
     */
    @Test
    public void testFormatDuration() {
        System.out.println("formatDuration");
        int duration = 0;
        CourseBusiness instance = new CourseBusiness();
        String expResult = "";
        String result = instance.formatDuration(duration);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class CourseBusiness.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Course model = null;
        CourseBusiness instance = new CourseBusiness();
        instance.insert(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CourseBusiness.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Course model = null;
        CourseBusiness instance = new CourseBusiness();
        instance.update(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
