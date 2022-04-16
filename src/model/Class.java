package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Class {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> studentList;
    private boolean isFilled;

    public Class(String className) {
        this.name = className;
        this.isFilled = false;
        this.id = count.incrementAndGet();
        studentList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getInfo() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'+'\n';
    }
}
