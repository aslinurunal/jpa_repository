package repository.repository;

import java.util.List;

import javax.persistence.*;

import repository.model.Product;

public class ProductRepo implements Repo<Product>{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
	EntityManager manager = factory.createEntityManager();

	@Override
	public Product findById(long id) {
		return manager.find(Product.class, id);
	}

	@Override
	public List<Product> getAll() {
		Query query = manager.createQuery("SELECT u FROM Product u");
		return query.getResultList();
	}

	@Override
	public List<Product> getAll(int limit) {
		return null;
	}

	@Override
	public void add(Product product) {
		try {
			manager.getTransaction().begin();
			manager.persist(product);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("An error occurred!");
		}
	}

	@Override
	public void update(Product product) {
		
		Product changedProduct = findById(product.getId());
		
		changedProduct = product;
		
		try {
			manager.getTransaction().begin();
			manager.merge(changedProduct);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("An error occurred!");
		}
	}

	@Override
	public void remove(long id) {
      Product removedProduct = findById(id);
		
		try {
			manager.getTransaction().begin();
			manager.remove(removedProduct);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("An error occurred!");
		}
	}

}
