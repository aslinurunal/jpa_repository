package repository.repository;

import java.util.List;

public interface Repo<T> {
	
	T findById(long id);
	List<T> getAll();
	List<T> getAll(int limit);
	void add(T t);
	void update(T t);
	void remove(long id);
	
	

}
