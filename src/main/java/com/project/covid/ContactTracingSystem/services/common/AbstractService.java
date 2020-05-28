package com.project.covid.ContactTracingSystem.services.common;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.util.Lists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    private static Log log = LogFactory.getLog(AbstractService.class);

    @Override
    public T findOne(Object id) {
        return getDao().findById((Long) id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public T create(T entity) {
        Object id = getCampValue(entity);

        if (getDao().findById((long)id).isEmpty()){
            log.info("User Has Been Added :"+ entity.toString());
            return getDao().save(entity);
        }else {
           log.warn("User Already Exist :"+ entity.toString());
            return entity;
        }

    }

    @Override
    public T update(T entity) {
        try {
            Object object = getDao().findById((long)getCampValue(entity));
            if (object != null){
                return getDao().save(entity);
            }
        }catch (IllegalStateException e){
            throw e;
        }
        return entity;
    }

    @Override
    public void delete(T entity) {
        Object id = getCampValue(entity);
        deleteById(id);
    }

    @Override
    public void deleteById(Object entityId) {
        try {
            T auxEntity = findOne(entityId);
            if (auxEntity != null){
                getDao().delete(auxEntity);
            }

        }catch (Exception e){
            throw e;
        }

    }
    private Object getCampValue(T entity){
        if(entity == null){
            return null;
        }
        for(Field f : entity.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) {
                try {
                    f.setAccessible(true);
                    Object campValue = f.get(entity);
                    return campValue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    protected abstract JpaRepository<T, Long> getDao();
}
