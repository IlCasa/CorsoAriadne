package ariadne.it.AffittoRisorse;

public abstract class Risorsa {
	protected Integer id;
	protected String tipo;
	protected int limite;
	protected static int incrementaID;
	
	
	public String getTipo() {
		return tipo;
	}
	public Integer getId() {
		return id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}


	public static void resetIncrementaID() {
		Risorsa.incrementaID = 0;
	}
	
	
}
