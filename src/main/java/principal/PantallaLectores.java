package principal;

import org.springframework.beans.factory.annotation.Autowired;

public class PantallaLectores extends javax.swing.JFrame {

    private final ModeloSalaEstudio modeloSalaEstudio;
    private SalaEstudio salaEstudio;
    @Autowired
    private SalaEstudioRepository salaEstudioRepository;

    public PantallaLectores() {
        initComponents();
        setLocationRelativeTo(null); // centra la pantalla al iniciar la interfaz
        salaEstudio = new SalaEstudio();
        modeloSalaEstudio = new ModeloSalaEstudio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEntrada = new javax.swing.JButton();
        jButtonSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonEntrada.setText("Lector Entrada");
        jButtonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaActionPerformed(evt);
            }
        });

        jButtonSalida.setText("Lector Salida");
        jButtonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonEntrada)
                .addGap(54, 54, 54)
                .addComponent(jButtonSalida)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrada)
                    .addComponent(jButtonSalida))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaActionPerformed

        modeloSalaEstudio.eliminarAforo(salaEstudio); // Llama al método para decrementar el aforo
        // Actualizar la instancia de salaEstudio después de decrementar el aforo
        salaEstudio = salaEstudioRepository.findById(salaEstudio.getId()).orElse(null);
    }//GEN-LAST:event_jButtonEntradaActionPerformed

    private void jButtonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalidaActionPerformed

        modeloSalaEstudio.aumentarAforo(salaEstudio); // Llama al método para incrementar el aforo
        // Actualizar la instancia de salaEstudio después de incrementar el aforo
        salaEstudio = salaEstudioRepository.findById(salaEstudio.getId()).orElse(null);
    }//GEN-LAST:event_jButtonSalidaActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLectores().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrada;
    private javax.swing.JButton jButtonSalida;
    // End of variables declaration//GEN-END:variables
}
