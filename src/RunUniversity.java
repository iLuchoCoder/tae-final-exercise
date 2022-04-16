import model.Class;
import model.Student;
import model.Teacher;
import model.University;

import java.util.Scanner;


public class RunUniversity {
    public static University globerU = new University();

    public static void initializeCampus(){
        // Teachers
        globerU.createTeacher("Alex","Cremento",7443246,1000000,false,0,16);
        globerU.createTeacher("Ema","Amado Bustos",2324546,1700000,false,0,24);
        globerU.createTeacher("Aitor","Tilla",97654343,2500000,true,12,0);
        globerU.createTeacher("Lola","Mento",45345322,1500000,true,5,0);

        // Students
        globerU.createStudent("Vicente","Levidente",115353234);
        globerU.createStudent("Helen","Chufe",124345555);
        globerU.createStudent("Dolores","Delano",432432342);
        globerU.createStudent("Ana","Busado de Hesa",864545455);
        globerU.createStudent("Josefa","Nática",343546767);
        globerU.createStudent("Andrés","Trozado",676455666);

        // Classes
        Class c1 = new Class("Object-oriented programming");
        c1.setTeacher(globerU.getTeacherList().get(0));
        c1.getStudentList().add(globerU.getStudentList().get(0));
        c1.getStudentList().add(globerU.getStudentList().get(1));
        c1.getStudentList().add(globerU.getStudentList().get(2));
        c1.getStudentList().add(globerU.getStudentList().get(4));

        // Adding the c1 class to the students list
        globerU.getStudentList().get(0).getMyClasses().add(c1);
        globerU.getStudentList().get(1).getMyClasses().add(c1);
        globerU.getStudentList().get(2).getMyClasses().add(c1);
        globerU.getStudentList().get(4).getMyClasses().add(c1);

        Class c2 = new Class("Algorithm Analysis");
        c2.setTeacher(globerU.getTeacherList().get(1));
        c2.getStudentList().add(globerU.getStudentList().get(2));
        c2.getStudentList().add(globerU.getStudentList().get(4));
        c2.getStudentList().add(globerU.getStudentList().get(5));

        // Adding the c2 class to the students list
        globerU.getStudentList().get(2).getMyClasses().add(c2);
        globerU.getStudentList().get(4).getMyClasses().add(c2);
        globerU.getStudentList().get(5).getMyClasses().add(c2);

        Class c3 = new Class("Data Structure");
        c3.setTeacher(globerU.getTeacherList().get(2));
        c3.getStudentList().add(globerU.getStudentList().get(0));
        c3.getStudentList().add(globerU.getStudentList().get(2));
        c3.getStudentList().add(globerU.getStudentList().get(3));
        c3.getStudentList().add(globerU.getStudentList().get(4));
        c3.getStudentList().add(globerU.getStudentList().get(5));

        // Adding the c3 class to the students list
        globerU.getStudentList().get(0).getMyClasses().add(c3);
        globerU.getStudentList().get(2).getMyClasses().add(c3);
        globerU.getStudentList().get(3).getMyClasses().add(c3);
        globerU.getStudentList().get(4).getMyClasses().add(c3);
        globerU.getStudentList().get(5).getMyClasses().add(c3);

        Class c4 = new Class("Automata and Formal Languages");
        c4.setTeacher(globerU.getTeacherList().get(3));
        c4.getStudentList().add(globerU.getStudentList().get(1));
        c4.getStudentList().add(globerU.getStudentList().get(5));

        // Adding the c4 class to the students list
        globerU.getStudentList().get(1).getMyClasses().add(c4);
        globerU.getStudentList().get(5).getMyClasses().add(c4);

        globerU.createClassObject(c1);
        globerU.createClassObject(c2);
        globerU.createClassObject(c3);
        globerU.createClassObject(c4);
    }

    public static void menu(){
        System.out.println("******************************");
        System.out.println("Globant University");
        System.out.println("1. Print all teachers with its data");
        System.out.println("2. Print all existing classes");
        System.out.println("3. Create a new Teacher");
        System.out.println("4. Create a new Student");
        System.out.println("5. Create a new Class with all data");
        System.out.println("6. List all classes that a student is attending");
        System.out.println("7. Exit");
        System.out.println("******************************");
    }

    public static void subMenu(){
        System.out.println("******************************");
        System.out.println("Globant University");
        System.out.println("Select an id to see the class information");
        System.out.println("******************************");
    }

    public static void subMenuStudents(){
        System.out.println("******************************");
        System.out.println("Add a student to the new class?");
        System.out.println("1. Yes");
        System.out.println("Q. No");
        System.out.println("******************************");
    }

