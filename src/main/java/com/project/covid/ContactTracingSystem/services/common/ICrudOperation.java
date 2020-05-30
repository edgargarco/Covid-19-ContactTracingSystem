package com.project.covid.ContactTracingSystem.services.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * This in a interface with must common CRUD operations.
 * Implements this interface in all services that need a CRUD.
 *
 * */
public interface ICrudOperation<T, ID> {
    /**
     * Function to create a new instance of an object on the persistence layer.
     *
     * @param entity the object that going to be persisted
     * @return entity type - the created object on the database
     */
    T createOrUpdate(T entity);

    /**
     *
     * @param id
     */
    void deleteById(ID id);

    /**
     *
     * @return
     */
    Collection<T> findAll();

    /**
     *
     * @param id
     * @return
     */
    T findById(ID id);
}