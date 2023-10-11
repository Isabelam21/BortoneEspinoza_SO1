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
    int dias_esamblar;
    int salario;
    int id_empresa;
    int guiones;
    int niveles;
    int graficos;
    int sistemas_abundantes;
    int ganancia;
    Semaphore driveInt;
    Semaphore driveN;
    Semaphore driveDCL;
    int juegos_esamblados;
    int min_juegos;
    int dias_trabajados;
    
    //Constructor
    public Integrador(int id_empresa, int guiones, int niveles, int graficos, int sistemas_abundantes, Semaphore driveInt, Semaphore driveN, Semaphore drive_DCL, int min_juegos) {
        this.dias_esamblar = 2;
        this.salario = salario;
        this.id_empresa = id_empresa;
        this.guiones = guiones;
        this.niveles = niveles;
        this.graficos = graficos;
        this.sistemas_abundantes = sistemas_abundantes;
        this.ganancia = ganancia;
        this.driveInt = driveInt;
        this.driveN = driveN;
        this.juegos_esamblados = 5;
        this.min_juegos = min_juegos;
        this.dias_trabajados = 0;
       
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
            esamblar();
        }   
    }
    
    
    //Funcion para esamblar un videojuego
     public void esamblar(){
        if (driveN.availablePermits() >= guiones){ //HAY QUE TERMINAR DE AGREGAR LAS DEMAS CONDICIONES DE ESAMBLAMIENTO
            try {
                driveInt.acquire(1); 
                driveN.release(guiones);
                crear_DLC();
                juegos_esamblados ++;
                System.out.println("Juego agregado al drive del integrador");
                System.out.println(driveInt.availablePermits());
            } catch (InterruptedException ex) {
                Logger.getLogger(DesarrolladorNarrativa.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Drive full, libere espacio");
                System.out.println(driveInt.availablePermits());
            }
        }else{
            System.out.println("No se puede esamblar el juego ya que no se cuenta con los recursos");
        }
    
    }
    
    public void crear_DLC(){
        if (juegos_esamblados > this.min_juegos) {
            //generarDLC();
            this.juegos_esamblados =0;   
        }
    }
    
}
