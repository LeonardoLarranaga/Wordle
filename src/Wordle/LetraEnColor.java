package Wordle;

public class LetraEnColor {
	public static String verde(String letra) {
		return "\033[32m" + letra + "\033[0m";
	}
	
	public static String gris(String letra) {
		return "\033[37m" + letra + "\033[0m";
	}
	
	public static String amarillo(String letra) {
		return "\033[33m" + letra + "\033[0m";
	}
}
