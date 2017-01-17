package org.farrukh.experiments.spring.orm.hibernate3.dao;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.farrukh.experiments.spring.orm.dao.IOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.base.Preconditions;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz;
    
    @Autowired
    private SessionFactory sessionFactory;

    // API
    
    public AbstractHibernateDao(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    @Override
    public final T findOne(final long id) {
        return ((T) getCurrentSession().get(clazz, id));
    }
    
    @Override
    public T findOne(Serializable id) {
        return ((T) getCurrentSession().get(clazz, id));
    }
    
    @Cacheable(value = "employeeFindCache", key = "#name")
    @Override
    public List<T> findByName(String name) {
        waitQuery();
        return getCurrentSession().createQuery("from Employee where firstName = :name").setParameter("name", name).list();
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
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().persist(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    

}
