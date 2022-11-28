import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisplayServlet", value = "/display")
public class DisplayServlet extends HttpServlet {
    Manager manager=new Manager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt="<h1>Danh sách sản phẩm</h1><table class=\"listProduct\">\n" +
                "  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Price</th>\n" +
                "  </tr>";
        txt+=manager.display(CreateServlet.listProduct1,"no");
        txt+="</table>";
        request.setAttribute("show", txt);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
