package Wordle;

import Interfaces.*;

public class Juego {
	InterfazTablero tablero;
	InterfazTeclado teclado;
	String palabra;
	
	public Juego(InterfazTablero tablero, InterfazTeclado teclado) {
		this.tablero = tablero;
		this.teclado = teclado;
		palabra = Diccionario.generarPalabra();
	}
	
	public void jugar() {
		String intento = "";
		
		tablero.mostrarInstrucciones();
		
		for(int i = 0; i < 6; i++) {
			tablero.limpiarPantalla();
			
			tablero.desplegar();
			teclado.desplegar();
			
			intento = teclado.leerIntento();
			
			tablero.getIntento(palabra, intento);
			teclado.getIntento(palabra, intento);
			
			if (intento.equalsIgnoreCase(palabra)) break;
		}
		
		tablero.desplegar();
		teclado.desplegar();
		tablero.mostrarResultado(palabra, intento);
	}
}
