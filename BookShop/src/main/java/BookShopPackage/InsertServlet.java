package BookShopPackage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String catagory = request.getParameter("catagory");
        String qunetity = request.getParameter("qunetity");
        String description = request.getParameter("description");

        boolean isTrue;

        // Insert data to the database
        isTrue = BookController.insertdata(name, price, catagory, qunetity, description);

        if (isTrue) {
            // Data insertion successful, redirect to GetAllServlet
            String alertMessage = "Data Insert Successful";
            response.getWriter().println("<script> alert('" + alertMessage + "'); window.location.href='GetAllServlet'</script>");
        } else {
            // Data insertion failed, forward to error page
            request.setAttribute("errorMessage", "Data insertion failed, please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
            dispatcher.forward(request, response);
        }
    }
}
