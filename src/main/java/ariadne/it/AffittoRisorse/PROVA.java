package ariadne.it.AffittoRisorse;

import Dao.*;

public class PROVA {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		UtenteDao d1 = new UtenteDao();
		Utente u1 = new Utente("albi","ariadne","psw");
		d1.createRecord(u1);
		System.out.println(d1.findById("albi"));
	}

}
