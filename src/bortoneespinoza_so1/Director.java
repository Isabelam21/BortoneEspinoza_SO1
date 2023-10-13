/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Random;

/**
 *
 * @author giubo
 */
public class Director extends Thread {

    int sueldo;
    int contador;
    int pago_por_hora;
    int dias_trabajados;
    int sueldo_pm;
    static boolean streams;
    static int faltas_pm;
    int juegos_disponibles;
    int integrador_id;
    int empresa_id;
    int ganancia_empresa;
    int ganancia_neta_nintendo;
    int ganancia_neta_bethesda;
    int descontado;
    boolean trabajando;

    public Director(int contador, int sueldo_pm, boolean streams, int juegos_disponibles, int empresa_id, int ganancia_empresa) {
        this.sueldo = 30;
        this.contador = contador;
        this.pago_por_hora = 30;
        this.dias_trabajados = 0;
        this.sueldo_pm = sueldo_pm;
        this.streams = streams;
        this.faltas_pm = faltas_pm;
        this.juegos_disponibles = juegos_disponibles;
        this.empresa_id = empresa_id;
        this.ganancia_empresa = ganancia_empresa;
        this.ganancia_neta_nintendo = 0;
        this.ganancia_neta_bethesda = 0;
        this.descontado = 0;
        this.trabajando = true;
    }

    // Metodo para calcular el salario del desarrollador
    public void calcular_salario(int dias_trabajados) {
        sueldo = (dias_trabajados * 24) * pago_por_hora;
        Nintendo.costos_operativos += sueldo;
    }

    // Funcion para enviar juegos a tienda si estan listos
    public void enviar_juegos() {
        if (empresa_id == 1) {
            int ganancia_neta_nintendo = juegos_disponibles * ganancia_empresa;
        } else {
            int ganancia_neta_bethesda = juegos_disponibles * ganancia_empresa;
        }
        contador = 0;

    }

    // Vigilar al PM
    public void vigilar_pm() {
        faltas_pm++;
        NintendoPanel.actualizarValueFaltas(faltas_pm);
        NintendoPanel.actualizarValueDescontado(descontado);
        descontado = descontado + 50;
    }

    // Trabajo administrativo
    public void trabajo() {
        try {
            int randomN = new Random().nextInt(1000);
            Thread.sleep(randomN);
            vigilar_pm();
            Thread.sleep(1000 - randomN);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void run() {
        while (contador >= 1) {
            trabajo();
            dias_trabajados++;
            calcular_salario(dias_trabajados);
        }
        if (contador == 0) {
            try {
                trabajando = !trabajando;
                enviar_juegos();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        if (trabajando) {
            String valor_dir = "Trabajando";
            NintendoPanel.actualizarValueDir(valor_dir);
        } else {
            String valor_dir = "Armando juego";
            NintendoPanel.actualizarValueDir(valor_dir);
        }
        
        

    }

}
