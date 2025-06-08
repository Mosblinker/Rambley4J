/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raccoon;

import com.technicjelle.UpdateChecker;
import files.extensions.ImageExtensions;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * This is a program that renders Rambley the Raccoon.
 * @author Mosblinker
 * @version 0.8.1
 */
public class Rambley4J extends JFrame {
    /**
     * This is the name of the program.
     */
    public static final String PROGRAM_NAME = "Rambley4J";
    /**
     * This is the version of the program.
     */
    public static final String PROGRAM_VERSION = "0.8.1";
    /**
     * The name of the author and main developer.
     */
    protected static final String AUTHOR_NAME = "Mosblinker";
    /**
     * This is the pattern for the file handler to use for the log files of this 
     * program.
     */
    private static final String PROGRAM_LOG_PATTERN = 
            "%h/.mosblinker/logs/"+PROGRAM_NAME+"-%u.%g.log";
    /**
     * This is the credits for the program. This is currently private as I plan 
     * to rework it.
     * @todo Rework this and then make it public. Also add any additional 
     * credits necessary
     */
    private static final String[][] CREDITS = {{
            "Developers",
            "Mosblinker - Main developer and artist."
        }, {
            "Testers",
            "*Insert Testers Here*"
        }, {
            "Libraries",
            "Thumbnailator - coobird - https://github.com/coobird/thumbnailator",
            "SwingExtended - Mosblinker - https://github.com/Mosblinker/SwingExtended",
            "FilesExtended - Mosblinker - https://github.com/Mosblinker/FilesExtended",
            "GeomArt4J - Mosblinker - https://github.com/Mosblinker/GeomArt4J",
            "UpdateChecker - TechnicJelle - https://github.com/TechnicJelle/UpdateCheckerJava",
        }, {
            "Special Thanks",
            "Special thanks to UniqueGeese and his team for creating Indigo "
            + "Park and thus Rambley.",
            "Special thanks to AnimalWave on Discord for help with the calculations.",
            "Special thanks to the UniqueGeese/Indigo Park server for "
            + "encouraging me to make this and for giving moral support."
    }};
    /**
     * This is an array containing the widths and heights for the icon images 
     * for this program. The icon images are generated on the fly.
     */
    private static final int[] ICON_SIZES = {16, 24, 32, 48, 64, 96, 128, 256, 512};
    /**
     * This is the name of the preference node used to store the settings for 
     * this program.
     */
    private static final String PREFERENCE_NODE_NAME = 
            "milo/raccoon/Rambley4J";
    /**
     * This is the key in the preference node for the state of the painter used 
     * to render Rambley the Raccoon.
     */
    private static final String RAMBLEY_FLAGS_KEY = "RambleyFlags";
    /**
     * This is the key in the preference node for the size of the background 
     * polka dots.
     */
    private static final String BACKGROUND_DOT_SIZE_KEY = "BackgroundDotSize";
    /**
     * This is the key in the preference node for the spacing of the background 
     * polka dots.
     */
    private static final String BACKGROUND_DOT_SPACING_KEY = 
            "BackgroundDotSpacing";
    /**
     * This is the key in the preference node for the shape of the background 
     * polka dots.
     */
    private static final String BACKGROUND_DOT_SHAPE_KEY = "BackgroundDotShape";
    
    private static final String PIXEL_GRID_SPACING_KEY = "PixelGridSpacing";
    
    private static final String PIXEL_GRID_THICKNESS_KEY = "PixelGridThickness";
    
    private static final String RAMBLEY_RIGHT_EYE_X_KEY = "RightEyeX";
    
    private static final String RAMBLEY_RIGHT_EYE_Y_KEY = "RightEyeY";
    
    private static final String RAMBLEY_LEFT_EYE_X_KEY = "LeftEyeX";
    
    private static final String RAMBLEY_LEFT_EYE_Y_KEY = "LeftEyeY";
    /**
     * This is the key in the preference node for whether the position of 
     * Rambley's left and right eyes are linked.
     */
    private static final String LINK_RAMBLEY_EYES_KEY = "LinkRambleyEyes";
    
    private static final String RAMBLEY_MOUTH_WIDTH_KEY = "MouthWidth";
    
    private static final String RAMBLEY_MOUTH_HEIGHT_KEY = "MouthHeight";
    /**
     * This is the key in the preference node for whether the preview of  
     * Rambley is scaled to fit the preview label.
     */
    private static final String RAMBLEY_PREVIEW_SCALED_KEY = "PreviewScaled";
    
    private static final String RAMBLEY_WIDTH_KEY = "ImageWidth";
    
    private static final String RAMBLEY_HEIGHT_KEY = "ImageHeight";
    
