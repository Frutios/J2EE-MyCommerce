package com.formation.mycommerce.dao;

import com.formation.mycommerce.UnknownCategoryException;
import com.formation.mycommerce.entity.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCategoryDao {
    private static List<Category> categories = new ArrayList();
    private static Long idSequence = 1L;

    private MyCategoryDao() {
    }

    public static void addCategory(Category category) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        category.setId(var1);
        categories.add(category);
    }

    public static void updateProduct(Category category) throws UnknownCategoryException {
        int index = getCategoryIndexById(category.getId());
        if (index > -1) {
            categories.set(index, category);
        } else {
            throw new UnknownCategoryException(category.getId());
        }
    }

    public static Category findCategoryById(Long id) throws UnknownCategoryException {
        int index = getCategoryIndexById(id);
        if (index > -1) {
            Category category = (Category) categories.get(index);
            return category;
        } else {
            throw new UnknownCategoryException(id);
        }
    }

    public static List<Category> getAllCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static void removeCategory(Category category) {
        removeCategory(category.getId());
    }

    public static void removeCategory(Long id)  {
        int index = getCategoryIndexById(id);
        if (index > -1) {
            categories.remove(index);
        } else {
            try {
                throw new UnknownCategoryException(id);
            } catch (UnknownCategoryException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getCategoryIndexById(Long id) {
        for(int i = 0; i < categories.size(); ++i) {
            Category category = (Category)categories.get(i);
            if (category.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
