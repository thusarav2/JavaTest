 package UserPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String gmail = request.getParameter("gmail");  // Fixed the typo here (gamil -> gmail)
	    String password = request.getParameter("password");

	    try {
	        // Validate login
	        List<UserModel> userlogin = UserController.loginValidate(gmail, password);

	        // Check if login is successful
	        if (userlogin.isEmpty()) {
	            // If login fails, send an alert message and redirect to 'GetAllServlet'
	            String alertMessage = "Invalid Gmail or Password. Please try again.";
	            response.setContentType("text/html");
	            response.getWriter().println("<script> alert('" + alertMessage + "');"
	                    + "window.location.href = 'Login.jsp';</script>");
	        } else {
	            // If login is successful, set the user data and forward to profile.jsp
	            String alertMessage = "Login is Successfulll";
	            response.setContentType("text/html");
	            response.getWriter().println("<script> alert('" + alertMessage + "');</script>");
	            
	            //Saving user details through session
	            request.getSession().setAttribute("user", userlogin.get(0));
	            response.sendRedirect("profileServlet");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
