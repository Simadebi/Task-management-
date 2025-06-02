import java.util.*;

class CourseRegistrationManager {
    protected String registrationId;
    protected Date date;

    public CourseRegistrationManager(String registrationId) {
        this.registrationId = registrationId;
        this.date = new Date();
    }
}

class Registration extends CourseRegistrationManager {
    private String regId;
    private Student student;
    private Course course;
    private String status;  // e.g. "Registered", "Waitlisted"

    public Registration(String registrationId, String regId, Student student, Course course, String status) {
        super(registrationId);
        this.regId = regId;
        this.student = student;
        this.course = course;
        this.status = status;
    }

    public String toString() {
        return "Registration ID: " + regId + ", Student: " + student.getName() + ", Course: " + course.getName() + ", Status: " + status;
    }
}

class Course extends CourseRegistrationManager {
    private String courseId;
    private String name;
    private int credits;

    public Course(String registrationId, String courseId, String name, int credits) {
        super(registrationId);
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " (" + credits + " credits)";
    }
}

class Account extends CourseRegistrationManager {
    private String accountId;
    private String username;
    private String password;

    public Account(String registrationId, String accountId, String username, String password) {
        super(registrationId);
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}

class Student {
    private String studentId;
    private String name;
    private String email;
    private Account account;
    private List<Registration> registrations;

    public Student(String studentId, String name, String email, Account account) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.account = account;
        this.registrations = new ArrayList<>();
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public String getName() {
        return name;
    }

    public void viewRegistrations() {
        System.out.println("Registrations for " + name + ":");
        for (Registration r : registrations) {
            System.out.println(r);
        }
    }
}

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Account account = new Account("REG001", "A001", "studentUser", "pass123");
        Student student = new Student("S001", "Jane Doe", "jane@example.com", account);

        Course course1 = new Course("REG002", "C101", "Data Structures", 3);
        Course course2 = new Course("REG003", "C102", "Operating Systems", 4);

        Registration reg1 = new Registration("REG004", "R001", student, course1, "Registered");
        Registration reg2 = new Registration("REG005", "R002", student, course2, "Waitlisted");

        student.addRegistration(reg1);
        student.addRegistration(reg2);

        student.viewRegistrations();
    }
}