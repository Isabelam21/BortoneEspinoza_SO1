/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

/**
 *
 * @author giubo
 */
public class Director extends Thread {
    int sueldo;
    int contador;
    int pago_por_hora;
    int dias_trabajados;

    public Director(int contador) {
        this.sueldo = 0;
        this.contador = 0;
        this.pago_por_hora =30;
        this.dias_trabajados = 0;
    }
    
    // Metodo para calcular el salario del desarrollador
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados  * 24) * pago_por_hora; 
    }
    
    // Funcion para enviar juegos a tienda si estan listos
    public void enviar_juegos(){
    }

    @Override
    public void run(){
        while(contador >= 1)
             try {
                 // vigilar_pm()
                 Thread.sleep(1000);
                 dias_trabajados ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        
        ();
            } 
    
    
    
    
    
}
