package model;

import utils.Logger;
import utils.Utils;

//Rappresenta l'entità, dove ogni entità è un record specifico della tabella in memoria
public class Persona implements Cloneable{
	
	private String nome, cognome, cf, age;
	private int ID=0;
	private static int id=0;
	
	private void increment() {
		ID = id++;
	}
	
	public Persona() {
		increment();
	}
	
	public Persona(String nome, String cognome, String cf, String age) {
		increment();
		this.nome = Utils.toUpperFirstChar(nome);
		this.cognome = Utils.toUpperFirstChar(cognome);
		this.cf = cf.toUpperCase();
		this.age = age;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = Utils.toUpperFirstChar(nome);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = Utils.toUpperFirstChar(cognome);
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf.toUpperCase();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int newID) {
		this.ID = newID;
	}
	
	public static void decreasesID() {
		id--;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[ID= " + ID + ", nome= " + nome + ", cognome= " + cognome + ", codice fiscale= " + cf + ", età= " + age + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())
			return false;
		Persona altro = (Persona) o;
		return((nome.equals(altro.getNome())) && (cognome.equals(altro.getCognome())) && (cf.equals(altro.getCf()))
				&& age.equals(altro.getAge()) && ID == altro.getID());
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + ID;
		result = 31 * result + nome.hashCode();
		result = 31 * result + cognome.hashCode();
		result = 31 * result + cf.hashCode();
		result = 31 * result + age.hashCode();
		
		return result;
	}
	
	@Override
	public Persona clone() {
		try {
			return (Persona) super.clone();
		} catch(CloneNotSupportedException e) {
			Logger.logger("CloneNotSupportedException generata");
			return null;
		}
	}
	
}
