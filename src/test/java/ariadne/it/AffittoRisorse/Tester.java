package ariadne.it.AffittoRisorse;

import org.junit.After;
import org.junit.Test;
import org.joda.time.LocalDateTime;

import Risorse.*;
import junit.framework.Assert;

public class Tester {
	
	Controller c = new Controller();
	
	@After 
	public void clear() {
		c.clearAll();
	}
	
	@Test
	public void shouldNotAddUtente() {
		System.out.println("TEST 1:");
		c.addUtente("albicasa", "ariadne", "Alberto");
		int size = c.getUtenti().mapSize();
		Assert.assertTrue("l'utente non è stato aggiunto", size == 0);
	}
	@Test 
	public void shouldAddUtente() {
		c.addUtente("albi@casa", "ariadne88", "alberto");
		Assert.assertTrue("c'è un utente", c.getUtenti().mapSize()==1);
	}

	@Test
	public void shouldAddRisorsa() {
		Risorsa ris = new Auto(5);
		Risorsa ris2 = new Laptop(7);
		c.addRisorsa(ris);
		c.addRisorsa(ris2);
		Assert.assertTrue("c'è una risorsa aggiunta, anzi due", c.getRisorse().mapSize() == 2);
	}
	
	@Test
	public void shouldNotAddPrenotazione() {
		//c.addPrenotazione("nope@not", "auto", 5, new LocalDateTime(2018, 2, 2, 12, 00), new LocalDateTime(2018, 2, 2, 22, 00));
		Assert.assertTrue("1 prenotella", c.getPrenotazioni().mapSize() == 0);
	}
	@Test
	public void shouldAddPrenotazione() {
		c.addUtente("albi@casa", "ariadne88", "alberto");
		Risorsa ris = new Auto(5);
		c.addRisorsa(ris);
		c.addPrenotazione("albi@casa", "auto", 5, new LocalDateTime(2018, 2, 2, 12, 00), new LocalDateTime(2018, 2, 2, 22, 00));
		Assert.assertTrue("1 prenotella", c.getPrenotazioni().mapSize() == 1);
	}
	
	@Test
	public void shouldPrintAllStuff() {
		System.out.println("\nTest PrintallStuff");
		c.addUtente("albi@casa", "ariadne88", "alberto");
		c.addUtente("marghe@casaMi", "ariadne100", "margherita");
		c.addUtente("guglie@casa", "ariadne77", "gianluca");
		Risorsa ris = new Auto(5);
		Risorsa ris2 = new Auto(5);
		Risorsa ris3 = new Auto(5);
		Risorsa ris4 = new Laptop(7);
		Risorsa ris5 = new Laptop(7);
		c.addRisorsa(ris);
		c.addRisorsa(ris2);
		c.addRisorsa(ris3);
		c.addRisorsa(ris4);
		c.addRisorsa(ris5);
		c.addPrenotazione("albi@casa", "auto", 5, new LocalDateTime(2018, 2, 2, 12, 00), new LocalDateTime(2018, 2, 2, 22, 00));
		c.addPrenotazione("marghe@casaMi", "laptop", 6, new LocalDateTime(2018, 2, 2, 12, 00), new LocalDateTime(2018, 2, 2, 22, 00));
		c.printEverything();
	}
	
	@Test
	public void shouldUpdateRisorsa() {
		Risorsa ris = new Auto(10);
		c.addRisorsa(ris);
		Risorsa ris1 = new Auto(5);
		c.updateRisorsa(ris.getId(), ris1);
	}
	
	@Test
	public void shouldNotUpdateRisorsa() {
		System.out.println("TEST EXC");
		Risorsa ris = new Auto(5);
		Risorsa ris1 = new Laptop(7);
		c.addRisorsa(ris);
		System.out.println(ris.getId()+"  e tipo "+ris.getTipo()+"  limite "+ ris.getLimite());
		//c.printAllRisorse();
		c.updateRisorsa(0, ris1);
		//c.printAllRisorse();
		
	}
	
	@Test
	public void heavyLoad() {
		System.out.println("\nTest HeavyLoad");
		for(int i = 0; i<1000000; i++) {
			Risorsa ris = new Auto(5);
			c.addRisorsa(ris);
		}
		System.out.println("fine HL");
		
		
	}
	
}
