package studentmanagementsystem;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, age, department, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getEmail());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setDepartment(rs.getString("department"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE students SET name=?, age=?, department=?, email=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getEmail());
            stmt.setInt(5, student.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted.");
            else System.out.println("Student not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

