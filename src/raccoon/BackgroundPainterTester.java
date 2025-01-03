/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raccoon;

import icons.DebuggingIcon;
import icons.Icon2D;
import java.awt.Component;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Mosblinker
 */
public class BackgroundPainterTester extends javax.swing.JFrame {

    /**
     * Creates new form BackgroundPainterTester
     */
    public BackgroundPainterTester() {
        bgPainter = new BackgroundPainter();
        initComponents();
        dotSpaceSpinner.setValue(bgPainter.getPolkaDotSpacing());
        dotSizeSpinner.setValue(bgPainter.getPolkaDotSize());
        dotShapeCombo.setSelectedIndex(bgPainter.getPolkaDotShape());
        bgPainter.addPropertyChangeListener(new Handler());
        debugIcon = new DebuggingIcon(new BackgroundIcon(),debugToggle.isSelected());
        previewLabel.setIcon(debugIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previewLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dotSpaceSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        dotSizeSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        widthSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        heightSpinner = new javax.swing.JSpinner();
        debugToggle = new javax.swing.JCheckBox();
        resetButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        listenerToggle = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        dotShapeCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        previewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setText("Spacing:");

        dotSpaceSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, -3.0d, null, 1.0d));
        dotSpaceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dotSpaceSpinnerStateChanged(evt);
            }
        });

        jLabel4.setText("Size:");

        dotSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0d, -3.0d, null, 1.0d));
        dotSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dotSizeSpinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Width:");

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(256, -3, null, 1));
        widthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSpinnerStateChanged(evt);
            }
        });

        jLabel3.setText("Height:");

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(256, -3, null, 1));
        heightSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heightSpinnerStateChanged(evt);
            }
        });

        debugToggle.setText("Debug");
        debugToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugToggleActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        printButton.setText("Print Data");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        listenerToggle.setSelected(true);
        listenerToggle.setText("Listeners");

        jLabel1.setText("Shape:");

        dotShapeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rhombus", "Circle", "Square" }));
        dotShapeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dotShapeComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dotSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listenerToggle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dotSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dotShapeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(debugToggle)
                            .addComponent(resetButton))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dotSpaceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(dotSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton)
                    .addComponent(jLabel1)
                    .addComponent(dotShapeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton)
                    .addComponent(listenerToggle)
                    .addComponent(debugToggle))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dotSpaceSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dotSpaceSpinnerStateChanged
        bgPainter.setPolkaDotSpacing((double)dotSpaceSpinner.getValue());
    }//GEN-LAST:event_dotSpaceSpinnerStateChanged

    private void dotSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dotSizeSpinnerStateChanged
        bgPainter.setPolkaDotSize((double)dotSizeSpinner.getValue());
    }//GEN-LAST:event_dotSizeSpinnerStateChanged

    private void widthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSpinnerStateChanged
        previewLabel.repaint();
    }//GEN-LAST:event_widthSpinnerStateChanged

    private void heightSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightSpinnerStateChanged
        previewLabel.repaint();
    }//GEN-LAST:event_heightSpinnerStateChanged

    private void debugToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugToggleActionPerformed
        debugIcon.setDebugEnabled(debugToggle.isSelected());
        previewLabel.repaint();
    }//GEN-LAST:event_debugToggleActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        bgPainter.reset();
        dotSpaceSpinner.setValue(bgPainter.getPolkaDotSpacing());
        dotSizeSpinner.setValue(bgPainter.getPolkaDotSize());
        dotShapeCombo.setSelectedIndex(bgPainter.getPolkaDotShape());
    }//GEN-LAST:event_resetButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        System.out.println(bgPainter);
    }//GEN-LAST:event_printButtonActionPerformed

    private void dotShapeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotShapeComboActionPerformed
        bgPainter.setPolkaDotShape(dotShapeCombo.getSelectedIndex());
    }//GEN-LAST:event_dotShapeComboActionPerformed

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
            java.util.logging.Logger.getLogger(BackgroundPainterTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackgroundPainterTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackgroundPainterTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackgroundPainterTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackgroundPainterTester().setVisible(true);
            }
        });
    }
    
    private BackgroundPainter bgPainter;
    private DebuggingIcon debugIcon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox debugToggle;
    private javax.swing.JComboBox<String> dotShapeCombo;
    private javax.swing.JSpinner dotSizeSpinner;
    private javax.swing.JSpinner dotSpaceSpinner;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox listenerToggle;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JSpinner widthSpinner;
    // End of variables declaration//GEN-END:variables
    
    private class BackgroundIcon implements Icon2D{

        @Override
        public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
            g = (Graphics2D) g.create();
            g.translate(x, y);
            bgPainter.paint(g, c, getIconWidth(), getIconHeight());
            g.dispose();
        }

        @Override
        public int getIconWidth() {
            return (int) widthSpinner.getValue();
        }

        @Override
        public int getIconHeight() {
            return (int) heightSpinner.getValue();
        }
        
    }
    
    private class Handler implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (listenerToggle.isSelected())
                System.out.println(evt);
            previewLabel.repaint();
        }
        
    }
}
