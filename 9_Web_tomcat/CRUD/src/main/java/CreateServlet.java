import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {
     static ArrayList<Product> listProduct1 = new ArrayList<>();

    String txt = "";
    Manager manager=new Manager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        txt = "<h1>Thêm sản phẩm</h1>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td><label>ID sản phẩm:</label></td>\n" +
                "            <td><input type=\"text\" name=\"idProduct\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td><label>Tên sản phẩm:</label></td>\n" +
                "            <td><input type=\"text\" name=\"nameProduct\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td><label>Giá bán sản phẩm:</label>\n" +
                "            <td><input type=\"text\" name=\"priceProduct\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <form action=\"/create\" method=\"post\"><button type=\"submit\" value=\"yes\" name=\"check\">Thêm sản phẩm</button></form>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                    <form action=\"/create\" method=\"post\"><button type=\"submit\" value=\"no\" name=\"check\">Bỏ qua</button></form>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n";
        request.setAttribute("show", txt);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        txt = "<h1>Danh sách sản phẩm</h1>";
        txt += "<table class=\"listProduct\">\n" +
                "  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Price</th>\n" +
                "  </tr>";
        if (check.equals("yes")) {
            int id = Integer.parseInt(request.getParameter("idProduct"));
            String name = request.getParameter("nameProduct");
            double price = Double.parseDouble(request.getParameter("priceProduct"));
            listProduct1.add(new Product(id, name, price));
            txt += manager.display(listProduct1, "no");
            txt += "</table>";
            request.setAttribute("show", txt);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }else {
            txt += manager.display(listProduct1, "no");
            txt += "</table>";
            request.setAttribute("show", txt);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
