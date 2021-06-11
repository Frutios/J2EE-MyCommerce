package com.formation.mycommerce.dao;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompile

import com.formation.mycommerce.UnknownProductException;
import com.formation.mycommerce.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyProductDao {
    private static List<Product> products = new ArrayList();
    private static Long idSequence = 1L;

    private MyProductDao() {
    }

    public static void addProduct(Product product) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        product.setId(var1);
        products.add(product);
    }

    public static void updateProduct(Product product) {
        int index = getProductIndexById(product.getId());
        if (index > -1) {
            products.set(index, product);
        } else {
            throw new UnknownProductException(product.getId());
        }
    }

    public static Product findProductById(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            Product product = (Product)products.get(index);
            return product;
        } else {
            throw new UnknownProductException(id);
        }
    }

    public static List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public static void removeProduct(Product product) {
        removeProduct(product.getId());
    }

    public static void removeProduct(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            products.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private static int getProductIndexById(Long id) {
        for(int i = 0; i < products.size(); ++i) {
            Product product = (Product)products.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}

