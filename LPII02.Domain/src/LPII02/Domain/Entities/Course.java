/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.security.Timestamp;

/**
 *
 * @author Gustavo
 */
public class Course extends BaseEntity {

    private Matter matter;
    private Teacher teacher;
    private String name;
    private int duration;
}
