/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bortoneespinoza_so1;

import static bortoneespinoza_so1.BethesdaPanel.guionesND2;
import static bortoneespinoza_so1.BethesdaPanel.pm2;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author isabe
 */
public class BethesdaPanel extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    int spinner_narrativa;
    int spinner_niveles;
    int spinner_sprites;
    int spinner_sistemicos;
    int spinner_dcls;
    int spinner_integradores;
    int cant_desarrolladores;
    int cant_disenadores;
    int cant_artistas;
    int cant_sistemas;
    int cant_dcls;
    int cant_videojuegos;
    int cant_estandar;
    int cant_dcl;
    Bethesda bethesda = new Bethesda();
    ProjectManager hiloPM = new ProjectManager(3,bethesda.getId());

    public static void actualizarGuionesEnDrive(int nuevoValor) {
        guionesND2.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarValuePm(String nuevoValor) {
        pm2.setText(nuevoValor);
    }
    
    public static void actualizarNiveles(int nuevoValor) {
        niveles.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarSprites(int nuevoValor) {
        sprites.setText(Integer.toString(nuevoValor));
    }
    
        
    public static void actualizarSistemas(int nuevoValor) {
        sistemas.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarDCL(int nuevoValor) {
        dcl_s.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarVideojuegos(int nuevoValor) {
        z.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarEstandar(int nuevoValor) {
        est.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarDcl(int nuevoValor) {
        Dcl.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarVideojuegosListos(int nuevoValor) {
        x.setText(Integer.toString(nuevoValor));
    }
    
    public BethesdaPanel() {
        
        initComponents();
        spinner_narrativa = (int) spinnerNarrativa.getValue();
        spinner_niveles = (int) spinnerNiveles.getValue();
        
        // Crear hilos desarollador narrativa
        hiloPM.start();
        if (spinner_narrativa == 1) {
            DesarrolladorNarrativa desarrollador2 = new DesarrolladorNarrativa(bethesda.getDriveNarrativa(), 3, bethesda.getId());
            cant_desarrolladores++;
            System.out.println(cant_desarrolladores);
            desarrollador2.start();
        }

        spinnerNarrativa.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerNarrativa.getValue();

                DesarrolladorNarrativa[] desarrolladoresNarrativa = new DesarrolladorNarrativa[spinner_narrativa];
                if (nuevoValorSpinner > spinner_narrativa) {

                    for (int i = 0; i < spinner_narrativa; i++) {
                        desarrolladoresNarrativa[i] = new DesarrolladorNarrativa(bethesda.getDriveNarrativa(), 3, bethesda.getId());
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
        }
        );
        
        //Diseñador de niveles
        
     if (spinner_niveles == 1) {
            DisenadorNiveles disenador2 = new DisenadorNiveles(bethesda.getDriveNiveles(), 13,4,1,13, bethesda.getId());
            cant_disenadores++;
            System.out.println(cant_disenadores);
            disenador2.start();
        }

        spinnerNiveles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerNiveles.getValue();
                

                DisenadorNiveles[] disenadorNiveles = new DisenadorNiveles[spinner_niveles];
                if (nuevoValorSpinner > spinner_niveles) {

                    for (int i = 0; i < spinner_niveles; i++) {
                        disenadorNiveles[i] = new DisenadorNiveles(bethesda.getDriveNiveles(), 13,4,1,13, bethesda.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DisenadorNiveles desarrollador : disenadorNiveles) {
                        cant_disenadores++;
                        System.out.println(cant_disenadores);
                        desarrollador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_niveles = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_niveles) {
                    for (int i = 0; i < spinner_niveles; i++) {
                        if (disenadorNiveles[i] != null) {
                            cant_disenadores--;
                            System.out.println(cant_disenadores);
                            disenadorNiveles[i].interrupt();
                        }
                    }

                }
            }
        }
        );
        
    //Artista de sprites
        
        if (spinner_sprites == 1) {
            ArtistaSprites artistaSprites = new ArtistaSprites(bethesda.getDriveNiveles(), 4,20, bethesda.getId());
            cant_artistas++;
            System.out.println(cant_artistas);
            artistaSprites.start();
        }

        spinnerSprites.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerSprites.getValue();
                

                ArtistaSprites[] artistaSprites = new ArtistaSprites[spinner_sprites];
                if (nuevoValorSpinner > spinner_sprites) {

                    for (int i = 0; i < spinner_sprites; i++) {
                        artistaSprites[i] = new ArtistaSprites(bethesda.getDriveNiveles(), 4,20, bethesda.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (ArtistaSprites artista : artistaSprites) {
                        cant_artistas++;
                        System.out.println(cant_artistas);
                        artista.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_sprites = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_sprites) {
                    for (int i = 0; i < spinner_sprites; i++) {
                        if (artistaSprites[i] != null) {
                            cant_artistas--;
                            System.out.println(cant_artistas);
                            artistaSprites[i].interrupt();
                        }
                    }

                }
            }
        }
        );  
        
        
          //Programador de logica
        
        if (spinner_sistemicos == 1) {
            Programador programador = new Programador(bethesda.getDriveNiveles(), 3,8, bethesda.getId());
            cant_sistemas++;
            System.out.println(cant_sistemas);
            programador.start();
        }

        spinnerSprites.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerSprites.getValue();
                

                Programador[] programador = new Programador[spinner_sistemicos];
                if (nuevoValorSpinner > spinner_sistemicos) {

                    for (int i = 0; i < spinner_sistemicos; i++) {
                        programador[i] = new Programador(bethesda.getDriveNiveles(), 3,8, bethesda.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (Programador sistemico : programador) {
                        cant_sistemas++;
                        System.out.println(cant_sistemas);
                        sistemico.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_sistemicos = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_sistemicos) {
                    for (int i = 0; i < spinner_sistemicos; i++) {
                        if (programador[i] != null) {
                            cant_sistemas--;
                            System.out.println(cant_sistemas);
                            programador[i].interrupt();
                        }
                    }

                }
            }
        }
        ); 
    
           //Desarrollador DCL
        
        if (spinner_dcls == 1) {
            DesarrolladorDLC desarrolladorDCL = new DesarrolladorDLC(bethesda.getDriveNiveles(), 3,17, bethesda.getId());
            cant_dcls++;
            System.out.println(cant_dcls);
            desarrolladorDCL.start();
        }

        spinnerSprites.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerSprites.getValue();
                

                DesarrolladorDLC[] desarrolladorDCL = new DesarrolladorDLC[spinner_dcls];
                if (nuevoValorSpinner > spinner_dcls) {

                    for (int i = 0; i < spinner_dcls; i++) {
                        desarrolladorDCL[i] = new DesarrolladorDLC(bethesda.getDriveNiveles(), 3,17, bethesda.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DesarrolladorDLC desarrollador : desarrolladorDCL) {
                        cant_dcls++;
                        System.out.println(cant_dcls);
                        desarrollador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_dcls = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_dcls) {
                    for (int i = 0; i < spinner_dcls; i++) {
                        if (desarrolladorDCL[i] != null) {
                            cant_dcls--;
                            System.out.println(cant_dcls);
                            desarrolladorDCL[i].interrupt();
                        }
                    }

                }
            }
        }
        ); 
        
        
           //Integrador
        
        if (spinner_sprites == 1) {
            DisenadorNiveles disenador2 = new DisenadorNiveles(bethesda.getDriveNiveles(), 13,3,1,13, bethesda.getId());
            cant_artistas++;
            System.out.println(cant_artistas);
            disenador2.start();
        }

        spinnerSprites.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("AAAAA");
                int nuevoValorSpinner = (int) spinnerSprites.getValue();
                

                DisenadorNiveles[] disenadorNiveles = new DisenadorNiveles[spinner_sprites];
                if (nuevoValorSpinner > spinner_sprites) {

                    for (int i = 0; i < spinner_sprites; i++) {
                        disenadorNiveles[i] = new DisenadorNiveles(bethesda.getDriveNiveles(), 13,3,1,13, bethesda.getId());
                    }

                    // Ahora puedes acceder a los objetos DesarrolladorNarrativa a través del arreglo
                    for (DisenadorNiveles desarrollador : disenadorNiveles) {
                        cant_artistas++;
                        System.out.println(cant_artistas);
                        desarrollador.start();
                    }

                    // Actualiza valorSpinner con el nuevo valor del JSpinner
                    spinner_sprites = nuevoValorSpinner;
                } else if (nuevoValorSpinner < spinner_sprites) {
                    for (int i = 0; i < spinner_sprites; i++) {
                        if (disenadorNiveles[i] != null) {
                            cant_artistas--;
                            System.out.println(cant_artistas);
                            disenadorNiveles[i].interrupt();
                        }
                    }

                }
            }
        }
        ); 
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel32 = new javax.swing.JLabel();
        spinnerNarrativa = new javax.swing.JSpinner();
        spinnerNiveles = new javax.swing.JSpinner();
        spinnerSprites = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        niveles = new javax.swing.JLabel();
        sprites = new javax.swing.JLabel();
        sistemas = new javax.swing.JLabel();
        dcl_s = new javax.swing.JLabel();
        z = new javax.swing.JLabel();
        x = new javax.swing.JLabel();
        est = new javax.swing.JLabel();
        Dcl = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        guionesND2 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pm2 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        BgBethesda = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Desarrollador DCL´s: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 51, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DCL:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 50, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Programador Lógica:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sistemas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Diseñador de niveles: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Artista de Sprites:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Drive:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Director:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Project Manager:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 120, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Desarrolladores de narrativa:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("-->");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("-->");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("-->");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("-->");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("-->");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("-->");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Guiones:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sprites:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Videojuegos:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Niveles:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("/1 ->4 días");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Desarrolladores:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("DCL´s:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("/1 ->2 días");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("/1 día");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("/5 día");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("/1 ->4 días");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("/1 ->2 días");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Integradores:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, 30));

        jLabel31.setBackground(new java.awt.Color(204, 51, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Estándar:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 80, 30));

        jLabel32.setBackground(new java.awt.Color(204, 51, 0));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Videojuegos listos:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, 30));

        spinnerNarrativa.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(spinnerNarrativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 50, -1));

        spinnerNiveles.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(spinnerNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 50, -1));

        spinnerSprites.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(spinnerSprites, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 50, -1));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 50, -1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 50, -1));

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));
        jPanel1.add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 50, -1));

        niveles.setForeground(new java.awt.Color(255, 255, 255));
        niveles.setText("0");
        jPanel1.add(niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 20, -1));

        sprites.setForeground(new java.awt.Color(255, 255, 255));
        sprites.setText("0");
        jPanel1.add(sprites, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 20, -1));

        sistemas.setForeground(new java.awt.Color(255, 255, 255));
        sistemas.setText("0");
        jPanel1.add(sistemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 20, -1));

        dcl_s.setForeground(new java.awt.Color(255, 255, 255));
        dcl_s.setText("0");
        jPanel1.add(dcl_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 20, -1));

        z.setForeground(new java.awt.Color(255, 255, 255));
        z.setText("0");
        jPanel1.add(z, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 20, -1));

        x.setForeground(new java.awt.Color(255, 255, 255));
        x.setText("0");
        jPanel1.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 20, -1));

        est.setForeground(new java.awt.Color(255, 255, 255));
        est.setText("0");
        jPanel1.add(est, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 20, -1));

        Dcl.setForeground(new java.awt.Color(255, 255, 255));
        Dcl.setText("0");
        jPanel1.add(Dcl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 20, -1));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("0");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 20, 20));

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Estado");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, 20));

        guionesND2.setForeground(new java.awt.Color(255, 255, 255));
        guionesND2.setText("0");
        jPanel1.add(guionesND2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 20, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Descontado:");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 70, 20));

        pm2.setForeground(new java.awt.Color(255, 255, 255));
        pm2.setText("Estado");
        jPanel1.add(pm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 170, 20));

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("0");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 40, 20));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Faltas:");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 40, 20));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("$");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 40, -1));

        BgBethesda.setBackground(new java.awt.Color(153, 153, 153));
        BgBethesda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bgBethesda1 (1)-modified.jpg"))); // NOI18N
        jPanel1.add(BgBethesda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 480, 430));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 410));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel BgBethesda;
    public static javax.swing.JLabel Dcl;
    public static javax.swing.JLabel dcl_s;
    public static javax.swing.JLabel est;
    public static javax.swing.JLabel guionesND2;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    public static javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    public static javax.swing.JLabel niveles;
    public static javax.swing.JLabel pm2;
    public static javax.swing.JLabel sistemas;
    private javax.swing.JSpinner spinnerNarrativa;
    private javax.swing.JSpinner spinnerNiveles;
    private javax.swing.JSpinner spinnerSprites;
    public static javax.swing.JLabel sprites;
    public static javax.swing.JLabel x;
    public static javax.swing.JLabel z;
    // End of variables declaration//GEN-END:variables
}
