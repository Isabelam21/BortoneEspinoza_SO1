/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author grupo
 */
public class Bethesda {
    int id;
    Semaphore driveNarrativa;
    Semaphore driveNiveles;
    Semaphore driveSprites;
    Semaphore driveProgramador;
    Semaphore driveDCL;
    int guiones;
    int niveles;
    int graficos;
    int sistemas_abundantes;
    int ganancia_est;
    int ganancia_dlc;
    int dlcs;
    int min_juegos;

    public Bethesda() {
        //Indentificacion empresa
        this.id = 2;
        //Drives
        this.driveNarrativa = driveNarrativa;
        this.driveNiveles = driveNiveles;
        this.driveSprites = driveSprites;
        this.driveProgramador = driveProgramador;
        this.driveDCL = driveDCL;
        // Nescarios para esamblar un juego
        this.guiones = 2;
        this.niveles = 3;
        this.graficos = 4;
        this.sistemas_abundantes = 6;
        this.ganancia_est = 450000;
        this.ganancia_dlc = 900000;
        // Condiciones
        this.dlcs = 5;
        this.min_juegos = 6;
    }

    public int getId() {
        return id;
    }

    public Semaphore getDriveNarrativa() {
        return driveNarrativa;
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
