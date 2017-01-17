package org.farrukh.experiments.spring.orm.jpa.dao;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.farrukh.experiments.spring.orm.dao.IOperations;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.base.Preconditions;

@SuppressWarnings("unchecked")
public abstract class AbstractJpaDao<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz;
    
    @PersistenceContext // Injection of the EntityManager
    EntityManager entityManager;

    public AbstractJpaDao(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    @Override
    public final T findOne(final long id) {
        return entityManager.find(clazz, id);
    }
    
    @Override
    public T findOne(Serializable id) {
        return entityManager.find(clazz, id);
    }
    
    @Cacheable(value = "employeeFindCache", key = "#name")
    @Override
    public List<T> findByName(String name) {
        waitQuery();
        return entityManager.createQuery("from Employee where firstName = :name").setParameter("name", name).getResultList();
    }
    
    private void waitQuery() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public final List<T> findAll() {
        String query = "";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        entityManager.persist(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return entityManager.merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        entityManager.remove(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

}
