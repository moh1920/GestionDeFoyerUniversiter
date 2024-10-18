package org.sayari.tpspringboot.service.Impl;

import org.sayari.tpspringboot.model.Chambre;

import java.util.List;

public interface CrudImpl<T> {
    T add(T value);      // Use T as defined at the interface level
    List<T> getAll();     // No need for <T> before List<T>, since T is already defined
    T get(Long id);       // Use the same T for return type
    T update(T value);    // Same for update
    void remove(Long id);    // Same for remove
}
