/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.HashSet;
import java.util.Set;
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
        
        Grafico grafico = new Grafico();
        grafico.setVisible(true);
        
        
        Nintendo empresa1 = new Nintendo();
        
        DesarrolladorNarrativa hilo1 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo2 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo3  = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo4  = new DesarrolladorNarrativa( empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());
        DesarrolladorNarrativa hilo5 = new DesarrolladorNarrativa(empresa1.getDriveNarrativa(), 3, 10, empresa1.getId());       
        Integrador hilo6 = new Integrador( 1, empresa1.getGuiones(), empresa1.getNiveles(), empresa1.getGraficos(), empresa1 .getSistemas_abundantes(), empresa1.getDriveNarrativa(), empresa1.getDriveDCL(), empresa1.getDriveNiveles() , 5 , empresa1.getDlcs());
        ProjectManager hilo7 = new ProjectManager(3);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        
        Bethesda empresa2 = new Bethesda();
        
        DesarrolladorNarrativa hilo8 = new DesarrolladorNarrativa(empresa2.getDriveNarrativa(), 4, 10, empresa2.getId());
        DesarrolladorNarrativa hilo9 = new DesarrolladorNarrativa(empresa2.getDriveNarrativa(), 4, 10, empresa2.getId());
        DesarrolladorNarrativa hilo10  = new DesarrolladorNarrativa(empresa2.getDriveNarrativa(), 4, 10, empresa2.getId());
        DesarrolladorNarrativa hilo11  = new DesarrolladorNarrativa( empresa2.getDriveNarrativa(), 4, 10, empresa2.getId());
        DesarrolladorNarrativa hilo12 = new DesarrolladorNarrativa(empresa2.getDriveNarrativa(), 4, 10, empresa2.getId());       
        Integrador hilo13 = new Integrador( 2, empresa2.getGuiones(), empresa2.getNiveles(), empresa2.getGraficos(), empresa2 .getSistemas_abundantes(), empresa2.getDriveNarrativa(), empresa2.getDriveDCL(), empresa2.getDriveNiveles() , 5 , empresa2.getDlcs());
        ProjectManager hilo14 = new ProjectManager(3);
        
        hilo8.start();
        hilo9.start();
        hilo10.start();
        hilo11.start();
        hilo12.start();
        hilo13.start();
        hilo14.start();
        
        
        }
    
}
