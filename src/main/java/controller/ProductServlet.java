package controller;

import models.Product;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "findByName":
                showFindByName(request, response);
                break;
            case "findByPrice":
                showFindByPrice(request, response);
                break;
            case "view":
                showInfor(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    void showInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/view.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("productView", product);
        dispatcher.forward(request, response);
    }

    void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/list.jsp");
        List<Product> productList = productService.findAll();
        request.setAttribute("danhsach", productList);
        requestDispatcher.forward(request, response);
    }

    void showFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/findByName.jsp");
        requestDispatcher.forward(request, response);
    }

    void showFindByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/findByPrice.jsp");
        requestDispatcher.forward(request, response);
    }

    void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("pDelete", product);
        requestDispatcher.forward(request, response);
    }

    void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("pEdit", product);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveCreate(request, response);
                break;
            case "edit":
                saveEdit(request, response);
                break;
            case "delete":
                saveDelete(request, response);
                break;
            case "findByName":
                saveFindByName(request, response);
                break;
            case "findByPrice":
                saveFindByPrice(request, response);
                break;
            default:
        }
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double price = Double.parseDouble(request.getParameter("price"));
        String name = request.getParameter("name");
        productService.update(id, new Product(id, name, price));
        response.sendRedirect("/products");
    }

    private void saveCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double price = Double.parseDouble(request.getParameter("price"));
        String name = request.getParameter("name");
        productService.save(new Product(id, name, price));
        response.sendRedirect("/products");
    }

    private void saveDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect("/products");
    }

    private void saveFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> listByName = productService.findByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listByName.jsp");
        request.setAttribute("ListName", listByName);
        dispatcher.forward(request, response);
    }

    private void saveFindByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listByPrice.jsp");
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));
        List<Product> listByPrice = productService.findByPrice(min, max);
        request.setAttribute("ListPrice", listByPrice);
        dispatcher.forward(request, response);
    }
}
