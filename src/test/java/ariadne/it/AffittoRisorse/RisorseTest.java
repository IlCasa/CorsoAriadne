package ariadne.it.AffittoRisorse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Risorse.*;

public class RisorseTest {
	
	private Controller c;
	private Risorsa b;
	private Risorsa d;
	
	@Before
	public void setup() {
		c = new Controller();
		b = new Auto(5);
		d = new Laptop(7);
		c.addUtente("albi@ariadne.it","ariadne1");
		c.addRisorsa(b);
		c.addRisorsa(d);
	}
	
	@After
	public void clear() {
		c.clear();
	}
	
	@Test
	public void createResource() {
		Risorsa a = new Auto(5);
		//System.out.println(a.toString());
		Risorsa l = new Laptop(10);
		//System.out.println(l.toString());
		//System.out.println(a.getId());
	}
	
	@Test
	public void controllerOnDb() {
		c.addRisorsa(b);
		c.addRisorsa(d);
		//c.checkDb();
	}
	
	@Test 
	public void addUserDb() {
		c.addUtente("amede0@araidne.it","ariadne2");
		//c.checkDb();
	}
	
	@Test
	public void addPrenotazione() {
		c.addUtente("albi2@com","ariadne3");
		
		//c.addPrenotazione("albi", 1,"laptop", 5, LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 1), LocalTime.of(12, 20)), LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 2), LocalTime.of(12, 40)));
		//DATA SBALLATA c.addPrenotazione("albi2", 1, LocalDateTime.of(2018, Month.MARCH, 1, 12, 20, 20), LocalDateTime.of(2018, Month.MARCH, 1, 11,00,00));
	
		//c.checkDb();
	}
	
	@Test
	public void shouldGetResourcesFromaType() {
		Risorsa a1 = new Auto(10);
		Risorsa a2 = new Auto(2);
		c.addRisorsa(a1);
		c.addRisorsa(a2);
		for(Risorsa r : c.findRisorse("auto", 4)) {
			//System.out.println("risorsa found: " + r.toString());
		}
		for(Risorsa r : c.findRisorse("laptop", 4)) {
		//	System.out.println("risorsa found: " + r.toString());
		}		
	}
	
	@Test
	public void shouldCheckSlot() {
		Risorsa a1 = new Auto(10);
		c.addRisorsa(a1);
		c.addUtente("Angela@ariadne.it", "8caratteri");
		c.addUtente("ar", "4car");
		c.addPrenotazione("albi@ariadne.it","auto", 4 , LocalDateTime.of(2018, Month.MARCH, 5, 10,30), LocalDateTime.of(2018, Month.MARCH, 5, 11,45));
		c.addPrenotazione("albi@ariadne.it","laptop", 6 , LocalDateTime.of(2018, Month.MARCH, 5, 14, 00), LocalDateTime.of(2018, Month.MARCH, 5, 15,00));
		c.addPrenotazione("albi@NOTHERE","auto", 4, LocalDateTime.of(2018, Month.MARCH, 5, 19,00), LocalDateTime.of(2018, Month.MARCH, 5, 21,00));
		c.addPrenotazione("albi@ariadne.it", "auto", 5, LocalDateTime.of(2018, Month.MARCH, 5, 9,00),  LocalDateTime.of(2018, Month.MARCH, 5, 20,00));
		c.addPrenotazione("albi@ariadne.it", "auto", 5, LocalDateTime.of(2018, Month.MARCH, 5, 10,00),  LocalDateTime.of(2018, Month.MARCH, 5, 15,00));
		int numPren = c.getDb().getNumPrenotazioni();
		Assert.assertTrue("£ prenotazioni totali", numPren == 3);
		c.checkDb();
		
	
		
	}
	
}
