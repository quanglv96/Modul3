import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator_Servlet", value = "/Calculator")
public class Calculator_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float frist = Float.parseFloat(request.getParameter("firstNum"));
        float second = Float.parseFloat(request.getParameter("secondNum"));
        String operator = request.getParameter("operrator");
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        switch (operator) {
            case "addition":
                writer.println("<h3>"+ (frist+second)+"</h3>");
                writer.println("<a href=\"http://localhost:8081/\">Back</a>");
                break;
            case "subtraction":
                writer.println("<h3>"+ (frist-second)+"</h3>");
                writer.println("<a href=\"http://localhost:8081/\">Back</a>");
                break;
            case "multiplication":
                writer.println("<h3>"+ (frist*second)+"</h3>");
                writer.println("<a href=\"http://localhost:8081/\">Back</a>");
                break;
            case "division":
                try {
                    writer.println("<h3>" + (frist / second) + "</h3>");
                    writer.println("<a href=\"http://localhost:8081/\">Back</a>");
                }
                catch (Exception e){
                    writer.println(e.getMessage());
                    writer.println("<a href=\"http://localhost:8081/\">Back</a>");
                }
                break;
        }
        writer.println("</html>");
    }
}
