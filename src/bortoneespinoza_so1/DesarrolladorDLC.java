/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

/**
 *
 * @author giubo
 */
public class DesarrolladorDLC {
    
    int sueldo;
    int dias_dcl;
    int dias_trabajados;
    int pago_por_hora;
    
    
  
    public DesarrolladorDLC() {
        this.sueldo = 0;
        this.dias_dcl = 3;
        this.dias_trabajados = 0;
        this.pago_por_hora = 8;
    }
   
    
    public void calcular_salario (int dias_trabajados){
        sueldo = (dias_trabajados * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(sueldo);    
    }
    
    public void generarDCL(){
        
        
        
    }
    
    
    public void run(){
        while(dias_trabajados < dias_dcl)
             try {
                 Thread.sleep(5000);
                 dias_trabajados ++;
                 calcular_salario(dias_trabajados);
                 
             } catch (InterruptedException ex) {
                System.out.println("ERROR");
             }
        generarDCL();
   
            }
    
}
