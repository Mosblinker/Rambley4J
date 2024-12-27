/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raccoon;

import geom.Rhombus2D;
import java.awt.*;
import java.awt.geom.*;
import swing.ListenedPainter;

/**
 * This is a Painter that paints the background behind Rambley the Raccoon.
 * @author Mosblinker
 */
public class BackgroundPainter extends ListenedPainter<Component>{
    /**
     * This is the main color for the background.
     */
    public static final Color BACKGROUND_COLOR = new Color(0x2CDFFF);
    /**
     * This is the color for the polka dots in the background.
     */
    public static final Color BACKGROUND_DOT_COLOR = new Color(0x1A73C9);
    /**
     * This is the color for the background gradient. The background gradient 
     * fades from this color to transparency.
     */
    public static final Color BACKGROUND_GRADIENT_COLOR = new Color(0x0068FF);
    /**
     * This is the color which the background gradient fades into. This is a 
     * transparent color.
     */
    protected static final Color BACKGROUND_GRADIENT_COLOR_2 = 
            new Color(BACKGROUND_GRADIENT_COLOR.getRGB()&0x00FFFFFF,true);
    /**
     * This indicates that the background polka dots will be rhombuses.
     */
    public static final int RHOMBUS_POLKA_DOTS = 0;
    /**
     * This indicates that the background polka dots will be circles.
     */
    public static final int CIRCLE_POLKA_DOTS = 1;
    /**
     * This indicates that the background polka dots will be squares.
     */
    public static final int SQUARE_POLKA_DOTS = 2;
    /**
     * This is the first valid value for the background polka dots shape.
     */
    public static final int FIRST_POLKA_DOTS_VALUE = RHOMBUS_POLKA_DOTS;
    /**
     * This is the last valid value for the background polka dots shape.
     */
    public static final int LAST_POLKA_DOTS_VALUE = SQUARE_POLKA_DOTS;
    /**
     * This is the default width and height of the background polka dots.
     */
    protected static final double DEFAULT_BACKGROUND_DOT_SIZE = 8.0;
    /**
     * This is the default diagonal spacing between the centers of the 
     * background polka dots. Refer to the documentation for the {@link 
     * #getBackgroundDotSpacing getBackgroundDotSpacing} method for a more in
     * depth description on the background polka dot spacing.
     */
    protected static final double DEFAULT_BACKGROUND_DOT_SPACING = 12.0;
    /**
     * This is the default shape of the background polka dots. By default, they 
     * are rhombuses.
     */
    protected static final int DEFAULT_POLKA_DOT_SHAPE = 
            RHOMBUS_POLKA_DOTS;
    /**
     * This identifies that a change has been made to the width and height of 
     * the background polka dots.
     */
    public static final String POLKA_DOT_SIZE_PROPERTY_CHANGED = 
            "BackgroundDotSizePropertyChanged"; 
    /**
     * This identifies that a change has been made to the spacing of the 
     * background polka dots.
     */
    public static final String POLKA_DOT_SPACING_PROPERTY_CHANGED = 
            "BackgroundDotSpacingPropertyChanged"; 
    /**
     * This identifies that a change has been made to the shape of the 
     * background polka dots.
     */
    public static final String POLKA_DOT_SHAPE_PROPERTY_CHANGED = 
            "BackgroundDotShapePropertyChanged";
    /**
     * The width and height of the background polka dots.
     */
    private double dotSize;
    /**
     * This is the diagonal spacing between the centers of the background polka 
     * dots. That is to say, the center of each background polka dot is {@code 
     * dotSpacing} pixels to the left and {@code dotSpacing} pixels below the 
     * center of another background polka dot.
     */
    private double dotSpacing;
    /**
     * This is a value controlling the shape of the background polka dots.
     */
    private int dotShape;
//    /**
//     * This is the main background color for the background painter.
//     */
//    private Color color;
//    /**
//     * This is the color for the background polka dots.
//     */
//    private Color dotColor;
//    /**
//     * This is the color for the top half of the background gradient.
//     */
//    private Color gradientColor;
//    /**
//     * This is the bottom color for the background gradient. This is a 
//     * transparent version of {@code gradientColor}.
//     */
//    private Color gradientColor2;
    /**
     * A scratch Rectangle2D object used for rendering the background. This is 
     * initialized the first time it is used. This scratch object may change at 
     * any time during the rendering process, and should not be assumed to be in 
     * a known state before being used.
     */
    private Rectangle2D rect = null;
    /**
     * A scratch Ellipse2D object used for rendering the background. This is 
     * initialized the first time it is used. This scratch object may change at 
     * any time during the rendering process, and should not be assumed to be in 
     * a known state before being used.
     */
    private Ellipse2D ellipse = null;
    /**
     * This is a scratch Rhombus2D object used for rendering the background. 
     * This is initialized the first time it is used. This scratch object may 
     * change at any time during the rendering process, and should not be 
     * assumed to be in a known state before being used.
     */
    private Rhombus2D rhombus = null;
    
