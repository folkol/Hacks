import java.util.*;
public class Student {
    int age;
    int grade;
    String name;
    static LinkedList ll = new LinkedList();
    public Student (String n) {   //we create here a student with a name and an age
        name=n;
        age=0;
        grade=0;
    }
    //-------------------------------------------------------------------------
    public void p(String x) {
        System.out.println(x);
    }

    public void addStudent() {
        Scanner s = new Scanner(System.in);
        p("Enter the name that you want");
        String f = s.nextLine();
        Student a = new Student(f);
        ll.add(a);
    }

    public void changeName() {                           //this method is to change the name of a student
        Scanner s = new Scanner(System.in);
        p("Enter whose name you want to change");
        String c = s.nextLine();
        p("Enter the name that you want");
        String b = s.nextLine();

    }

    public void setGrade(Student a) {                 //this method is to put the student's grade
        Scanner s = new Scanner(System.in);
        p("Enter the grade that you want");
        int g = s.nextInt();
        a.grade=g;
    }

    public void setAge(Student a) {                 //This method is to put the student's grade
        Scanner s = new Scanner(System.in);
        p("Enter the age that you want");
        int h = s.nextInt();
        a.age=h;
    }

    public String getName(Student a) {
        return a.name;
    }

    public int getAge(Student a) {
        return a.age;
    }

    public int getGrade(Student a) {
        return a.grade;
    }
}