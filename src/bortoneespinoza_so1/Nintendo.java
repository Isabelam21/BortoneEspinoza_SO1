/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giubo
 */
public class Nintendo {
    Semaphore driveNarrativa;
    Semaphore driveNiveles;
    Semaphore driveSprites;
    Semaphore driveProgramador;
    Semaphore driveDCL;
    Semaphore driveIntegrador;
    int guiones;
    int niveles;
    int graficos;
    int sistemas_abundantes;
    int ganancia;

    public Nintendo() {
        this.driveNarrativa = new Semaphore(25); // Debes proporcionar un número de permisos para el Semaphore
        this.driveNiveles = new Semaphore(20);
        this.driveSprites = new Semaphore(55);
        this.driveProgramador = new Semaphore(35);
        this.driveDCL = new Semaphore(10);
        this.driveIntegrador = new Semaphore(100000);
        this.guiones = 2;
        this.niveles = 1;
        this.graficos = 4;
        this.sistemas_abundantes = 4;
        this.ganancia = 550000;
      
    }
    
    public Semaphore getDriveNarrativa() {
        return driveNarrativa;
    }

    // Getters para las variables miembro que deseas acceder desde fuera de la clase
    public int getGuiones() {
        return guiones;
    }

    public int getNiveles() {
        return niveles;
    }

    public int getGraficos() {
        return graficos;
    }

    public int getSistemas_abundantes() {
        return sistemas_abundantes;
    }

    public int getGanancia() {
        return ganancia;
    }


    // Setters para las variables miembro que deseas actualizar desde fuera de la clase
    public void setGuiones(int guiones) {
        this.guiones = guiones;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public void setGraficos(int graficos) {
        this.graficos = graficos;
    }

    public void setSistemas_abundantes(int sistemas_abundantes) {
        this.sistemas_abundantes = sistemas_abundantes;
    }
    
    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }
    
}