    public BackgroundPainter(){
        dotSize = DEFAULT_BACKGROUND_DOT_SIZE;
        dotSpacing = DEFAULT_BACKGROUND_DOT_SPACING;
        dotShape = DEFAULT_POLKA_DOT_SHAPE;
    }
    /**
     * This returns the width and height used for the background polka dots.
     * @return The size of the background polka dots.
     * @see #setPolkaDotSize 
     * @see #getPolkaDotSpacing 
     * @see #setPolkaDotSpacing 
     * @see #getPolkaDotShape 
     * @see #setPolkaDotShape 
     */
    public double getPolkaDotSize(){
        return dotSize;
    }
    /**
     * This sets the width and height used for the background polka dots. 
     * @param size The size for the background polka dots. 
     * @return This {@code BackgroundPainter}.
     * @see #getPolkaDotSize 
     * @see #getPolkaDotSpacing 
     * @see #setPolkaDotSpacing 
     * @see #getPolkaDotShape 
     * @see #setPolkaDotShape 
     */
    public BackgroundPainter setPolkaDotSize(double size){
            // If the new size is different from the old size
        if (size != dotSize){
                // Get the old size
            double old = dotSize;
            dotSize = size;
            firePropertyChange(POLKA_DOT_SIZE_PROPERTY_CHANGED,old,size);
        }
        return this;
    }
    /**
     * This returns the diagonal spacing between the centers of the background 
     * polka dots. That is to say, the center of each background polka dot is 
     * {@code getBackgroundDotSpacing()} pixels to the left and {@code 
     * getBackgroundDotSpacing()} pixels below the center of the previous 
     * background polka dot.
     * 
     * @todo Rework the documentation for this method.
     * 
     * @return The diagonal spacing between the background polka dots.
     * @see #getPolkaDotSize 
     * @see #setPolkaDotSize 
     * @see #setPolkaDotSpacing 
     * @see #getPolkaDotShape 
     * @see #setPolkaDotShape 
     */
    public double getPolkaDotSpacing(){
        return dotSpacing;
    }
    /**
     * This sets the diagonal spacing between the centers of the background 
     * polka dots. That is to say, the center of each background polka dot will  
     * be {@code getBackgroundDotSpacing()} pixels to the left and {@code 
     * getBackgroundDotSpacing()} pixels below the center of the previous 
     * background polka dot.
     * 
     * @todo Rework the documentation for this method.
     * 
     * @param spacing The diagonal spacing between the background polka dots.
     * @return This {@code BackgroundPainter}.
     * @see #getPolkaDotSize 
     * @see #setPolkaDotSize 
     * @see #getPolkaDotSpacing 
     * @see #getPolkaDotShape 
     * @see #setPolkaDotShape 
     */
    public BackgroundPainter setPolkaDotSpacing(double spacing){
            // If the new spacing is different from the old spacing
        if (spacing != dotSpacing){
                // Get the old dot spacing
            double old = dotSpacing;
            dotSpacing = spacing;
            firePropertyChange(POLKA_DOT_SPACING_PROPERTY_CHANGED,old,spacing);
        }
        return this;
    }
    /**
     * This returns the shape used for the background polka dots.
     * @return The shape of the background polka dots.
     * @see #getPolkaDotSize 
     * @see #setPolkaDotSize 
     * @see #getPolkaDotSpacing 
     * @see #setPolkaDotSpacing 
     * @see #setPolkaDotShape 
     * @see #RHOMBUS_POLKA_DOTS
     * @see #CIRCLE_POLKA_DOTS
     * @see #SQUARE_POLKA_DOTS
     */
    public int getPolkaDotShape(){
        return dotShape;
    }
    /**
     * This sets the shape used for the background polka dots.
     * @param shape The shape of the background polka dots.
     * @return This {@code BackgroundPainter}.
     * @throws IllegalArgumentException If the shape is not a valid shape.
     * @see #getPolkaDotSize 
     * @see #setPolkaDotSize 
     * @see #getPolkaDotSpacing 
     * @see #setPolkaDotSpacing 
     * @see #getPolkaDotShape 
     * @see #RHOMBUS_POLKA_DOTS
     * @see #CIRCLE_POLKA_DOTS
     * @see #SQUARE_POLKA_DOTS
     */
    public BackgroundPainter setPolkaDotShape(int shape){
            // If the shape value is out of the valid range for the shape
        if (shape < FIRST_POLKA_DOTS_VALUE || shape > LAST_POLKA_DOTS_VALUE)
            throw new IllegalArgumentException("Invalid polka dot shape value: " + shape);
            // If the new shape is different from the old shape
        if (shape != dotShape){
                // Get the old dot shape
            double old = dotShape;
            dotShape = shape;
            firePropertyChange(POLKA_DOT_SHAPE_PROPERTY_CHANGED,old,dotShape);
        }
        return this;
    }
    
