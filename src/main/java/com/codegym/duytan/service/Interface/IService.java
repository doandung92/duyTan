package com.codegym.duytan.service.Interface;

import java.util.List;
import java.util.Optional;

public interface IService<V, K> {

    List<V> findAll();
    Optional<V> findById(K id);
    void remove(V v);
    V save (V v);
}
