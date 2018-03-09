package ariadne.it.AffittoRisorse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	private static Database db = new Database();
	
	
	
	public void addRisorsa(Risorsa ris) {
		db.setRisorse(ris);
	}
	public void checkDb() {
		System.out.println("Risorse:\n"+db.risorsetoString() +"\nUtenti: \n"+ db.utentitoString()+"\nPrenotazioni:\n"+db.prenotazionitoString());
	}
	public void addUtente(String mail, String psw) {
		boolean flag = false;
		for(User u: db.getUtenti()) {
			if(u.getMail().equals(mail)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			User user = new User(mail, psw);
			if(user.getMail()!=null&&user.getPsw()!=null)
				db.setUtenti(user);
			else
				System.out.println("invalid arguments to create user");
		}else {
			System.out.println("Utente già presente, cambiare mail.");
		}
	}
	public void printRisorse() {
		System.out.println("risorse: ");
		for(Risorsa r: db.getRisorse()) {
			System.out.println("--"+r.toString());
		}
	}
	
	public void addPrenotazione(String mail,String tipo, int limite,  LocalDateTime dataInizio, LocalDateTime dataFine) {
		if (db.checkUser(mail)) {
			//if(db.checkRisorsa(idRisorsa)) {
				if(dataInizio.isBefore(dataFine)) {
					int app = checkSlot(tipo, limite, dataInizio, dataFine);
					if(app!=-1) {
						Prenotazione p = new Prenotazione(app, mail, dataInizio, dataFine);
						System.out.println("aggiunta prenotazione");
						db.addPrenotazione(p);
					}else
						System.out.println("DIOBOIA hai paccato, non ci sono slot o risorse");
				}else{
					System.out.println("date sballate");
				}
//			}else {
//				System.out.println("risorsa inesistente");
//			}
		}else {
			System.out.println("User non existent");
		}
	}
	
	public ArrayList<Risorsa> findRisorse(String tipo, int limite) {
		ArrayList<Risorsa> tmp = new ArrayList<>();
		for(Risorsa r : db.getRisorse()) {
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
		risorseOk = findRisorse(tipo, limite);
		boolean flag=true;
		for(Risorsa r: risorseOk) {
			flag = true;
			for(Prenotazione p : db.getPrenotazione()) {
				if(r.getId()==p.getIdRisorsa()) {
					if(!((start.isAfter(p.dataFine))||(end.isBefore(p.dataInizio)))){
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
	
	public void cancellaPrenotazione(int idPrenotazione){
		db.cancellaPrenotazione(idPrenotazione);
	}
	
	public void consegna(int idPrenotazione) {
		db.getPrenotazione().get(idPrenotazione).consegna();
	}
	
	public void clear() {
		db.clear();
	}
	
	public Database getDb() {
		return db;
	}
	
}
