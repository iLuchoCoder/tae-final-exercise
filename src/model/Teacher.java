package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class Teacher extends Person{

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isFilled;
    private double baseSalary;
    private boolean fullTime;
    private int antiquity;
    private int hours;

    public Teacher(String name, String lastName, int idNumber, double baseSalary, boolean fullTime, int antiquity, int hours) {
        super(name,lastName,idNumber);
        setName(name);
        setLastName(lastName);
        setIdNumber(idNumber);
        setBaseSalary(baseSalary);
        setFullTime(fullTime);
        setAntiquity(antiquity);
        setHours(hours);
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
                ", salary=" + calculateSalary() +
                '}'+'\n';
    }

    public String calculateSalary(){
        BigDecimal bd = new BigDecimal(0);
        if(isFullTime()){
            bd = new BigDecimal(getBaseSalary()).multiply(BigDecimal.valueOf((getAntiquity()*1.1)));
        }
        else{
            bd = new BigDecimal(getBaseSalary()).multiply(BigDecimal.valueOf((getHours())));
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(bd);
    }
}
