/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;


import static bortoneespinoza_so1.DesarrolladorNarrativa.generarGuion;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giubo
 */
public class Integrador extends Thread{
    int dias_esamblar; // Cada cuantos dias en integrador ensambla
    int salario;
    int id_empresa;
    int guiones;
    int niveles;
    int graficos;
    int sistemas_abundantes;
    Semaphore driveN;
    Semaphore driveDCL;
    int juegos_esamblados; 
    int min_juegos; // Minimo de juegos para generar un DLC
    int dias_trabajados;
    int juegos_temporal; //Contandor para saber cuantos juegos se tiene para crear un DLC
    int dlcs; // Cantidad de dcls a tomar por cada n juegos (min juegos)
    
    //Constructor
    public Integrador(int id_empresa, int guiones, int niveles, int graficos, int sistemas_abundantes,  Semaphore driveN, Semaphore drive_DCL, int min_juegos, int dlcs) {
        this.dias_esamblar = 2;
        this.salario = salario;
        this.id_empresa = id_empresa;
        this.guiones = guiones;
        this.niveles = niveles;
        this.graficos = graficos;
        this.sistemas_abundantes = sistemas_abundantes;
        this.driveN = driveN;
        this.juegos_esamblados = 0;
        this.min_juegos = min_juegos;
        this.dias_trabajados = 0;
        this.juegos_temporal = 0;
        this.dlcs = dlcs;

       
    }
    
    // Calcular el salario del integrador
    public void calcular_salario (int dias_trabajados){
        int pago_por_hora = 25;
        salario= (dias_trabajados  * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(salario); 
    }
    
    @Override
    public void run(){
        while(dias_trabajados < dias_esamblar){
            try {
                Thread.sleep(2000);
                dias_trabajados ++;
                calcular_salario(dias_trabajados);

            } catch (InterruptedException ex) {
                System.out.println("ERROR ENSAMBLADOR");
            }
            esamblar(dlcs);
        }   
    }
    
    
    //Funcion para esamblar un videojuego
     public void esamblar(int dlcs){
        if (driveN.availablePermits() == guiones){ //HAY QUE TERMINAR DE AGREGAR LAS DEMAS CONDICIONES DE ESAMBLAMIENTO
            juegos_esamblados ++;
            juegos_temporal ++;
            driveN.release(guiones);
           
            if (juegos_temporal == min_juegos){
                juegos_temporal = 0;
                driveDCL.release(dlcs);
            }
            
            System.out.println("Juego agregado al drive del integrador");
            
        }else{
            System.out.println("No se puede esamblar el juego ya que no se cuenta con los recursos");
        }
    
    }
    
}
