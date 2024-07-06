/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raccoon;

import files.extensions.ImageExtensions;
import icons.DebuggingIcon;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Milo Steier
 */
public class RambleyViewer extends javax.swing.JFrame {
    /**
     * This is the name of the preference node used to store the settings for 
     * this program.
     */
    private static final String PREFERENCE_NODE_NAME = 
            "milo/Rambley4J/raccoon/test";
    
    private static final String RAMBLEY_PAINTER_FLAGS_KEY = "RambleyPainterFlags";
    
    private static final String DEBUG_ELEMENTS_KEY = "DebugElements";
    
    private static final String ALWAYS_SCALE_KEY = "AlwaysScale";
    
    private static final String PRINT_LISTENERS_KEY = "PrintListeners";
    
    private static final String LINK_PAINTER_SIZE_KEY = "LinkPainterSize";
    
    private static final String PAINTER_WIDTH_KEY = "PainterWidth";
    
    private static final String PAINTER_HEIGHT_KEY = "PainterHeight";
    
    private static final String SELECTED_SAVE_FILE_KEY = "SelectedSaveFile";
    
    /**
     * Creates new form RambleyViewer
     */
    public RambleyViewer() {
        rambleyIcon = new RambleyTestIcon();
        debugIcon = new DebuggingIcon(rambleyIcon,false);
        initComponents();
        try{    // Try to load the settings from the preference node
            config = Preferences.userRoot().node(PREFERENCE_NODE_NAME);
            rambleyIcon.setFlags(config.getInt(RAMBLEY_PAINTER_FLAGS_KEY, 
                    rambleyIcon.getFlags()));
            debugIcon.setDebugEnabled(config.getBoolean(DEBUG_ELEMENTS_KEY, 
                    debugIcon.isDebugEnabled()));
            viewLabel.setImageAlwaysScaled(config.getBoolean(ALWAYS_SCALE_KEY, 
                    viewLabel.isImageAlwaysScaled()));
            listenerToggle.setSelected(config.getBoolean(PRINT_LISTENERS_KEY, 
                    listenerToggle.isSelected()));
            widthSpinner.setValue(config.getInt(PAINTER_WIDTH_KEY, 
                    (int)Math.ceil(RambleyPainter.INTERNAL_RENDER_WIDTH)));
            heightSpinner.setValue(config.getInt(PAINTER_HEIGHT_KEY, 
                    (int)Math.ceil(RambleyPainter.INTERNAL_RENDER_HEIGHT)));
            linkSizeToggle.setSelected(config.getBoolean(LINK_PAINTER_SIZE_KEY, 
                    Objects.equals(widthSpinner.getValue(), heightSpinner.getValue())));
            bgDotSizeSpinner.setValue(config.getDouble(
                    RambleyPainter.BACKGROUND_DOT_SIZE_PROPERTY_CHANGED, 
                    rambleyIcon.getBackgroundDotSize()));
            bgDotSpacingSpinner.setValue(config.getDouble(
                    RambleyPainter.BACKGROUND_DOT_SPACING_PROPERTY_CHANGED, 
                    rambleyIcon.getBackgroundDotSpacing()));
            String selFile = config.get(SELECTED_SAVE_FILE_KEY, null);
            if (selFile != null)
                fc.setSelectedFile(new File(selFile));
        } catch (SecurityException | IllegalStateException ex){
            config = null;
            System.out.println("Unable to load settings: " +ex);
        } catch (IllegalArgumentException ex){
            System.out.println("Invalid setting: " + ex);
        }
        updateSettings();
        debugToggle.setSelected(debugIcon.isDebugEnabled());
        scaleToggle.setSelected(viewLabel.isImageAlwaysScaled());
        
        jSpinner1.setValue(rambleyIcon.getTestDouble1()*100);
        jSpinner2.setValue(rambleyIcon.getTestDouble2()*100);
        jSpinner3.setValue(rambleyIcon.getTestDouble3()*100);
        jSpinner4.setValue(rambleyIcon.getTestDouble4()*100);
        jSpinner5.setValue(rambleyIcon.getTestDouble5()*100);
        jSpinner6.setValue(rambleyIcon.getTestDouble6());
//        jComboBox1.setSelectedIndex(rambleyIcon.getEarTest());
//        jSpinner7.setValue(rambleyIcon.getEarSplits());
        
        viewLabel.setIcon(debugIcon);
        IconHandler handler = new IconHandler();
        rambleyIcon.addChangeListener(handler);
        rambleyIcon.addPropertyChangeListener(handler);
    }
    
