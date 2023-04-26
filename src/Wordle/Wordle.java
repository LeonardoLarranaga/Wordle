package Wordle;

import Interfaces.*;
import Consola.*;
import Holografico.*;

public class Wordle {
	public static void main(String[] args) {
		InterfazTablero tablero = new TableroHolografico();
		InterfazTeclado teclado = new TecladoHolografico();
		
		Juego juego = new Juego(tablero, teclado);
		juego.jugar();			
	}
}
