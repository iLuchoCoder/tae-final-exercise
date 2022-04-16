package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private List<Class> classList;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    public University() {
        super();
        this.classList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void createTeacher(String name, String lastName, int idNumber, double baseSalary, boolean fullTime, int antiquity, int hours) {
        Teacher teacher = new Teacher(name,lastName,idNumber,baseSalary,fullTime,antiquity,hours);
        this.teacherList.add(teacher);
    }

    public void createStudent(String name, String lastName, int idNumber) {
        Student student = new Student(name,lastName,idNumber);
        this.studentList.add(student);
    }


    public void createClass(String className){
        Class newClass = new Class(className);
        this.classList.add(newClass);
    }

    public void createTeacherObject(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void createStudentObject(Student student){
        this.studentList.add(student);
    }

    public void createClassObject(Class newClass){
        this.classList.add(newClass);
    }

    public List<String> showAllTeachers(){
        return getTeacherList().stream().map(teacher -> teacher.getInfo()).collect(Collectors.toList());
    }

    public List<String> showAllClasses(){
        return getClassList().stream().map(classes -> classes.getInfo()).collect(Collectors.toList());
    }

    public List<String> showAllClassesStudent(List<Class> classesList){
        return classesList.stream().map(classes -> classes.getInfo()).collect(Collectors.toList());
    }

    public List<String> showAllStudents(){
        return getStudentList().stream().map(student -> student.getInfo()).collect(Collectors.toList());
    }

    public List<String> showAllListStudents(List<Student> students){
        return students.stream().map(student -> student.getInfo()).collect(Collectors.toList());
    }

    public void showClassInfoById(int id){
        Class cFound = getClassList().stream().filter(classes -> classes.getId()==id).findAny().orElse(null);
        System.out.println(cFound.getInfo());
        System.out.println(cFound.getTeacher().getInfo());
        System.out.println(showAllListStudents(cFound.getStudentList()));
    }

    public Teacher searchTeacherById(int id){
        Teacher tFound = getTeacherList().stream().filter(teachers -> teachers.getId()==id).findAny().orElse(null);
        return tFound;
    }

    public Student searchStudentById(int id){
        Student sFound = getStudentList().stream().filter(teachers -> teachers.getId()==id).findAny().orElse(null);
        return sFound;
    }

}
