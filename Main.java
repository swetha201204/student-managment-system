package studentmanagementsystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    Student s = new Student();
                    System.out.print("Enter name: ");
                    s.setName(sc.nextLine());
                    System.out.print("Enter age: ");
                    s.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    s.setDepartment(sc.nextLine());
                    System.out.print("Enter email: ");
                    s.setEmail(sc.nextLine());
                    dao.addStudent(s);
                    break;
                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student st : students) {
                        System.out.println(st.getId() + " | " + st.getName() + " | " +
                                           st.getAge() + " | " + st.getDepartment() + " | " +
                                           st.getEmail());
                    }
                    break;
                case 3:
                    Student stu = new Student();
                    System.out.print("Enter ID to update: ");
                    stu.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    stu.setName(sc.nextLine());
                    System.out.print("Enter new age: ");
                    stu.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter new department: ");
                    stu.setDepartment(sc.nextLine());
                    System.out.print("Enter new email: ");
                    stu.setEmail(sc.nextLine());
                    dao.updateStudent(stu);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteStudent(id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