    private void updateSettings(){
        backgroundToggle.setSelected(rambleyIcon.isBackgroundPainted());
        gridToggle.setSelected(rambleyIcon.isPixelGridPainted());
        evilToggle.setSelected(rambleyIcon.isRambleyEvil());
        ratioToggle.setSelected(!rambleyIcon.isAspectRatioIgnored());
        circleDotToggle.setSelected(rambleyIcon.getCircularBackgroundDots());
        shadowToggle.setSelected(rambleyIcon.isBorderAndShadowPainted());
        abTestingToggle.setSelected(rambleyIcon.getABTesting());
        linesToggle.setSelected(rambleyIcon.getShowsLines());
        heightSpinner.setEnabled(!linkSizeToggle.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        jSpinner7 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        viewLabel = new components.JThumbnailLabel();
        saveButton = new javax.swing.JButton();
        backgroundToggle = new javax.swing.JCheckBox();
        debugToggle = new javax.swing.JCheckBox();
        printButton = new javax.swing.JButton();
        gridToggle = new javax.swing.JCheckBox();
        linesToggle = new javax.swing.JCheckBox();
        scaleToggle = new javax.swing.JCheckBox();
        abTestingToggle = new javax.swing.JCheckBox();
        evilToggle = new javax.swing.JCheckBox();
        ratioToggle = new javax.swing.JCheckBox();
        listenerToggle = new javax.swing.JCheckBox();
        linkSizeToggle = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        widthSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        heightSpinner = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        circleDotToggle = new javax.swing.JCheckBox();
        shadowToggle = new javax.swing.JCheckBox();
        resetButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bgDotSizeSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        bgDotSpacingSpinner = new javax.swing.JSpinner();

        fc.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fc.setFileFilter(ImageExtensions.PNG_FILTER);

        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner7.setEnabled(false);
        jSpinner7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner7StateChanged(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Upper", "Lower", "Tip" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewLabel.setImageScaleMode(components.JThumbnailLabel.ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backgroundToggle.setText("Background");
        backgroundToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundToggleActionPerformed(evt);
            }
        });

