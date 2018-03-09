package Risorse;

import ariadne.it.AffittoRisorse.Risorsa;

public class Laptop extends Risorsa{

	public Laptop(int limite) {
		this.id = incrementaID;
		incrementaID +=1;
		this.limite = limite ;
		this.tipo = "laptop";
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", tipo=" + tipo + ", limite=" + limite + "]";
	}

}
