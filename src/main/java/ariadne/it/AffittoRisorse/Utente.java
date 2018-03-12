package ariadne.it.AffittoRisorse;

public class Utente {
	private String mail, password, nome;

	public Utente(String mail, String password, String nome) {
		this.mail = mail;
		this.nome = nome;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
