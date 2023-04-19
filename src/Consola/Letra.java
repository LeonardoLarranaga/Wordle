package Consola;

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
