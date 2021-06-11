package com.formation.mycommerce;

public class UnknownCategoryException extends Throwable {
    public UnknownCategoryException(Long id) {
            super("The category with id=" + id + " doesn't exist.");
    }
}
