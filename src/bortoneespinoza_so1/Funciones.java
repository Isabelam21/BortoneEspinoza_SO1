/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

/**
 *
 * @author giubo
 */
public class Funciones extends Thread {
    
    boolean activo;
    
    public Funciones() {
        this.activo = true;
    }
    
    @Override
    public void run(){
        while (activo) {
            try {
                Thread.sleep(1100);
                MainPanel.actualizarCostosOperativosN(Nintendo.costos_operativos);
            } catch (InterruptedException ex) {
                System.out.println("Funciones err");
            }
        }
    }
}
