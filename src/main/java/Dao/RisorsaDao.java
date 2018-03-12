package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ariadne.it.AffittoRisorse.Risorsa;

public class RisorsaDao<T extends Risorsa> implements DAO<Integer,T> {

	private TreeMap<Integer, T> risorsaMap;
	
	public RisorsaDao() {
		risorsaMap = new TreeMap<>();
	}

	@Override
	public void createRecord(T risorsa) {
		risorsaMap.put(risorsa.getId(), risorsa);
	}

	@Override
	public void deleteRecord(Integer k) {
		risorsaMap.remove(k);
	}

	@Override
	public void updateRecord(Integer k, T t) {
		if(risorsaMap.containsKey(k))
			risorsaMap.put(k, t);
		else
			System.out.println("- Risorsa non presente, impossibile l'update.");
	}

	@Override
	public ArrayList<T> findAll() {
		ArrayList<T> listaRisorse = new ArrayList<>(risorsaMap.values());
		return listaRisorse;
	}

	@Override
	public T findById(Integer k) {
		return risorsaMap.get(k);
	}

	public boolean checkRisorsa(Integer key) {
		if(risorsaMap.containsKey(key))
			return true;
		else
			return false;
	}

	@Override
	public int mapSize() {
		return risorsaMap.size();
	}
}
