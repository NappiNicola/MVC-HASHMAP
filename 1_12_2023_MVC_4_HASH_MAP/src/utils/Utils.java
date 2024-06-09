package utils;

import java.util.Scanner;

public class Utils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int leggiInt(String s) {
		System.out.print(s + " ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static int leggiNonLettInt(String s) {
		int num=0;
		
		try {
			num = leggiInt(s);
		}catch (NumberFormatException e) {
			Logger.logger("NumberFormatException generata");
			num = leggiNonLettInt(s + "\nInserisci un input valido --> ");
		}
		return num;
	}
	
	public static double leggiDouble(String s) {
		System.out.print(s + " ");
		return Double.parseDouble(sc.nextLine());
	}
	
	public static String leggiString(String s) {
		System.out.print(s + " ");
		return sc.nextLine();
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static String toUpperFirstChar(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);	
	}
	
	public static <T> void inziGenericVet(T[] vector) {
		for(int i=0; i<vector.length; i++)
			vector[i] = null;
	}

}
