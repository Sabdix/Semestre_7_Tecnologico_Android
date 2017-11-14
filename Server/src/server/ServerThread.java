
package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sabdi
 */
public class ServerThread extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSession;
    
    public ServerThread(Socket socket, int id) {
        this.socket = socket;
        this.idSession = id;
        
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        String nombre;
        int tamaño;
        while (true) {
            try {
                if((nombre = readLine())!=null){
                    tamaño = dis.readInt();
                    System.out.println("Recibiendo Archivo "+nombre);
                    FileOutputStream fos = new FileOutputStream("C:\\"+nombre);
                    BufferedOutputStream out = new BufferedOutputStream(fos);
                    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                    byte[] buffer = new byte[tamaño];
                    for (int i=0; i<buffer.length; i++) {
                        buffer[i] = (byte)in.read();
                    }
                    out.write(buffer);
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
