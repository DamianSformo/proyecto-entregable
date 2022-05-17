package com.dh.booking.service;

import java.util.Set;

public interface IService<T>{

    Set<T> getAll();
    T get(Long id);
    void save(T t);
    void delete(Long id);
}
