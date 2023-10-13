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

    static int dias_restantes;
    static boolean streams;
    static int sueldo;
    int dias_trabajados;
    int pago_por_hora;
    int faltas;

    public ProjectManager(int dias_restantes) {
        this.dias_restantes = dias_restantes;
        this.streams = true;
        this.sueldo = 0;
        this.dias_trabajados = dias_trabajados;
        this.pago_por_hora = 20;
        this.faltas = 0;
    }

    // Metodo para calcular el salario del desarrollador
    public void calcular_salario(int dias_trabajados) {
        sueldo = (dias_trabajados * 24) * pago_por_hora;
    }

    @Override
    public void run() {
        int horas = 0;
        while (true) { // Trabaja durante las primeras 16 horas del día
            if (horas < 16) {
                try {
                    if (streams) {
                        Thread.sleep(25); // 30 minutos para ver streams
                    } else {
                        Thread.sleep(25); // 30 minutos para trabajar
                    }
                    if (streams) {
                        String valor_pm = "Viendo Streams";
                        NintendoPanel.actualizarValuePm(valor_pm);
                    } else {
                        String valor_pm = "Trabajando";
                        NintendoPanel.actualizarValuePm(valor_pm);
                    }
                    streams = !streams; // Cambia entre ver streams y trabajar
                    horas++; // Aumenta el contador de horas trabajadas
                } catch (InterruptedException ex) {
                    System.out.println("ERROR");
                }
            } else {  // Las últimas 8 horas las invierte cambiando el contador de días restantes
                try {
                    dias_restantes--;
                    Thread.sleep(600); // 30 minutos para cambiar el contador de días restantes
                } catch (InterruptedException ex) {
                    System.out.println("ERROR");
                }
                dias_trabajados++;
                calcular_salario(dias_trabajados);
                horas = 0;

            }
        }
    }

    public static int getDias_restantes() {
        return dias_restantes;
    }

    public static boolean isStreams() {
        return streams;
    }

    public static int getSueldo() {
        return sueldo;
    }

    public int getDias_trabajados() {
        return dias_trabajados;
    }

    public int getPago_por_hora() {
        return pago_por_hora;
    }

    public int getFaltas() {
        return faltas;
    }

    public static int getMIN_PRIORITY() {
        return MIN_PRIORITY;
    }

    public static int getNORM_PRIORITY() {
        return NORM_PRIORITY;
    }

    public static int getMAX_PRIORITY() {
        return MAX_PRIORITY;
    }
}
