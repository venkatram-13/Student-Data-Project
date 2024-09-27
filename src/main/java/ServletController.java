

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import bean.Student;
import dao.DBOperations;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    if (request.getParameter("display") != null) {
	        try {
	            displayStudentDetailsMethod(request, response);
	        } 
	        catch (Exception e) {
	            PrintWriter out = response.getWriter() ;
	            out.println("<h1>There seems to be an error in ServletController functionality</h1>");
	            e.printStackTrace() ;
	        }
	    }
	    else if (request.getParameter("deleteRegNo") != null) {
            // Call the delete functionality
            String regNo = request.getParameter("deleteRegNo");
            try {
                deleteStudentDetails(regNo, request, response);
            } 
            catch (ClassNotFoundException | SQLException e) {
                PrintWriter out = response.getWriter();
                out.println("<h1>Error occurred while deleting student</h1>");
                e.printStackTrace();
            }
        }
	    else if (request.getParameter("updateRegNo") != null) {
            String regNo = request.getParameter("updateRegNo");
            try {
                findByRegNo_edit(regNo, request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
	    else if (request.getParameter("edit") != null) {
	        try {
	            String registeredNo = request.getParameter("regNo");
	            String studentName = request.getParameter("name");
	            String DOB = request.getParameter("dob");
	            String gender = request.getParameter("gender");
	            String branch = request.getParameter("branch");
	            int year = Integer.parseInt(request.getParameter("year"));
	            String semester = request.getParameter("semester");
	            String collegeName = request.getParameter("collegeName");

	            Student s = new Student(registeredNo, studentName, DOB, gender, branch, year, semester, collegeName);

	            // Call the update method and handle any exceptions properly
	            updateStudentDetailsMethod(s, request, response);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            response.getWriter().println("<h1>Error occurred while updating student details</h1>");
	        }
	    }


	}

	private void displayStudentDetailsMethod(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException, ClassNotFoundException {
	    DBOperations op = new DBOperations();
	    List<Student> studentDetails = op.getStudentDetails(); // Fetch the details from DB
	    request.setAttribute("studentDetails", studentDetails); // Set as an attribute
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/StudentInfoDetails.jsp");
	    dispatcher.forward(request, response); // Forward to JSP
	}
	
	private void deleteStudentDetails(String regNo, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        DBOperations op = new DBOperations();
        op.deleteStudent(regNo); // Call the DB operation to delete the student
        displayStudentDetailsMethod(request, response);
    }
	
	private void findByRegNo_edit(String regNo, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        DBOperations db_op = new DBOperations(); // Create instance of DBOperations
        Student s = db_op.findByRegNo(regNo); // Find student by regNo

        RequestDispatcher rd = request.getRequestDispatcher("EditStudentDetails.jsp"); // Forward to JSP
        request.setAttribute("Student", s); // Set student details as request attribute
        rd.include(request, response); // Include the JSP page
    }
	
	private void updateStudentDetailsMethod(Student s, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        DBOperations op = new DBOperations();
        op.updateStudentDetails(s); 
        displayStudentDetailsMethod(request, response);
    }

}
