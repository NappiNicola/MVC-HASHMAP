package view;

import java.util.HashMap;
import java.util.Map;
import model.*;
import utils.Utils;

public class View {

	// metodo che stampa una singola persona
	public void printPersona(Persona p) {
		Utils.print(p.toString());
	}

	// metodo per il popolamento di un oggetto Persona
	public Persona newPersona(Persona p) {
		p.setNome(Utils.leggiString("Inserisci il nome"));
		p.setCognome(Utils.leggiString("Inserisci il cognome"));
		p.setCf(Utils.leggiString("Inserisci il codice fiscale"));
		p.setAge(Utils.leggiString("Inserisci l'età"));
		return p;
	}
	
	//metodo per l'aggiornamento di un Oggetto Persona
	public Persona mascheraModifica(Persona p, Persona tmp) {
		
		int count=0;
		
		String nome = Utils.leggiString("Nome[" + p.getNome() + "]:");
		if(!nome.equalsIgnoreCase("")) {	//controllo che l'utente non prema invio senza inserire nulla, in tal caso non effettuo modifiche
			tmp.setNome(nome);
			count++;
		}else 
			tmp.setNome(p.getNome());
		String cognome = Utils.leggiString("Cognome[" + p.getCognome() + "]:");
		if(!cognome.equalsIgnoreCase("")) {	//controllo che l'utente non prema invio senza inserire nulla, in tal caso non effettuo modifiche
			tmp.setCognome(cognome);
			count++;
		}else 
			tmp.setCognome(p.getCognome());
		String cf = Utils.leggiString("Codice fiscale[" + p.getCf() + "]:");
		if(!cf.equalsIgnoreCase("")) {	//controllo che l'utente non prema invio senza inserire nulla, in tal caso non effettuo modifiche
			tmp.setCf(cf);
			count++;
		}else 
			tmp.setCf(p.getCf());
		String age = Utils.leggiString("Età [" + p.getAge() + "]:");
		if(!age.equalsIgnoreCase("")) {	//controllo che l'utente non prema invio senza inserire nulla, in tal caso non effettuo modifiche
			tmp.setAge(age);
			count++;
		}else 
			tmp.setAge(p.getAge());

		if(count == 0) {
			Utils.print("\nNessun campo modificato, nessuna modifica effettuata...\n");
			return null;
		}
		return tmp;
	}

	// metodo per la stampa dell'array di oggetti Persona
	public void printPeople(HashMap<Integer, Persona> list) {
		Utils.print("");
		
		if(!list.isEmpty()) {
			for(Map.Entry<Integer, Persona> entry : list.entrySet()) {
				Utils.print(entry.getValue().toString());
			}
		}else
			Utils.print("Collezione vuota...");
		
		Utils.print("");
	}

	public void msg(String s) {
		Utils.print(s);
	}

	public int printMenu() {
		return Utils.leggiNonLettInt("--->	MENU	<---\n0: Esci\n1: Inserisci\n2: Stampa collezione\n3: Ricerca persona\n4: Eliminazione persona\n"
				+ "5: Modifica\n-->");
	}

}// fine classe
