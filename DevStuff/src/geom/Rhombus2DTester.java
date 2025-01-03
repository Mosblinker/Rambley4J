/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package geom;

import icons.Icon2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Mosblinker
 */
public class Rhombus2DTester extends javax.swing.JFrame {

    /**
     * Creates new form Rhombus2DTester
     */
    public Rhombus2DTester() {
        rect = new Rectangle2D.Double(0,0,0,0);
        rhombusD = new Rhombus2D.Double(5, 10, 30, 50);
        rhombusF = new Rhombus2D.Float();
        rhombusF.setFrame(rhombusD.getBounds2D());
        initComponents();
        xSpinner.setValue(rhombusD.getX());
        ySpinner.setValue(rhombusD.getY());
        wSpinner.setValue(rhombusD.getWidth());
        hSpinner.setValue(rhombusD.getHeight());
        previewLabel.setIcon(new TestIcon());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previewLabel = new components.JThumbnailLabel();
        jLabel1 = new javax.swing.JLabel();
        xSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        ySpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        wSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        hSpinner = new javax.swing.JSpinner();
        frameButton = new javax.swing.JButton();
        doubleToggle = new javax.swing.JToggleButton();
        fillToggle = new javax.swing.JToggleButton();
        frameToggle = new javax.swing.JCheckBox();
        printButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        wSpinner1 = new javax.swing.JSpinner();
        xSpinner1 = new javax.swing.JSpinner();
        ySpinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hSpinner1 = new javax.swing.JSpinner();
        intersectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        previewLabel.setImageScaleMode(components.JThumbnailLabel.ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO);
        previewLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                previewLabelMouseMoved(evt);
            }
        });
        previewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                previewLabelMouseReleased(evt);
            }
        });

        jLabel1.setText("x:");

        xSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel2.setText("y:");

        ySpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel3.setText("w:");

        wSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel4.setText("h:");

        hSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        frameButton.setText("Set Frame");
        frameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameButtonActionPerformed(evt);
            }
        });

        doubleToggle.setSelected(true);
        doubleToggle.setText("Double");
        doubleToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleToggleActionPerformed(evt);
            }
        });

        fillToggle.setText("Fill");
        fillToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillToggleActionPerformed(evt);
            }
        });

        frameToggle.setText("Show Frame");
        frameToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameToggleActionPerformed(evt);
            }
        });

        printButton.setText("Print Data");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("x:");

        jLabel6.setText("w:");

        wSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        wSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSpinnerStateChanged(evt);
            }
        });

        xSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        xSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSpinnerStateChanged(evt);
            }
        });

        ySpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        ySpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSpinnerStateChanged(evt);
            }
        });

        jLabel7.setText("y:");

        jLabel8.setText("h:");

        hSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        hSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSpinnerStateChanged(evt);
            }
        });

        intersectButton.setText("Check Intersection");
        intersectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intersectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frameButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frameToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doubleToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fillToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intersectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(xSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(ySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frameButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(frameToggle)
                                .addComponent(printButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(wSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(hSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doubleToggle)
                            .addComponent(fillToggle)
                            .addComponent(intersectButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(xSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(ySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(wSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(hSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previewLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewLabelMouseMoved
//        Point point = previewLabel.getMousePositionInThumbnailRegion();
//        if (point != null){
//            point = previewLabel.convertPointToImage(point);
//            System.out.println(point + " " + rect.contains(point));
//        }
    }//GEN-LAST:event_previewLabelMouseMoved

    private void doubleToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleToggleActionPerformed
        previewLabel.repaint();
    }//GEN-LAST:event_doubleToggleActionPerformed

    private void fillToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillToggleActionPerformed
        previewLabel.repaint();
    }//GEN-LAST:event_fillToggleActionPerformed

    private void frameToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameToggleActionPerformed
        previewLabel.repaint();
    }//GEN-LAST:event_frameToggleActionPerformed

    private void frameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameButtonActionPerformed
        double x = (double) xSpinner.getValue();
        double y = (double) ySpinner.getValue();
        double w = (double) wSpinner.getValue();
        double h = (double) hSpinner.getValue();
        rhombusD.setFrame(x, y, w, h);
        rhombusF.setFrame(x, y, w, h);
        previewLabel.repaint();
    }//GEN-LAST:event_frameButtonActionPerformed

    private void previewLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewLabelMouseReleased
        
    }//GEN-LAST:event_previewLabelMouseReleased

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        System.out.println("rhombusD: ");
        printRhombus(rhombusD);
        System.out.println("rhombusF: ");
        printRhombus(rhombusF);
        System.out.println();
    }//GEN-LAST:event_printButtonActionPerformed

    private void printRhombus(Rhombus2D rhombus){
        System.out.println("    " + rhombus);
        GeometryMath.printShape("    Rhombus: ", rhombus);
        System.out.printf("    %5.3f, %5.3f, %5.3f, %5.3f%n",
                rhombus.getX(), rhombus.getY(), rhombus.getWidth(), rhombus.getHeight());
        System.out.println("    Bounds: " + rhombus.getBounds2D());
        System.out.println("    Hashcode: " + rhombus.hashCode());
        GeometryMath.printPathIterator(rhombus);
    }
    
    private void intersectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectButtonActionPerformed
        System.out.println("rhombusD: ");
        intersectTest(rhombusD);
        System.out.println("rhombusF: ");
        intersectTest(rhombusF);
        System.out.println();
    }//GEN-LAST:event_intersectButtonActionPerformed

    private void rectSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rectSpinnerStateChanged
        rect.setFrame((double) xSpinner1.getValue(), 
                (double) ySpinner1.getValue(), 
                (double) wSpinner1.getValue(), 
                (double) hSpinner1.getValue());
        previewLabel.repaint();
    }//GEN-LAST:event_rectSpinnerStateChanged

    private void intersectTest(Rhombus2D rhombus){
        System.out.printf("    contains(%5.3f, %5.3f): %5b%n",
                rect.getX(), rect.getY(), rhombus.contains(rect.getX(),rect.getY()));
        System.out.printf("    intersects(%5.3f, %5.3f, %5.3f, %5.3f): %5b%n",
                rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rhombus.intersects(rect));
        System.out.printf("    contains(%5.3f, %5.3f, %5.3f, %5.3f): %5b%n",
                rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), rhombus.contains(rect));
    }
    
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
            java.util.logging.Logger.getLogger(Rhombus2DTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rhombus2DTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rhombus2DTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rhombus2DTester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rhombus2DTester().setVisible(true);
            }
        });
    }
    
    private Rhombus2D getRhombus(){
        return (doubleToggle.isSelected()) ? rhombusD : rhombusF;
    }

    private Rectangle2D rect;
    private Rhombus2D rhombusD;
    private Rhombus2D rhombusF;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton doubleToggle;
    private javax.swing.JToggleButton fillToggle;
    private javax.swing.JButton frameButton;
    private javax.swing.JCheckBox frameToggle;
    private javax.swing.JSpinner hSpinner;
    private javax.swing.JSpinner hSpinner1;
    private javax.swing.JButton intersectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private components.JThumbnailLabel previewLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JSpinner wSpinner;
    private javax.swing.JSpinner wSpinner1;
    private javax.swing.JSpinner xSpinner;
    private javax.swing.JSpinner xSpinner1;
    private javax.swing.JSpinner ySpinner;
    private javax.swing.JSpinner ySpinner1;
    // End of variables declaration//GEN-END:variables

    private class TestIcon implements Icon2D{

        @Override
        public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
            g.translate(x, y);
            if (frameToggle.isSelected()){
                g.setColor(Color.GRAY);
                g.draw(getRhombus().getBounds2D());
            }
            if (fillToggle.isSelected()){
                g.setColor(Color.BLUE);
                g.fill(getRhombus());
            }
            else{
                g.setColor(Color.BLACK);
                g.draw(getRhombus());
            }
            if (getRhombus().intersects(rect))
                g.setColor(Color.GREEN);
            else
                g.setColor(Color.RED);
            g.draw(rect);
            
        }

        @Override
        public int getIconWidth() {
            return 100;
        }

        @Override
        public int getIconHeight() {
            return 100;
        }
        
    }
}
