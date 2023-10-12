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
    static int dias_temporal;
    static int guiones_generados;
    
  //Constructor 
    public DesarrolladorNarrativa(Semaphore drive, int dias_guion, int pago_por_hora, int empresa) {
        this.sueldo = 0;
        this.dias_guion = 3;
        this.dias_trabajados = 0;
        this.pago_por_hora = 10;  
        this.driveN= drive;
        this.id_empresa = empresa;
        this.dias_temporal = 0;
        this.guiones_generados =0;
        
    }
    // Metodo para calcular el salario del desarrollador
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados  * 24) * pago_por_hora;          
    }
   
    // Metodo para generar el Guion por parte del desarrollador
    public static void generarGuion(){
         System.out.println("DESARROLLADOR");
        try {
            driveN.acquire(1);
            guiones_generados++;
            System.out.println("Guion agregado al drive");
            System.out.println("Guiones generados: " + guiones_generados);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(DesarrolladorNarrativa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Drive full, libere espacio");
        }
        dias_temporal = 0;
    }
   
    @Override
    public void run(){
        while(dias_temporal < dias_guion)
             try {
                 Thread.sleep(1000);
                 dias_trabajados ++;
                 dias_temporal ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        
        generarGuion();
            }   
    
    }
    
        
        
        
        
        
        

    
    
    
    
    
    

    


