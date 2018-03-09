package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ariadne.it.AffittoRisorse.Utente;

public class UtenteDao<T extends Utente> implements DAO<String, T>{

	private TreeMap<String, T> utenteMap;
	
	public UtenteDao() {
		utenteMap = new TreeMap<>();
	}
	
	@Override
	public void createRecord(T t) {
		utenteMap.put(t.getMail(), t);
	}

	@Override
	public void deleteRecord(String key) {
		utenteMap.remove(key);
	}

	@Override
	public void updateRecord(String key, T t) {
		if(utenteMap.containsKey(key))
			utenteMap.put(key, t);
		else
			System.out.println("key non presente, provare a creare");
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>(utenteMap.values());

		return list;
	}

	@Override
	public T findById(String key) {
		return utenteMap.get(key);
	}

}
