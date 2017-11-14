
package dadmu3p5.cliente;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sabdi
 */
public class DADMU3P5Cliente {

    public DADMU3P5Cliente() {
        Client cliente = ClientBuilder.newClient();
        WebTarget wt = cliente.target("http://localhost:8080/p6/webresources/ws_usuarios");
        String usr = JOptionPane.showInputDialog("Ingrese nombre de usuario");
        String pass = JOptionPane.showInputDialog("Ingrese contraseña");
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String correo = JOptionPane.showInputDialog("Ingrese su correo");
        
        String resultado = wt.path("insert/"+usr+"/"+pass+"/"+nombre+"/"+correo+"").request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(resultado);
    }
    
    public static void main(String[] args) {
        new DADMU3P5Cliente();
    }
    
}
