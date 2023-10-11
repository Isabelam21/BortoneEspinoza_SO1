/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giubortone
 */
public class DisenadorNiveles extends Thread{
    int sueldo;
    int dias_nivel;
    int dias_trabajados;
    int pago_por_hora;
    static Semaphore driveNiveles;
    int id_empresa;
    static int dias_temporal;
    static int niveles_generados;

    public DisenadorNiveles(Semaphore drive, int sueldo, int dias_nivel, int dias_trabajados, int pago_por_hora, int empresa) {
        this.sueldo = 0;
        this.driveNiveles = drive;
        this.dias_nivel = 3;
        this.dias_trabajados = dias_trabajados;
        this.pago_por_hora = 13;
        this.id_empresa = id_empresa;
    }
    
    
    // Metodo para calcular el salario del desarrollador
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados  * 24) * pago_por_hora;    
    }
    
    // Metodo para generar el Nivel por parte del desarrollador
    public static void generarNivel(){
         System.out.println("DESARROLLADOR");
        try {
            driveNiveles.acquire(1);
            niveles_generados++;
            System.out.println("Nivel agregado al drive");
            System.out.println("Niveles generados: " + niveles_generados);
            
        } catch (InterruptedException ex) {
            System.out.println("Drive full, libere espacio");
        }
        dias_temporal = 0;
    }
    
    
    @Override
    public void run(){
        while(dias_temporal < dias_nivel)
             try {
                 Thread.sleep(1000);
                 dias_trabajados ++;
                 dias_temporal ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        
        generarNivel();
            }   
    
    }
    