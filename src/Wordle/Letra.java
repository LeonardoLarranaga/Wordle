package Wordle;

import java.awt.Color;

import Consola.LetraEnColor;
import Holografico.TableroHolografico;

public class Letra {
    public enum Estado {
        NULO,
        COLOCADA,
        DESCOLOCADA,
        INCORRECTA
    }
    
    private String letra;
    private Estado estado;
    
    
    public Letra(String letra, Estado estado) {
        this.letra = letra;
        this.estado = estado;
    }
    
    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public String getLetra() {
        return letra;
    }
    
    public void drawOnCanvas(int x, int y) {
    	Color color;
    	
    	switch (estado) {
    	case COLOCADA:
    		color = Color.decode("#68A263");
    		break;
    		
    	case DESCOLOCADA:
    		color = Color.decode("#EBC330");
    		break;
    		
    	case INCORRECTA:
    		color = Color.decode("#787C7E");
    		break;
    		
    	default:
    		color = Color.decode("#C4C7CC");
    		break;
    	}
    	
    	TableroHolografico.canvas.setForegroundColor(color);
    	TableroHolografico.canvas.fillRectangle(x, y, 35, 35);
    	
    	TableroHolografico.canvas.setForegroundColor(estado == Estado.NULO ? Color.black : Color.white);
    	TableroHolografico.canvas.drawString(letra, x + 10, y + 25);
    }
    
    public String toString() {
    	switch (estado) {
    	case COLOCADA:
    		return LetraEnColor.verde(letra + "\t");
    	case DESCOLOCADA:
    		return LetraEnColor.amarillo(letra + "\t");
    	case INCORRECTA:
    		return LetraEnColor.gris(letra + "\t");
    	default:
    		return letra;
    	}
    }
}
