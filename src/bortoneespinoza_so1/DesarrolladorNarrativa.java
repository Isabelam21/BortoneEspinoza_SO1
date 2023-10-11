/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giubo
 */
public class DesarrolladorNarrativa extends Thread{
    int sueldo;
    int dias_guion;
    int dias_trabajados;
    int pago_por_hora;
    static Semaphore driveN;
    int id_empresa;
    
  //Constructor 
    public DesarrolladorNarrativa(Semaphore drive, int dias_guion, int pago_por_hora, int empresa) {
        this.sueldo = 0;
        this.dias_guion = 3;
        this.dias_trabajados = 0;
        this.pago_por_hora = 10;  
        this.driveN= drive;
        this.id_empresa = empresa;
    }
    // Metodo para calcular el salario del desarrollador
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados  * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(sueldo);
          
    }
   
    // Metodo para generar el Guion por parte del desarrollador
    public static void generarGuion(){
        try {
            driveN.acquire(1);
            System.out.println("Guion agregado al drive");
            System.out.println(driveN.availablePermits());
        } catch (InterruptedException ex) {
            Logger.getLogger(DesarrolladorNarrativa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Drive full, libere espacio");
            System.out.println(driveN.availablePermits());
        }   
    }
    
 
    @Override
    public void run(){
        while(dias_trabajados < dias_guion)
             try {
                 Thread.sleep(5000);
                 dias_trabajados ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        generarGuion();
            }   
    
    }
    
        
        
        
        
        
        

    
    
    
    
    
    

    


