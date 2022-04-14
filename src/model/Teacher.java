package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Teacher extends Person{

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isFilled;
    private double baseSalary;
    private boolean fullTime;
    private int antiquity;
    private int hours;

    public Teacher(String name, String lastName, int idNumber) {
        super(name,lastName,idNumber);
        setName(name);
        setLastName(lastName);
        setIdNumber(idNumber);
        this.isFilled = false;
        this.id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getInfo() {
        return "Teacher{" +
                "id=" + id +
                ", name=" + getName() +
                ", lastName=" + getLastName() +
                ", idNumber=" + getIdNumber() +
                ", baseSalary=" + baseSalary +
                ", fullTime=" + fullTime +
                ", antiquity=" + antiquity +
                ", hours=" + hours +
                '}';
    }

    public double calculateSalary(){
        double salary = 0;
        if(isFullTime()){
            salary = getBaseSalary() * (getAntiquity()*1.1);
        }
        else{
            salary = getBaseSalary() * getHours();
        }
        return salary;
    }
}
