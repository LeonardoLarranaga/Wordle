package Wordle;

import Interfaces.*;
import Consola.*;

public class Wordle {
	public static void main(String[] args) {
		InterfazTablero tablero = new TableroConsola();
		InterfazTeclado teclado = new TecladoConsola();
		
		Juego juego = new Juego(tablero, teclado);
		juego.jugar();			
	}
}
