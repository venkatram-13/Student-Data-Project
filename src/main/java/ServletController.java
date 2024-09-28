import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.Student;
import dao.DBOperations;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Initialize the logger
    private static final Logger logger = Logger.getLogger(ServletController.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        logger.info("Received request in doGet method");

        if (request.getParameter("display") != null) {
            logger.info("Display student details request received");
            try {
                displayStudentDetailsMethod(request, response);
                logger.info("Student details displayed successfully");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error displaying student details", e);
                response.getWriter().println("<h1>There seems to be an error in ServletController functionality</h1>");
            }
        }
        else if (request.getParameter("deleteRegNo") != null) {
            String regNo = request.getParameter("deleteRegNo");
            logger.info("Delete request received for student with RegNo: " + regNo);
            try {
                deleteStudentDetails(regNo, request, response);
                logger.info("Student with RegNo " + regNo + " deleted successfully");
            } catch (ClassNotFoundException | SQLException e) {
                logger.log(Level.SEVERE, "Error occurred while deleting student with RegNo: " + regNo, e);
                response.getWriter().println("<h1>Error occurred while deleting student</h1>");
            }
        }
        else if (request.getParameter("updateRegNo") != null) {
            String regNo = request.getParameter("updateRegNo");
            logger.info("Update request received for student with RegNo: " + regNo);
            try {
                findByRegNo_edit(regNo, request, response);
                logger.info("Fetched details for student with RegNo: " + regNo + " for editing");
            } catch (ClassNotFoundException | SQLException e) {
                logger.log(Level.SEVERE, "Error occurred while fetching details for student with RegNo: " + regNo, e);
            }
        }
        else if (request.getParameter("edit") != null) {
            logger.info("Edit request received for updating student details");
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
                logger.info("Attempting to update student with RegNo: " + registeredNo);
                updateStudentDetailsMethod(s, request, response);
                logger.info("Student with RegNo " + registeredNo + " updated successfully");
            } catch (ClassNotFoundException | SQLException e) {
                logger.log(Level.SEVERE, "Error occurred while updating student details", e);
                response.getWriter().println("<h1>Error occurred while updating student details</h1>");
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING, "Invalid year format for student update", e);
                response.getWriter().println("<h1>Invalid input for year</h1>");
            }
        }
    }

    private void displayStudentDetailsMethod(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        logger.info("Fetching student details from database");
        DBOperations op = new DBOperations();
        List<Student> studentDetails = op.getStudentDetails(); 
        request.setAttribute("studentDetails", studentDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/StudentInfoDetails.jsp");
        dispatcher.forward(request, response);
        logger.info("Student details fetched and forwarded to JSP");
    }

    private void deleteStudentDetails(String regNo, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        logger.info("Deleting student with RegNo: " + regNo);
        DBOperations op = new DBOperations();
        op.deleteStudent(regNo); 
        displayStudentDetailsMethod(request, response);
        logger.info("Student with RegNo: " + regNo + " deleted and updated list displayed");
    }

    private void findByRegNo_edit(String regNo, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        logger.info("Fetching student with RegNo: " + regNo + " for editing");
        DBOperations db_op = new DBOperations();
        Student s = db_op.findByRegNo(regNo);
        request.setAttribute("Student", s);
        RequestDispatcher rd = request.getRequestDispatcher("EditStudentDetails.jsp");
        rd.include(request, response);
        logger.info("Student with RegNo: " + regNo + " fetched and forwarded to EditStudentDetails.jsp");
    }

    private void updateStudentDetailsMethod(Student s, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        logger.info("Updating student with RegNo: " + s.getRegisteredNo());
        DBOperations op = new DBOperations();
        op.updateStudentDetails(s); 
        displayStudentDetailsMethod(request, response);
        logger.info("Student with RegNo: " + s.getRegisteredNo() + " updated and displayed");
    }
}
