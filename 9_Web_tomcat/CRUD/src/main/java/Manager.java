import java.util.ArrayList;
import java.util.Objects;

public class Manager {
    public String display(ArrayList<Product> listProduct, String text) {
        String txt = "";
        for (int i = 0; i < listProduct.size(); i++) {
            txt += "<div class=\"row\">\n" +
                    "        <tr>\n" +
                    "            <div class=\"col\"><td>" + listProduct.get(i).getId() + "</td></div>\n" +
                    "            <div class=\"col\"><td>" + listProduct.get(i).getName() + "</td></div>\n" +
                    "            <div class=\"col\"><td>" + listProduct.get(i).getPrice() + "</td></div>\n";
            if (Objects.equals(text, "delete") || Objects.equals(text, "edit")) {
                switch (text) {
                    case "edit":
                        txt += "<div class=\"col\"><form method=\"post\" action=\"/edit\"><td><button type=\"submit\" value="+i+" name=\"edit\">Sửa</button></form></td></div>";
                        break;
                    case "delete":
                        txt += "<div class=\"col\"><form method=\"post\" action=\"/delete\"><td><button type=\"submit\"  value=\""+i+"\" name=\"delete\">Xóa</button></td></div>";
                }
                txt += "</tr></div>";
            }
        }
        return txt;
    }
}

