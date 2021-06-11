package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.entity.Category;
import com.formation.mycommerce.entity.Product;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class AddProductServlet extends HttpServlet {
    private EntityManagerFactory emf = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareRequest(req);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String productContent = req.getParameter("productContent");
        String productPriceStr = req.getParameter("productPrice");
        String productCategoryStr = req.getParameter("productCategory");
        float productPrice = 0;
        long productCategory = 0;

        try {
            productPrice = Float.parseFloat(productPriceStr);
            productCategory = Long.parseLong(productCategoryStr);

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        Product product = new Product();
        product.setName(productName);
        product.setContent(productContent);
        product.setPrice(productPrice);
        CategoryDao<Long, Category> categoryDao = DaoFactory.getCategoryDao();
        Category categoryProduct = categoryDao.findById(productCategory);
        product.setCategory(categoryProduct);
        ProductDao productDao = DaoFactory.getProductDao();
        Long createdId = productDao.create(product);

        boolean isCreated = createdId == 0 ? false : true;

        if (!isCreated){
           req.setAttribute("error", "Erreur le produit n'a pas de catégorie");
           RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/addProduct.jsp");
           prepareRequest(req);
           rd.forward(req, resp);

        }
        resp.sendRedirect(req.getContextPath() + "/listProduct");
    }

    public void prepareRequest(HttpServletRequest req){
        CategoryDao<Long, Category> categoryDao = DaoFactory.getCategoryDao();
        List<Category> categories = categoryDao.findAll();
        req.setAttribute("categoryList", categories);
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
