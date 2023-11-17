
package proyectocurso.presentacion;

import javax.swing.JOptionPane;
import proyectocurso.logica.Curso;
import proyectocurso.logica.Estudiante;

/**
 *
 * @author 92555606
 */
public class GuiGestionCurso extends javax.swing.JFrame {

    /**
     * Creates new form GuiGestionCurso
     */
    
    private Curso curso = new Curso();
    
    public GuiGestionCurso() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de cursos");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursos"));
        jPanel1.setLayout(null);

        jLabel1.setText("Codigo del curso");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(34, 44, 130, 16);

        jLabel2.setText("Nombre del curso");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 90, 150, 16);

        jLabel3.setText("Semestre del curso");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 140, 130, 16);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(200, 50, 230, 22);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(200, 90, 230, 22);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(200, 130, 230, 22);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudiante"));
        jPanel2.setLayout(null);

        jLabel4.setText("Identificacion estudiante");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 30, 140, 16);

        jLabel5.setText("Nombres del estudiante");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 70, 140, 16);

        jLabel6.setText("Apellidos del estudiante");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 110, 140, 16);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(180, 30, 220, 22);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(180, 70, 220, 22);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(180, 110, 220, 22);

        jButton1.setText("Adicionar estudiante al curso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(30, 150, 360, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 180, 420, 210);

        jButton2.setText("Crear curso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(40, 400, 190, 50);

        jButton3.setText("Nuevo curso");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 400, 190, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(9, 9, 510, 470);

        setSize(new java.awt.Dimension(551, 528));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Estudiante estudiante = new Estudiante();
        estudiante.setIdentificacion(jTextField4.getText());
        estudiante.setNombres(jTextField5.getText());
        estudiante.setApellidos(jTextField6.getText());
        curso.matricularEstudiante(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante vinculado al curso");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField4.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        curso.setCodigo(jTextField1.getText());
        curso.setNombre(jTextField2.getText());
        curso.setSemestre(Integer.parseInt(jTextField3.getText()));
        curso.registrarCurso();
        JOptionPane.showMessageDialog(null, "Curso creado correctamente");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
         jTextField1.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiGestionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiGestionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiGestionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiGestionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
