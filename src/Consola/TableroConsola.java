package Consola;

import Interfaces.InterfazTablero;
import Wordle.Letra;
import Wordle.Letra.Estado;

import java.util.Scanner;
import java.util.ArrayList;

public class TableroConsola implements InterfazTablero {
	
	ArrayList<ArrayList<Letra>> palabras = new ArrayList<ArrayList<Letra>>();
	
	public TableroConsola() {
		for (int i = 0; i < 6; i++) {
		    ArrayList<Letra> listaLetras = new ArrayList<>();
		    for (int j = 0; j < 5; j++) {
		        listaLetras.add(null);
		    }
		    palabras.add(listaLetras);
		}
	}
	
	@Override
	public void desplegar() {
		System.out.println("\t\tWordle\n\n\n");
		
		for (ArrayList<Letra> palabra : palabras) {
			for (Letra letra : palabra) {
				if (letra == null) {
					System.out.print("◻\t");
				} else {
					System.out.print(letra.toString());
				}
			}
			
			System.out.println("\n");
		}
		
		System.out.println("\n\n\n");
	}

	@Override
	public void limpiarPantalla() {
		for (int i = 0; i < 25; i++) System.out.println();
	}

	@Override
	public void mostrarInstrucciones() {
		System.out.println("\t\tWordle");
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
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\nPresiona enter para jugar...");
		scanner.nextLine();
	}

	@Override
	public void getIntento(String palabra, String intento) {
		for(int i = 0; i < palabras.size(); i++) {
			if (palabras.get(i).get(0) == null) {
				ArrayList<String> copia = new ArrayList<String>();
				
				for (String string : palabra.split("")) {
					copia.add(string);
				}
				
				for(int j = 0; j < 5; j++) {
					String letra = Character.toString(intento.charAt(j)).toUpperCase();
					
					if (copia.contains(letra)) {
						if (Character.toString(palabra.charAt(j)).equals(letra)) {
							palabras.get(i).set(j, new Letra(letra, Estado.COLOCADA));
						} else {
							palabras.get(i).set(j, new Letra(letra, Estado.DESCOLOCADA));
						}
						
						copia.remove(letra);
					} else {
						palabras.get(i).set(j, new Letra(letra, Estado.INCORRECTA));
					}
				}
				
				break;
			}
		}
	}

	@Override
	public void mostrarResultado(String palabra, String ultimoIntento) {
		if (palabra.equalsIgnoreCase(ultimoIntento)) {
			System.out.println("\n\n" + LetraEnColor.verde("¡Acertaste!"));
		} else {
			System.out.println("\n\n¡Perdiste! La palabra era: " + LetraEnColor.gris(palabra));
		}
	}
}
