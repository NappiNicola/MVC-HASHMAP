package utils;

public class Logger {
	
	public static void logger(String msg) {
		logger_stampa(msg);
	}
	
    private static void logger_stampa(String testo) {
        int lunghezzaCornice = testo.length() + 4; // 2 caratteri per ogni lato

        // Stampa la parte superiore della cornice
        stampaRigaOrizzontale(lunghezzaCornice);

        // Stampa il testo con la cornice laterale
        System.out.println("| " + testo + " |");

        // Stampa la parte inferiore della cornice
        stampaRigaOrizzontale(lunghezzaCornice);
    }

    private static void stampaRigaOrizzontale(int lunghezza) {
        for (int i = 0; i < lunghezza; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
