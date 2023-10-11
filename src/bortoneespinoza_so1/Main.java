/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.concurrent.Semaphore;


/**
 *
 * @author isabe
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Nintendo empresa1 = new Nintendo();
        DesarrolladorNarrativa hilo1 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        Integrador hilo2 = new Integrador( 1, empresa1.getGuiones(), empresa1.getNiveles(), empresa1.getGraficos(), empresa1 .getSistemas_abundantes(),  empresa1.getDriveIntegrador(), empresa1.getDriveNarrativa(), empresa1.getDriveDCL(), 5);
        hilo1.start();
        
        try {
            hilo1.join(); // Espera a que hilo1 termine antes de iniciar hilo2
        } catch (InterruptedException e) {
            e.printStackTrace();
        
        }
        
        hilo2.start();
        
        
        
    }
    
}
