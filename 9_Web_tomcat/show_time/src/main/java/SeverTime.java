import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SeverTime", urlPatterns = "/index")
public class SeverTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Hello world</h1>");
        writer.println("</html>");
        PrintWriter writer1=response.getWriter();
        writer1.println("<html>");
        Date today=new Date();
        writer1.println("<h1>"+today+"</h1>");
        writer1.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
