package simulacroexamen;

public class Libro extends Elemento {
    private final String titulo;
    private final String autor;

    public Libro(int id, String titulo, String autor) {
        super(id);
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String mostrarInformacion() {
        return "Libro: " + titulo + " por " + autor;
    }
}