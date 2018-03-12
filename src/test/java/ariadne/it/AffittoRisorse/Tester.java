package ariadne.it.AffittoRisorse;

import org.junit.Test;
import org.joda.time.LocalDateTime;

import Risorse.*;
import junit.framework.Assert;

public class Tester {
	
	Controller c = new Controller();
	
	@Test
	public void shouldNotAddUtente() {
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
		c.addPrenotazione("nope@not", "auto", 5, new LocalDateTime(2018, 2, 2, 12, 00), new LocalDateTime(2018, 2, 2, 22, 00));
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
	
	
}
