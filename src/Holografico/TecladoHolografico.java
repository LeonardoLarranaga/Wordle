package Holografico;

import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.InterfazTeclado;
import Wordle.Diccionario;
import Wordle.Letra;
import Wordle.Letra.Estado;

public class TecladoHolografico implements InterfazTeclado {

	ArrayList<Letra> letras = new ArrayList<Letra>();
	
	public TecladoHolografico() {
		String[] qwerty = "QWERTYUIOPASDFGHJKLÑZXCVBNM".split("");
		
		for (String letra : qwerty) {
			letras.add(new Letra(letra, Letra.Estado.NULO));
		}
	}
	
	@Override
	public void desplegar() {
		for(int i = 0; i < 10; i++) letras.get(i).drawOnCanvas(i * 45 + 60, 300);
		
		for(int i = 10; i < 20; i++) letras.get(i).drawOnCanvas((i - 10) * 45 + 60, 345);
	
		for(int i = 20; i < 27; i++) letras.get(i).drawOnCanvas((i - 20) * 45 + 130, 390);
	}

	@Override
	public String leerIntento() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String intento = "";
		
		do {
		    System.out.println("Intente adivinar la palabra:");
		    intento = scanner.nextLine();

		    if (intento.length() != 5) {
		        System.out.println("La palabra debe tener exactamente 5 letras.");
		    } else if (!Diccionario.verificarPalabra(intento)) {
		        System.out.println("La palabra no está en el diccionario.");
		    }
		} while (intento.length() != 5 || !Diccionario.verificarPalabra(intento));
		
		return intento;
	}

	@Override
	public void getIntento(String palabra, String intento) {
		ArrayList<String> copia = new ArrayList<String>();
		
		for (String string : palabra.split("")) {
			copia.add(string);
		}
		
		for(int i = 0; i < 5; i++) {
			String letra = Character.toString(intento.charAt(i)).toUpperCase();
			
			if (copia.contains(letra)) {
				if (Character.toString(palabra.charAt(i)).equalsIgnoreCase(letra)) {
					for(int j = 0; j < letras.size(); j++)
						if (letras.get(j).getLetra().equalsIgnoreCase(letra) && letras.get(j).getEstado() != Estado.COLOCADA) {
							letras.get(j).setEstado(Estado.COLOCADA);
							break;
						}
					
				} else {
					for(int j = 0; j < letras.size(); j++)
						if (letras.get(j).getLetra().equalsIgnoreCase(letra) && letras.get(j).getEstado() != Estado.COLOCADA) {
							letras.get(j).setEstado(Estado.DESCOLOCADA);
							break;
						}
				}
			} else {
				for (int j = 0; j < letras.size(); j++)
					if (letras.get(j).getLetra().equalsIgnoreCase(letra) && letras.get(j).getEstado() == Estado.NULO) {
						letras.get(j).setEstado(Estado.INCORRECTA);
						break;
					}
			}
			
			copia.remove(0);
		}
	}

}
