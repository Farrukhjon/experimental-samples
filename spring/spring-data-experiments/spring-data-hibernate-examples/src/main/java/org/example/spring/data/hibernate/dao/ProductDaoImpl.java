/**
 * 
 */
package org.example.spring.data.hibernate.dao;

import org.example.spring.data.hibernate.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Repository
public abstract class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public <S extends Product> S save(S entity) {
		return (S) template.save(entity);
	}

	@Override
	public Iterable<Product> findAll() {
		return (Iterable<Product>) template.find("from products");
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Product> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub
		
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Product> entities) {
		// TODO Auto-generated method stub
		
	}




	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
