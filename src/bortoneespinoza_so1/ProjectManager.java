/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;


/**
 *
 * @author isa
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

    @Override
    public void run() {
        System.out.println("ProjectManager");
        int horas = 0;
        while (horas < 16) { // Trabaja durante las primeras 16 horas del día
            try {
                if (streams) {
                    Thread.sleep(250); // 30 minutos para ver streams
                    System.out.println("streams");
                } else {
                    Thread.sleep(250); // 30 minutos para trabajar
                    System.out.println("trabajando");
                }
                streams = !streams; // Cambia entre ver streams y trabajar
                horas++; // Aumenta el contador de horas trabajadas
            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
        }

        // Las últimas 8 horas las invierte cambiando el contador de días restantes
       
            try {
                Thread.sleep(250); // 30 minutos para cambiar el contador de días restantes
                dias_restantes--;
                horas++;
                System.out.println("Ultimas 8 horas (trabajando con el contador)");
            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
        

        // Imprime el sueldo total ganado
        System.out.println("El Project Manager gana 480$ diarios.");
    }
   

}
   