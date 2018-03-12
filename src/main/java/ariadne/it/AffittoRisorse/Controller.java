package ariadne.it.AffittoRisorse;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import Dao.*;

public class Controller {
	
	private PrenotazioneDao prenotazioni;
	private RisorsaDao risorse;
	private UtenteDao utenti;
	
	public Controller() {
		this.prenotazioni = new PrenotazioneDao();
		this.risorse = new RisorsaDao();
		this.utenti = new UtenteDao();
	}
		
	public PrenotazioneDao getPrenotazioni() {
		return prenotazioni;
	}

	public RisorsaDao getRisorse() {
		return risorse;
	}

	public UtenteDao getUtenti() {
		return utenti;
	}

	// RISORSE CONTROLLER
	public <T extends Risorsa> void addRisorsa(T ris) {
		
		risorse.createRecord(ris);
	}
	
	public <T extends Risorsa> void updateRisorsa(int id, T ris) {
		if(risorse.checkRisorsa(id))
			risorse.updateRecord(id, ris);
		else
			System.out.println("- Risorsa non presente, impossibile l'update");
	}
	
	public void deleteRisorsa(int id) {
		if(risorse.checkRisorsa(id))
			risorse.deleteRecord(id);
		else
			System.out.println("- Risorsa non presente, impossibile eliminare");
		//find by id and if not null
	}
	
	public void printRisorsa(int id) {
		System.out.println(risorse.findById(id));
	}
	
	public void printAllRisorse() {
		System.out.println(risorse.findAll());
	}
	
	// UTENTI CONTROLLER
	public void addUtente(String mail, String psw, String nome) {
		if(!utenti.checkUtente(mail)) {
			if (utenti.checkData(mail, psw)){
				Utente user = new Utente(mail, psw, nome);
				utenti.createRecord(user);
			}else {
				System.out.println("- Non rispettati i pattern di mail e password");
			}
		}else {
			System.out.println("- Utente già presente.");
		}
	}
	
	public void deleteUtente(String key) {
		utenti.deleteRecord(key);
	}
	
	public void updateUtente(String mail, String psw, String nome) {
		if(utenti.checkUtente(mail)) {
			if(utenti.checkData(mail,psw)) {
				Utente u = new Utente(mail, psw, nome);
				utenti.updateRecord(mail, u);
			}
		}
	}
	
	public void printAllUtenti() {
		System.out.println(utenti.findAll());
	}
	
	public void printUtente(String key) {
		System.out.println(utenti.findById(key));
	}

	
	// PRENOTAZIONI CONTROLLER
	
	
	public void addPrenotazione(String mail,String tipo, int limite,  LocalDateTime dataInizio, LocalDateTime dataFine) {
		if(utenti.checkUtente(mail)) {
				if(dataInizio.isBefore(dataFine)) {
					int app = checkSlot(tipo, limite, dataInizio, dataFine);
					if(app!=-1) {
						Prenotazione p = new Prenotazione(app, mail, dataInizio, dataFine);
						System.out.println("aggiunta prenotazione");
						prenotazioni.createRecord(p);
					}else
						System.out.println("DIOBOIA hai paccato, non ci sono slot o risorse");
				}else{
					System.out.println("date sballate");
				}
		}else {
			System.out.println("User non presente");
		}
	}
	
	public ArrayList<Risorsa> findRisorseOk(String tipo, int limite) {
		ArrayList<Risorsa> tmp = new ArrayList<>();
		for(Risorsa r : (ArrayList<Risorsa>)risorse.findAll()) {
			if((r.getTipo().equals(tipo))&&(r.getLimite()>=limite)){
				tmp.add(r);
			}
		}
		return tmp;
	}
	
	public int checkSlot(String tipo, int limite, LocalDateTime start, LocalDateTime end) {
		List<Risorsa> risorseOk = new ArrayList<>();
		List<Risorsa> risorseOkDispo = new ArrayList<>();
		int index = -1;
		risorseOk = findRisorseOk(tipo, limite);
		boolean flag=true;
		for(Risorsa r: risorseOk) {
			flag = true;
			for(Prenotazione p : (ArrayList<Prenotazione>)prenotazioni.findAll()) {
				if(r.getId()==p.getIdRisorsa()) {
					if(!((start.isAfter(p.getDataFine()))||(end.isBefore(p.getDataInizio())))){
						System.out.println("SPACCATO");
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				risorseOkDispo.add(r);
				if(index==-1)
					index=r.getId();
				//append in an array to get the risorse disponibili in questo lsso di tempo
			}
		}
		if(index!=-1) {
			return index;
		}else {
			System.out.println("non inseribile in nessuno slot");
			return -1;
		}
	}
	
	
}
