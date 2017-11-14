/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadm_u3p1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabdi
 */
public class DADM_U3P1 {

    public DADM_U3P1 () {
        Hilo hilo = new Hilo();
        hilo.start();
        
        while(true) {
            System.out.println("Soy el main");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DADM_U3P1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        DADM_U3P1 obj = new DADM_U3P1();
    }
    
    class Hilo extends Thread {
        
        @Override
        public void run() {
            while(true) {
                System.out.println("Soy el Hilo");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DADM_U3P1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
