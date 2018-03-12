package Dao;

import java.util.ArrayList;
import java.util.List;
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

}
