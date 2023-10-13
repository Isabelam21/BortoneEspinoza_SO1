/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author isa
 */
public class Programador extends Thread {

    int sueldo;
    int sistema_dias;
    int dias_trabajados;
    int pago_por_hora;
    Semaphore driveP;
    int id_empresa;
    int dias_temporal;
    int sistemas_generados;

    public Programador(Semaphore driveP, int sprite_dias, int pago_por_hora, int empresa) {
        this.sueldo = 0;
        this.sistema_dias = 1;
        this.dias_trabajados = 0;
        this.pago_por_hora = 8;
        this.driveP = driveP;
        this.id_empresa = id_empresa;
        this.dias_temporal = 0;
        this.sistemas_generados = 0;

    }

    public void calcular_salario(int dias_trabajados) {
        sueldo = (dias_trabajados * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(sueldo);

    }

    public void generarSistema() {
        try {
            driveP.acquire(3);
            sistemas_generados = sistemas_generados + 3;
            System.out.println("Nivel agregado al drive");

        } catch (InterruptedException ex) {
            System.out.println("Drive full, libere espacio");
        }
        dias_temporal = 0;

    }

    @Override
    public void run() {
        while (dias_temporal <= sistema_dias) {

            try {
                Thread.sleep(1000);
                dias_trabajados++;
                dias_temporal++;
                calcular_salario(dias_trabajados);

            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
        }
        generarSistema();
    }
}
