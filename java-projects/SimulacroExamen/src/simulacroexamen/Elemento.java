
package simulacroexamen;

public abstract class Elemento {
    protected int id;

    public Elemento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract String mostrarInformacion();
}