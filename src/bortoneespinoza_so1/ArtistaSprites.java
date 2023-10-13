/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bortoneespinoza_so1;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giubo
 */
public class ArtistaSprites extends Thread {

    int sueldo;
    int sprite_dias;
    int dias_trabajados;
    int pago_por_hora;
    Semaphore driveS;
    int id_empresa;
    int dias_temporal;
    int sprites_generados;

    public ArtistaSprites(Semaphore driveS, int sprite_dias, int pago_por_hora, int empresa) {
        this.sueldo = 0;
        this.sprite_dias = 1;
        this.dias_trabajados = 0;
        this.pago_por_hora = 20;
        this.driveS = driveS;
        this.id_empresa = id_empresa;
        this.dias_temporal = 0;
        this.sprites_generados = 0;

    }

    public void calcular_salario(int dias_trabajados) {
        sueldo = (dias_trabajados * 24) * pago_por_hora;
        System.out.println(dias_trabajados);
        System.out.println(sueldo);

    }

    public void generarSprite() {
        try {
            driveS.acquire(2);
            sprites_generados = sprites_generados + 2;
            System.out.println("Nivel agregado al drive");

        } catch (InterruptedException ex) {
            System.out.println("Drive full, libere espacio");
        }
        dias_temporal = 0;

    }

    @Override
    public void run() {
        while (dias_temporal <= sprite_dias) {

            try {
                Thread.sleep(1000);
                dias_trabajados++;
                dias_temporal++;
                calcular_salario(dias_trabajados);

            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }

            generarSprite();
        }
    }
}
