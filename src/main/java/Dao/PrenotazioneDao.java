package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ariadne.it.AffittoRisorse.Prenotazione;

public class PrenotazioneDao<T extends Prenotazione> implements DAO<Integer, T> {

	private TreeMap<Integer, T> prenotazioneMap;

	public PrenotazioneDao() {
		prenotazioneMap = new TreeMap<>();
	}

	@Override
	public void createRecord(T t) {
		prenotazioneMap.put(t.getIdPrenotazione(), t);
	}

	@Override
	public void deleteRecord(Integer k) {
		prenotazioneMap.remove(k);
	}

	@Override
	public void updateRecord(Integer k, T t) {
		if(prenotazioneMap.containsKey(k))
			prenotazioneMap.put(k, t);
		else
			System.out.println("- Prenotazione non presente, impossibile l'update");
	}

	@Override
	public List<T> findAll() {
		List<T> listaPrenotazioni = new ArrayList<>(prenotazioneMap.values());
		return listaPrenotazioni;
	}
	
	

	@Override
	public T findById(Integer k) {
		return prenotazioneMap.get(k);
	}

	@Override
	public int mapSize() {
		return prenotazioneMap.size();
	}

	@Override
	public void printAll() {
		System.out.println("-PRENOTAZIONI: \n");
		for (Map.Entry<Integer, T> entry : prenotazioneMap.entrySet()) {
	        T value = entry.getValue();
	        Integer key = entry.getKey();
	        System.out.println("-- "+ value.toString());
		}
		
	}

	public void clear() {
		prenotazioneMap.clear();
		Prenotazione.resetIncrementaId();
	}

}
