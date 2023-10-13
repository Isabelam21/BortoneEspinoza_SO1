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
public class Integrador extends Thread {

    int dias_esamblar; //Cada cuantos dias en integrador ensambla
    int salario;
    int id_empresa;
    int guiones;
    int niveles;
    int sprites;
    int sistemas_abundantes;
    Semaphore driveN;
    Semaphore driveDCL;
    Semaphore driveNiveles;
    Semaphore driveSprites;
    Semaphore driveSistemas;
    static int juegos_esamblados;
    static int juegos_esamblados_dcl;
    static int juegos_esamblados_totales;
    int min_juegos; // Minimo de juegos para generar un DLC
    int dias_trabajados;
    int juegos_temporal; //Contandor para saber cuantos juegos se tiene para crear un DLC
    int dlcs; // Cantidad de dcls a tomar por cada n juegos (min juegos)
    int permisos_ocupados;

    //Constructor
    public Integrador(int id_empresa, int guiones, int niveles, int sprites, int sistemas_abundantes, Semaphore driveN, Semaphore drive_DCL, Semaphore driveNiveles, Semaphore driveSprites, Semaphore driveSistemas, int min_juegos, int dlcs) {
        this.id_empresa = id_empresa;
        // Condiciones para armar el juego
        this.dias_esamblar = 2;
        this.guiones = guiones;
        this.niveles = niveles;
        this.sprites = sprites;
        this.sistemas_abundantes = sistemas_abundantes;
        this.dlcs = dlcs;
        // Drives
        this.driveN = driveN;
        this.driveNiveles = driveNiveles;
        this.driveDCL = drive_DCL;
        this.driveSistemas = driveSistemas;
        this.driveSprites = driveSprites;
        //variables
        this.salario = salario;
        this.juegos_esamblados = 0;
        this.min_juegos = min_juegos;
        this.dias_trabajados = 0;
        this.juegos_temporal = 0;
        this.permisos_ocupados = 0;
    }

    // Calcular el salario del integrador
    public void calcular_salario(int dias_trabajados) {
        int pago_por_hora = 25;
        salario = (dias_trabajados * 24) * pago_por_hora;
    }

    //Calcular cantidad de permisos ocupados en un drive
    public int permisos_ocupados(int numero, Semaphore drive) {
        permisos_ocupados = numero - drive.availablePermits();
        return permisos_ocupados;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                dias_trabajados++;
                calcular_salario(dias_trabajados);

                if ((permisos_ocupados(25, driveN) >= guiones) && (permisos_ocupados(20, driveNiveles) >= niveles) && (permisos_ocupados(55, driveSprites) >= sprites) && (permisos_ocupados(35, driveSistemas) >= sistemas_abundantes) && (permisos_ocupados(10, driveDCL) >= dlcs)) {
                    Thread.sleep(2000);
                    ensamblar(dlcs);
                } else {
                    System.out.println("No se puede esamblar el juego ya que no se cuenta con los recursos");
                }

            } catch (InterruptedException ex) {
                System.out.println("ERROR ENSAMBLADOR");
            }
        }
    }

    //Funcion para esamblar un videojuego
    public void ensamblar(int dlcs) {  //HAY QUE TERMINAR DE AGREGAR LAS DEMAS CONDICIONES DE ESAMBLAMIENTO

        if (juegos_temporal == min_juegos) {
            driveDCL.release(dlcs);
            driveN.release(guiones);
            driveNiveles.release(niveles);
            driveSprites.release(sprites);
            driveSistemas.release(sistemas_abundantes);
            juegos_esamblados_dcl++;
            juegos_esamblados_totales++;
            NintendoPanel.actualizarJuegosEsambladosDcl(juegos_esamblados_dcl);
            juegos_temporal = 0;
        } else {
            driveN.release(guiones);
            driveNiveles.release(niveles);
            driveSprites.release(sprites);
            driveSistemas.release(sistemas_abundantes);
            juegos_esamblados++;
            juegos_temporal++;
            juegos_esamblados_totales++;
            NintendoPanel.actualizarJuegosEsambladosEst(juegos_esamblados);
        }
        NintendoPanel.actualizarJuegosEsambladosTotales(juegos_esamblados_totales);
    }

}
