package vista;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.ProcesosRepetidos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class MDI extends javax.swing.JFrame {

    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    String idBusqueda = LOGIN_SA.idCliente;
    private Mnt_Usuarios mnt_usuarios;

    public MDI() {
        initComponents();
        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(252, 239, 180));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_SA.nombreCliente.toUpperCase() + "   " + procesoRepetido.getFechaActual("gt") + " ]  ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_actualizarPermisos = new javax.swing.JMenu();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        Mnu_mantenimientos = new javax.swing.JMenu();
        MnI_Usuarios = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        Jdp_contenedor.setBackground(new java.awt.Color(249, 220, 92));

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_actualizarPermisos.setText("*");
        Sbm_actualizarPermisos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Sbm_actualizarPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sbm_actualizarPermisosMouseClicked(evt);
            }
        });
        Mnb_menu.add(Sbm_actualizarPermisos);

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_mantenimientos.setText("Mantenimientos");

        MnI_Usuarios.setText("Usuarios");
        MnI_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_UsuariosActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_Usuarios);

        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");
        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cerrarSesionMouseClicked(evt);
            }
        });
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    private void Sbm_actualizarPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sbm_actualizarPermisosMouseClicked

    }//GEN-LAST:event_Sbm_actualizarPermisosMouseClicked

    private void Btn_cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarSesionMouseClicked
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Verifiación", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_Btn_cerrarSesionMouseClicked

    private void MnI_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_UsuariosActionPerformed
        mnt_usuarios = new Mnt_Usuarios();

        Jdp_contenedor.add(mnt_usuarios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = mnt_usuarios.getSize();
        mnt_usuarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        mnt_usuarios.setVisible(true);
        mnt_usuarios.toFront();
    }//GEN-LAST:event_MnI_UsuariosActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    private javax.swing.JMenuItem MnI_Usuarios;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static javax.swing.JMenu Mnu_procesos;
    public static javax.swing.JMenu Sbm_actualizarPermisos;
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    // End of variables declaration//GEN-END:variables
}
