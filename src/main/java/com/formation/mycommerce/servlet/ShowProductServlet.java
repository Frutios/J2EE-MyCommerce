package com.formation.mycommerce.servlet;

import com.formation.mycommerce.entity.Product;
import com.formation.mycommerce.dao.MyProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = null;

        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        Product product = MyProductDao.findProductById(id);
        req.setAttribute("product", product);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/showProduct.jsp");
        rd.forward(req,resp);

    }
}
