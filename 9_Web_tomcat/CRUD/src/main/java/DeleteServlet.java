import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    Manager manager=new Manager();
    
    int index;
    int count=0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = "<h1>Danh sách sản phẩm</h1>";
        txt += "<table class=\"listProduct\">\n" +
                "  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Name</th>\n" +
                "    <th>Price</th>\n" +
                "  <th>Delete</th></tr>";
        txt += manager.display(CreateServlet.listProduct1, "delete");
        request.setAttribute("show", txt);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt;
        if (count == 0) {
            count=1;
             txt= "<h1>Xác thực xóa</h1>";
            index = Integer.parseInt(request.getParameter("delete"));
            txt += "<table class=\"listProduct\">\n" +
                    "  <tr>\n" +
                    "    <th>ID</th>\n" +
                    "    <th>Name</th>\n" +
                    "    <th>Price</th>\n";
            txt += "<div class=\"row\">\n" +
                    "        <tr>\n" +
                    "            <div class=\"col\"><td>" + CreateServlet.listProduct1.get(index).getId() + "</td></div>\n" +
                    "            <div class=\"col\"><td>" + CreateServlet.listProduct1.get(index).getName() + "</td></div>\n" +
                    "            <div class=\"col\"><td>" + CreateServlet.listProduct1.get(index).getPrice() + "</td></div>" +
                    "</tr></div>";
            txt += "<div class=\"row\">\n" +
                    "<form action=\"/delete\" method=\"post\">\n" +
                    "    <button type=\"submit\" value=\"yes\" name=\"check\">Xóa</button>\n" +
                    "    <button type=\"reset\" value=\"no\" name=\"check\">Không xóa</button>\n" +
                    "</form>\n" +
                    "</div>";
            request.setAttribute("show", txt);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }else{
            count=0;
            String check = request.getParameter("check");
            txt= "<table class=\"listProduct\">\n" +
                    "  <tr>\n" +
                    "    <th>ID</th>\n" +
                    "    <th>Name</th>\n" +
                    "    <th>Price</th>\n" +
                    "  <th>Delete</th></tr>";
            switch (check){
                case "yes":
                    CreateServlet.listProduct1.remove(index);
                    txt+= manager.display(CreateServlet.listProduct1,"delete");
                    break;
                case "no":
                    txt+=manager.display(CreateServlet.listProduct1,"delete");
                    break;
            }
            request.setAttribute("show", txt);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
