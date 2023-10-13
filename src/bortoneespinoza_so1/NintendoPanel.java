/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bortoneespinoza_so1;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author isabe
 */
public class NintendoPanel extends javax.swing.JPanel {

    int cant_desarrolladores;
    int spinner_narrativa;
    int spinner_niveles;
    int spinner_sprites;
    int spinner_sistemas;
    int spinner_dlc;
    int spinner_integrador;

    Nintendo nintendo = new Nintendo();
    ProjectManager project_manager = new ProjectManager(3);
    Director director = new Director(4, project_manager.getSueldo(), project_manager.isStreams(), 7, nintendo.getId(), nintendo.getGanancia_neta_nintendo());

    public static void actualizarGuionesEnDrive(int nuevoValor) {
        guionesND.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarValuePm(String nuevoValor) {
        pm.setText(nuevoValor);
    }

    public static void actualizarValueFaltas(int nuevoValor) {
        faltas_pm.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarValueDescontado(int nuevoValor) {
        descontado_pm.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarValueDir(String nuevoValor) {
        dir.setText(nuevoValor);
    }

    public static void actualizarDLCDriveN(int nuevoValor) {
        dlcND.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarIntegradoresVideojuegosDriveN(int nuevoValor) {
        integradoresND.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarNivelesDriveN(int nuevoValor) {
        nivelesND.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarSistemasDriveN(int nuevoValor) {
        sistemasND.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarSpritesDriveN(int nuevoValor) {
        spritesND.setText(Integer.toString(nuevoValor));
    }

    public NintendoPanel() {
        initComponents();
        cant_desarrolladores = 0;

        project_manager.start();
        director.start();

        // Crear hilos desarollador narrativa
        spinner_narrativa = (int) spinnerNarrativa.getValue();
        if (spinner_narrativa == 1) {
            DesarrolladorNarrativa desarrollador = new DesarrolladorNarrativa(nintendo.getDriveNarrativa(), 3, nintendo.getId());
            cant_desarrolladores++;
            System.out.println(cant_desarrolladores);
            desarrollador.start();
        }

        spinnerNarrativa.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Hols");
                int nuevoValorSpinner = (int) spinnerNarrativa.getValue();

                DesarrolladorNarrativa[] desarrolladoresNarrativa = new DesarrolladorNarrativa[spinner_narrativa];
                if (nuevoValorSpinner > spinner_narrativa) {

                    for (int i = 0; i < spinner_narrativa; i++) {
                        desarrolladoresNarrativa[i] = new DesarrolladorNarrativa(nintendo.getDriveNarrativa(), 3, nintendo.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DesarrolladorNarrativa desarrollador : desarrolladoresNarrativa) {
                        cant_desarrolladores++;
                        System.out.println(cant_desarrolladores);
                        desarrollador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_narrativa = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_narrativa) {
                    for (int i = 0; i < spinner_narrativa; i++) {
                        if (desarrolladoresNarrativa[i] != null) {
                            cant_desarrolladores--;
                            System.out.println(cant_desarrolladores);
                            desarrolladoresNarrativa[i].interrupt();
                        }
                    }

                }
            }
        });

        // Crear hilos desarollador niveles
        spinner_niveles = (int) spinnerNiveles.getValue();
        if (spinner_niveles == 1) {
            DisenadorNiveles disenadorNiveles = new DisenadorNiveles(nintendo.getDriveNiveles(), 3, nintendo.getId());
            cant_desarrolladores++;
            disenadorNiveles.start();
        }

        spinnerNiveles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerNiveles.getValue();

                DisenadorNiveles[] disenadorNiveles = new DisenadorNiveles[spinner_niveles];
                if (nuevoValorSpinner > spinner_niveles) {

                    for (int i = 0; i < spinner_niveles; i++) {
                        disenadorNiveles[i] = new DisenadorNiveles(nintendo.getDriveNiveles(), 3, nintendo.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DisenadorNiveles desarrollador : disenadorNiveles) {
                        cant_desarrolladores++;
                        desarrollador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_niveles = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_niveles) {
                    for (int i = 0; i < spinner_niveles; i++) {
                        if (disenadorNiveles[i] != null) {
                            cant_desarrolladores--;
                            disenadorNiveles[i].interrupt();
                        }
                    }

                }
            }
        });

        // Crear hilos desarollador sprites
        spinner_sprites = (int) spinnerSprites.getValue();
        if (spinner_sprites == 1) {
            ArtistaSprites artistaSprite = new ArtistaSprites(nintendo.getDriveSprites(), 3, nintendo.getId());
            cant_desarrolladores++;
            artistaSprite.start();
        }

        spinnerSprites.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerSprites.getValue();

                ArtistaSprites[] artistaSprite = new ArtistaSprites[spinner_sprites];
                if (nuevoValorSpinner > spinner_sprites) {

                    for (int i = 0; i < spinner_sprites; i++) {
                        artistaSprite[i] = new ArtistaSprites(nintendo.getDriveSprites(), 3, nintendo.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (ArtistaSprites artista : artistaSprite) {
                        cant_desarrolladores++;
                        artista.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_sprites = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_sprites) {
                    for (int i = 0; i < spinner_sprites; i++) {
                        if (artistaSprite[i] != null) {
                            cant_desarrolladores--;
                            System.out.println(cant_desarrolladores);
                            artistaSprite[i].interrupt();
                        }
                    }
                }
            }
        });

        // Crear hilos desarollador sistemas
        spinner_sistemas = (int) spinnerSistemas.getValue();
        if (spinner_sistemas == 1) {
            Programador programadorLogica = new Programador(nintendo.getDriveProgramador(), 3, nintendo.getId());
            cant_desarrolladores++;
            programadorLogica.start();
        }

        spinnerSistemas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerSistemas.getValue();

                Programador[] programadorLogica = new Programador[spinner_sistemas];
                if (nuevoValorSpinner > spinner_sistemas) {

                    for (int i = 0; i < spinner_sistemas; i++) {
                        programadorLogica[i] = new Programador(nintendo.getDriveProgramador(), 3, nintendo.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (Programador programador : programadorLogica) {
                        cant_desarrolladores++;
                        programador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_sistemas = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_sistemas) {
                    for (int i = 0; i < spinner_sistemas; i++) {
                        if (programadorLogica[i] != null) {
                            cant_desarrolladores--;
                            programadorLogica[i].interrupt();
                        }
                    }
                }
            }
        });

        // Crear hilos desarollador DLC
        spinner_dlc = (int) spinnerDLC.getValue();
        if (spinner_dlc == 1) {
            DesarrolladorDLC desarrolladorDLC = new DesarrolladorDLC(nintendo.getDriveDCL(), 3, nintendo.getId());
            cant_desarrolladores++;
            desarrolladorDLC.start();
        }

        spinnerDLC.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerDLC.getValue();

                DesarrolladorDLC[] desarrolladorDLC = new DesarrolladorDLC[spinner_dlc];
                if (nuevoValorSpinner > spinner_dlc) {

                    for (int i = 0; i < spinner_dlc; i++) {
                        desarrolladorDLC[i] = new DesarrolladorDLC(nintendo.getDriveDCL(), 3, nintendo.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DesarrolladorDLC devDLC : desarrolladorDLC) {
                        cant_desarrolladores++;
                        devDLC.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_dlc = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_dlc) {
                    for (int i = 0; i < spinner_dlc; i++) {
                        if (desarrolladorDLC[i] != null) {
                            cant_desarrolladores--;
                            desarrolladorDLC[i].interrupt();
                        }
                    }
                }
            }
        });

        // Crear hilos integradores
        spinner_integrador = (int) spinnerIntegradores.getValue();
        if (spinner_integrador == 1) {
            Integrador integrador = new Integrador(nintendo.getId(), nintendo.getGuiones(), nintendo.getNiveles(), nintendo.getGraficos(), nintendo.getSistemas_abundantes(), nintendo.driveNarrativa, nintendo.driveDCL, nintendo.driveNiveles, 5, 2);
            cant_desarrolladores++;
            integrador.start();
        }

        spinnerIntegradores.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerIntegradores.getValue();

                Integrador[] integradores = new Integrador[spinner_integrador];
                if (nuevoValorSpinner > spinner_integrador) {

                    for (int i = 0; i < spinner_integrador; i++) {
                        integradores[i] = new Integrador(nintendo.getId(), nintendo.getGuiones(), nintendo.getNiveles(), nintendo.getGraficos(), nintendo.getSistemas_abundantes(), nintendo.driveNarrativa, nintendo.driveDCL, nintendo.driveNiveles, 5, 2);
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (Integrador integrador : integradores) {
                        cant_desarrolladores++;
                        integrador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_integrador = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_integrador) {
                    for (int i = 0; i < spinner_integrador; i++) {
                        if (integradores[i] != null) {
                            cant_desarrolladores--;
                            integradores[i].interrupt();
                        }
                    }
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel33 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        spinnerNarrativa = new javax.swing.JSpinner();
        spinnerNiveles = new javax.swing.JSpinner();
        spinnerSprites = new javax.swing.JSpinner();
        spinnerSistemas = new javax.swing.JSpinner();
        spinnerDLC = new javax.swing.JSpinner();
        spinnerIntegradores = new javax.swing.JSpinner();
        guionesND = new javax.swing.JLabel();
        descontado_pm = new javax.swing.JLabel();
        faltas_pm = new javax.swing.JLabel();
        pm = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        nivelesND = new javax.swing.JLabel();
        spritesND = new javax.swing.JLabel();
        sistemasND = new javax.swing.JLabel();
        dlcND = new javax.swing.JLabel();
        integradoresND = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        dir = new javax.swing.JLabel();
        BgMario = new javax.swing.JLabel();

        jLabel33.setText("jLabel33");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Desarrollador DCL´s: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel2.setBackground(new java.awt.Color(204, 51, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DCL:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 40, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Programador Lógica:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sistemas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Diseñador de niveles: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Artista de Sprites:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Drive:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Project Manager:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Director:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Desarrolladores de narrativa:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("-->");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("-->");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("-->");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("-->");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("-->");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("-->");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Guiones:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sprites:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Videojuegos:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Niveles:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("/1 ->3 días");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Desarrolladores:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("DCL´s:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("/1 ->2 días");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("/2 día");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("/3 día");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("/1 ->3 días");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("/1 ->3 días");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Integradores:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, 30));

        jLabel30.setBackground(new java.awt.Color(204, 51, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Estándar:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 70, 30));

        jLabel31.setBackground(new java.awt.Color(204, 51, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Videojuegos listos:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, 30));

        spinnerNarrativa.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerNarrativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 50, -1));

        spinnerNiveles.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 50, -1));

        spinnerSprites.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerSprites, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 50, -1));

        spinnerSistemas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerSistemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 50, -1));

        spinnerDLC.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerDLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 50, -1));

        spinnerIntegradores.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(spinnerIntegradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 50, -1));

