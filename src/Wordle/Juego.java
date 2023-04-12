package Wordle;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\t\tWordle");
		imprimirInstrucciones();
		
		System.out.println("\n\nPresiona enter para jugar.");
		scanner.nextLine();
		
		//TODO: Hacer el juego, pues.
		
		scanner.close();
	}
	
	public static void imprimirInstrucciones() {
		System.out.println("\n\n\nSolo tienes 6 intentos. Úsalos sabiamente.");
		System.out.println("\nCada intento debe ser una palabra válida de 5 letras.");
		System.out.println("No puedes indicar palabras que no tengan sentido o letras aleatorias.");
		System.out.println("\nDespués de cada intento el color de las letras cambia para mostrar qué tan cerca estás de acertar la palabra.");
		System.out.println("\nMira este ejemplo:\n\n");
		
		System.out.println(LetraEnColor.verde("A") + "BEJA");
		System.out.println("La letra A está en la palabra y en el lugar correcto.");
		
		System.out.println("\nFL" + LetraEnColor.amarillo("A") + "CO");
		System.out.println("La letra A está en la palabra pero en el lugar equivocado.");
		
		System.out.println("\nJU" + LetraEnColor.gris("G") + "AR");
		System.out.println("La letra G no está en la palabra en ningún lugar.");
	}
}
