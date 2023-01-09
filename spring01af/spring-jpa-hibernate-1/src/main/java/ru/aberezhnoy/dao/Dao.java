package ru.aberezhnoy.dao;

import ru.aberezhnoy.persist.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Dao <T, ID extends Serializable>{
    List<T> findAll();

    Optional<Product> findById(ID id);

    T saveOrUpdate(T obj);

    void deleteById(ID id);
}