    private static final String LINK_RAMBLEY_SIZE_KEY = "LinkImageSize";
    /**
     * This is the key in the component-specific preference node for the widths 
     * of components.
     */
    private static final String PREFERENCE_WIDTH_KEY = "WindowWidth";
    /**
     * This is the key in the component-specific preference node for the heights 
     * of components.
     */
    private static final String PREFERENCE_HEIGHT_KEY = "WindowHeight";
    /**
     * This is the name of the child preference node used to store values 
     * related to the save file chooser.
     */
    private static final String SAVE_FILE_CHOOSER_PREFERENCE_NODE = 
            "SaveFileChooser";
    /**
     * This is the key in the preference node for the directory for the save 
     * file chooser.
     */
    private static final String SAVE_FILE_CHOOSER_DIRECTORY_KEY = 
            "SaveCurrentDirectory";
    /**
     * This is the key in the preference node for whether the program checks for 
     * updates at the start of the program.
     */
    private static final String CHECK_FOR_UPDATES_AT_START_KEY = 
            "CheckForUpdatesAtStartup";
    /**
     * The default width for the image of Rambley.
     */
    private static final int DEFAULT_RAMBLEY_WIDTH = 1024;
    /**
     * The default height for the image of Rambley.
     */
    private static final int DEFAULT_RAMBLEY_HEIGHT = 1024;
    /**
     * The flags for the RambleyPainter that is used to create the images used 
     * as the icon for this program.
     */
    private static final int ICON_IMAGES_RAMBLEY_FLAGS = 
            RambleyPainter.PAINT_RAMBLEY_OUTLINE_FLAG | 
            RambleyPainter.PAINT_RAMBLEY_SHADOW_FLAG;
    /**
     * 
     */
    private static final Logger logger = Logger.getLogger(PROGRAM_NAME+"-"+
            PROGRAM_VERSION);
    /**
     * 
     * @return 
     */
    public static Logger getLogger(){
        return logger;
    }
    /**
     * 
     * @param level
     * @param sourceClass
     * @param method
     * @param msg
     */
    public static void log(Level level, Class sourceClass, String method, 
            String msg){
        getLogger().logp(level, sourceClass.getName(), method, msg);
    }
    /**
     * 
     * @param level
     * @param sourceClass
     * @param method
     * @param msg
     * @param thrown
     */
    public static void log(Level level, Class sourceClass, String method, 
            String msg, Throwable thrown){
        getLogger().logp(level, sourceClass.getName(), method, msg, thrown);
    }
    /**
     * 
     * @param level
     * @param sourceClass
     * @param method
     * @param msg
     * @param param1
     */
    public static void log(Level level, Class sourceClass, String method, 
            String msg, Object param1){
        getLogger().logp(level, sourceClass.getName(), method, msg, param1);
    }
    /**
     * 
     * @param level
     * @param sourceClass
     * @param method
     * @param msg
     * @param params
     */
    public static void log(Level level, Class sourceClass, String method, 
            String msg, Object[] params){
        getLogger().logp(level, sourceClass.getName(), method, msg, params);
    }
    /**
     * 
     * @param sourceClass
     * @param method
     * @param thrown 
     */
    public static void logThrown(Class sourceClass, String method, 
            Throwable thrown){
        getLogger().throwing(sourceClass.getName(), method, thrown);
    }
    /**
     * Creates new form Rambley4J
     * @param debugMode
     */
    public Rambley4J(boolean debugMode) {
        this.debugMode = debugMode;
        rambleyPainter = new RambleyIcon2();
            // This is a RambleyPainter used to generate the icon images for 
            // this program
        RambleyPainter iconImgPainter = new RambleyPainter(ICON_IMAGES_RAMBLEY_FLAGS);
        iconImgPainter.setRambleyOpenMouthHeight(1.0);
            // Generate the icon images for this program
        setIconImages(generateIconImages(iconImgPainter));
        try{
            updateChecker = new UpdateChecker(AUTHOR_NAME,PROGRAM_NAME,
                    PROGRAM_VERSION);
        } catch (RuntimeException ex){
            log(Level.WARNING, this.getClass(), "Rambley4J", 
                    "UpdateChecker could not be constructed", ex);
        }
        initComponents();
        RambleyIcon aboutIcon = new RambleyIcon(128);
        aboutIcon.setFlags(ICON_IMAGES_RAMBLEY_FLAGS);
        aboutIcon.setRambleyOpenMouthHeight(1.0);
        aboutIconLabel.setIcon(aboutIcon);
        aboutIcon = new RambleyIcon(64);
        aboutIcon.setFlags(ICON_IMAGES_RAMBLEY_FLAGS);
        aboutIcon.setRambleyOpenMouthHeight(1.0);
        updateIconLabel.setIcon(aboutIcon);
        
            // Get the document for the credits text pane
        StyledDocument doc = aboutCreditsTextPane.getStyledDocument();
            // Create a style to use to center the text on the text pane
        SimpleAttributeSet centeredText = new SimpleAttributeSet();
            // Make the style center the text
        StyleConstants.setAlignment(centeredText, StyleConstants.ALIGN_CENTER);
            // This is a String to get the credits text
        String credits = "";
            // Go through the credits arrays
        for (int i = 0; i < CREDITS.length; i++){
                // If this is not the first array
            if (i > 0)
                credits += System.lineSeparator()+System.lineSeparator();
                // Add the header for this section
            credits += "---- "+CREDITS[i][0]+" ----";
                // Go through the credits in this section
            for (int j = 1; j < CREDITS[i].length; j++){
                credits += System.lineSeparator()+CREDITS[i][j];
            }
        }
        aboutCreditsTextPane.setText(credits);
            // Apply the centered text style to the entire pane
        doc.setParagraphAttributes(0, doc.getLength(), centeredText, false);
        
        if (debugMode)
            previewLabel.setComponentPopupMenu(debugPopup);
        try{    // Try to load the settings from the preference node
            config = Preferences.userRoot().node(PREFERENCE_NODE_NAME);
            checkUpdatesAtStartToggle.setSelected(config.getBoolean(
                    CHECK_FOR_UPDATES_AT_START_KEY, true));
            rambleyPainter.setFlags(config.getInt(RAMBLEY_FLAGS_KEY, 
                    rambleyPainter.getFlags()) & RambleyPainter.MAXIMUM_VALID_FLAGS);
            bgDotSizeSpinner.setValue(config.getDouble(BACKGROUND_DOT_SIZE_KEY, 
                    rambleyPainter.getBackgroundPainter().getPolkaDotSize()));
            bgDotSpacingSpinner.setValue(config.getDouble(BACKGROUND_DOT_SPACING_KEY, 
                    rambleyPainter.getBackgroundPainter().getPolkaDotSpacing()));
            try{
                int shape = rambleyPainter.getBackgroundPainter().getPolkaDotShape();
                rambleyPainter.getBackgroundPainter().setPolkaDotShape(config.getInt(BACKGROUND_DOT_SHAPE_KEY, shape));
            } catch (IllegalArgumentException ex) {
                log(Level.INFO,this.getClass(),"Rambley4J","Invalid Shape",ex);
            }
            bgDotsShapeCombo.setSelectedIndex(rambleyPainter.getBackgroundPainter().getPolkaDotShape());
            gridSpacingSpinner.setValue(config.getDouble(PIXEL_GRID_SPACING_KEY, 
                    rambleyPainter.getPixelGridPainter().getLineSpacing()));
            gridThicknessSpinner.setValue(config.getFloat(PIXEL_GRID_THICKNESS_KEY, 
                    rambleyPainter.getPixelGridPainter().getLineThickness()));
            double eyeRX = config.getDouble(RAMBLEY_RIGHT_EYE_X_KEY, 
                    rambleyPainter.getRambleyRightEyeX());
            double eyeRY = config.getDouble(RAMBLEY_RIGHT_EYE_Y_KEY, 
                    rambleyPainter.getRambleyRightEyeY());
            double eyeLX = config.getDouble(RAMBLEY_LEFT_EYE_X_KEY, 
                    rambleyPainter.getRambleyLeftEyeX());
            double eyeLY = config.getDouble(RAMBLEY_LEFT_EYE_Y_KEY, 
                    rambleyPainter.getRambleyLeftEyeY());
            eyeCtrlR.setValueX((int)(eyeRX*100));
            eyeCtrlR.setValueY((int)(eyeRY*100));
            eyeCtrlL.setValueX((int)(eyeLX*100));
            eyeCtrlL.setValueY((int)(eyeLY*100));
            linkEyesToggle.setSelected(config.getBoolean(LINK_RAMBLEY_EYES_KEY,
                    eyeRX == eyeLX && eyeRY == eyeLY));
            double mouthW = config.getDouble(RAMBLEY_MOUTH_WIDTH_KEY, 
                    rambleyPainter.getRambleyOpenMouthWidth());
            double mouthH = config.getDouble(RAMBLEY_MOUTH_HEIGHT_KEY, 
                    rambleyPainter.getRambleyOpenMouthHeight());
            mouthCtrl.setValueX((int)(mouthW*100));
            mouthCtrl.setValueY((int)(mouthH*100));
            previewLabel.setImageAlwaysScaled(config.getBoolean(
                    RAMBLEY_PREVIEW_SCALED_KEY, 
                    previewLabel.isImageAlwaysScaled()));
            widthSpinner.setValue(config.getInt(RAMBLEY_WIDTH_KEY, DEFAULT_RAMBLEY_WIDTH));
            heightSpinner.setValue(config.getInt(RAMBLEY_HEIGHT_KEY, DEFAULT_RAMBLEY_HEIGHT));
            linkSizeToggle.setSelected(config.getBoolean(LINK_RAMBLEY_SIZE_KEY, 
                    linkSizeToggle.isSelected()));
                // Get the size for the program
            Dimension dim = getPreferenceSize(null,getPreferredSize());
                // Get the minimum size for the program
            Dimension min = getMinimumSize();
                // Make sure the width and height are within range
            dim.width = Math.max(dim.width, min.width);
            dim.height = Math.max(dim.height, min.height);
                // Set the size from the node
            setSize(dim);
                // Set the size of the save file chooser
            fc.setPreferredSize(getPreferenceSize(SAVE_FILE_CHOOSER_PREFERENCE_NODE,
                    fc.getPreferredSize()));
                // Get the name of the current directory for the save file 
                // chooser, or null
            String dirName = config.get(SAVE_FILE_CHOOSER_DIRECTORY_KEY, null);
                // If there is a current directory for the save file chooser
            if (dirName != null){
                    // Get the current directory as a File
                File dir = new File(dirName);
                    // If that file exists
                if (dir.exists())
                        // Set teh save file chooser's current directory
                    fc.setCurrentDirectory(dir);
            }
        } catch (SecurityException | IllegalStateException ex){
            config = null;
            log(Level.SEVERE, this.getClass(), "Rambley4J", 
                    "Unable to load settings",ex);
        } catch (IllegalArgumentException ex){
            log(Level.WARNING, this.getClass(), "Rambley4J", 
                    "Invalid setting",ex);
        }
        fc.setFileFilter(ImageExtensions.PNG_FILTER);
        updateToggleSettings();
        previewLabel.setIcon((Icon)rambleyPainter);
        rambleyPainter.addPropertyChangeListener(new RambleyHandler());
        updatePixelGridInputEnabled();
        updatePolkaDotsInputEnabled();
            // If the program should check for updates at startup
        if (checkUpdatesAtStartToggle.isSelected()){
            new UpdateCheckWorker(true).execute();
        }
    }
    /**
     * Creates new form Rambley4J
     */
    public Rambley4J(){
        this(false);
    }
    /**
     * This generates a list of BufferedImages using the given RambleyPainter to 
     * be used as the icon images for this program. The  width and height for 
     * the images are stored in the {@link #ICON_SIZES} array.
     * @param painter The RambleyPainter to use to generate the images.
     * @return A list of images to use as the icon images for this program.
     * @see #ICON_SIZES
     */
    private java.util.List<BufferedImage> generateIconImages(RambleyPainter painter){
            // Create a list to get the images
        ArrayList<BufferedImage> iconImages = new ArrayList<>();
            // Go through the sizes for the images
        for (int size : ICON_SIZES){
                // Create a new image that is the current size
            BufferedImage image = new BufferedImage(size, size, 
                    BufferedImage.TYPE_INT_ARGB);
                // Create the graphics for that image
            Graphics2D g = image.createGraphics();
            painter.paint(g, null, size, size);
            g.dispose();
            iconImages.add(image);
        }
        return iconImages;
    }
    /**
     * 
     */
    private void updateToggleSettings(){
        bgToggle.setSelected(rambleyPainter.isBackgroundPainted());
        gridToggle.setSelected(rambleyPainter.isPixelGridPainted());
        evilToggle.setSelected(rambleyPainter.isRambleyEvil());
        ignoreRatioToggle.setSelected(rambleyPainter.isAspectRatioIgnored());
        shadowToggle.setSelected(rambleyPainter.isRambleyShadowPainted());
        outlineToggle.setSelected(rambleyPainter.isRambleyOutlinePainted());
        updateHeightSpinnerEnabled();
        flippedToggle.setSelected(rambleyPainter.isRambleyFlipped());
        jawToggle.setSelected(rambleyPainter.isRambleyJawClosed());
        bandanaToggle.setSelected(rambleyPainter.isRambleyBandanaPainted());
        glitchyToggle.setSelected(rambleyPainter.isRambleyGlitchy());
        hatToggle.setSelected(rambleyPainter.isConductorHatPainted());
        scalePreviewToggle.setSelected(previewLabel.isImageAlwaysScaled());
    }
    /**
     * 
     */
    private void updateStateInSettings(){
        if (config != null){
            try{
                config.putInt(RAMBLEY_FLAGS_KEY, rambleyPainter.getFlags());
            } catch (IllegalStateException ex){ 
                log(Level.WARNING, this.getClass(), "updateStateInSettings", 
                    "Error storing flags for RambleyPainter",ex);
            }
        }
    }
    /**
     * This updates the boolean value stored at the given key in the program's 
     * preference node to reflect whether the given toggle button is selected or 
     * not.
     * @param key The key for the value in the preference node to update.
     * @param toggleButton The toggle button to use to set the value in the 
     * preference node.
     */
    private void updateConfigBoolean(String key, AbstractButton toggleButton){
        if (config != null){        // If the preference node is available
            try{
                config.putBoolean(key, toggleButton.isSelected());
            } catch (IllegalStateException ex){ 
                log(Level.WARNING, this.getClass(), "updateConfigBoolean", 
                    "Error storing button state",ex);
            }
        }
    }
    /**
     * This checks to see if the preference node is available, and if not, 
     * throws an IllegalStateException.
     * @throws IllegalStateException If the preference node was not available to 
     * the program at initialization.
     */
    private void checkIfPreferencesIsAvailable(){
            // If the preference node is not available
        if (config == null)
            throw new IllegalStateException("Preference node is not available");
    }
    /**
     * This returns the size mapped to the given key in the preference node, or 
     * {@code def} if no size is mapped to that key.
     * @param key The key to get the associated size for.
     * @param def The default size to use if there is no size associated with 
     * the given key.
     * @return The size mapped to the given key, or {@code def} if no size is 
     * mapped to the given key.
     * @throws IllegalStateException If the preference node is not available, 
     * either due to not being available when the program started up or due to 
     * the preference node being removed.
     * @throws IllegalArgumentException If the key contains the null control 
     * character.
     */
    private Dimension getPreferenceSize(String key, Dimension def){
            // Use an empty String if given null
        key = Objects.requireNonNullElse(key, "");
            // Check as to whether the preference node is available
        checkIfPreferencesIsAvailable();
            // Get the node used to store the size
        Preferences node = config.node(key);
            // If both the width and height have not been set
        if (node.get(PREFERENCE_WIDTH_KEY, null) == null && 
                node.get(PREFERENCE_HEIGHT_KEY, null) == null)
            return def;
           // If the default size is null
        if (def == null)
            def = new Dimension(0,0);
            // Get the width
        int width = node.getInt(PREFERENCE_WIDTH_KEY, def.width);
            // Get the height
        int height = node.getInt(PREFERENCE_HEIGHT_KEY, def.height);
        return new Dimension(width,height);
    }
    /**
     * This maps the given key to the given size in the preference node. If the 
     * given size is null, then the key will be removed.
     * @param key The key to map the size to.
     * @param size The size to map to the key.
     * @throws IllegalStateException If the preference node is not available, 
     * either due to not being available when the program started up or due to 
     * the preference node being removed.
     * @throws IllegalArgumentException If the key either contains the null 
     * control character or is too long to be stored in the preference node. 
     */
    private void setPreferenceSize(String key, Dimension size){
            // Check as to whether the preference node is available
        checkIfPreferencesIsAvailable();
            // Use an empty String if given null
        key = Objects.requireNonNullElse(key, "");
            // Get the node used to store the size
        Preferences node = config.node(key);
            // If the given size is null
        if (size == null){
                // Remove the width
            node.remove(PREFERENCE_WIDTH_KEY);
                // Remove the height
            node.remove(PREFERENCE_HEIGHT_KEY);
        } else {
                // Set the width
            node.putInt(PREFERENCE_WIDTH_KEY, size.width);
                // Set the height
            node.putInt(PREFERENCE_HEIGHT_KEY, size.height);
        }
    }
    /**
     * This opens the given file chooser as a save file chooser to allow the 
     * user to select the file or folder to save to.
     * @param fc The file chooser to open.
     * @return The selected file, or null if the user canceled the file chooser.
     */
    private File showSaveFileChooser(JFileChooser fc){
            // This is used to store which button the user pressed
        int option = fc.showSaveDialog(this);
        fc.setPreferredSize(fc.getSize());
            // If the given file chooser is the normal save file chooser
        if (fc == this.fc){
            try{    // Update the file chooser's size
                setPreferenceSize(SAVE_FILE_CHOOSER_PREFERENCE_NODE,fc.getSize());
                    // Update the file chooser's current directory
                config.put(SAVE_FILE_CHOOSER_DIRECTORY_KEY, 
                        fc.getCurrentDirectory().toString());
            }catch (IllegalStateException ex){ 
                log(Level.WARNING, this.getClass(), "showSaveFileChooser", 
                    "Error storing settings for file chooser " + fc,ex);
            }
        }   // If the user wants to save the file
        if (option == JFileChooser.APPROVE_OPTION)
            return fc.getSelectedFile();
        else
            return null;
    }
    /**
     * This creates and returns an image of Rambley with the given width and 
     * height.
     * @param width The width for the image.
     * @param height The height for the image.
     * @return The generated image of Rambley.
     */
    private BufferedImage createRambleyImage(int width, int height){
            // This creates the placeholder image
        BufferedImage image = new BufferedImage(width, height, 
                BufferedImage.TYPE_INT_ARGB);
            // This creates the graphics for the image
        Graphics2D g = image.createGraphics();
        rambleyPainter.paint(g, null, width, height);
        g.dispose();
        return image;
    }
    /**
     * This attempts to save the given image to the given file, as a png. If the 
     * image fails to save, then this will open a prompt to retry, and will 
     * try again and again as long as the image fails to save and the user wants 
     * to retry.
     * @param image The image to save.
     * @param file The file to save to.
     * @return Whether the image was successfully saved to the file.
     */
    private boolean saveImage(BufferedImage image, File file){
            // This gets whether the user wants to retry if the image fails to 
        boolean retry;  // save
        do{
            try {   // Try to save the image
                return ImageIO.write(image, "png", file);
            } catch (IOException ex) {
                log(Level.WARNING, this.getClass(), "saveImage", 
                    "Error saving image to file \""+file+"\"",ex);
                    // Show the user a prompt asking if the program should try 
                    // again, and if the user says yes, then tis should try again
                retry = JOptionPane.showConfirmDialog(this, 
                        "There was an error saving the image to file\n"+
                                "\""+file+"\".\n"+
                                "Would you like to try again?"+
                                    // If we are in debug, show the error
                                ((debugMode)?"\nError: "+ex:""), 
                        "Image Failed To Save", JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION;
            }
        }   // While the image fails to save and the user wants to try again
        while(retry);
        return false;
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
        inputEnabledToggle = new javax.swing.JCheckBoxMenuItem();
        fc = new javax.swing.JFileChooser();
        aboutDialog = new javax.swing.JDialog(this);
        aboutPanel = new javax.swing.JPanel();
        aboutIconLabel = new javax.swing.JLabel();
        aboutMainPanel = new javax.swing.JPanel();
        aboutNameLabel = new javax.swing.JLabel();
        javax.swing.Box.Filler filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        aboutVersionLabel = new javax.swing.JLabel();
        javax.swing.Box.Filler filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        aboutCreditsPanel = new javax.swing.JPanel();
        aboutCreditsScrollPane = new javax.swing.JScrollPane();
        aboutCreditsTextPane = new javax.swing.JTextPane();
        aboutBottomPanel = new javax.swing.JPanel();
        aboutButtonsPanel = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        aboutOkButton = new javax.swing.JButton();
        updateCheckDialog = new javax.swing.JDialog(this);
        updatePanel = new javax.swing.JPanel();
        updateIconLabel = new javax.swing.JLabel();
        updateTextLabel = new javax.swing.JLabel();
        currentVersTextLabel = new javax.swing.JLabel();
        latestVersTextLabel = new javax.swing.JLabel();
        checkUpdatesAtStartToggle = new javax.swing.JCheckBox();
        currentVersLabel = new javax.swing.JLabel();
        latestVersLabel = new javax.swing.JLabel();
        updateContinueButton = new javax.swing.JButton();
        updateOpenButton = new javax.swing.JButton();
        previewLabel = new components.JThumbnailLabel();
        bgToggle = new javax.swing.JCheckBox();
        gridToggle = new javax.swing.JCheckBox();
        bandanaToggle = new javax.swing.JCheckBox();
        evilToggle = new javax.swing.JCheckBox();
        glitchyToggle = new javax.swing.JCheckBox();
        ignoreRatioToggle = new javax.swing.JCheckBox();
        shadowToggle = new javax.swing.JCheckBox();
        outlineToggle = new javax.swing.JCheckBox();
        hatToggle = new javax.swing.JCheckBox();
        flippedToggle = new javax.swing.JCheckBox();
        sidePanel = new javax.swing.JPanel();
        eyesPanel = new javax.swing.JPanel();
        eyeCtrlR = new swing.TwoAxisSlider();
        eyeCtrlL = new swing.TwoAxisSlider();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        centerSidePanel = new javax.swing.JPanel();
        leftCenterSidePanel = new javax.swing.JPanel();
        linkEyesToggle = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        scalePreviewToggle = new javax.swing.JCheckBox();
        aboutButton = new javax.swing.JButton();
        mouthPanel = new javax.swing.JPanel();
        mouthCtrl = new swing.TwoAxisSlider();
        jawToggle = new javax.swing.JCheckBox();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        pixelGridPanel = new javax.swing.JPanel();
        gridSpacingLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        gridSpacingSpinner = new javax.swing.JSpinner();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        gridThicknessLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        gridThicknessSpinner = new javax.swing.JSpinner();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        bgDotsPanel = new javax.swing.JPanel();
        bgDotsShapeLabel = new javax.swing.JLabel();
        bgDotsShapeCombo = new javax.swing.JComboBox<>();
        bgDotsSpinnerPanel = new javax.swing.JPanel();
        bgDotSizeLabel = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        bgDotSizeSpinner = new javax.swing.JSpinner();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        bgDotSpacingLabel = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        bgDotSpacingSpinner = new javax.swing.JSpinner();
        sizePanel = new javax.swing.JPanel();
        widthLabel = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        widthSpinner = new javax.swing.JSpinner();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        heightLabel = new javax.swing.JLabel();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        heightSpinner = new javax.swing.JSpinner();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 0), new java.awt.Dimension(6, 32767));
        linkSizeToggle = new javax.swing.JCheckBox();

