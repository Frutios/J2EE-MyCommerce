package com.formation.mycommerce.servlet;


import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.entity.Product;
import com.formation.mycommerce.UnknownProductException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/", "/listProduct"})
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws UnknownProductException, IOException, ServletException {
        ProductDao productDao = DaoFactory.getProductDao();
        List<Product> products  = productDao.findAll();
        req.setAttribute("products", products);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);

    }
}
