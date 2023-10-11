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
    int id;
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
    int ganancia_est;
    int ganancia_dlc;
    int dlcs;
    int min_juegos;
    

    public Nintendo() {
        this.id = 1;
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
        this.ganancia_est = 550000;
        this.ganancia_dlc = 600000;
        this.min_juegos = 5;
        this.dlcs = 2;    
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

    public int getGanancia_est() {
        return ganancia_est;
    }

    public int getGanancia_dlc() {
        return ganancia_dlc;
    }

    public int getDlcs() {
        return dlcs;
    }

    public int getMin_juegos() {
        return min_juegos;
    }
    
    public int getId() {
        return id;
    }

    public Semaphore getDriveNiveles() {
        return driveNiveles;
    }

    public Semaphore getDriveSprites() {
        return driveSprites;
    }

    public Semaphore getDriveProgramador() {
        return driveProgramador;
    }

    public Semaphore getDriveDCL() {
        return driveDCL;
    }

    public Semaphore getDriveIntegrador() {
        return driveIntegrador;
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
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDriveNarrativa(Semaphore driveNarrativa) {
        this.driveNarrativa = driveNarrativa;
    }

    public void setDriveNiveles(Semaphore driveNiveles) {
        this.driveNiveles = driveNiveles;
    }

    public void setDriveSprites(Semaphore driveSprites) {
        this.driveSprites = driveSprites;
    }

    public void setDriveProgramador(Semaphore driveProgramador) {
        this.driveProgramador = driveProgramador;
    }

    public void setDriveDCL(Semaphore driveDCL) {
        this.driveDCL = driveDCL;
    }

    public void setDriveIntegrador(Semaphore driveIntegrador) {
        this.driveIntegrador = driveIntegrador;
    }

    public void setGanancia_est(int ganancia_est) {
        this.ganancia_est = ganancia_est;
    }

    public void setGanancia_dlc(int ganancia_dlc) {
        this.ganancia_dlc = ganancia_dlc;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setMin_juegos(int min_juegos) {
        this.min_juegos = min_juegos;
    }
    
    
}


