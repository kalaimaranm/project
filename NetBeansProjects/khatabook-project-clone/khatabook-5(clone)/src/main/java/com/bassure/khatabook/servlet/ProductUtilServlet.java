package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.model.Stock;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductUtilServlet extends GenericServlet {

    PrintWriter out;
    KhatabookDAO khatabook = new MysqlKhatabookImpl();

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        String option = request.getParameter("option");
        switch (option) {
            case "addproductform": {
                addProductForm();
                break;
            }
            case "addproduct": {

                int id = 0;
                try {
                    id = khatabook.getProduct().generateID(request.getParameter("name"));
                    Product product = new Product(id, request.getParameter("name"),
                            Double.parseDouble(request.getParameter("costperunit")),
                            Double.parseDouble(request.getParameter("profitperunit")),
                            request.getParameter("weight"),
                            Integer.parseInt(request.getParameter("quantity")),
                            LocalDateTime.now().toString(), true);
                    out.write("<!DOCTYPE html>\n");
                    if (khatabook.getProduct().addProduct(product)) {
                        out.print("<h2 style=\"color:green;\" align = 'center'>Product Added Successfully...</h2>");
                    } else {
                        out.print("<div style=\"color:red;\"\"><h2 align = 'center'> Product Failed to add</h2>");
                        out.print("<h2 align = 'center'> Please try again</h2></div>");
                    }
                    out.write("<div align = \"center\"><br/><br/><br/><br/><br/><br/><br/><button><a href = \"shopkeeperhome.html\">Home</a></button></div>");
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

            case "viewproduct": {
                try {
                    viewProduct(khatabook.getProduct().getAllProduct().values().toArray(new Product[khatabook.getProduct().getAllProduct().values().size()]));
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "deleteproductform": {
                deleteProductForm();
                break;
            }
            case "deleteproduct": {
                try {
                    boolean b = khatabook.getProduct().deleteProduct(Integer.parseInt(request.getParameter("id")));
                    out.print(b
                            ? "<h1 bgcolor = 'green' align = center>product deleted successfully</h1> "
                            : "<h1 bgcolor = 'red' align = center>Sorry, product deletion failed...\nPlease try again</h1>");
                    out.write("<div align = \"center\"><br/><br/><br/><br/><br/><br/><br/>"
                            + "<button><a href = \"shopkeeperhome.html\">Home</a></button></div>");
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "updateproduct": {

                try {
                    Product[] product = khatabook.getProduct().getAllProduct().values().toArray(new Product[khatabook.getProduct().getAllProduct().values().size()]);
                    out.print("<h1 align = 'center'>Update Product</h1>");
                    out.print("<table align=\"center\" border=1 rules=all>");
                    out.print("    <th>");
                    out.print("        <tr>");
                    out.print("            <th> Id</th>");
                    out.print("            <th> Name</th>");
                    out.print("            <th>Cost Per Unit</th>");
                    out.print("            <th>Profit Per Unit Price</th>");
                    out.print("            <th>Weight(gm/kg)</th>");
                    out.print("            <th>Quantity</th>");
                    out.print("            <th colspan=\"2\">Update Qty</th>");
                    out.print("        </tr> ");
                    out.print("    </th> ");
                    for (Product tempProduct : product) {
                        if (tempProduct.isStatus()) {
                            out.print("<tr>");
                            out.print("<td>" + tempProduct.getId() + "</td>");
                            out.print("<td>" + tempProduct.getName() + "</td>");
                            out.print("<td>" + tempProduct.getPrice() + "</td>");
                            out.print("<td>" + tempProduct.getProfitPerUnit() + "</td>");
                            out.print("<td>" + tempProduct.getWeight() + "</td>");
                            out.print("<td>" + tempProduct.getQuantity() + "</td>");
                            out.print("<td><a href=product?id=" + tempProduct.getId() + "&option=updateproductform>update product</a></td>");
                            out.print("</tr>");
                        }
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "updateproductform": {
                try {
                    Product product = khatabook.getProduct().getProductById(Integer.parseInt(request.getParameter("id")));
                    out.write("\n");
                    out.write("\n");
                    out.write("\n");
                    out.write("<!DOCTYPE html>\n");
                    out.write("<html>\n");
                    out.write("    <head>\n");
                    out.write("        <title>Update product</title>\n");
                    out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\" rel=\"stylesheet\">\n");
                    out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\" integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">\n");
                    out.write("        <style>\n");
                    out.write("            html, body {\n");
                    out.write("                min-height: 100%;\n");
                    out.write("            }\n");
                    out.write("            body, div, form, input, textarea, p {\n");
                    out.write("                padding: 0;\n");
                    out.write("                margin: 0;\n");
                    out.write("                outline: none;\n");
                    out.write("                font-family: Roboto, Arial, sans-serif;\n");
                    out.write("                font-size: 14px;\n");
                    out.write("                color: #666;\n");
                    out.write("                line-height: 22px;\n");
                    out.write("            }\n");
                    out.write("            h1 {\n");
                    out.write("                position: absolute;\n");
                    out.write("                margin: 0;\n");
                    out.write("                font-size: 32px;\n");
                    out.write("                color: #fff;\n");
                    out.write("                z-index: 2;\n");
                    out.write("            }\n");
                    out.write("            .testbox {\n");
                    out.write("                display: flex;\n");
                    out.write("                justify-content: center;\n");
                    out.write("                align-items: center;\n");
                    out.write("                height: inherit;\n");
                    out.write("                padding: 20px;\n");
                    out.write("            }\n");
                    out.write("            form {\n");
                    out.write("                width: 100%;\n");
                    out.write("                padding: 20px;\n");
                    out.write("                border-radius: 6px;\n");
                    out.write("                background: #fff;\n");
                    out.write("                box-shadow: 0 0 10px 0 #cc0052;\n");
                    out.write("            }\n");
                    out.write("            .banner {\n");
                    out.write("                position: relative;\n");
                    out.write("                height: 210px;\n");
                    out.write("                background-image: url(\"/uploads/media/default/0001/01/f1cf9a9068f4bfbdbd9758c45db79203579a3561.jpeg\");\n");
                    out.write("                background-size: cover;\n");
                    out.write("                display: flex;\n");
                    out.write("                justify-content: center;\n");
                    out.write("                align-items: center;\n");
                    out.write("                text-align: center;\n");
                    out.write("            }\n");
                    out.write("            .banner::after {\n");
                    out.write("                content: \"\";\n");
                    out.write("                background-color: rgba(0, 0, 0, 0.4);\n");
                    out.write("                position: absolute;\n");
                    out.write("                width: 100%;\n");
                    out.write("                height: 100%;\n");
                    out.write("            }\n");
                    out.write("            input, textarea {\n");
                    out.write("                margin-bottom: 10px;\n");
                    out.write("                border: 1px solid #ccc;\n");
                    out.write("                border-radius: 3px;\n");
                    out.write("            }\n");
                    out.write("            input {\n");
                    out.write("                width: calc(100% - 10px);\n");
                    out.write("                padding: 5px;\n");
                    out.write("            }\n");
                    out.write("            textarea {\n");
                    out.write("                width: calc(100% - 12px);\n");
                    out.write("                padding: 5px;\n");
                    out.write("            }\n");
                    out.write("            .item:hover p, input:hover::placeholder {\n");
                    out.write("                color: #cc0052;\n");
                    out.write("            }\n");
                    out.write("            .item input:hover, .item textarea:hover {\n");
                    out.write("                border: 1px solid transparent;\n");
                    out.write("                box-shadow: 0 0 6px 0 #cc0052;\n");
                    out.write("                color: #cc0052;\n");
                    out.write("            }\n");
                    out.write("            .item {\n");
                    out.write("                position: relative;\n");
                    out.write("                margin: 10px 0;\n");
                    out.write("            }\n");
                    out.write("            .btn-block {\n");
                    out.write("                margin-top: 10px;\n");
                    out.write("                text-align: center;\n");
                    out.write("            }\n");
                    out.write("            button {\n");
                    out.write("                width: 150px;\n");
                    out.write("                padding: 10px;\n");
                    out.write("                border: none;\n");
                    out.write("                border-radius: 5px;\n");
                    out.write("                background: #cc0052;\n");
                    out.write("                font-size: 16px;\n");
                    out.write("                color: #fff;\n");
                    out.write("                cursor: pointer;\n");
                    out.write("            }\n");
                    out.write("            button:hover {\n");
                    out.write("                background: #ff0066;\n");
                    out.write("            }\n");
                    out.write("            @media (min-width: 568px) {\n");
                    out.write("                .name-item, .contact-item {\n");
                    out.write("                    display: flex;\n");
                    out.write("                    flex-wrap: wrap;\n");
                    out.write("                    justify-content: space-between;\n");
                    out.write("                }\n");
                    out.write("                .contact-item .item {\n");
                    out.write("                    width: calc(50% - 8px);\n");
                    out.write("                }\n");
                    out.write("                .name-item input {\n");
                    out.write("                    width: calc(50% - 20px);\n");
                    out.write("                }\n");
                    out.write("                .contact-item input {\n");
                    out.write("                    width: calc(100% - 12px);\n");
                    out.write("                }\n");
                    out.write("            }\n");
                    out.write("        </style>\n");
                    out.write("        <script>\n");
                    out.write("\n");
                    out.write("        </script>\n");
                    out.write("    </head>\n");
                    out.write("    <body>\n");
                    out.write("        <div class=\"testbox\">\n");
                    out.write("            <form name = \"updateproduct\"action=\"product?option=updateproductsubmit\" method = \"post\">");
                    out.write("                <div class=\"banner\">\n");
                    out.write("                    <h1>Update Product Form</h1>\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"item\">\n");
                    out.write("                    <label for = \"id\">Id</label>\n");
                    out.write("                    <div class=\"name-item\">\n");
                    out.write("                        <input type=\"text\" name=\"id\" id = \"id\" value=\"" + product.getId() + "\" readonly />\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"item\">\n");
                    out.write("                    <label for = \"name\">Name</label>\n");
                    out.write("                    <div class=\"name-item\">\n");
                    out.write("                        <input type=\"text\" name=\"name\" id = \"name\" value = \"" + product.getName() + "\"  placeholder=\"Enter the product name\" />\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"contact-item\">\n");
                    out.write("                    <div class=\"item\">\n");
                    out.write("                        <label>Cost Per Unit</label>\n");
                    out.write("                        <input type=\"text\" name=\"costperunit\" placeholder=\"Enter the amount in &#x20B9\" value = \"" + product.getPrice() + "\" />\n");
                    out.write("                    </div>\n");
                    out.write("\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"item\">\n");
                    out.write("                    <label>profit Per Unit</label>\n");
                    out.write("                    <input type=\"text\" name=\"profitperunit\" placeholder=\"Enter the amount in &#x20B9\" value = \"" + product.getProfitPerUnit() + "\" />\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"item\">\n");
                    out.write("                    <label>Weight</label>\n");
                    out.write("                    <input type =\"text\" name = \"weight\" placeholder=\"Enter the weight in gm/kg\" value = \"" + product.getWeight() + "\" />\n");
                    out.write("                    <!--<textarea rows=\"3\" required></textarea>-->\n");
                    out.write("                </div>\n");
                    out.write("                <div class=\"item\">\n");
                    out.write("                    <label>Quantity</label>\n");
                    out.write("                    <input type = \"number\" name = \"quantity\" />\n");
                    out.write("                    <!--<textarea rows=\"3\" required></textarea>-->\n");
                    out.write("                </div>\n");
                    out.write("\n");
                    out.write("\n");
                    out.write("                <div class=\"btn-block\">\n");
                    out.write("                    <input type=\"submit\" value = \"UPDATE\" name = \"submit\" id = \"submit\" />\n");
                    out.write("                </div>\n");
                    out.write("            </form>\n");
                    out.write("        </div>\n");
                    out.write("    </body>\n");
                    out.write("</html>");
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "updateproductsubmit": {
                Product product = new Product(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        Double.parseDouble(request.getParameter("costperunit")),
                        Double.parseDouble(request.getParameter("profitperunit")),
                        request.getParameter("weight"),
                        Integer.parseInt(request.getParameter("quantity")),
                        "",
                        true);
                Stock stock = new Stock();
                stock.setProductID(product.getId());
                stock.setQuantity(product.getQuantity());
                stock.setDateTime(LocalDateTime.now().toString());
                try {
                    if (khatabook.getProduct().updateProduct(product) && khatabook.getStock().stockEntry(stock)) {
                        out.print("<h1 align = \"center\" >Product updated successfully...</h1>");
                    } else {
                        out.print("<h1 align = \"center\">Product updation Failed....</h1>");
                    }
                    out.write("<div align = \"center\"><br/><br/><br/><br/><br/><br/><br/><button><a href = \"shopkeeperhome.html\">Home</a></button></div>");

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ProductUtilServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

        }

    }

    public void addProductForm() {
        out.write("<!DOCTYPE html>\n");
        out.write("<html lang=\"en\">\n");
        out.write("\n");
        out.write("    <head>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        out.write("        <meta name=\"viewport\" content=\n");
        out.write("              \"width=device-width, initial-scale=1.0\">\n");
        out.write("        <title>\n");
        out.write("            Build a Survey Form using HTML and CSS\n");
        out.write("        </title>\n");
        out.write("\n");
        out.write("        <style>\n");
        out.write("\n");
        out.write("            /* Styling the Body element i.e. Color,\n");
        out.write("            Font, Alignment */\n");
        out.write("            body {\n");
        out.write("                background-color: #05c46b;\n");
        out.write("                font-family: Verdana;\n");
        out.write("                text-align: center;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling the Form (Color, Padding, Shadow) */\n");
        out.write("            form {\n");
        out.write("                background-color: #fff;\n");
        out.write("                max-width: 500px;\n");
        out.write("                margin: 50px auto;\n");
        out.write("                padding: 30px 20px;\n");
        out.write("                box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling form-control Class */\n");
        out.write("            .form-control {\n");
        out.write("                text-align: left;\n");
        out.write("                margin-bottom: 25px;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling form-control Label */\n");
        out.write("            .form-control label {\n");
        out.write("                display: block;\n");
        out.write("                margin-bottom: 10px;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling form-control input,\n");
        out.write("            select, textarea */\n");
        out.write("            .form-control input,\n");
        out.write("            .form-control select,\n");
        out.write("            .form-control textarea {\n");
        out.write("                border: 1px solid #777;\n");
        out.write("                border-radius: 2px;\n");
        out.write("                font-family: inherit;\n");
        out.write("                padding: 10px;\n");
        out.write("                display: block;\n");
        out.write("                width: 95%;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling form-control Radio\n");
        out.write("            button and Checkbox */\n");
        out.write("            .form-control input[type=\"radio\"],\n");
        out.write("            .form-control input[type=\"checkbox\"] {\n");
        out.write("                display: inline-block;\n");
        out.write("                width: auto;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            /* Styling Button */\n");
        out.write("            button {\n");
        out.write("                background-color: #05c46b;\n");
        out.write("                border: 1px solid #777;\n");
        out.write("                border-radius: 2px;\n");
        out.write("                font-family: inherit;\n");
        out.write("                font-size: 21px;\n");
        out.write("                display: block;\n");
        out.write("                width: 100%;\n");
        out.write("                margin-top: 50px;\n");
        out.write("                margin-bottom: 20px;\n");
        out.write("            }\n");
        out.write("        </style>\n");
        out.write("    </head>\n");
        out.write("\n");
        out.write("    <body>\n");
        out.write("        <h1>Product Details</h1>\n");
        out.write("\n");
        out.write("        <!-- Create Form -->\n");
        out.write("        <form id=\"form\" method = \"post\" action = \"product?option=addproduct\">\n");
        out.write("\n");
        out.write("            <!-- Details -->\n");
        out.write("            <div class=\"form-control\">\n");
        out.write("                <label for=\"name\" id=\"label-name\">\n");
        out.write("                   Product Name\n");
        out.write("                </label>\n");
        out.write("\n");
        out.write("                <!-- Input Type Text -->\n");
        out.write("                <input type=\"text\"\n");
        out.write("                       id=\"name\" name =\"name\"\n");
        out.write("                       placeholder=\"Enter product name\" />\n");
        out.write("            </div>\n");
        out.write("\n");
        out.write("            <div class=\"form-control\">\n");
        out.write("                <label for=\"costperunit\" id=\"label-email\">\n");
        out.write("                    Cost Per Unit\n");
        out.write("                </label>\n");
        out.write("\n");
        out.write("                <!-- Input Type Email-->\n");
        out.write("                <input type=\"text\"\n");
        out.write("                       name =\"costperunit\"\n");
        out.write("                       id=\"costperunit\"\n");
        out.write("                       placeholder=\"Enter the cost per unit in &#x20b9;\" />\n");
        out.write("            </div>\n");
        out.write("\n");
        out.write("            <div class=\"form-control\">\n");
        out.write("                <label for=\"profitperunit\" id=\"label-age\">\n");
        out.write("                    Profit Per Unit\n");
        out.write("                </label>\n");
        out.write("\n");
        out.write("                <!-- Input Type Text -->\n");
        out.write("                <input type=\"text\"\n");
        out.write("                       id=\"profitperunit\"\n");
        out.write("                       name =\"profitperunit\"\n");
        out.write("                       placeholder=\"Enter the cost per unit in &#x20b9;\" />\n");
        out.write("            </div>\n");
        out.write("\n");
        out.write("            <div class=\"form-control\">\n");
        out.write("                <label for=\"weight\" id=\"label-role\">Weight</label>\n");
        out.write("                <input type = \"text\" id = \"weight\" name = \"weight\" placeholder=\"Enter the product weigth\" />\n");
        out.write("                <!-- Dropdown options -->\n");
        out.write("\n");
        out.write("            </div>\n");
        out.write("            <div class=\"form-control\">\n");
        out.write("                <label for=\"quantity\" id=\"label-role\">Quantity</label>\n");
        out.write("                <input type = \"text\" id = \"quantity\" name = \"quantity\" placeholder=\"Enter Product Quantity\" />\n");
        out.write("            </div>\n");
        out.write("\n");
        out.write("            <!-- Multi-line Text Input Control -->\n");
        out.write("            <button type=\"submit\" value=\"submit\">\n");
        out.write("                Submit\n");
        out.write("            </button>\n");
        out.write("        </form>\n");
        out.write("        <!--<a href = \"\"></a>-->\n");
        out.write("    </body>\n");
        out.write("\n");
        out.write("</html>\n");
    }

    public void viewProduct(Product[] product) {
        out.write("<!DOCTYPE html>\n");
        out.write("<html lang=\"en\" >\n");
        out.write("    <head>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <title>view All Customer Profile</title>\n");
        out.write("        <!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->\n");
        out.write("        <!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->\n");
        out.write("        <style>\n");
        out.write("            table.GeneratedTable {\n");
        out.write("                width: 100%;\n");
        out.write("                background-color: #ffffff;\n");
        out.write("                border-collapse: collapse;\n");
        out.write("                border-width: 2px;\n");
        out.write("                border-color: #000000;\n");
        out.write("                border-style: double;\n");
        out.write("                color: #000000;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            table.GeneratedTable td, table.GeneratedTable th {\n");
        out.write("                border-width: 2px;\n");
        out.write("                border-color: #000000;\n");
        out.write("                border-style: double;\n");
        out.write("                padding: 3px;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            table.GeneratedTable thead {\n");
        out.write("                background-color: #5ad368;\n");
        out.write("            }\n");
        out.write("        </style>\n");
        out.write("\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("    <h1 align = 'center'>Products</h1>\n");
        out.write("\n");
        out.write("        <!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->\n");
        out.write("        <table class=\"GeneratedTable\">\n");
        out.write("            <thead>\n");
        out.write("                <tr>\n");
        out.write("                    <th>ID</th>\n");
        out.write("                    <th>Name</th>\n");
        out.write("                    <th>Cost per unit</th>\n");
        out.write("                    <th>Profit per unit</th>\n");
        out.write("                    <th>Weight</th>\n");
        out.write("                    <th>Quantity</th>\n");
        out.write("\n");
        out.write("                </tr>\n");
        out.write("            </thead>\n");
        if (Objects.nonNull(product)) {
            for (Product tempProduct : product) {
                out.write("            <tbody>\n");
                out.write("                <tr>\n");
                out.write("                    <td>" + tempProduct.getId() + "</td>\n");
                out.write("                    <td>" + tempProduct.getName() + "</td>\n");
                out.write("                    <td>" + tempProduct.getPrice() + "</td>\n");
                out.write("                    <td>" + tempProduct.getProfitPerUnit() + "</td>\n");
                out.write("                    <td>" + tempProduct.getWeight() + "</td>\n");
                out.write("                    <td>" + tempProduct.getQuantity() + "</td>\n");
                out.write("                </tr>\n");
                out.write("            </tbody>\n");
            }
        }
        out.write("        </table>\n");
        out.write("\n");
        out.write("        <!-- partial -->\n");
        out.write("\n");
        out.write("<div align = \"center\"><br/><br/><br/><br/><br/><br/><br/>"
                + "<button><a href = \"shopkeeperhome.html\">Home</a></button></div>");
        out.write("    </body>\n");
        out.write("</html>");
    }

    public void deleteProductForm() {

        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>view customer</title>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("\n");
        out.write("      <div align = \"center\">  <form name = \"deleteproduct\" action=\"product?option=deleteproduct\" method = \"post\">\n");
        out.write("            <div class=\"deleteproduct\">\n");
        out.write("                <div class=\"container1\">\n");
        out.write("                    <h1 id=\"control-7823122\" align = \"center\">Product Deletion</h1></div>\n");
        out.write("                <div class=\"container2\">\n");
        out.write("                    <label for=\"id\" class=\"formbuilder-text-label\">Product Id<span class=\"formbuilder-required\">*</span></label>\n");
        out.write("                    <input type=\"text\" placeholder=\"Enter Your Product Id\" class=\"form-control\" name=\"id\" id=\"id\" required=\"required\" aria-required=\"true\">\n");
        out.write("                </div>\n");
        out.write("                <div class=\"formbuilder-button form-group field-submit\" align = \"center\">\n");
        out.write("                    <button type=\"submit\" class=\"btn-success btn\" name=\"submit\" style=\"success\" id=\"submit\">submit</button>\n");
        out.write("                </div>\n");
        out.write("            </div>\n</div>");
      out.write("<div align = \"center\"><br/><br/><br/><br/><br/><br/><br/>"
                + "<button><a href = \"shopkeeperhome.html\">Home</a></button></div>");
        out.write("        </form>\n");
        out.write("    </body>\n");
        out.write("</html>\n");
    }

}
