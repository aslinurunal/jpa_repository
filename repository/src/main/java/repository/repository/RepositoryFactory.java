package repository.repository;

public class RepositoryFactory {
	
	public static Repo getProductRepository() {
		return new ProductRepo();
	}

}
