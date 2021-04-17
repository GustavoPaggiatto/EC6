/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Gustavo
 */
public class Teacher extends User {

    private int userId;
    private String lastDegree;
    private String expecialization;
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }

    public String getExpecialization() {
        return this.expecialization;
    }

    public void setExpecialization(String expecialization) {
        this.expecialization = expecialization;
    }

    @Override
    public String toString() {
        return this._id + " - " + this.name;
    }
}