    public static void main(String[] args) {
        initializeCampus();
        String ans = "";
        Scanner lector = new Scanner(System.in);
        while (true){
            menu();
            ans = lector.nextLine();
            if(ans.equalsIgnoreCase("1")){
                System.out.println(globerU.showAllTeachers());
            }
            if(ans.equalsIgnoreCase("2")){
                System.out.println(globerU.showAllClasses());
                subMenu();
                Scanner lector2 = new Scanner(System.in);
                String ans2 = lector.nextLine();
                globerU.showClassInfoById(Integer.parseInt(ans2));
            }
            if(ans.equalsIgnoreCase("3")){
                String name = "";
                String lastName = "";
                int idNumber=0;
                double baseSalary = 0;
                boolean fullTime = false;
                int antiquity = 0;
                int hours=0;

                System.out.println("Creating a new teacher.....");
                System.out.println("The new teacher is a Full Time or Part Time : 1 - Yes, 2 -No ");
                Scanner lector3 = new Scanner(System.in);
                String ans3 = lector3.nextLine();
                if(ans3.equalsIgnoreCase("1")){
                    fullTime = true;
                    System.out.println("Enter the teachers Name: ");
                    name = lector3.nextLine();
                    System.out.println("Enter the teachers Last Name: ");
                    lastName = lector3.nextLine();
                    System.out.println("Enter the teachers ID Number: ");
                    idNumber = Integer.parseInt(lector3.nextLine());
                    System.out.println("Enter the teachers Base Salary: ");
                    baseSalary = Double.parseDouble(lector3.nextLine());
                    System.out.println("Enter the teachers Antiquity: ");
                    antiquity = Integer.parseInt(lector3.nextLine());
                    globerU.createTeacher(name,lastName,idNumber,baseSalary,fullTime,antiquity,hours);
                    System.out.println("Teacher was created successfully");
                }
                else{
                    System.out.println("Enter the teachers Name: ");
                    name = lector3.nextLine();
                    System.out.println("Enter the teachers Last Name: ");
                    lastName = lector3.nextLine();
                    System.out.println("Enter the teachers ID Number: ");
                    idNumber = Integer.parseInt(lector3.nextLine());
                    System.out.println("Enter the teachers Base Salary: ");
                    baseSalary = Double.parseDouble(lector3.nextLine());
                    System.out.println("Enter the teachers hours per week: ");
                    hours = Integer.parseInt(lector3.nextLine());
                    globerU.createTeacher(name,lastName,idNumber,baseSalary,fullTime,antiquity,hours);
                    System.out.println("Teacher was created successfully");
                }
            }
            if(ans.equalsIgnoreCase("4")){
                String name;
                String lastName;
                int idNumber;
                Scanner lector4 = new Scanner(System.in);
                System.out.println("Creating a new student.....");
                System.out.println("Enter the students Name: ");
                name = lector4.nextLine();
                System.out.println("Enter the students Last Name: ");
                lastName = lector4.nextLine();
                System.out.println("Enter the students ID Number: ");
                idNumber = Integer.parseInt(lector4.nextLine());

                globerU.createStudent(name,lastName,idNumber);

                System.out.println("Student was created successfully");
            }
            if(ans.equalsIgnoreCase("5")){
                Scanner lector5 = new Scanner(System.in);
                String className;
                int teacherID;
                String ans5 = "";
                System.out.println("Creating a new class.....");
                System.out.println("Enter the class name");
                className = lector5.nextLine();
                Class nc = new Class(className);
                System.out.println("Now, you've to add a teacher to this new class, here's the teacher's list");
                System.out.println(globerU.showAllTeachers());
                System.out.println("Enter the teachers ID");
                teacherID = Integer.parseInt(lector5.nextLine());
                Teacher nt = globerU.searchTeacherById(teacherID);
                nc.setTeacher(nt);
                System.out.println("Teacher was added successfully to the new class");
                System.out.println("Now, you've to add students to this new class" );
                boolean out = true;
                while (out)
                {
                    subMenuStudents();
                    ans5 = lector5.nextLine();
                    if(ans5.equalsIgnoreCase("1"))
                    {
                        System.out.println("Here's the student's list" );
                        System.out.println(globerU.showAllStudents());
                        System.out.println("Enter the students ID");
                        String stID = lector5.nextLine();
                        Student student = globerU.searchStudentById(Integer.parseInt(stID));
                        // Adding the student to the class students list
                        nc.getStudentList().add(student);
                        // Adding the class to the student class list
                        student.getMyClasses().add(nc);
                        System.out.println("Student was successfully added to the new class");
                    }
                    if(ans5.equalsIgnoreCase("Q"))
                    {
                        out = false;
                        globerU.createClassObject(nc);
                    }
                }
                System.out.println("The Class was added successfully created");
            }
            if(ans.equalsIgnoreCase("6")){
                Scanner lector6 = new Scanner(System.in);
                System.out.println("Here's the student's list" );
                System.out.println(globerU.showAllStudents());
                System.out.println("Enter the students ID");
                String ans6 = lector6.nextLine();
                Student student = globerU.searchStudentById(Integer.parseInt(ans6));
                System.out.println(student.getInfo());
                System.out.println(globerU.showAllClassesStudent(student.getMyClasses()));
            }
            if(ans.equalsIgnoreCase("7")){
                break;
            }
        }
    }
}
