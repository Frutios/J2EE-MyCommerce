package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.entity.Category;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
    private EntityManagerFactory emf = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/addCategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        Category category = new Category();
        category.setName(categoryName);
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        categoryDao.create(category);

        resp.sendRedirect(req.getContextPath()+"/listProduct");

    }

    @Override
    public void destroy() {
        this.emf.close();
    }

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("PU");
    }
}
