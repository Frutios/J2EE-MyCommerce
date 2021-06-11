package com.formation.mycommerce.dao.interfaz;

import java.util.List;

public interface CategoryDao <ID,T>{
    Long create(T object);

    T findById(ID id);

    List<T> findAll();

    Boolean update(T object);

    Boolean remove(ID id);
}