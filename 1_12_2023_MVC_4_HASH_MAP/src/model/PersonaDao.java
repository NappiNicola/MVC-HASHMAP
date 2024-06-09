package model;

import java.util.HashMap;
import java.util.Map;
import utils.Utils;

public class PersonaDao {
	
	private HashMap<Integer, Persona> persone;	//Mappa di oggetti Persona
	
	public PersonaDao() {
		persone = new HashMap<Integer, Persona>();
	}
	
	//metodo per controllare se la lista è vuota anche al di fuori della classe
	public boolean isEmpty() {
		return persone.isEmpty();
	}
	
	//metodo per l'inserimento di un oggetto Persona
	public boolean addPeopleInNull(Persona p) {
		
		if(isDuplicateCF(p.getCf())) {
			Utils.print("Impossibile effettuare l'inserimento, cf gia presente");
			Persona.decreasesID();
			return false;
		}
		
		persone.put(p.getID(), p);
		return true;
	}
	
	//metodo per la ricerca
	public int searchPeopleToCf(String cf) {	
		for(Map.Entry<Integer, Persona> entry : persone.entrySet()) {
			Persona p = entry.getValue();
			if(p.getCf().equals(cf.toUpperCase()))
				return entry.getKey();
		}
		return -1;
	}
	
	//metodo per l'eliminazione
	public Persona deletePerson(int index) {
		if(index != -1) {
			return persone.remove(index);
		}else {
			Utils.print("Eliminazione non effettuata, persona non presente");
			return null;
		}
	}
	
	//metodo per la modifica
	public void modify(int index, Persona p) {
		
		if(!persone.get(index).getCf().equals(p.getCf())) {
			if(isDuplicateCF(p.getCf())) {
				Utils.print("Codice fiscale duplicato, impossibile apportate modifiche");
				return;
			}

		}else {

			if(Utils.leggiString("Confermi le modifiche? Si/No").equalsIgnoreCase("si")) {
				persone.put(index, p);//se l'utente intende attuare le modifiche, eseguo un update dell'oggetto in posizione index
				Utils.print("Modifiche validate...\n");
			}else
				Utils.print("Modifiche invalidate...\n");
		}
	}
	
	//metodo per restituire l'intera ArrayList
	public HashMap<Integer, Persona> getCollezione() {
		return persone;
	}
	
	private boolean isDuplicateCF(String cf) {
		for(Map.Entry<Integer, Persona> entry : persone.entrySet()) {
			Persona p = entry.getValue();
			if(p.getCf().equals(cf.toUpperCase()))
				return true;
		}
		return false;
	}
	
}//fine classe
