package ru.aberezhnoy.dao;

import ru.aberezhnoy.persist.Customer;
import ru.aberezhnoy.persist.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer, Long> {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Customer saveOrUpdate(Customer obj) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
