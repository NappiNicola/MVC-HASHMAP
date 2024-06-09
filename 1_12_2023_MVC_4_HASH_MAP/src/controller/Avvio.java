package controller;

import model.*;
import utils.Utils;
import view.*;

public class Avvio {

	public static void main(String[] args) {

		PersonaDao pDao = new PersonaDao();
		View v = new View();

		while (true) {

			switch (v.printMenu()) {
			case 0:
				v.msg("ARRIVEDERCI");
				return;
			case 1:
				if(pDao.addPeopleInNull(v.newPersona(new Persona())))
					v.msg("\nInserimento effettuato...\n");
				else
					v.msg("Inserimento non effettuato");
				break;
			case 2:
				if(!pDao.isEmpty())
					v.printPeople(pDao.getCollezione());
				else
					v.msg("\nCollezione vuota...\n");
				break;
			case 3:
				if(!pDao.isEmpty()) {
					int index = pDao.searchPeopleToCf(Utils.leggiString("Inserisci codice fiscale"));
					if(index != -1)
						v.msg("\nPersona trovata: " + pDao.getCollezione().get(index) + "\n");
					else
						v.msg("\nPersona non presente\n");
				} else 
					v.msg("\nCollezione vuota, impossibile effettuare ricerca...\n");
				break;
			case 4: 
				if(!pDao.isEmpty()) {
					Persona p = pDao.deletePerson(pDao.searchPeopleToCf(Utils.leggiString("Inserisci codice fiscale")));
					if(p != null)
						v.msg("\nPersona eliminata: " + p.toString() + "\n");
				} else 
					v.msg("\nCollezione vuota, impossibile effettuare eliminazione...\n");
				break;
			case 5: 
				if(!pDao.isEmpty()) {

					Persona tmp = null; //variabile di tipo Persona in cui andrò a salvare i nuovi parametri

					int index = pDao.searchPeopleToCf(Utils.leggiString("Inserisci il codice fiscale della Persona per cui si vogliono apportare modifiche:").toUpperCase()); //recupero l'indice dell'oggetto Persona attraverso il codice fiscale
					if(index == -1) {
						Utils.print("Nessuna persona disponibile per la modifica");
					} else {

						Persona p = pDao.getCollezione().get(index); //istanzio una variabile Persona in cui vado a salvare la persona in analisi
						tmp = p.clone(); //clono l'oggetto recuperato dalla mappa, su cui posso apportare modifiche senza modificare l'oggetto primario
						
						Persona per = v.mascheraModifica(p, tmp);
						
						if(per != null) {
							pDao.modify(index, per);
						}
					}
				} else 
					v.msg("\nCollezione vuota, impossibile effettuare modifiche...\n");
				break;
			default:
				v.msg("\nNessuna operazione associata all'input...\n");
				break;
			}//fine switch
		}//fine while
	}//fine main
}