/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;


import static bortoneespinoza_so1.DesarrolladorNarrativa.driveN;
import static bortoneespinoza_so1.DesarrolladorNarrativa.generarGuion;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giubo
 */
public class Integrador extends Thread{
    int dias_esamblar; //Cada cuantos dias en integrador ensambla
    int salario;
    int id_empresa;
    int guiones;
    int niveles;
    int sprites;
    int sistemas_abundantes;
    Semaphore driveN;
    Semaphore driveDCL;
    Semaphore driveNiveles;
    static int juegos_esamblados; 
    int min_juegos; // Minimo de juegos para generar un DLC
    int dias_trabajados;
    int juegos_temporal; //Contandor para saber cuantos juegos se tiene para crear un DLC
    int dlcs; // Cantidad de dcls a tomar por cada n juegos (min juegos)
    int permisos_ocupados;
 
    //Constructor
    public Integrador(int id_empresa, int guiones, int niveles, int sprites, int sistemas_abundantes,  Semaphore driveN, Semaphore drive_DCL, Semaphore driveNiveles, int min_juegos, int dlcs) {
        this.id_empresa = id_empresa;
        // Condiciones para armar el juego
        this.dias_esamblar = 2;
        this.guiones = guiones;
        this.niveles = niveles;
        this.sprites = sprites;
        this.sistemas_abundantes = sistemas_abundantes;
        // Drives
        this.driveN = driveN;
        this. driveNiveles = driveNiveles;
        //variables
        this.salario = salario;
        this.juegos_esamblados = 0;
        this.min_juegos = min_juegos;
        this.dias_trabajados = 0;
        this.juegos_temporal = 0;
        this.dlcs = dlcs;
        this.permisos_ocupados = 0;
    }
    
    // Calcular el salario del integrador
    public void calcular_salario (int dias_trabajados){
        int pago_por_hora = 25;
        salario= (dias_trabajados  * 24) * pago_por_hora;
    }
    
    //Calcular cantidad de permisos ocupados en un drive
     public int permisos_ocupados(int numero, Semaphore drive){
        permisos_ocupados = numero - drive.availablePermits();
        System.out.println("Permisos ocupados" + permisos_ocupados);
        return permisos_ocupados;
    }
     
     
    @Override
    public void run(){
        System.out.println("INTEGRADOR");
        while(true){
            try {
                Thread.sleep(1000);
                dias_trabajados ++;
                calcular_salario(dias_trabajados);
               
                if ((permisos_ocupados(25,driveN) >= guiones) &&  (permisos_ocupados(20, driveNiveles) >= niveles)){
                    Thread.sleep(2000);
                    ensamblar(dlcs);
                } else{ 
                    System.out.println("No se puede esamblar el juego ya que no se cuenta con los recursos");
                }
                
            } catch (InterruptedException ex) {
                System.out.println("ERROR ENSAMBLADOR");
            } 
        }  
    }
    
    //Funcion para esamblar un videojuego
     public void ensamblar(int dlcs){  //HAY QUE TERMINAR DE AGREGAR LAS DEMAS CONDICIONES DE ESAMBLAMIENTO
            juegos_esamblados ++;
            juegos_temporal ++;
            driveN.release(guiones);
           
            if (juegos_temporal == min_juegos){
                juegos_temporal = 0;
                driveDCL.release(dlcs);
                System.out.println(driveDCL.availablePermits());
            }
            System.out.println("Juego agregado al drive del integrador");
    }
    
}