        printButton.setText("Print Data");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        debugPopup.add(printButton);

        inputEnabledToggle.setSelected(true);
        inputEnabledToggle.setText("Input Enabled");
        inputEnabledToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEnabledToggleActionPerformed(evt);
            }
        });
        debugPopup.add(inputEnabledToggle);

        fc.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        aboutDialog.setTitle("About "+PROGRAM_NAME);
        aboutDialog.setMinimumSize(new java.awt.Dimension(640, 400));
        aboutDialog.setResizable(false);

        aboutPanel.setLayout(new java.awt.BorderLayout(18, 7));

        aboutIconLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        aboutIconLabel.setAlignmentX(0.5F);
        aboutPanel.add(aboutIconLabel, java.awt.BorderLayout.LINE_START);

        aboutMainPanel.setLayout(new javax.swing.BoxLayout(aboutMainPanel, javax.swing.BoxLayout.Y_AXIS));

        aboutNameLabel.setFont(aboutNameLabel.getFont().deriveFont(aboutNameLabel.getFont().getStyle() | java.awt.Font.BOLD, aboutNameLabel.getFont().getSize()+9));
        aboutNameLabel.setText(PROGRAM_NAME);
        aboutNameLabel.setAlignmentX(0.5F);
        aboutMainPanel.add(aboutNameLabel);
        aboutMainPanel.add(filler20);

        aboutVersionLabel.setFont(aboutVersionLabel.getFont().deriveFont((aboutVersionLabel.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD, aboutVersionLabel.getFont().getSize()+5));
        aboutVersionLabel.setText("Version "+PROGRAM_VERSION);
        aboutVersionLabel.setAlignmentX(0.5F);
        aboutMainPanel.add(aboutVersionLabel);
        aboutMainPanel.add(filler21);

        aboutCreditsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Credits"));
        aboutCreditsPanel.setLayout(new java.awt.BorderLayout());

        aboutCreditsTextPane.setEditable(false);
        aboutCreditsScrollPane.setViewportView(aboutCreditsTextPane);

        aboutCreditsPanel.add(aboutCreditsScrollPane, java.awt.BorderLayout.CENTER);

        aboutMainPanel.add(aboutCreditsPanel);

        aboutPanel.add(aboutMainPanel, java.awt.BorderLayout.CENTER);

        aboutBottomPanel.setLayout(new java.awt.BorderLayout());

        aboutButtonsPanel.setLayout(new javax.swing.BoxLayout(aboutButtonsPanel, javax.swing.BoxLayout.LINE_AXIS));

        updateButton.setText("Check For Updates");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        aboutButtonsPanel.add(updateButton);
        aboutButtonsPanel.add(filler19);

        aboutOkButton.setText("OK");
        aboutOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutOkButtonActionPerformed(evt);
            }
        });
        aboutButtonsPanel.add(aboutOkButton);

        aboutBottomPanel.add(aboutButtonsPanel, java.awt.BorderLayout.LINE_END);

        aboutPanel.add(aboutBottomPanel, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        updateCheckDialog.setTitle(PROGRAM_NAME+" Update Checker");
        updateCheckDialog.setMinimumSize(new java.awt.Dimension(400, 196));
        updateCheckDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        updateCheckDialog.setResizable(false);

        updatePanel.setLayout(new java.awt.GridBagLayout());

        updateIconLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 18);
        updatePanel.add(updateIconLabel, gridBagConstraints);

        updateTextLabel.setText("A new version of "+PROGRAM_NAME+" is available.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 18, 0);
        updatePanel.add(updateTextLabel, gridBagConstraints);

        currentVersTextLabel.setText("Current Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 12);
        updatePanel.add(currentVersTextLabel, gridBagConstraints);

        latestVersTextLabel.setText("Latest Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 12);
        updatePanel.add(latestVersTextLabel, gridBagConstraints);

        checkUpdatesAtStartToggle.setSelected(true);
        checkUpdatesAtStartToggle.setText("Check for Updates at startup");
        checkUpdatesAtStartToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUpdatesAtStartToggleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        updatePanel.add(checkUpdatesAtStartToggle, gridBagConstraints);

        currentVersLabel.setText(PROGRAM_VERSION);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        updatePanel.add(currentVersLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        updatePanel.add(latestVersLabel, gridBagConstraints);

        updateContinueButton.setText("Continue");
        updateContinueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateContinueButtonActionPerformed(evt);
            }
        });

        updateOpenButton.setText("Go to web page");
        updateOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOpenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateCheckDialogLayout = new javax.swing.GroupLayout(updateCheckDialog.getContentPane());
        updateCheckDialog.getContentPane().setLayout(updateCheckDialogLayout);
        updateCheckDialogLayout.setHorizontalGroup(
            updateCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCheckDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateCheckDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateOpenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateContinueButton)))
                .addContainerGap())
        );
        updateCheckDialogLayout.setVerticalGroup(
            updateCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCheckDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(updateCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateContinueButton)
                    .addComponent(updateOpenButton))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(PROGRAM_NAME);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        bgToggle.setText("Background");
        bgToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgToggleActionPerformed(evt);
            }
        });

        gridToggle.setText("Pixel Grid");
        gridToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridToggleActionPerformed(evt);
            }
        });

        bandanaToggle.setText("Bandana");
        bandanaToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bandanaToggleActionPerformed(evt);
            }
        });

        evilToggle.setText("Evil");
        evilToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evilToggleActionPerformed(evt);
            }
        });

        glitchyToggle.setText("Glitchy");
        glitchyToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glitchyToggleActionPerformed(evt);
            }
        });

        ignoreRatioToggle.setText("Ignore Aspect Ratio");
        ignoreRatioToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreRatioToggleActionPerformed(evt);
            }
        });

        shadowToggle.setText("Shadow");
        shadowToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shadowToggleActionPerformed(evt);
            }
        });

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

        sidePanel.setLayout(new javax.swing.BoxLayout(sidePanel, javax.swing.BoxLayout.Y_AXIS));

        eyesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Eyes"));
        eyesPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

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
        eyesPanel.add(eyeCtrlR);

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
        eyesPanel.add(eyeCtrlL);

        sidePanel.add(eyesPanel);
        sidePanel.add(filler7);

        centerSidePanel.setLayout(new java.awt.GridBagLayout());

        linkEyesToggle.setText("Link Eyes");
        linkEyesToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkEyesToggleActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        scalePreviewToggle.setText("Scale Preview");
        scalePreviewToggle.setToolTipText("Whether the preview of the image should be scaled to fit the preview window.");
        scalePreviewToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scalePreviewToggleActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftCenterSidePanelLayout = new javax.swing.GroupLayout(leftCenterSidePanel);
        leftCenterSidePanel.setLayout(leftCenterSidePanelLayout);
        leftCenterSidePanelLayout.setHorizontalGroup(
            leftCenterSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftCenterSidePanelLayout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(leftCenterSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scalePreviewToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(leftCenterSidePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(leftCenterSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(linkEyesToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        leftCenterSidePanelLayout.setVerticalGroup(
            leftCenterSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftCenterSidePanelLayout.createSequentialGroup()
                .addComponent(linkEyesToggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scalePreviewToggle)
                .addGap(9, 9, 9)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        centerSidePanel.add(leftCenterSidePanel, gridBagConstraints);

        mouthPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mouth"));
        mouthPanel.setLayout(new java.awt.BorderLayout(0, 6));

        mouthCtrl.setValueX(100);
        mouthCtrl.setValueY(0);
        mouthCtrl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mouthCtrlStateChanged(evt);
            }
        });
        mouthPanel.add(mouthCtrl, java.awt.BorderLayout.CENTER);

        jawToggle.setText("Jaw Closed");
        jawToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jawToggleActionPerformed(evt);
            }
        });
        mouthPanel.add(jawToggle, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.9;
        centerSidePanel.add(mouthPanel, gridBagConstraints);

        sidePanel.add(centerSidePanel);
        sidePanel.add(filler8);

        pixelGridPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pixel Grid"));
        pixelGridPanel.setLayout(new javax.swing.BoxLayout(pixelGridPanel, javax.swing.BoxLayout.LINE_AXIS));

        gridSpacingLabel.setLabelFor(gridSpacingSpinner);
        gridSpacingLabel.setText("Spacing:");
        pixelGridPanel.add(gridSpacingLabel);
        pixelGridPanel.add(filler1);

        gridSpacingSpinner.setModel(new javax.swing.SpinnerNumberModel(5.0d, 0.0d, null, 1.0d));
        gridSpacingSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridSpacingSpinnerStateChanged(evt);
            }
        });
        pixelGridPanel.add(gridSpacingSpinner);
        pixelGridPanel.add(filler2);

        gridThicknessLabel.setLabelFor(gridThicknessSpinner);
        gridThicknessLabel.setText("Thickness:");
        pixelGridPanel.add(gridThicknessLabel);
        pixelGridPanel.add(filler3);

        gridThicknessSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0f, 0.0f, null, 1.0f));
        gridThicknessSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridThicknessSpinnerStateChanged(evt);
            }
        });
        pixelGridPanel.add(gridThicknessSpinner);

        sidePanel.add(pixelGridPanel);
        sidePanel.add(filler9);

        bgDotsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Background Polka-Dots"));

        bgDotsShapeLabel.setLabelFor(bgDotsShapeCombo);
        bgDotsShapeLabel.setText("Shape:");

        bgDotsShapeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rhombus", "Circle", "Square" }));
        bgDotsShapeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgDotsShapeComboActionPerformed(evt);
            }
        });

        bgDotsSpinnerPanel.setLayout(new javax.swing.BoxLayout(bgDotsSpinnerPanel, javax.swing.BoxLayout.LINE_AXIS));

        bgDotSizeLabel.setLabelFor(bgDotSizeSpinner);
        bgDotSizeLabel.setText("Size:");
        bgDotsSpinnerPanel.add(bgDotSizeLabel);
        bgDotsSpinnerPanel.add(filler4);

        bgDotSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(8.0d, null, null, 1.0d));
        bgDotSizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgDotSizeSpinnerStateChanged(evt);
            }
        });
        bgDotsSpinnerPanel.add(bgDotSizeSpinner);
        bgDotsSpinnerPanel.add(filler5);

        bgDotSpacingLabel.setLabelFor(bgDotSpacingSpinner);
        bgDotSpacingLabel.setText("Spacing:");
        bgDotsSpinnerPanel.add(bgDotSpacingLabel);
        bgDotsSpinnerPanel.add(filler6);

        bgDotSpacingSpinner.setModel(new javax.swing.SpinnerNumberModel(12.0d, null, null, 1.0d));
        bgDotSpacingSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bgDotSpacingSpinnerStateChanged(evt);
            }
        });
        bgDotsSpinnerPanel.add(bgDotSpacingSpinner);

        javax.swing.GroupLayout bgDotsPanelLayout = new javax.swing.GroupLayout(bgDotsPanel);
        bgDotsPanel.setLayout(bgDotsPanelLayout);
        bgDotsPanelLayout.setHorizontalGroup(
            bgDotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgDotsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(bgDotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bgDotsSpinnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgDotsPanelLayout.createSequentialGroup()
                        .addComponent(bgDotsShapeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bgDotsShapeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        bgDotsPanelLayout.setVerticalGroup(
            bgDotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDotsPanelLayout.createSequentialGroup()
                .addComponent(bgDotsSpinnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgDotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bgDotsShapeLabel)
                    .addComponent(bgDotsShapeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        sidePanel.add(bgDotsPanel);

        sizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Image Size"));
        sizePanel.setLayout(new javax.swing.BoxLayout(sizePanel, javax.swing.BoxLayout.LINE_AXIS));

        widthLabel.setLabelFor(widthSpinner);
        widthLabel.setText("Width:");
        sizePanel.add(widthLabel);
        sizePanel.add(filler11);

        widthSpinner.setModel(new javax.swing.SpinnerNumberModel(512, 0, null, 1));
        widthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                widthSpinnerStateChanged(evt);
            }
        });
        sizePanel.add(widthSpinner);
        sizePanel.add(filler12);

        heightLabel.setLabelFor(heightSpinner);
        heightLabel.setText("Height:");
        sizePanel.add(heightLabel);
        sizePanel.add(filler13);

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(512, 0, null, 1));
        heightSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heightSpinnerStateChanged(evt);
            }
        });
        sizePanel.add(heightSpinner);
        sizePanel.add(filler14);

        linkSizeToggle.setSelected(true);
        linkSizeToggle.setText("Link Size");
        linkSizeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkSizeToggleActionPerformed(evt);
            }
        });
        sizePanel.add(linkSizeToggle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ignoreRatioToggle)
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
                                .addComponent(bandanaToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(evilToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(glitchyToggle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(flippedToggle))
                            .addComponent(sizePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bgToggle)
                            .addComponent(gridToggle)
                            .addComponent(bandanaToggle)
                            .addComponent(evilToggle)
                            .addComponent(glitchyToggle)
                            .addComponent(flippedToggle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ignoreRatioToggle)
                            .addComponent(shadowToggle)
                            .addComponent(outlineToggle)
                            .addComponent(hatToggle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        updateConfigBoolean(LINK_RAMBLEY_EYES_KEY,linkEyesToggle);
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

    private void bgDotsShapeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgDotsShapeComboActionPerformed
        rambleyPainter.getBackgroundPainter().setPolkaDotShape(bgDotsShapeCombo.getSelectedIndex());
    }//GEN-LAST:event_bgDotsShapeComboActionPerformed

    private void bandanaToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bandanaToggleActionPerformed
        rambleyPainter.setRambleyBandanaPainted(bandanaToggle.isSelected());
    }//GEN-LAST:event_bandanaToggleActionPerformed

    private void evilToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evilToggleActionPerformed
        rambleyPainter.setRambleyEvil(evilToggle.isSelected());
    }//GEN-LAST:event_evilToggleActionPerformed

    private void glitchyToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glitchyToggleActionPerformed
        rambleyPainter.setRambleyGlitchy(glitchyToggle.isSelected());
    }//GEN-LAST:event_glitchyToggleActionPerformed

    private void flippedToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flippedToggleActionPerformed
        rambleyPainter.setRambleyFlipped(flippedToggle.isSelected());
    }//GEN-LAST:event_flippedToggleActionPerformed

    private void ignoreRatioToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreRatioToggleActionPerformed
        rambleyPainter.setAspectRatioIgnored(ignoreRatioToggle.isSelected());
    }//GEN-LAST:event_ignoreRatioToggleActionPerformed

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
     * This saves the image of Rambley to a file selected by the user.
     * @param evt The ActionEvent.
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
            // This will get the file that the user selected
        File file;
        do{     // Open the save file chooser and get the file the user selected
            file = showSaveFileChooser(fc);
                // If no file was selected
            if (file == null)
                return;
                // If the PNG file filter is in use and the entered file does 
                // not have the PNG file extension
            if (ImageExtensions.PNG_FILTER.equals(fc.getFileFilter()) && 
                    !ImageExtensions.PNG_FILTER.accept(file)){
                    // Add the PNG file extension to the file
                file = new File(file.toString()+"."+ImageExtensions.PNG);
                fc.setSelectedFile(file);
            }   // If the file already exists
            if (file.exists()){
                    // Show the user a confirmation dialog asking if the user 
                    // wants to overwrite the file
                int option = JOptionPane.showConfirmDialog(this, 
                        "There is already a file with that name.\n"+
                        "Should the file be overwritten?\n"+
                        "File: \""+file+"\"", "File Already Exists", 
                        JOptionPane.YES_NO_CANCEL_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                    // Determine the action to perform based off the user's 
                switch(option){ // choice
                        // If the user selected No
                    case(JOptionPane.NO_OPTION):
                            // Set the file to null to run the loop again
                        file = null;
                        // If the user selected Yes
                    case(JOptionPane.YES_OPTION):
                        break;
                        // If the user selected Cancel or exited the dialog
                    default:
                            // Cancel the operation, and show a prompt notifying 
                            // that nothing was saved.
                        JOptionPane.showMessageDialog(this,"No file was saved.", 
                                "File Already Exists", 
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                }
            }   // While the file is null (user decided to select a different 
        } while (file == null);     // file)
                // Save Rambley to the file
        saver = new RambleySaver(file);
        saver.execute();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void gridSpacingSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridSpacingSpinnerStateChanged
        rambleyPainter.getPixelGridPainter().setLineSpacing((double)gridSpacingSpinner.getValue());
    }//GEN-LAST:event_gridSpacingSpinnerStateChanged

    private void gridThicknessSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridThicknessSpinnerStateChanged
        rambleyPainter.getPixelGridPainter().setLineThickness((float)gridThicknessSpinner.getValue());
    }//GEN-LAST:event_gridThicknessSpinnerStateChanged

    private void bgDotSizeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgDotSizeSpinnerStateChanged
        rambleyPainter.getBackgroundPainter().setPolkaDotSize((double)bgDotSizeSpinner.getValue());
    }//GEN-LAST:event_bgDotSizeSpinnerStateChanged

    private void bgDotSpacingSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bgDotSpacingSpinnerStateChanged
        rambleyPainter.getBackgroundPainter().setPolkaDotSpacing((double)bgDotSpacingSpinner.getValue());
    }//GEN-LAST:event_bgDotSpacingSpinnerStateChanged

    private void widthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_widthSpinnerStateChanged
        if (linkSizeToggle.isSelected())
            heightSpinner.setValue(widthSpinner.getValue());
        previewLabel.repaint();
        if (config != null)
            config.putInt(RAMBLEY_WIDTH_KEY, (int)widthSpinner.getValue());
    }//GEN-LAST:event_widthSpinnerStateChanged

    private void heightSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightSpinnerStateChanged
        if (!linkSizeToggle.isSelected())
            previewLabel.repaint();
        if (config != null)
            config.putInt(RAMBLEY_HEIGHT_KEY, (int)heightSpinner.getValue());
    }//GEN-LAST:event_heightSpinnerStateChanged

    private void linkSizeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkSizeToggleActionPerformed
        updateHeightSpinnerEnabled();
        if (linkSizeToggle.isSelected())
            heightSpinner.setValue(widthSpinner.getValue());
        updateConfigBoolean(LINK_RAMBLEY_SIZE_KEY,linkSizeToggle);
        previewLabel.repaint();
    }//GEN-LAST:event_linkSizeToggleActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
            // Reset the RambleyPainter
        rambleyPainter.reset();
        widthSpinner.setValue(DEFAULT_RAMBLEY_WIDTH);
        heightSpinner.setValue(DEFAULT_RAMBLEY_HEIGHT);
        linkSizeToggle.setSelected(Objects.equals(widthSpinner.getValue(), 
                heightSpinner.getValue()));
        bgDotSizeSpinner.setValue(rambleyPainter.getBackgroundPainter().getPolkaDotSize());
        bgDotSpacingSpinner.setValue(rambleyPainter.getBackgroundPainter().getPolkaDotSpacing());
        gridSpacingSpinner.setValue(rambleyPainter.getPixelGridPainter().getLineSpacing());
        gridThicknessSpinner.setValue(rambleyPainter.getPixelGridPainter().getLineThickness());
        double eyeRX = rambleyPainter.getRambleyRightEyeX() * 100;
        double eyeRY = rambleyPainter.getRambleyRightEyeY() * 100;
        double eyeLX = rambleyPainter.getRambleyLeftEyeX() * 100;
        double eyeLY = rambleyPainter.getRambleyLeftEyeY() * 100;
        double mouthW = rambleyPainter.getRambleyOpenMouthWidth() * 100;
        double mouthH = rambleyPainter.getRambleyOpenMouthHeight() * 100;
        eyeCtrlR.setValueX((int)eyeRX);
        eyeCtrlR.setValueY((int)eyeRY);
        eyeCtrlL.setValueX((int)eyeLX);
        eyeCtrlL.setValueY((int)eyeLY);
        linkEyesToggle.setSelected(eyeRX == eyeLX && eyeRY == eyeLY);
        mouthCtrl.setValueX((int)mouthW);
        mouthCtrl.setValueY((int)mouthH);
        updateToggleSettings();
        updateStateInSettings();
        updateConfigBoolean(LINK_RAMBLEY_EYES_KEY,linkEyesToggle);
        updateConfigBoolean(LINK_RAMBLEY_SIZE_KEY,linkSizeToggle);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void scalePreviewToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scalePreviewToggleActionPerformed
        previewLabel.setImageAlwaysScaled(scalePreviewToggle.isSelected());
        updateConfigBoolean(RAMBLEY_PREVIEW_SCALED_KEY,scalePreviewToggle);
    }//GEN-LAST:event_scalePreviewToggleActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
            // If the window is not maximized
        if ((getExtendedState() & JFrame.MAXIMIZED_BOTH) == 0){
            try{    // Set the stored size in the preference node
                setPreferenceSize(null,getSize());
            }catch (IllegalStateException ex){ 
                log(Level.WARNING, this.getClass(), "formComponentResized", 
                    "Error storing program size",ex);
            }
        }
    }//GEN-LAST:event_formComponentResized

    private void inputEnabledToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEnabledToggleActionPerformed
        setInputEnabled(inputEnabledToggle.isSelected());
    }//GEN-LAST:event_inputEnabledToggleActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
            // Make the about dialog location relative to the program
        aboutDialog.setLocationRelativeTo(this);
            // Show the about dialog
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        new UpdateCheckWorker(false).execute();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void aboutOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutOkButtonActionPerformed
        aboutDialog.setVisible(false);
    }//GEN-LAST:event_aboutOkButtonActionPerformed

    private void checkUpdatesAtStartToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUpdatesAtStartToggleActionPerformed
        updateConfigBoolean(CHECK_FOR_UPDATES_AT_START_KEY,
                checkUpdatesAtStartToggle);
    }//GEN-LAST:event_checkUpdatesAtStartToggleActionPerformed

    private void updateContinueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateContinueButtonActionPerformed
        updateCheckDialog.setVisible(false);
    }//GEN-LAST:event_updateContinueButtonActionPerformed

    private void updateOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOpenButtonActionPerformed
            // Get the update URL
        String url = updateChecker.getUpdateUrl();
        try {   // Try to open the update URL in the user's web browser
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (URISyntaxException | IOException ex) {
            log(Level.WARNING, this.getClass(),
                    "updateOpenButtonActionPerformed",
                    "Could not open update URL "+url,ex);
        }
    }//GEN-LAST:event_updateOpenButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            // Set the logger's level to the lowest level in order to log all
        getLogger().setLevel(Level.FINEST);
        try {   // Get the parent file for the log file
            File file = new File(PROGRAM_LOG_PATTERN.replace("%h", 
                    System.getProperty("user.home"))
                    .replace('/', File.separatorChar)).getParentFile();
                // If the parent of the log file doesn't exist
            if (!file.exists()){
                try{    // Try to create the directories for the log file
                    Files.createDirectories(file.toPath());
                } catch (IOException ex){
                    getLogger().log(Level.WARNING, 
                            "Failed to create directories for log file", ex);
                }
            }   // Add a file handler to log messages to a log file
            getLogger().addHandler(new java.util.logging.FileHandler(
                    PROGRAM_LOG_PATTERN,0,8));
        } catch (IOException | SecurityException ex) {
            getLogger().log(Level.SEVERE, "Failed to get log file", ex);
        }
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
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger().log(Level.SEVERE, "Failed to load Nimbus LnF", ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Rambley4J(true).setVisible(true);
        });
    }
    
    private void updateHeightSpinnerEnabled(){
        heightSpinner.setEnabled(!linkSizeToggle.isSelected() && inputEnabled);
    }
    
    private void setInputEnabled(boolean enabled){
        inputEnabled = enabled;
        bgToggle.setEnabled(enabled);
        gridToggle.setEnabled(enabled);
        bandanaToggle.setEnabled(enabled);
        evilToggle.setEnabled(enabled);
        flippedToggle.setEnabled(enabled);
        ignoreRatioToggle.setEnabled(enabled);
//        glitchyToggle.setEnabled(enabled);
//        hatToggle.setEnabled(enabled);
        shadowToggle.setEnabled(enabled);
        outlineToggle.setEnabled(enabled);
        eyeCtrlR.setEnabled(enabled);
        eyeCtrlL.setEnabled(enabled);
        linkEyesToggle.setEnabled(enabled);
        mouthCtrl.setEnabled(enabled);
        jawToggle.setEnabled(enabled);
        saveButton.setEnabled(enabled);
        resetButton.setEnabled(enabled);
        widthSpinner.setEnabled(enabled);
        updateHeightSpinnerEnabled();
        linkSizeToggle.setEnabled(enabled);
        aboutButton.setEnabled(enabled);
        updatePixelGridInputEnabled();
        updatePolkaDotsInputEnabled();
        fc.setEnabled(enabled);
        updateButton.setEnabled(enabled);
        updateOpenButton.setEnabled(enabled);
    }
    
    private void updatePixelGridInputEnabled(){
        pixelGridPanel.setEnabled(rambleyPainter.isPixelGridPainted());
        gridSpacingLabel.setEnabled(pixelGridPanel.isEnabled());
        gridSpacingSpinner.setEnabled(inputEnabled && gridSpacingLabel.isEnabled());
        gridThicknessLabel.setEnabled(pixelGridPanel.isEnabled());
        gridThicknessSpinner.setEnabled(gridSpacingSpinner.isEnabled());
    }
    
    private void updatePolkaDotsInputEnabled(){
        bgDotsPanel.setEnabled(rambleyPainter.isBackgroundPainted());
        bgDotSizeLabel.setEnabled(bgDotsPanel.isEnabled());
        bgDotSpacingLabel.setEnabled(bgDotsPanel.isEnabled());
        bgDotsShapeLabel.setEnabled(bgDotsPanel.isEnabled());
        bgDotSizeSpinner.setEnabled(inputEnabled && bgDotsPanel.isEnabled());
        bgDotSpacingSpinner.setEnabled(bgDotSizeSpinner.isEnabled());
        bgDotsShapeCombo.setEnabled(bgDotSizeSpinner.isEnabled());
    }
    /**
     * This is the painter used to paint Rambley.
     */
    private RambleyPainter rambleyPainter;
    /**
     * This is a preference node to store the settings for this program.
     */
    private Preferences config;
    /**
     * This is the last RambleySaver used to save the image of Rambley.
     */
    private RambleySaver saver = null;
    /**
     * Whether this program is currently accepting input.
     */
    private volatile boolean inputEnabled = true;
    /**
     * Whether this application is in debug mode.
     */
    private final boolean debugMode;
    /**
     * This is the checker to use to check for updates for the program.
     */
    private UpdateChecker updateChecker = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutBottomPanel;
    private javax.swing.JButton aboutButton;
    private javax.swing.JPanel aboutButtonsPanel;
    private javax.swing.JPanel aboutCreditsPanel;
    private javax.swing.JScrollPane aboutCreditsScrollPane;
    private javax.swing.JTextPane aboutCreditsTextPane;
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JLabel aboutIconLabel;
    private javax.swing.JPanel aboutMainPanel;
    private javax.swing.JLabel aboutNameLabel;
    private javax.swing.JButton aboutOkButton;
    private javax.swing.JPanel aboutPanel;
    private javax.swing.JLabel aboutVersionLabel;
    private javax.swing.JCheckBox bandanaToggle;
    private javax.swing.JLabel bgDotSizeLabel;
    private javax.swing.JSpinner bgDotSizeSpinner;
    private javax.swing.JLabel bgDotSpacingLabel;
    private javax.swing.JSpinner bgDotSpacingSpinner;
    private javax.swing.JPanel bgDotsPanel;
    private javax.swing.JComboBox<String> bgDotsShapeCombo;
    private javax.swing.JLabel bgDotsShapeLabel;
    private javax.swing.JPanel bgDotsSpinnerPanel;
    private javax.swing.JCheckBox bgToggle;
    private javax.swing.JPanel centerSidePanel;
    private javax.swing.JCheckBox checkUpdatesAtStartToggle;
    private javax.swing.JLabel currentVersLabel;
    private javax.swing.JLabel currentVersTextLabel;
    private javax.swing.JPopupMenu debugPopup;
    private javax.swing.JCheckBox evilToggle;
    private swing.TwoAxisSlider eyeCtrlL;
    private swing.TwoAxisSlider eyeCtrlR;
    private javax.swing.JPanel eyesPanel;
    private javax.swing.JFileChooser fc;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JCheckBox flippedToggle;
    private javax.swing.JCheckBox glitchyToggle;
    private javax.swing.JLabel gridSpacingLabel;
    private javax.swing.JSpinner gridSpacingSpinner;
    private javax.swing.JLabel gridThicknessLabel;
    private javax.swing.JSpinner gridThicknessSpinner;
    private javax.swing.JCheckBox gridToggle;
    private javax.swing.JCheckBox hatToggle;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JCheckBox ignoreRatioToggle;
    private javax.swing.JCheckBoxMenuItem inputEnabledToggle;
    private javax.swing.JCheckBox jawToggle;
    private javax.swing.JLabel latestVersLabel;
    private javax.swing.JLabel latestVersTextLabel;
    private javax.swing.JPanel leftCenterSidePanel;
    private javax.swing.JCheckBox linkEyesToggle;
    private javax.swing.JCheckBox linkSizeToggle;
    private swing.TwoAxisSlider mouthCtrl;
    private javax.swing.JPanel mouthPanel;
    private javax.swing.JCheckBox outlineToggle;
    private javax.swing.JPanel pixelGridPanel;
    private components.JThumbnailLabel previewLabel;
    private javax.swing.JMenuItem printButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox scalePreviewToggle;
    private javax.swing.JCheckBox shadowToggle;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel sizePanel;
    private javax.swing.JButton updateButton;
    private javax.swing.JDialog updateCheckDialog;
    private javax.swing.JButton updateContinueButton;
    private javax.swing.JLabel updateIconLabel;
    private javax.swing.JButton updateOpenButton;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JLabel updateTextLabel;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JSpinner widthSpinner;
    // End of variables declaration//GEN-END:variables
    
    private class RambleyHandler implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            previewLabel.repaint();
            if (config != null){
                switch(evt.getPropertyName()){
                    case(RambleyPainter.BACKGROUND_PAINTED_PROPERTY_CHANGED):
                        updatePolkaDotsInputEnabled();
                        break;
                    case(RambleyPainter.PIXEL_GRID_PAINTED_PROPERTY_CHANGED):
                        updatePixelGridInputEnabled();
                }
                try{
                    if (RambleyPainter.FLAG_PROPERTY_NAMES_MAP.values().
                            contains(evt.getPropertyName())){
                        updateStateInSettings();
                    } else {
                        switch(evt.getPropertyName()){
                            case(BackgroundPainter.POLKA_DOT_SIZE_PROPERTY_CHANGED):
                                config.putDouble(BACKGROUND_DOT_SIZE_KEY, 
                                        rambleyPainter.getBackgroundPainter().getPolkaDotSize());
                                break;
                            case(BackgroundPainter.POLKA_DOT_SPACING_PROPERTY_CHANGED):
                                config.putDouble(BACKGROUND_DOT_SPACING_KEY, 
                                        rambleyPainter.getBackgroundPainter().getPolkaDotSpacing());
                                break;
                            case(BackgroundPainter.POLKA_DOT_SHAPE_PROPERTY_CHANGED):
                                config.putInt(BACKGROUND_DOT_SHAPE_KEY, 
                                        rambleyPainter.getBackgroundPainter().getPolkaDotShape());
                                break;
                            case(PixelGridPainter.LINE_SPACING_PROPERTY_CHANGED):
                                config.putDouble(PIXEL_GRID_SPACING_KEY, 
                                        rambleyPainter.getPixelGridPainter().getLineSpacing());
                                break;
                            case(PixelGridPainter.LINE_THICKNESS_PROPERTY_CHANGED):
                                config.putFloat(PIXEL_GRID_THICKNESS_KEY, 
                                        rambleyPainter.getPixelGridPainter().getLineThickness());
                                break;
                            case(RambleyPainter.RAMBLEY_RIGHT_EYE_X_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_RIGHT_EYE_X_KEY, 
                                        rambleyPainter.getRambleyRightEyeX());
                                break;
                            case(RambleyPainter.RAMBLEY_RIGHT_EYE_Y_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_RIGHT_EYE_Y_KEY, 
                                        rambleyPainter.getRambleyRightEyeY());
                                break;
                            case(RambleyPainter.RAMBLEY_LEFT_EYE_X_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_LEFT_EYE_X_KEY, 
                                        rambleyPainter.getRambleyLeftEyeX());
                                break;
                            case(RambleyPainter.RAMBLEY_LEFT_EYE_Y_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_LEFT_EYE_Y_KEY, 
                                        rambleyPainter.getRambleyLeftEyeY());
                                break;
                            case(RambleyPainter.RAMBLEY_OPEN_MOUTH_WIDTH_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_MOUTH_WIDTH_KEY, 
                                        rambleyPainter.getRambleyOpenMouthWidth());
                                break;
                            case(RambleyPainter.RAMBLEY_OPEN_MOUTH_HEIGHT_PROPERTY_CHANGED):
                                config.putDouble(RAMBLEY_MOUTH_HEIGHT_KEY, 
                                        rambleyPainter.getRambleyOpenMouthHeight());
                        }
                    }
                } catch (IllegalStateException ex){ 
                    log(Level.WARNING, this.getClass(), "propertyChange", 
                            "Error encountered in processing change to painter", 
                            ex);
                }
            }
        }
    }
    
    private class RambleyIcon2 extends RambleyIcon{
        @Override
        public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
            g.translate(x, y);
            paint(g, c, getIconWidth(), getIconHeight());
        }
        @Override
        public int getIconWidth() {
            if (widthSpinner == null)
                return DEFAULT_RAMBLEY_WIDTH;
            return (int)widthSpinner.getValue();
        }
        @Override
        public int getIconHeight() {
            if (linkSizeToggle == null || heightSpinner == null)
                return DEFAULT_RAMBLEY_HEIGHT;
            if (linkSizeToggle.isSelected())
                return getIconWidth();
            return (int)heightSpinner.getValue();
        }
    }
    /**
     * This attempts to create the given directories, opening an Error 
     * JOptionPane if failed, and returns whether it was successful.
     * @param dir The directory to create.
     * @param existingMessage The message to display if the given directory 
     * exists as a file.
     * @param errorMessage The message to display if an error occurs.
     * @return Whether this was successful at creating the directories.
     */
    private boolean createDirectories(File dir, String existingMessage, 
            String errorMessage) {
        String message;     // The message to display
            // The exception that was thrown
        Exception ex = null;
        try {
            Files.createDirectories(dir.toPath());
            return true;
        }
        catch(FileAlreadyExistsException exc) {
            message = existingMessage+" already exists as a file.";
            ex = exc;
        }
        catch (IOException | SecurityException exc) {
            message = "An error occurred while creating the "+errorMessage;
            ex = exc;
        }
        log(Level.WARNING,this.getClass(),"createDirectories",message,ex);
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this,message,
                "ERROR - Error Creating Directory",
            JOptionPane.ERROR_MESSAGE);
        return false;
    }
    /**
     * This attempts to create the given directories, opening an Error 
     * JOptionPane if failed, and returns whether it was successful.
     * @param dir The directory to create.
     * @param multiple If there will be multiple directories created.
     * @return Whether this was successful at creating the directories.
     */
    private boolean createDirectories(File dir, boolean multiple) {
        if (multiple){  // If multiple directories will be created
            return createDirectories(dir,"One of the directories",
                    "directories.");
        } else{
            return createDirectories(dir,"The specified directory",
                    "the specified directory.");
        }
    }
    /**
     * This attempts to create the given directory.
     * @param dir The directory to create.
     * @return Whether the directory was successfully created.
     */
    private boolean createDirectories(File dir){
            // If the directory file does not exist
        if (!dir.exists() || !dir.isDirectory()) {
            if (!createDirectories(dir,true))   // If the directory was not created
                return false;
        }
        return true;
    }
    /**
     * This is used to save the image of Rambley to a file.
     */
    private class RambleySaver extends SwingWorker<Void,Void>{
        /**
         * The file to save the image to.
         */
        private final File file;
        /**
         * Whether the image was successfully saved
         */
        private boolean success = false;
        /**
         * This creates a RambleySaver that will save the image of Rambley to 
         * the given file.
         * @param file The file to save to (cannot be null).
         */
        RambleySaver(File file){
            this.file = Objects.requireNonNull(file);
        }
        @Override
        protected Void doInBackground() throws Exception {
            setInputEnabled(false);
                // If the file's parent was not created
            if (!createDirectories(file.getParentFile()))
                return null;
            int width = (int) widthSpinner.getValue();
            int height = (linkSizeToggle.isSelected()) ? width : (int) heightSpinner.getValue();
                // Create the image of Rambley
            BufferedImage image = createRambleyImage(width,height);
                // Save the image
            success = saveImage(image,file);
            return null;
        }
        @Override
        protected void done(){
            if (success){   // If the image was successfully saved to the file
                JOptionPane.showMessageDialog(Rambley4J.this, 
                        "The image was successfully saved.", 
                        "Image Saved Successfully", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(Rambley4J.this, 
                        "The image failed to save.", 
                        "Image Failed To Save", JOptionPane.ERROR_MESSAGE);
            }
            setInputEnabled(true);
        }
    }
    /**
     * 
     */
    private class UpdateCheckWorker extends SwingWorker<Boolean, Void>{
        /**
         * This gets whether there is an update available for the program.
         */
        private boolean updateAvailable = false;
        
        private boolean success = false;
        /**
         * Whether this is being called at the start of the program.
         */
        private boolean isAtStart;
        /**
         * 
         * @param isAtStart 
         */
        UpdateCheckWorker(boolean isAtStart){
            this.isAtStart = isAtStart;
        }
        @Override
        protected Boolean doInBackground() throws Exception {
            getLogger().entering(this.getClass().getName(), "doInBackground");
                // If this is at the start of the program
            if (isAtStart){
                log(Level.FINER, this.getClass(),"doInBackground", 
                        "Running at start of program");
                updateButton.setEnabled(false);
            } else
                setInputEnabled(false);
                // Whether this should retry to check for an update
            boolean retry = false;
            do{     // If this is not at the start of the program
                if (!isAtStart)
                        // Set the cursor to the one for waiting
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                try{    // Check for an update
                    updateChecker.check();
                    success = true;
                } catch (Exception ex){
                    log(Level.WARNING, this.getClass(),"doInBackground", 
                            "An error occurred while checking the latest version",
                            ex);
                        // If this is not at the start of the program
                    if (!isAtStart){
                            // Reset the cursor
                        setCursor(null);
                            // Ask the user if they would like to try checking for 
                            // updates again
                        retry = JOptionPane.showConfirmDialog(aboutDialog,
                                "Failed to check for updates.\nWould you like to try again?",
                                "Update Checker Failed",JOptionPane.YES_NO_OPTION,
                                JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION;
                    }
                }
            }   // While this has not checked for an update and the user wants 
                // to try again
            while (!success && retry);
                // Get whether there is an update available
            updateAvailable = updateChecker.isUpdateAvailable();
            getLogger().exiting(this.getClass().getName(), "doInBackground", 
                    updateAvailable);
            return updateAvailable;
        }
        @Override
        protected void done(){
                // If this was successful at checking for an update
            if (success){
                    // If there's an update available, then set the text for the 
                    // latest version label to be the latest version for the 
                    // program. Otherwise, just state the current version
                latestVersLabel.setText((updateAvailable) ? 
                        updateChecker.getLatestVersion() : 
                        updateChecker.getCurrentVersion());
            }
            System.gc();        // Run the garbage collector
            setInputEnabled(true);
                // Reset the cursor
            setCursor(null);
                // If this was successful at checking for an update
            if (success){
                    // If there is an update available for the program
                if (updateAvailable){
                        // Log the update
                    updateChecker.logUpdateMessage(getLogger());
                        // Set the update check dialog's location relative to 
                        // this if at startup and relative to the about dialog 
                        // if the check was initialized from there.
                    updateCheckDialog.setLocationRelativeTo(
                            (isAtStart)?Rambley4J.this:aboutDialog);
                    updateCheckDialog.setVisible(true);
                        // If this is not at the start of the program
                } else if (!isAtStart){
                    JOptionPane.showMessageDialog(aboutDialog, 
                            "This program is already up to date,",
                            updateCheckDialog.getTitle(), 
                            JOptionPane.INFORMATION_MESSAGE, 
                            updateIconLabel.getIcon());
                }
            }
        }
    }
}
