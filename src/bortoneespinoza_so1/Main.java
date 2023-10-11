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
        DesarrolladorNarrativa hilo1 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10 );
        hilo1.start();
        
        
        
    }
    
}
