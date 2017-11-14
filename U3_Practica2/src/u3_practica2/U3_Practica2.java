
package u3_practica2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sabdi
 */
public class U3_Practica2 {

    public U3_Practica2() {
        HiloServidor hServer = new HiloServidor();
        hServer.start();
        
        while(emisor());
    }
    
    private boolean emisor() {
        Socket cliente = null;
        try {
            cliente = new Socket("127.0.0.1", 1234);
            
            if (cliente.isConnected()) {
                String msg = JOptionPane.showInputDialog("Mensaje: ");
                ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
                oos.writeObject(msg);
                oos.close();
            }
            cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int respuesta = JOptionPane.showConfirmDialog(null, "Deseas enviar otro mensaje?", "Seguir Enviando", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
        
    }
   
    public static void main(String[] args) {
        new U3_Practica2();
    }
    
    //Clase del Hilo
    class HiloServidor extends Thread {
        @Override
        public void run() {
            for (;;) {
                receptor();
            }
        }
        
        private void receptor() {
            ServerSocket servidor = null;
            Socket canal = null;
            try {
                servidor = new ServerSocket(1234);
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
    }
}
