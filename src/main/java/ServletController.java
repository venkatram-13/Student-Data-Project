

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
	        } catch (Exception e) {
	            PrintWriter out = response.getWriter() ;
	            out.println("<h1>There seems to be an error in ServletController functionality</h1>");
	            e.printStackTrace() ;
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


}
