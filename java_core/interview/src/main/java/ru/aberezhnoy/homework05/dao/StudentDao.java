package ru.aberezhnoy.homework05.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface StudentDao<T, ID extends Serializable> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void deleteById(ID id);

    T saveOrUpdate(T obj);
}
