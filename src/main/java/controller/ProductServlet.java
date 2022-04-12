package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static CategoryDAO categoryDAO = new CategoryDAO();
    private static ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "add":
                    showAddForm(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    getAllProduct(request,response);
                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "add":
                    addProduct(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    break;

            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArrayList<Product> products = productDAO.getAll();
        request.setAttribute("products",products);
        RequestDispatcher rD = request.getRequestDispatcher("homepage.jsp");
        rD.forward(request,response);
    }
    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher rD = request.getRequestDispatcher("addProduct.jsp");
        ArrayList<Category> categories = categoryDAO.getAll();
        request.setAttribute("categories",categories);
        rD.forward(request,response);
    }
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        double price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category"));
        Category category = categoryDAO.getById(category_id);
        Product product = new Product(name,price,quantity,color,description,category);
        productDAO.insertRecord(product);
        response.sendRedirect("/ProductServlet");
    }
}
