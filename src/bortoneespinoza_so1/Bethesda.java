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

    public Bethesda(int id, Semaphore driveNarrativa, Semaphore driveNiveles, Semaphore driveSprites, Semaphore driveProgramador, Semaphore driveDCL, int guiones, int niveles, int graficos, int sistemas_abundantes, int ganancia_est, int ganancia_dlc, int dlcs, int min_juegos) {
        this.id = id;
        this.driveNarrativa = driveNarrativa;
        this.driveNiveles = driveNiveles;
        this.driveSprites = driveSprites;
        this.driveProgramador = driveProgramador;
        this.driveDCL = driveDCL;
        
        this.guiones = 2;
        this.niveles = 3;
        this.graficos = 4;
        this.sistemas_abundantes = 6;
        this.ganancia_est = 450000;
        this.ganancia_dlc = 900000;
        
        this.dlcs = dlcs;
        this.min_juegos = min_juegos;
    }
    
    
    
}
