/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

/**
 *
 * @author giubo
 */
public class DesarrolladorNarrativa extends Thread{
    int sueldo;
    int dias_guion;
    int dias_trabajados;
    int pago_por_hora;
    
    
    

    public DesarrolladorNarrativa() {
        this.sueldo = 0;
        this.dias_guion = 3;
        this.dias_trabajados = 0;
        this.pago_por_hora = 10;
        
         
    }
    
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados  * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(sueldo);
          
    }
    
    public void generarGuion(){
        
        
    }
    
    
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
    
        
        
        
        
        
        

    
    
    
    
    
    

    


