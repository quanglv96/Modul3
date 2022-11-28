import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    Manager manager = new Manager();
    int count = 0;
    int index;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = "<h1>Danh sách sản phẩm</h1>";
        txt += "<table class=\"listProduct\">\n" +
                "  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Price</th>\n" +
                "  <th>Edit</th></tr>";
        txt += manager.display(CreateServlet.listProduct1, "edit");
        request.setAttribute("show", txt);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = "<h1>Chỉnh sửa thông tin</h1>";
        if (count == 0) {
            index = Integer.parseInt(request.getParameter("edit"));
            txt += "<form action=\"/edit\" method=\"post\">\n" +
                    "    <table>\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"col\">\n" +
                    "                <tr>\n" +
                    "                    <td><label>ID</label></td>\n" +
                    "                    <td><input type=\"text\" name=\"upID\" value=\"" + CreateServlet.listProduct1.get(index).getId() + "\"/></td>\n" +
                    "                </tr>\n" +
                    "            </div>\n" +
                    "            <div class=\"col\">\n" +
                    "                <tr>\n" +
                    "                    <td><label>Name</label></td>\n" +
                    "                    <td><input type=\"text\" name=\"upName\" value=\"" + CreateServlet.listProduct1.get(index).getName() + "\"/></td>\n" +
                    "                </tr>\n" +
                    "            </div>\n" +
                    "            <div class=\"col\">\n" +
                    "                <tr>\n" +
                    "                    <td><label>Price</label></td>\n" +
                    "                    <td><input type=\"text\" name=\"upPrice\" value=\"" + CreateServlet.listProduct1.get(index).getPrice() + "\"/></td>\n" +
                    "                </tr>\n" +
                    "            </div>\n" +
                    "            <div class=\"col\">\n" +
                    "                <tr>\n" +
                    "                    <td>\n" +
                    "                        <button type=\"submit\"  value=\"yes\" name=\"check\">Cập nhập</button>\n" +
                    "                    </td>\n" +
                    "                    <td>\n" +
                    "                        <button type=\"sumit\" value=\"no\"name=\"check\">Bỏ qua</button>" +
                    "                </tr>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </table>\n" +
                    "</form>";
            txt += "</table>";
            request.setAttribute("show", txt);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
            count = 1;
        } else {
            count = 0;
            String check = request.getParameter("check");
            txt = "<h1>Danh sách sản phẩm</h1>";
            txt += "<table class=\"listProduct\">\n" +
                    "  <tr>\n" +
                    "    <th>ID</th>\n" +
                    "    <th>Name</th>\n" +
                    "    <th>Price</th><th>Edit</th>\n" +
                    "  </tr>";
            if (check.equals("yes")) {
                int upId = Integer.parseInt(request.getParameter("upID"));
                String upName = request.getParameter("upName");
                double upPrice = Double.parseDouble(request.getParameter("upPrice"));
                CreateServlet.listProduct1.set(index, new Product(upId, upName, upPrice));

                txt += manager.display(CreateServlet.listProduct1, "edit");
                txt += "</table>";
                request.setAttribute("show", txt);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            } else {
                txt += manager.display(CreateServlet.listProduct1, "edit");
                txt += "</table>";
                request.setAttribute("show", txt);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
