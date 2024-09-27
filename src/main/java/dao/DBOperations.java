package dao;

import java.sql.Connection;
import java.util.* ;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Student;

public class DBOperations {

    // Method to get a connection to the MySQL database
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database connection parameters: MySQL URL, userName, and password
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "valluri200513");
        
        return connect;
    }
    
    public List<Student> getStudentDetails() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM students";
        List<Student> studentList = new ArrayList<>();
        Connection connect = getConnection(); // Ensure your connection method is correctly set up
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(query);

        while (res.next()) {
            String registeredNo = res.getString(1);
            String studentName = res.getString(2);
            String DOB = res.getString(3);
            String gender = res.getString(4);
            String branch = res.getString(5);
            int year = res.getInt(6);
            String semester = res.getString(7);
            String collegeName = res.getString(8);

            Student s = new Student(registeredNo, studentName, DOB, gender, branch, year, semester, collegeName);
            studentList.add(s);
        }
        return studentList;
    }


    // Method to insert student details into the database
    public void insertStudentDetails(Student s) throws ClassNotFoundException, SQLException {
        Connection connect = getConnection(); // Get the database connection

        // SQL query to insert student details into the table studentDetails
        String query = "insert into students values(?,?,?,?,?,?,?,?)";

        // Prepare the SQL query
        PreparedStatement p = connect.prepareStatement(query);

        // Set values from the Student object into the SQL query
        p.setString(1, s.getRegisteredNo());
        p.setString(2, s.getStudentName());
        p.setString(3, s.getDOB());
        p.setString(4, s.getGender());
        p.setString(5, s.getBranch());
        p.setInt(6, s.getYear());
        p.setString(7, s.getSemester());
        p.setString(8, s.getCollegeName());

        // Execute the query
        p.executeUpdate();
    }
    
    public void deleteStudent(String regNo) throws ClassNotFoundException, SQLException {
        Connection connect = getConnection();
        String query = "DELETE FROM students WHERE registered_number = ?";
        PreparedStatement p = connect.prepareStatement(query);
        p.setString(1, regNo);
        p.executeUpdate();
    }
    
    public Student findByRegNo(String regNo) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM students WHERE registered_number = ?";
        Connection connect = getConnection();
        PreparedStatement p = connect.prepareStatement(query);
        p.setString(1, regNo);
        ResultSet res = p.executeQuery();

        Student s = null;
        if (res.next()) {
            String registeredNo = res.getString(1);
            String studentName = res.getString(2);
            String DOB = res.getString(3);
            String gender = res.getString(4);
            String branch = res.getString(5);
            int year = res.getInt(6);
            String semester = res.getString(7);
            String collegeName = res.getString(8);

            s = new Student(registeredNo, studentName, DOB, gender, branch, year, semester, collegeName);
        }
        return s;
    }

    
    public void updateStudentDetails(Student s) throws ClassNotFoundException, SQLException {
        Connection connect = getConnection();
        System.out.println(s);
        String query = "update students set name =?, dob =?, gender =?, branch =?, year =?, semester =?, college_name=? where registered_number=?";
        PreparedStatement p = connect.prepareStatement(query);
        
        p.setString(1, s.getStudentName());
        p.setString(2, s.getDOB());
        p.setString(3, s.getGender());
        p.setString(4, s.getBranch());
        p.setInt(5, s.getYear());
        p.setString(6, s.getSemester());
        p.setString(7, s.getCollegeName());
        p.setString(8, s.getRegisteredNo());

        p.executeUpdate();
    }



}
