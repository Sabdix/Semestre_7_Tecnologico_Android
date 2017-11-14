
package ModeloBD;

import java.util.Date;

/**
 *
 * @author sabdi
 */
public class Venta {
    private int id;
    private Date fecha;
    private String FECHA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha.toString();
    }

    public void setFecha(String fecha) {
        FECHA = fecha;
    }
    
    @Override
    public String toString() {
        return"id:" + id +" Fecha: "+ FECHA;
    }
}
