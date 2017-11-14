
package dadm_u3p1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sabdi
 */
public class Cliente {
    
    public Cliente () {
        Socket cliente = null;
        try {
            try {
                cliente  = new Socket("localhost", 9876);
                if (cliente.isConnected()) {
                    ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
                    String msg = JOptionPane.showInputDialog("Mensaje: ");
                    oos.writeObject(msg);
                    oos.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (cliente != null) {
                try {
                    cliente.close();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void main(String [] args) {
        new Cliente();
    }
}
