package guardac;
public class Album {
    private int id;
    private int anyo;
    private String titulo;
    private String imagen;
    private boolean patrocinado;
    private final static String artista = "David Bowie";
    private String lista;
    
    public Album(){}
    
     public Album(int id, int anyo, String titulo, String imagen, boolean patrocinado, String lista) {
        this.id = id;
        this.anyo = anyo;
        this.titulo = titulo;
        this.imagen = imagen;
        this.patrocinado = patrocinado;
        this.lista = lista;
    }
    
    public String anyadirC (String can){
        lista = lista +", "+ can;
        return lista;
    }
     
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the anyo
     */
    public int getAnyo() {
        return anyo;
    }

    /**
     * @param anyo the anyo to set
     */
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the patrocinado
     */
    public boolean isPatrocinado() {
        return patrocinado;
    }

    /**
     * @param patrocinado the patrocinado to set
     */
    public void setPatrocinado(boolean patrocinado) {
        this.patrocinado = patrocinado;
    }

    /**
     * @return the artista
     */
    public static String getArtista() {
        return artista;
    }

    /**
     * @return the lista
     */
    public String getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(String lista) {
        this.lista = lista;
    }
}
