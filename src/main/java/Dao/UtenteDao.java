package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ariadne.it.AffittoRisorse.Utente;

public class UtenteDao<T extends Utente> implements DAO<String, T>{

	private TreeMap<String, T> utenteMap;
	
	public UtenteDao() {
		utenteMap = new TreeMap<>();
	}
	
	
	public boolean checkData(String mail, String psw) {
		String pswPattern = ".*{8,16}";
		String mailPattern = ".*[a-zA-Z0-9]@.*[a-zA-Z0-9]";
		if ((mail.matches(mailPattern))&&(psw.matches(pswPattern)))
			return true;
		else
			return false;
				
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
	
	public boolean checkUtente(String key) {
		if(utenteMap.containsKey(key))
			return true;
		else
			return false;
	}


	@Override
	public int mapSize() {
		return utenteMap.size();
	}


	@Override
	public void printAll() {
		System.out.println("-UTENTI: \n");
		for (Map.Entry<String, T> entry : utenteMap.entrySet()) {
	        T value = entry.getValue();
	        String key = entry.getKey();
	        System.out.println("-- "+ value.toString());
		}
				
	}


	public void clear() {
		utenteMap.clear();
	}

}
