
package ModeloBd;

/**
 *
 * @author sabdi
 */
public class Tutorial {
    private int id;
    private String titulo;
    private String contenido;
    private int contVideos;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getContVideos() {
        return contVideos;
    }

    public void setContVideos(int contVideos) {
        this.contVideos = contVideos;
    }
    
    public String toString() {
        return id + " " + titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
