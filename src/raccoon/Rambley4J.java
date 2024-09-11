/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raccoon;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
 *
 * @author Milo Steier
 */
public class Rambley4J extends JFrame {

    /**
     * Creates new form Rambley4J
     */
    public Rambley4J() {
        rambleyPainter = new RambleyIcon();
        initComponents();
        placeholderLabel.setIcon((Icon)rambleyPainter);
        rambleyPainter.addPropertyChangeListener(new RambleyHandler());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        debugPopup = new javax.swing.JPopupMenu();
        printButton = new javax.swing.JMenuItem();
        placeholderLabel = new components.JThumbnailLabel();
        jPanel1 = new javax.swing.JPanel();
        eyeCtrlR = new swing.TwoAxisSlider();
        eyeCtrlL = new swing.TwoAxisSlider();
        jPanel2 = new javax.swing.JPanel();
        mouthCtrl = new swing.TwoAxisSlider();
        bgToggle = new javax.swing.JCheckBox();
        gridToggle = new javax.swing.JCheckBox();
        scarfToggle = new javax.swing.JCheckBox();
        evilToggle = new javax.swing.JCheckBox();
        linkEyesToggle = new javax.swing.JCheckBox();
        glitchyToggle = new javax.swing.JCheckBox();
        ignoreARToggle = new javax.swing.JCheckBox();
        shadowToggle = new javax.swing.JCheckBox();
        outlineToggle = new javax.swing.JCheckBox();
        hatToggle = new javax.swing.JCheckBox();
        flippedToggle = new javax.swing.JCheckBox();
        jawToggle = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        gridSpacingSpinner = new javax.swing.JSpinner();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        jLabel3 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        gridThicknessSpinner = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bgDotsComboBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        bgDotSizeSpinner = new javax.swing.JSpinner();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        jLabel5 = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        bgDotSpacingSpinner = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();

        printButton.setText("Print Data");
        debugPopup.add(printButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rambley4J");

        placeholderLabel.setImageScaleMode(components.JThumbnailLabel.ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO);
        placeholderLabel.setComponentPopupMenu(debugPopup);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Eyes"), javax.swing.BorderFactory.createEmptyBorder(0, 6, 7, 6)));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        eyeCtrlR.setMajorTickSpacing(20);
        eyeCtrlR.setMinimumX(-100);
        eyeCtrlR.setMinimumY(-100);
        eyeCtrlR.setMinorTickSpacing(10);
        eyeCtrlR.setValueX(0);
        eyeCtrlR.setValueY(0);
        eyeCtrlR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eyeCtrlRStateChanged(evt);
            }
        });
        jPanel1.add(eyeCtrlR);

        eyeCtrlL.setMajorTickSpacing(20);
        eyeCtrlL.setMinimumX(-100);
        eyeCtrlL.setMinimumY(-100);
        eyeCtrlL.setMinorTickSpacing(10);
        eyeCtrlL.setValueX(0);
        eyeCtrlL.setValueY(0);
        eyeCtrlL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eyeCtrlLStateChanged(evt);
            }
        });
        jPanel1.add(eyeCtrlL);

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Mouth"), javax.swing.BorderFactory.createEmptyBorder(0, 6, 7, 6)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        mouthCtrl.setValueX(100);
        mouthCtrl.setValueY(0);
        mouthCtrl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mouthCtrlStateChanged(evt);
            }
        });
        jPanel2.add(mouthCtrl, java.awt.BorderLayout.CENTER);

        bgToggle.setSelected(true);
        bgToggle.setText("Background");
        bgToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgToggleActionPerformed(evt);
            }
        });

        gridToggle.setSelected(true);
        gridToggle.setText("Pixel Grid");
        gridToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridToggleActionPerformed(evt);
            }
        });

        scarfToggle.setSelected(true);
        scarfToggle.setText("Scarf");
        scarfToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scarfToggleActionPerformed(evt);
            }
        });

        evilToggle.setText("Evil");
        evilToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evilToggleActionPerformed(evt);
            }
        });

        linkEyesToggle.setSelected(true);
        linkEyesToggle.setText("Link Eyes");
        linkEyesToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkEyesToggleActionPerformed(evt);
            }
        });

        glitchyToggle.setText("Glitchy");
        glitchyToggle.setEnabled(false);
        glitchyToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glitchyToggleActionPerformed(evt);
            }
        });

        ignoreARToggle.setText("Ignore Aspect Ratio");
        ignoreARToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreARToggleActionPerformed(evt);
            }
        });

        shadowToggle.setSelected(true);
        shadowToggle.setText("Shadow");
        shadowToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shadowToggleActionPerformed(evt);
            }
        });

        outlineToggle.setSelected(true);
        outlineToggle.setText("Outline");
        outlineToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outlineToggleActionPerformed(evt);
            }
        });

        hatToggle.setText("Conductor Hat");
        hatToggle.setEnabled(false);
        hatToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatToggleActionPerformed(evt);
            }
        });

        flippedToggle.setText("Flipped");
        flippedToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flippedToggleActionPerformed(evt);
            }
        });

        jawToggle.setText("Jaw Closed");
        jawToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jawToggleActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Pixel Grid"), javax.swing.BorderFactory.createEmptyBorder(0, 6, 7, 6)));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Spacing:");
        jPanel3.add(jLabel2);
        jPanel3.add(filler1);

        gridSpacingSpinner.setModel(new javax.swing.SpinnerNumberModel(5.0d, 1.0d, null, 1.0d));
        jPanel3.add(gridSpacingSpinner);
        jPanel3.add(filler2);

        jLabel3.setText("Thickness:");
        jPanel3.add(jLabel3);
        jPanel3.add(filler3);

        gridThicknessSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0f, 0.0f, null, 1.0f));
        jPanel3.add(gridThicknessSpinner);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Background Polka-Dots"));

        jLabel1.setText("Shape:");

        bgDotsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rhombus", "Circle" }));
        bgDotsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgDotsComboBoxActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Size:");
        jPanel5.add(jLabel4);
        jPanel5.add(filler4);

        bgDotSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(8.0d, null, null, 1.0d));
        jPanel5.add(bgDotSizeSpinner);
        jPanel5.add(filler5);

        jLabel5.setText("Spacing:");
        jPanel5.add(jLabel5);
        jPanel5.add(filler6);

        bgDotSpacingSpinner.setModel(new javax.swing.SpinnerNumberModel(12.0d, null, null, 1.0d));
        jPanel5.add(bgDotSpacingSpinner);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bgDotsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bgDotsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placeholderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ignoreARToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(shadowToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(outlineToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hatToggle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bgToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gridToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scarfToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(evilToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(glitchyToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(flippedToggle)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(linkEyesToggle)
                                    .addComponent(jawToggle)
                                    .addComponent(saveButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(placeholderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bgToggle)
                            .addComponent(gridToggle)
                            .addComponent(scarfToggle)
                            .addComponent(evilToggle)
                            .addComponent(glitchyToggle)
                            .addComponent(flippedToggle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ignoreARToggle)
                            .addComponent(shadowToggle)
                            .addComponent(outlineToggle)
                            .addComponent(hatToggle)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(linkEyesToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jawToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void eyeCtrlRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_eyeCtrlRStateChanged
        double eyeX = eyeCtrlR.getValueX()/100.0;
        double eyeY = eyeCtrlR.getValueY()/100.0;
        if (linkEyesToggle.isSelected()){
            rambleyPainter.setRambleyEyes(eyeX, eyeY);
            eyeCtrlL.setValueX(eyeCtrlR.getValueX());
            eyeCtrlL.setValueY(eyeCtrlR.getValueY());
        } else {
            rambleyPainter.setRambleyRightEye(eyeX, eyeY);
        }
    }//GEN-LAST:event_eyeCtrlRStateChanged

    private void eyeCtrlLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_eyeCtrlLStateChanged
        double eyeX = eyeCtrlL.getValueX()/100.0;
        double eyeY = eyeCtrlL.getValueY()/100.0;
        if (linkEyesToggle.isSelected()){
            rambleyPainter.setRambleyEyes(eyeX, eyeY);
            eyeCtrlR.setValueX(eyeCtrlL.getValueX());
            eyeCtrlR.setValueY(eyeCtrlL.getValueY());
        }  else {
            rambleyPainter.setRambleyLeftEye(eyeX, eyeY);
        }
    }//GEN-LAST:event_eyeCtrlLStateChanged

    private void linkEyesToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkEyesToggleActionPerformed
        if (linkEyesToggle.isSelected()){
            int x = Math.floorDiv(eyeCtrlR.getValueX() + eyeCtrlL.getValueX(),2);
            int y = Math.floorDiv(eyeCtrlR.getValueY() + eyeCtrlL.getValueY(),2);
            eyeCtrlR.setValueX(x);
            eyeCtrlR.setValueY(y);
        }
    }//GEN-LAST:event_linkEyesToggleActionPerformed

    private void mouthCtrlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mouthCtrlStateChanged
        rambleyPainter.setRambleyOpenMouthWidth(mouthCtrl.getValueX() / 100.0);
        rambleyPainter.setRambleyOpenMouthHeight(mouthCtrl.getValueY() / 100.0);
    }//GEN-LAST:event_mouthCtrlStateChanged

    private void bgToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgToggleActionPerformed
        rambleyPainter.setBackgroundPainted(bgToggle.isSelected());
    }//GEN-LAST:event_bgToggleActionPerformed

    private void gridToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridToggleActionPerformed
        rambleyPainter.setPixelGridPainted(gridToggle.isSelected());
    }//GEN-LAST:event_gridToggleActionPerformed

    private void bgDotsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgDotsComboBoxActionPerformed
        rambleyPainter.setCircularBackgroundDots(bgDotsComboBox.getSelectedIndex() > 0);
    }//GEN-LAST:event_bgDotsComboBoxActionPerformed

    private void scarfToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scarfToggleActionPerformed
        rambleyPainter.setRambleyScarfPainted(scarfToggle.isSelected());
    }//GEN-LAST:event_scarfToggleActionPerformed

    private void evilToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evilToggleActionPerformed
        rambleyPainter.setRambleyEvil(evilToggle.isSelected());
    }//GEN-LAST:event_evilToggleActionPerformed

    private void glitchyToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glitchyToggleActionPerformed
        rambleyPainter.setRambleyGlitchy(glitchyToggle.isSelected());
    }//GEN-LAST:event_glitchyToggleActionPerformed

    private void flippedToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flippedToggleActionPerformed
        rambleyPainter.setRambleyFlipped(flippedToggle.isSelected());
    }//GEN-LAST:event_flippedToggleActionPerformed

    private void ignoreARToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreARToggleActionPerformed
        rambleyPainter.setAspectRatioIgnored(ignoreARToggle.isSelected());
    }//GEN-LAST:event_ignoreARToggleActionPerformed

    private void shadowToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shadowToggleActionPerformed
        rambleyPainter.setRambleyShadowPainted(shadowToggle.isSelected());
    }//GEN-LAST:event_shadowToggleActionPerformed

    private void outlineToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outlineToggleActionPerformed
        rambleyPainter.setRambleyOutlinePainted(outlineToggle.isSelected());
    }//GEN-LAST:event_outlineToggleActionPerformed

    private void hatToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hatToggleActionPerformed
        rambleyPainter.setConductorHatPainted(hatToggle.isSelected());
    }//GEN-LAST:event_hatToggleActionPerformed

    private void jawToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jawToggleActionPerformed
        rambleyPainter.setRambleyJawClosed(jawToggle.isSelected());
    }//GEN-LAST:event_jawToggleActionPerformed

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
            java.util.logging.Logger.getLogger(Rambley4J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rambley4J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rambley4J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rambley4J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rambley4J().setVisible(true);
            }
        });
    }
    
    private RambleyPainter rambleyPainter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner bgDotSizeSpinner;
    private javax.swing.JSpinner bgDotSpacingSpinner;
    private javax.swing.JComboBox<String> bgDotsComboBox;
    private javax.swing.JCheckBox bgToggle;
    private javax.swing.JPopupMenu debugPopup;
    private javax.swing.JCheckBox evilToggle;
    private swing.TwoAxisSlider eyeCtrlL;
    private swing.TwoAxisSlider eyeCtrlR;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JCheckBox flippedToggle;
    private javax.swing.JCheckBox glitchyToggle;
    private javax.swing.JSpinner gridSpacingSpinner;
    private javax.swing.JSpinner gridThicknessSpinner;
    private javax.swing.JCheckBox gridToggle;
    private javax.swing.JCheckBox hatToggle;
    private javax.swing.JCheckBox ignoreARToggle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JCheckBox jawToggle;
    private javax.swing.JCheckBox linkEyesToggle;
    private swing.TwoAxisSlider mouthCtrl;
    private javax.swing.JCheckBox outlineToggle;
    private components.JThumbnailLabel placeholderLabel;
    private javax.swing.JMenuItem printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox scarfToggle;
    private javax.swing.JCheckBox shadowToggle;
    // End of variables declaration//GEN-END:variables

    private class RambleyHandler implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            placeholderLabel.repaint();
        }
        
    }
}
