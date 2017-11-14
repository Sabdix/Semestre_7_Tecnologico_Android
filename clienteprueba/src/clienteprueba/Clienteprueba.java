/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteprueba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author sabdi
 */
public class Clienteprueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
          {
            // Creamos la direccion IP de la maquina que recibira el archivo
            InetAddress direccion = InetAddress.getByName( "localhost" );
         
            // Creamos el Socket con la direccion y elpuerto de comunicacion
            Socket socket = new Socket( direccion, 5000 );
         
            // Creamos el flujo de salida, este tipo de flujo nos permite 
            // hacer la escritura de diferentes tipos de datos tales como
            // Strings, boolean, caracteres y la familia de enteros, etc.
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            dos.writeUTF("enviarArchivo");
            dos.writeUTF("C:/pruebas/ArchivoPrueba1.txt");
            
            String nombre = dis.readUTF();
            int tamaño = dis.readInt();
            System.out.println("Recibiendo Archivo....");
            FileOutputStream fos = new FileOutputStream("C:/Users/sabdi/Dropbox/Escuela/7 Semestre/Sistemas Operativos 2/AppCliente/"+nombre);
            BufferedOutputStream out = new BufferedOutputStream(fos);
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());

            byte[] buffer = new byte[tamaño];

            for(int i=0; i<buffer.length; i++) {
                buffer[i] = (byte)in.read();
            }
            
            out.write(buffer);
            out.flush();
            out.close();
            System.out.println("Archivo Recibido "+nombre);
            

          }
          catch( Exception e )
          {
            System.out.println( e.toString() );
          }
    }
    
}
