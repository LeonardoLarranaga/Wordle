package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Diccionario {
	
	public static boolean verificarPalabra(String palabra) {
		boolean existe = false;
		
		try {
			FileReader fileReader = new FileReader("src/Palabras5Letras.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String lineaActual;
			
			while((lineaActual = bufferedReader.readLine()) != null) {
				if (lineaActual.equalsIgnoreCase(palabra)) {
					existe = true;
					break;
				}
			}
			
			bufferedReader.close();
			fileReader.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		return existe;
	}
	
	public static String generarPalabra() {
		String palabra = null;
		
		try {
			FileReader fileReader = new FileReader("src/Palabras5Letras.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			Random random = new Random();
			int numero = random.nextInt(10856);
			
			for (int i = 0; i <= numero; i++) palabra = bufferedReader.readLine();
			
			fileReader.close();
			bufferedReader.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		return palabra;
	}
}