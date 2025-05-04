package UserPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed, but you should be using POST for delete operations.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ID of the user to delete
        String id = request.getParameter("id");

        // Call the delete function from UserController
        boolean isTrue = UserController.deleteProfile(id);

        if (isTrue) {
            // If deletion is successful, show an alert and redirect to Login.jsp
            String alertMessage = "Data delete successful";
            response.getWriter().println("<script> alert('" + alertMessage + "');"
                    + "window.location.href = 'Login.jsp';</script>");
        } else {
            // If deletion fails, redirect to an error page or show an error message
            String alertMessage = "Data deletion failed";
            response.getWriter().println("<script> alert('" + alertMessage + "');"
                    + "window.location.href = 'wrong.jsp';</script>");
        }
    }
}
