/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.lang.System.Logger;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giubo
 */
public class DesarrolladorDLC extends Thread {

    int sueldo;
    int dias_dlc;
    int dias_trabajados;
    int pago_por_hora;
    static Semaphore driveDLC;
    int id_empresa;
    static int dias_temporal;
    static int dlc_generados;

    //Constructor 
    public DesarrolladorDLC(Semaphore drive, int dias_dlc, int empresa) {
        this.sueldo = 0;
        this.dias_dlc = 3;
        this.dias_trabajados = 0;
        this.pago_por_hora = 10;
        this.driveDLC = drive;
        this.id_empresa = empresa;
        this.dias_temporal = 0;
    }

    // Metodo para calcular el salario del desarrollador
    public void calcular_salario(int dias_trabajados) {
        sueldo = (dias_trabajados * 24) * pago_por_hora;
        Nintendo.costos_operativos += sueldo;
    }

    // Metodo para generar el Guion por parte del desarrollador
    public static void generarDLC() {
        try {
            driveDLC.acquire(1);
            dlc_generados++;
            NintendoPanel.actualizarDLCDriveN(dlc_generados);
        } catch (InterruptedException ex) {
            System.out.println("Drive full, libere espacio");
        }
        dias_temporal = 0;
    }

    @Override
    public void run() {
        while (dias_temporal < dias_dlc) {

            try {
                Thread.sleep(1000);
                dias_trabajados++;
                dias_temporal++;
                calcular_salario(dias_trabajados);

            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
            generarDLC();
        }
    }

}
