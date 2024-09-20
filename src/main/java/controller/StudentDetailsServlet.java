package controller;

import java.io.IOException;

import java.sql.SQLException;
import bean.Student;
import dao.DBOperations;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 @WebServlet(name = "StudentDetailsServlet", urlPatterns = {"/StudentDetailsServlet"})
public class StudentDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        // Retrieve form parameters
        String registeredNo = request.getParameter("regno");
        String studentName = request.getParameter("name");
        String DOB = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String branch = request.getParameter("branch");
        int year = Integer.parseInt(request.getParameter("year"));
        String semester = request.getParameter("semester");
        String collegeName = request.getParameter("collegeName");
        
     // Create Student object
        Student student = new Student(registeredNo, studentName, DOB, gender, branch, year, semester, collegeName);

        // Create DBOperations object
        DBOperations dbOperations = new DBOperations();
        try {
            // Insert student details into the database
            dbOperations.insertStudentDetails(student);

            // Redirect or forward to a success page
            request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect or forward to an error page
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}

 
 
 /*

 try {
            // Set student attributes in request
            request.setAttribute("registeredNo", registeredNo);
            request.setAttribute("studentName", studentName);
            request.setAttribute("DOB", DOB);
            request.setAttribute("gender", gender);
            request.setAttribute("branch", branch);
            request.setAttribute("year", year);
            request.setAttribute("semester", semester);
            request.setAttribute("collegeName", collegeName);

            // Forward request to JSP page to display data
            // request.getRequestDispatcher("/displayStudentDetails.jsp").forward(request, response);
            request.getRequestDispatcher("/WEB-INF/displayStudentDetails.jsp").forward(request, response) ;
            
        } 
        catch (Exception e) {
            // If an error occurs, redirect to error.jsp
            // response.sendRedirect("error.jsp");
        	response.sendRedirect("WEB-INF/error.jsp") ;
        }
        
        
 
 
  * */