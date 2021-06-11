package com.formation.mycommerce.dao.interfaz;

import java.util.List;

public interface ProductDao<ID,T> {
    Long create(T object);

    T findById(ID id);

    List<T> findAll();

    Boolean update(T object);

    Boolean remove(ID id);
}