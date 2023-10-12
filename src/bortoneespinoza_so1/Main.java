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
        DesarrolladorNarrativa hilo2 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo3  = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo4  = new DesarrolladorNarrativa( empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo5 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());       
        Integrador hilo6 = new Integrador( 1, empresa1.getGuiones(), empresa1.getNiveles(), empresa1.getGraficos(), empresa1 .getSistemas_abundantes(), empresa1.getDriveNarrativa(), empresa1.getDriveDCL(), empresa1.getDriveNiveles() , 5 , empresa1.getDlcs() );
        ProjectManager hilo7 = new ProjectManager(3);
       
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        
    }
    
}
