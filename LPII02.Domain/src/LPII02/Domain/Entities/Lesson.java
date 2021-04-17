/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

/**
 *
 * @author Gustavo
 */
public class Lesson extends BaseEntity {

    private Course course;
    private String lessonGuid;
    private String name;
    private String resume;
    private int order;
    private byte[] content;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getLessonGuid() {
        return lessonGuid;
    }

    public void setLessonGuid(String lessonGuid) {
        this.lessonGuid = lessonGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
