/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

/**
 *
 * @author giubo
 */
public class ProjectManager extends Thread {
    int dias_restantes;
    boolean streams;
    int sueldo;
    int dias_trabajados;
    int pago_por_hora;

    public ProjectManager(int dias_restantes) {
        this.dias_restantes = dias_restantes;
        this.streams = true;
        this.sueldo = 0;
        this.dias_trabajados = dias_trabajados;
        this.pago_por_hora = 20;
    }
    
    @Override
    public void run(){
        while(true)
             try {
                 Thread.sleep(300);
                 streams = false;
                
                 
                 
          
                 dias_trabajados ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        
            } 
    
   
    
    
    
    
    
    
}
