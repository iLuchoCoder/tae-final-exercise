package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Student extends Person{
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isFilled;
    private List<Class> myClasses;

    public Student(String name, String lastName, int idNumber) {
        super(name,lastName,idNumber);
        setName(name);
        setLastName(lastName);
        setIdNumber(idNumber);
        this.isFilled = false;
        this.id = count.incrementAndGet();
        this.myClasses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Class> getMyClasses() {
        return myClasses;
    }

    public void setMyClasses(List<Class> myClasses) {
        this.myClasses = myClasses;
    }

    public String getInfo() {
        return "Student{" +
                "id=" + id +
                ", name=" + getName() +
                ", lastName=" + getLastName() +
                ", idNumber=" + getIdNumber() +
                '}'+'\n';
    }
}
