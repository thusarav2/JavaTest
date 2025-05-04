package UserPackage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gmail = request.getParameter("gmail");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        boolean isTrue = UserController.updateProfile(id, name, gmail, password, phone); // Update user profile
        
        int idx = Integer.parseInt(id);
        if (isTrue) {
            // Redirect to the profile page with updated details
            request.getSession().setAttribute("user", new UserModel(idx, name, gmail, password, phone)); // Update the session with new user data
            response.sendRedirect("profileServlet"); // Redirect to profile page
        } else {
            // If the update fails, redirect to an error page
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}
