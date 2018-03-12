package Dao;

import java.util.List;

public interface DAO<K, T>{
	
	public void createRecord(T t);
	public void deleteRecord(K k);
	public void updateRecord(K k, T t);
	public List<T> findAll();
	public T findById(K k);
	public int mapSize();
	
}
