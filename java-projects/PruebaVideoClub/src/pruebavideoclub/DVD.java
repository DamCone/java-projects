package pruebavideoclub;

public class DVD {
    private String titulo;
    private String tipo;

    public DVD(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public DVD() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
