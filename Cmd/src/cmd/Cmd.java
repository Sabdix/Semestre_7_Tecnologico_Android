/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

/**
 *
 * @author sabdi
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime;
public class Cmd {

    public static Process proceso;
    public static InputStream inputstream;
    public static BufferedReader bufferedReader;
    
    public static void main(String[] args) throws IOException {
        proceso = Runtime.getRuntime().exec("ipconfig");
        inputstream = proceso.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
        String texto="";
        while (texto != null) {
            texto = bufferedReader.readLine();
            System.out.println(texto);
        }
        
    
    }  
}