        debugToggle.setText("Debug");
        debugToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugToggleActionPerformed(evt);
            }
        });

        printButton.setText("Print Data");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        gridToggle.setText("Grid");
        gridToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridToggleActionPerformed(evt);
            }
        });

        linesToggle.setText("Lines");
        linesToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linesToggleActionPerformed(evt);
            }
        });

        scaleToggle.setText("Scale");
        scaleToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleToggleActionPerformed(evt);
            }
        });

        abTestingToggle.setText("A-B Test");
        abTestingToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abTestingToggleActionPerformed(evt);
            }
        });

        evilToggle.setText("Evil");
        evilToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evilToggleActionPerformed(evt);
            }
        });

        ratioToggle.setText("Aspect Ratio");
        ratioToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratioToggleActionPerformed(evt);
            }
        });

        listenerToggle.setSelected(true);
        listenerToggle.setText("Print Listeners");
        listenerToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenerToggleActionPerformed(evt);
            }
        });

        linkSizeToggle.setText("Link Width and Height");
        linkSizeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkSizeToggleActionPerformed(evt);
            }
        });

        jLabel1.setText("Width:");

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(256, -3, null, 1));
        widthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSpinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Height:");

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(256, -3, null, 1));
        heightSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heightSpinnerStateChanged(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 7, 6));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jSpinner1.setEnabled(false);
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner1);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jSpinner2.setEnabled(false);
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner2);

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jSpinner3.setEnabled(false);
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner3);

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jSpinner4.setEnabled(false);
        jSpinner4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner4StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner4);

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jSpinner5.setEnabled(false);
        jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner5StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner5);

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        jSpinner6.setEnabled(false);
        jSpinner6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner6StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner6);

        circleDotToggle.setText("Circle Dots");
        circleDotToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleDotToggleActionPerformed(evt);
            }
        });

        shadowToggle.setText("Shadow");
        shadowToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shadowToggleActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("BG Dot Size:");

        bgDotSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        bgDotSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgDotSizeSpinnerStateChanged(evt);
            }
        });

        jLabel4.setText("BG Dot Spacing:");

        bgDotSpacingSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        bgDotSpacingSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgDotSpacingSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(linkSizeToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(abTestingToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(linesToggle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(debugToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)
                                .addGap(8, 8, 8)
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scaleToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listenerToggle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backgroundToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gridToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(evilToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ratioToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(circleDotToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(shadowToggle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bgDotSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bgDotSpacingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backgroundToggle)
                            .addComponent(gridToggle)
                            .addComponent(evilToggle)
                            .addComponent(ratioToggle)
                            .addComponent(circleDotToggle)
                            .addComponent(shadowToggle))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bgDotSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(bgDotSpacingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(debugToggle)
                            .addComponent(saveButton)
                            .addComponent(printButton)
                            .addComponent(scaleToggle)
                            .addComponent(listenerToggle)
                            .addComponent(resetButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(widthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(heightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linkSizeToggle)
                            .addComponent(abTestingToggle)
                            .addComponent(linesToggle))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        System.out.println("Rambley Icon: " + rambleyIcon);
//        System.out.println("Background Gradient: "+rambleyIcon.getBackgroundGradient());
    }//GEN-LAST:event_printButtonActionPerformed

    private void debugToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugToggleActionPerformed
        debugIcon.setDebugEnabled(debugToggle.isSelected());
        viewLabel.repaint();
        if (config != null)
            config.putBoolean(DEBUG_ELEMENTS_KEY, debugToggle.isSelected());
    }//GEN-LAST:event_debugToggleActionPerformed
    
    private void updateConfigFlags(){
        if (config != null)
            config.putInt(RAMBLEY_PAINTER_FLAGS_KEY, rambleyIcon.getFlags());
    }
    
    private void backgroundToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundToggleActionPerformed
        rambleyIcon.setBackgroundPainted(backgroundToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_backgroundToggleActionPerformed

    private void gridToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridToggleActionPerformed
        rambleyIcon.setPixelGridPainted(gridToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_gridToggleActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            if (file == null)
                return;
            if (ImageExtensions.PNG_FILTER.equals(fc.getFileFilter()) && 
                    !ImageExtensions.PNG_FILTER.accept(file)){
                file = new File(file.toString()+"."+ImageExtensions.PNG);
                fc.setSelectedFile(file);
            }
            if (config != null)
                config.put(SELECTED_SAVE_FILE_KEY, file.toString());
            BufferedImage image = debugIcon.toImage(viewLabel);
            try {
                ImageIO.write(image, "png", file);
            } catch (IOException ex) {
                System.out.println("Failed to save image: " + ex);
//                Logger.getLogger(JThumbnailLabelTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void linesToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linesToggleActionPerformed
        rambleyIcon.setShowsLines(linesToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_linesToggleActionPerformed

    private void scaleToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleToggleActionPerformed
        viewLabel.setImageAlwaysScaled(scaleToggle.isSelected());
        if (config != null)
            config.putBoolean(ALWAYS_SCALE_KEY, viewLabel.isImageAlwaysScaled());
    }//GEN-LAST:event_scaleToggleActionPerformed

    private void abTestingToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abTestingToggleActionPerformed
        rambleyIcon.setABTesting(abTestingToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_abTestingToggleActionPerformed

    private void evilToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evilToggleActionPerformed
        rambleyIcon.setRambleyEvil(evilToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_evilToggleActionPerformed

    private void ratioToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratioToggleActionPerformed
        rambleyIcon.setAspectRatioIgnored(!ratioToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_ratioToggleActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        double value = (double) jSpinner1.getValue()/100;
        if (value != rambleyIcon.getTestDouble1()){
            rambleyIcon.setTestDouble1(value);
        }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        double value = (double) jSpinner2.getValue()/100;
        if (value != rambleyIcon.getTestDouble2()){
            rambleyIcon.setTestDouble2(value);
        }
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        double value = (double) jSpinner3.getValue()/100;
        if (value != rambleyIcon.getTestDouble3()){
            rambleyIcon.setTestDouble3(value);
        }
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jSpinner4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner4StateChanged
        double value = (double) jSpinner4.getValue()/100;
        if (value != rambleyIcon.getTestDouble4()){
            rambleyIcon.setTestDouble4(value);
        }
    }//GEN-LAST:event_jSpinner4StateChanged

    private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner5StateChanged
        double value = (double) jSpinner5.getValue()/100;
        if (value != rambleyIcon.getTestDouble5()){
            rambleyIcon.setTestDouble5(value);
        }
    }//GEN-LAST:event_jSpinner5StateChanged

    private void jSpinner6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner6StateChanged
        double value = (double) jSpinner6.getValue();
        if (value != rambleyIcon.getTestDouble6()){
            rambleyIcon.setTestDouble6(value);
        }
    }//GEN-LAST:event_jSpinner6StateChanged

    private void jSpinner7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner7StateChanged
//        rambleyIcon.setEarSplits((Integer)jSpinner7.getValue());
    }//GEN-LAST:event_jSpinner7StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //        double earX = 0;
        //        double earY = 0;
        //        ArrayList<Point2D> upperPts = new ArrayList<>();
        //        ArrayList<Point2D> lowerPts = new ArrayList<>();
        //        ArrayList<Point2D> tipPts = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts1U = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts2U = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts1L = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts2L = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts1T = new ArrayList<>();
        //        ArrayList<Point2D> ctrlPts2T = new ArrayList<>();
        //        DoubleUnaryOperator upperX = rambleyIcon.getRambleyEarX(0);
        //        DoubleUnaryOperator upperY = rambleyIcon.getRambleyEarY(0);
        //        DoubleUnaryOperator lowerX = rambleyIcon.getRambleyEarX(1);
        //        DoubleUnaryOperator lowerY = rambleyIcon.getRambleyEarY(1);
        //        DoubleUnaryOperator tipX = rambleyIcon.getRambleyEarX(2);
        //        DoubleUnaryOperator tipY = rambleyIcon.getRambleyEarY(2);
        //        rambleyIcon.calculateSplinePoints(earX, earY, 4, upperX, upperY,
            //                upperPts, ctrlPts1U, ctrlPts2U);
        //        rambleyIcon.calculateSplinePoints(earX, earY, 4, lowerX, lowerY,
            //                lowerPts, ctrlPts1L, ctrlPts2L);
        //        rambleyIcon.calculateSplinePoints(earX, earY, 7, tipX, tipY,
            //                tipPts, ctrlPts1T, ctrlPts2T);
        //        System.out.println(upperPts);
        //        System.out.println(lowerPts);
        //        System.out.println(tipPts);
        //        Line2D upper1 = new Line2D.Double(upperPts.get(0),upperPts.get(1));
        //        int tipOff = 0;
        //        Line2D tip1 = new Line2D.Double(tipPts.get(tipOff+1),tipPts.get(tipOff));
        //        while (!upper1.intersectsLine(tip1)){
            //            tipOff ++;
            //            tip1.setLine(tipPts.get(tipOff+1),tipPts.get(tipOff));
            //        }
        //        System.out.printf("Upper To Tip?: (%12.8f, %12.8f)%n",earX+15.5,earY+upperY.applyAsDouble(15.5));
        //
        //        System.out.printf("((%9.5f, %9.5f), (%9.5f, %9.5f)), ((%9.5f, %9.5f), (%9.5f, %9.5f))%n",
            //                upper1.getX1(),upper1.getY1(),upper1.getX2(),upper1.getY2(),
            //                tip1.getX1(),tip1.getY1(),tip1.getX2(),tip1.getY2());
        //
        ////        for (int i = 0; i < 25; i++){
            ////            if (upper1.getP1().distance(upper1.getP2()) <= tip1.getP1().distance(tip1.getP2())){
                ////                getIntersectingLine(tip1,upper1,earX,earY,tipY);
                ////            } else {
                ////                getIntersectingLine(upper1,tip1,earX,earY,upperY);
                ////            }
            ////        }
        ////        System.out.printf("((%9.5f, %9.5f), (%9.5f, %9.5f)), ((%9.5f, %9.5f), (%9.5f, %9.5f))%n",
            ////                upper1.getX1(),upper1.getY1(),upper1.getX2(),upper1.getY2(),
            ////                tip1.getX1(),tip1.getY1(),tip1.getX2(),tip1.getY2());
        ////        double tempX = (upper1.getX1()+upper1.getX2()+tip1.getX1()+tip1.getX2())/4.0;
        ////        double tempY = (upperY.applyAsDouble(tempX-earX)+tipY.applyAsDouble(tempX-earX))/2.0+earY;
        ////        System.out.printf("Upper To Tip:  (%9.5f, %9.5f)%n",tempX,tempY);
        //
        //        Point2D uTT = getLineIntersection(earX, earY, tip1, upper1, tipY, upperY);
        //        System.out.printf("Upper To Tip:  (%12.8f, %12.8f)%n",uTT.getX(),uTT.getY());
        //        uTT = rambleyIcon.getRambleyEarUpperTip(earX, earY, null);
        //        System.out.printf("Upper To Tip:  (%12.8f, %12.8f)%n",uTT.getX(),uTT.getY());
        //
        //        tipOff = 0;
        //        Line2D tip2 = new Line2D.Double();
        //        Line2D lower1 = new Line2D.Double();
        //        int lowerOff = 0;
        //        do{
            //            tip2.setLine(tipPts.get(tipPts.size()-2-tipOff),tipPts.get(tipPts.size()-1-tipOff));
            //            lower1.setLine(lowerPts.get(0),lowerPts.get(1));
            //            for (int off = 0; off < lowerPts.size()-1 && !tip2.intersectsLine(lower1); off++){
                //                lower1.setLine(lowerPts.get(off+0),lowerPts.get(off+1));
                //                lowerOff = off;
                //            }
            //            tipOff++;
            //        }
        //        while (!tip2.intersectsLine(lower1));
        //
        //        System.out.printf("((%9.5f, %9.5f), (%9.5f, %9.5f)), ((%9.5f, %9.5f), (%9.5f, %9.5f)) %2d %2d%n",
            //                lower1.getX1(),lower1.getY1(),lower1.getX2(),lower1.getY2(),
            //                tip2.getX1(),tip2.getY1(),tip2.getX2(),tip2.getY2(), tipOff-1, lowerOff);
        //
        ////        for (int i = 0; i < 25; i++){
            ////            if (lower1.getP1().distance(lower1.getP2()) <= tip2.getP1().distance(tip2.getP2())){
                ////                getIntersectingLine(tip2,lower1,earX,earY,tipY);
                ////            } else {
                ////                getIntersectingLine(lower1,tip2,earX,earY,lowerY);
                ////            }
            ////        }
        ////
        ////        double tempX1 = (lower1.getX1()+lower1.getX2()+tip2.getX1()+tip2.getX2())/4.0;
        ////        double tempY1 = (lowerY.applyAsDouble(tempX1-earX)+tipY.applyAsDouble(tempX1-earX))/2.0+earY;
        ////        System.out.printf("Lower To Tip:  (%9.5f, %9.5f)%n",tempX1,tempY1);
        //
        //        Point2D lTT = getLineIntersection(earX, earY, tip2, lower1, tipY, lowerY);
        //        System.out.printf("Lower To Tip:  (%12.8f, %12.8f)%n",lTT.getX(),lTT.getY());
        //        lTT = rambleyIcon.getRambleyEarLowerTip(earX, earY, null);
        //        System.out.printf("Lower To Tip:  (%12.8f, %12.8f)%n",lTT.getX(),lTT.getY());

        //        System.out.printf("((%9.5f, %9.5f), (%9.5f, %9.5f)), ((%9.5f, %9.5f), (%9.5f, %9.5f))%n",
            //                lower1.getX1(),lower1.getY1(),lower1.getX2(),lower1.getY2(),
            //                tip2.getX1(),tip2.getY1(),tip2.getX2(),tip2.getY2());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//        rambleyIcon.setEarTest(jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void widthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSpinnerStateChanged
        if (linkSizeToggle.isSelected())
            heightSpinner.setValue(widthSpinner.getValue());
        viewLabel.repaint();
        if (config != null)
            config.putInt(PAINTER_WIDTH_KEY, (int)widthSpinner.getValue());
    }//GEN-LAST:event_widthSpinnerStateChanged

    private void heightSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightSpinnerStateChanged
        if (!linkSizeToggle.isSelected())
            viewLabel.repaint();
        if (config != null)
            config.putInt(PAINTER_HEIGHT_KEY, (int)heightSpinner.getValue());
    }//GEN-LAST:event_heightSpinnerStateChanged

    private void linkSizeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkSizeToggleActionPerformed
        heightSpinner.setEnabled(!linkSizeToggle.isSelected());
        if (linkSizeToggle.isSelected())
            heightSpinner.setValue(widthSpinner.getValue());
        viewLabel.repaint();
        if (config != null)
            config.putBoolean(LINK_PAINTER_SIZE_KEY, linkSizeToggle.isSelected());
    }//GEN-LAST:event_linkSizeToggleActionPerformed

    private void listenerToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenerToggleActionPerformed
        if (config != null)
            config.putBoolean(PRINT_LISTENERS_KEY, listenerToggle.isSelected());
    }//GEN-LAST:event_listenerToggleActionPerformed

    private void circleDotToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleDotToggleActionPerformed
        rambleyIcon.setCircularBackgroundDots(circleDotToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_circleDotToggleActionPerformed

    private void shadowToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shadowToggleActionPerformed
        rambleyIcon.setBorderAndShadowPainted(shadowToggle.isSelected());
        updateConfigFlags();
    }//GEN-LAST:event_shadowToggleActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        rambleyIcon.setFlags(RambleyPainter.PAINT_BACKGROUND_FLAG | 
            RambleyPainter.PAINT_PIXEL_GRID_FLAG | 
                RambleyPainter.PAINT_BORDER_AND_SHADOW_FLAG);
        widthSpinner.setValue((int)RambleyPainter.INTERNAL_RENDER_WIDTH);
        heightSpinner.setValue((int)RambleyPainter.INTERNAL_RENDER_HEIGHT);
        linkSizeToggle.setSelected(Objects.equals(widthSpinner.getValue(), 
                heightSpinner.getValue()));
        bgDotSizeSpinner.setValue(RambleyPainter.DEFAULT_BACKGROUND_DOT_SIZE);
        bgDotSpacingSpinner.setValue(RambleyPainter.DEFAULT_BACKGROUND_DOT_SPACING);
        updateConfigFlags();
        updateSettings();
        if (config != null)
            config.putBoolean(LINK_PAINTER_SIZE_KEY, linkSizeToggle.isSelected());
    }//GEN-LAST:event_resetButtonActionPerformed

    private void bgDotSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgDotSizeSpinnerStateChanged
        rambleyIcon.setBackgroundDotSize((Double)bgDotSizeSpinner.getValue());
        if (config != null)
            config.putDouble(RambleyPainter.BACKGROUND_DOT_SIZE_PROPERTY_CHANGED, 
                    rambleyIcon.getBackgroundDotSize());
    }//GEN-LAST:event_bgDotSizeSpinnerStateChanged

    private void bgDotSpacingSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgDotSpacingSpinnerStateChanged
        rambleyIcon.setBackgroundDotSpacing((Double)bgDotSpacingSpinner.getValue());
        if (config != null)
            config.putDouble(RambleyPainter.BACKGROUND_DOT_SPACING_PROPERTY_CHANGED, 
                    rambleyIcon.getBackgroundDotSpacing());
    }//GEN-LAST:event_bgDotSpacingSpinnerStateChanged
    
    private Point2D getLineIntersection(double x, double y, Line2D line1, Line2D line2, 
            DoubleUnaryOperator getY1, DoubleUnaryOperator getY2){
        double x1 = Math.min(Math.min(line1.getX1(), line1.getX2()), Math.min(line2.getX1(), line2.getX2()));
        double x2 = Math.max(Math.max(line1.getX1(), line1.getX2()), Math.max(line2.getX1(), line2.getX2()));
        return RambleyPainter.getLineIntersection(x, y, x1, x2, getY1, getY2, null);
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
            java.util.logging.Logger.getLogger(RambleyViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RambleyViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RambleyViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RambleyViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RambleyViewer().setVisible(true);
            }
        });
    }
    
    private DebuggingIcon debugIcon;
    private RambleyIcon rambleyIcon;
    /**
     * This is a preference node to store the settings for this program.
     */
    private Preferences config;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox abTestingToggle;
    private javax.swing.JCheckBox backgroundToggle;
    private javax.swing.JSpinner bgDotSizeSpinner;
    private javax.swing.JSpinner bgDotSpacingSpinner;
    private javax.swing.JCheckBox circleDotToggle;
    private javax.swing.JCheckBox debugToggle;
    private javax.swing.JCheckBox evilToggle;
    private javax.swing.JFileChooser fc;
    private javax.swing.JCheckBox gridToggle;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JCheckBox linesToggle;
    private javax.swing.JCheckBox linkSizeToggle;
    private javax.swing.JCheckBox listenerToggle;
    private javax.swing.JButton printButton;
    private javax.swing.JCheckBox ratioToggle;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox scaleToggle;
    private javax.swing.JCheckBox shadowToggle;
    private components.JThumbnailLabel viewLabel;
    private javax.swing.JSpinner widthSpinner;
    // End of variables declaration//GEN-END:variables
    
    private class RambleyTestIcon extends RambleyIcon{
        @Override
        public int getIconWidth() {
            if (widthSpinner == null)
                return super.getIconHeight();
            return (int)widthSpinner.getValue();
        }
        @Override
        public int getIconHeight() {
            if (linkSizeToggle == null || heightSpinner == null)
                return super.getIconWidth();
            if (linkSizeToggle.isSelected())
                return getIconWidth();
            return (int)heightSpinner.getValue();
        }
    }
    
    private class IconHandler implements ChangeListener, PropertyChangeListener{

        @Override
        public void stateChanged(ChangeEvent evt) {
            viewLabel.repaint();
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (listenerToggle.isSelected())
                System.out.println("Property Change: " + evt);
            viewLabel.repaint();
        }
    }
}