    @Override
    public void paint(Graphics2D g, Component object, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
//    /**
//     * This is used to render the background polka dots. The background polka 
//     * dots will be drawn in a {@link BACKGROUND_DOT_COLOR dark blue} color. 
//     * Each polka dot will be {@link getBackgroundDot getBackgroundDot()} in 
//     * width and height, and will be spaced diagonally by {@link 
//     * #getBackgroundDotSpacing getBackgroundDotSpacing}. The polka dots will be 
//     * either circular or rhombus-shaped, depending on whether {@link 
//     * #getCircularBackgroundDots getCircularBackgroundDots} is set to {@code 
//     * true} or not. Each polka dot is generated using the {@link 
//     * #getBackgroundDot getBackgroundDot} method. The polka dots will be offset 
//     * horizontally by {@link #getBackgroundDotOffsetX getBackgroundDotOffsetX} 
//     * and vertically by {@link #getBackgroundDotOffsetY 
//     * getBackgroundDotOffsetY}. This renders to a copy of the given graphics 
//     * context, so as to protect the rest of the paint code from changes made to 
//     * the graphics context while rendering the background polka dots.
//     * @param g The graphics context to render to.
//     * @param x The x-coordinate of the top-left corner of the area to fill.
//     * @param y The y-coordinate of the top-left corner of the area to fill.
//     * @param w The width of the area to fill.
//     * @param h The height of the area to fill.
//     * @see #paint 
//     * @see #paintBackground 
//     * @see BACKGROUND_DOT_COLOR
//     * @see #getBackgroundDot 
//     * @see #getBackgroundDotOffsetX 
//     * @see #getBackgroundDotOffsetY 
//     * @see #getBackgroundDotSize 
//     * @see #getBackgroundDotSpacing 
//     * @see #getCircularBackgroundDots 
//     * @see #setCircularBackgroundDots 
//     * @see #isBackgroundPainted 
//     * @see #setBackgroundPainted 
//     */
//    protected void paintBackgroundDots(Graphics2D g, int x, int y, int w, int h){
//            // Create a copy of the given graphics context over the given area
//        g = (Graphics2D) g.create(x, y, w, h);
//            // Set the color to the background polka dot color
//        g.setColor(dotColor);
//            // If the background scratch Ellipse2D object has not been 
//        if (bgEllipse == null)   // initialized yet
//            bgEllipse = new Ellipse2D.Double();
//            // If the background scratch Rhombus2D object has not been 
//        if (bgRhombus == null)  // initialized yet
//            bgRhombus = new Rhombus2D.Double();
//            // Get the x offset for the background polka dots
//        double x1 = getBackgroundDotOffsetX(w);
//            // Get the y offset for the background polka dots
//        double y1 = getBackgroundDotOffsetY(h);
//            // Go through the multipliers for the y-coordinates for the centers 
//            // of the background polka dots (to create the polka dot pattern, 
//            // we need to know what row number we are on, so we can offset the 
//            // x-coordinates accordingly)
//        for (int i = 0; (i * getBackgroundDotSpacing()) <= h; i++){
//                // Get the y-coordinate for the centers of the polka dots on 
//                // this row
//            double yDot = (i * getBackgroundDotSpacing())+y1;
//                // Go through the x-coordinates for the centers of the 
//                // background polka dots (polka dots on odd rows are offset 
//                // compared to the polka dots on even rows)
//            for (double xDot = getBackgroundDotSpacing() * (i % 2); xDot <= w; 
//                    xDot+=getBackgroundDotSpacing()+getBackgroundDotSpacing()){
//                    // Fill the current background polka dot
//                g.fill(getBackgroundDot(xDot+x1,yDot));
//            }
//        }   // Dispose of the copy of the graphics context
//        g.dispose();
//    }
    /**
     * {@inheritDoc }
     */
    @Override
    protected String paramString(){
        return "dotShape="+getPolkaDotShape()+
                ",dotSize="+getPolkaDotSize()+
                ",dotSpacing="+getPolkaDotSpacing();
    }
    /**
     * This resets this BackgroundPainter, setting it's values to their 
     * defaults.
     * @return This {@code BackgroundPainter}.
     */
    public BackgroundPainter reset(){
        return setPolkaDotSize(DEFAULT_BACKGROUND_DOT_SIZE)
                .setPolkaDotSpacing(DEFAULT_BACKGROUND_DOT_SPACING)
                .setPolkaDotShape(DEFAULT_POLKA_DOT_SHAPE);
    }
}