        guionesND.setForeground(new java.awt.Color(255, 255, 255));
        guionesND.setText("0");
        jPanel1.add(guionesND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 30, 20));

        descontado_pm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        descontado_pm.setForeground(new java.awt.Color(255, 255, 255));
        descontado_pm.setText("0");
        jPanel1.add(descontado_pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 70, 20));

        faltas_pm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        faltas_pm.setForeground(new java.awt.Color(255, 255, 255));
        faltas_pm.setText("0");
        jPanel1.add(faltas_pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 40, 20));

        pm.setForeground(new java.awt.Color(255, 255, 255));
        pm.setText("Valor pm");
        jPanel1.add(pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 20));

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Descontado:");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 20));

        nivelesND.setForeground(new java.awt.Color(255, 255, 255));
        nivelesND.setText("0");
        jPanel1.add(nivelesND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 20, -1));

        spritesND.setForeground(new java.awt.Color(255, 255, 255));
        spritesND.setText("0");
        jPanel1.add(spritesND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 20, -1));

        sistemasND.setForeground(new java.awt.Color(255, 255, 255));
        sistemasND.setText("0");
        jPanel1.add(sistemasND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 20, -1));

        dlcND.setForeground(new java.awt.Color(255, 255, 255));
        dlcND.setText("0");
        jPanel1.add(dlcND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 20, -1));

        integradoresND.setForeground(new java.awt.Color(255, 255, 255));
        integradoresND.setText("0");
        jPanel1.add(integradoresND, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 20, -1));

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("0");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 20, -1));

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("0");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 20, -1));

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("0");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 20, -1));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Faltas:");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 60, 20));

        dir.setForeground(new java.awt.Color(255, 255, 255));
        dir.setText("Estado");
        jPanel1.add(dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, 20));

        BgMario.setForeground(new java.awt.Color(124, 124, 124));
        BgMario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bgMario (1)-modified.png"))); // NOI18N
        BgMario.setText("0");
        jPanel1.add(BgMario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 3, 470, 400));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BgMario;
    public static javax.swing.JLabel descontado_pm;
    public static javax.swing.JLabel dir;
    public static javax.swing.JLabel dlcND;
    public static javax.swing.JLabel faltas_pm;
    public static javax.swing.JLabel guionesND;
    public static javax.swing.JLabel integradoresND;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel nivelesND;
    public static javax.swing.JLabel pm;
    public static javax.swing.JLabel sistemasND;
    private javax.swing.JSpinner spinnerDLC;
    private javax.swing.JSpinner spinnerIntegradores;
    private javax.swing.JSpinner spinnerNarrativa;
    private javax.swing.JSpinner spinnerNiveles;
    private javax.swing.JSpinner spinnerSistemas;
    private javax.swing.JSpinner spinnerSprites;
    public static javax.swing.JLabel spritesND;
    // End of variables declaration//GEN-END:variables

}
