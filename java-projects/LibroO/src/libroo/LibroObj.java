package libroo;
public class LibroObj {
    private String titulo;
    private String autor;
    private String año;
    private String editorial;
    
    public LibroObj(String titulo, String autor, String año, String editorial){
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public LibroObj(){
    }
    public void imprime (){
        System.out.println("Titulo: "+getTitulo()+"\nAutor: "+getAutor()+"\nAño: "+getAño()+"\nEditorial: "+getEditorial());
    }
}
