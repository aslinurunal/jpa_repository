package repository.test;

import java.math.BigDecimal;
import java.util.Date;

import repository.model.Product;
import repository.repository.Repo;
import repository.repository.RepositoryFactory;

public class Test {
	public static void main(String[] args) {
 
		Repo repo = RepositoryFactory.getProductRepository();
		
		@SuppressWarnings("deprecation")
		Product product = new Product("laptop",BigDecimal.valueOf(10000.50), new Date(120,3,30));
		
		repo.add(product);
	}
}
