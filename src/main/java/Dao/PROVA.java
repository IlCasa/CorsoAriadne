package Dao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ariadne.it.AffittoRisorse.Utente;

public class PROVA {
	
	public static ExecutorService executor = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
		for (int i =0 ; i< 1000 ; i++) {
			
			executor.submit(new UtenteCr());
		}
		UtenteCr uc = new UtenteCr();
		//System.out.println(uc.sized());
		executor.shutdown();
	}
}


class UtenteCr implements Runnable {
	public static UtenteDao ud;
	
	@Override
	public void run() {
		Utente u = new Utente("mail@mail", "password2", "albi");
		ud.createRecord(u);
	}
	public int sized () {
		return ud.mapSize();
	}
}