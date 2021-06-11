package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        Long id = Long.parseLong(req.getParameter("id"));
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.remove(id);
        resp.sendRedirect(req.getContextPath()+"/listProduct");
    }
}

