package Holografico;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.util.ArrayList;

import Interfaces.InterfazTablero;
import Wordle.Letra;
import Wordle.Letra.Estado;

public class TableroHolografico implements InterfazTablero {
	public static Canvas canvas;
	
	ArrayList<ArrayList<Letra>> palabras = new ArrayList<ArrayList<Letra>>();
	
	public TableroHolografico() {
		for (int i = 0; i < 6; i++) {
		    ArrayList<Letra> listaLetras = new ArrayList<>();
		    
		    for (int j = 0; j < 5; j++) {
		        listaLetras.add(null);
		    }
		    
		    palabras.add(listaLetras);
		}
		
		canvas = new Canvas("Wordle", 600, 450);
		canvas.setFont(new Font("Helvetica", Font.BOLD, 24));
	}
	
	@Override
	public void desplegar() {		
		canvas.setFont(new Font("Helvetica", Font.BOLD, 14));
		canvas.setForegroundColor(Color.decode("#68A263"));
		canvas.drawString("WORDLE", 10, 20);
		
		canvas.setFont(new Font("Helvetica", Font.BOLD, 24));
		
		for (int i = 0; i < palabras.size(); i++) {
			for (int j = 0; j < palabras.get(i).size(); j++) {
				Letra letra = palabras.get(i).get(j);
				
				if (letra == null) {
					canvas.setForegroundColor(Color.decode("#C4C7CC"));
					canvas.fillRectangle(j * 45 + 175, i * 45 + 20, 35, 35);
				} else {
					letra.drawOnCanvas(j * 45 + 175, i * 45 + 20);
				}
			}
		}
	}

	@Override
	public void limpiarPantalla() {
		canvas.erase();
	}

	@Override
	public void mostrarInstrucciones() {
		canvas.setFont(new Font("Helvetica", Font.PLAIN, 18));
		canvas.setForegroundColor(Color.blue);
		
		canvas.drawString("¡Wordle!", 10, 20);
		
		canvas.setForegroundColor(Color.gray);
		canvas.drawString("Solo tienes 6 intentos. Úsalos sabiamente.", 10, 45);
		canvas.drawString("Cada intento debe ser una palabra válida de 5 letras.", 10, 70);
		canvas.drawString("No puedes indicar palabras que no tengan sentido o letras aleatorias.", 10, 95);
		canvas.drawString("Después de cada intento el color de las letras cambia para mostrar", 10, 120);
		canvas.drawString("qué tan cerca estás de acertar la palabra.", 10, 140);
		canvas.drawString("Mira este ejemplo:", 10, 170);
		
		ArrayList<Letra> ejemplo = new ArrayList<Letra>();
		ejemplo.add(new Letra("A", Estado.COLOCADA));
		
		for(String letra: "BEJA".split("")) {
			ejemplo.add(new Letra(letra, Estado.NULO));
		}
		
		for (int i = 0; i < ejemplo.size(); i++) {
			ejemplo.get(i).drawOnCanvas(i * 45 + 10, 190);
		}
		
		canvas.drawString("La letra A está en la palabra y en el lugar correcto.", 10, 245);
	
		ejemplo.clear();
		
		for(String letra: "FL".split("")) {
			ejemplo.add(new Letra(letra, Estado.NULO));
		}
		
		ejemplo.add(new Letra("A", Estado.DESCOLOCADA));
		
		for(String letra: "CO".split("")) {
			ejemplo.add(new Letra(letra, Estado.NULO));
		}
		
		for (int i = 0; i < ejemplo.size(); i++) {
			ejemplo.get(i).drawOnCanvas(i * 45 + 10, 275);
		}
		
		canvas.drawString("La letra A está en la palabra pero en el lugar equivocado.", 10, 325);
		
		ejemplo.clear();
		
		for(String letra: "JU".split("")) {
			ejemplo.add(new Letra(letra, Estado.NULO));
		}
		
		ejemplo.add(new Letra("G", Estado.INCORRECTA));
		
		for(String letra: "AR".split("")) {
			ejemplo.add(new Letra(letra, Estado.NULO));
		}
		
		for (int i = 0; i < ejemplo.size(); i++) {
			ejemplo.get(i).drawOnCanvas(i * 45 + 10, 345);
		}
		
		canvas.drawString("La letra G no está en la palabra en ningún lugar.", 10, 395);
		
		canvas.setFont(new Font("Helvetica", Font.BOLD, 24));
		
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
		canvas.setFont(new Font("Helvetica", Font.BOLD, 32));
		
		if (palabra.equalsIgnoreCase(ultimoIntento)) {
			canvas.setForegroundColor(Color.decode("#68A263"));
			canvas.drawString("¡Acertaste!", 10, 50);
		} else {
			canvas.setForegroundColor(Color.red);
			canvas.drawString("¡Perdiste! La palabra era: " + palabra + ".", 10, 50);
		}
	}
}
