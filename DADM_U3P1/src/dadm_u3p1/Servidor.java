
package dadm_u3p1;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sabdi
 */
public class Servidor {
    
    public Servidor () {
        ServerSocket servidor = null;
        Socket canal = null;
        try {
            servidor = new ServerSocket (9876);
            canal = servidor.accept();
            
            ObjectInputStream ois = new ObjectInputStream(canal.getInputStream());
            System.out.println("Recibí: " + ois.readObject());
            ois.close();
            canal.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String [] args) {
        new Servidor();
    }
}
