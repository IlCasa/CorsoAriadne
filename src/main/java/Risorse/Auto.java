package Risorse;

import ariadne.it.AffittoRisorse.*;

public class Auto extends Risorsa {
	
	public Auto(int limite) {
		this.id = incrementaID;
		incrementaID +=1;
		this.limite = limite ;
		this.tipo = "auto";
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", tipo=" + tipo + ", limite=" + limite + "]";
	}
	
	
	
}
