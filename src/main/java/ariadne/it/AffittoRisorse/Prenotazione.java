package ariadne.it.AffittoRisorse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Prenotazione {
	private int idRisorsa;
	private String user;
	LocalDateTime dataInizio;
	LocalDateTime dataFine;
	private LocalDateTime DataConsegna;
	private int idPrenotazione;
	private static int addId;
	
	public Prenotazione(int idRisorsa, String user, LocalDateTime dataInizio2, LocalDateTime dataFine2) {
		this.idRisorsa = idRisorsa;
		this.user = user;
		this.dataInizio = dataInizio2;
		this.dataFine = dataFine2;
		this.idPrenotazione = addId;
		addId ++;
	}
	
	public int getIdRisorsa() {
		return idRisorsa;
	}
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public String getIdUtente() {
		return user;
	}
	public boolean consegnato() {
		LocalDateTime dataAttuale = LocalDateTime.now();
		if (DataConsegna.isBefore(dataAttuale)) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Prenotazione [idRisorsa=" + idRisorsa + ", user=" + user + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", DataConsegna=" + DataConsegna + ", idPrenotazione=" + idPrenotazione + "]";
	}
	public void consegna() {
		DataConsegna = LocalDateTime.now();
	}
	
	
	
	
	
	
	
}
