/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raccoon;

import geom.Rhombus2D;
import java.awt.*;
import java.awt.geom.*;
import java.util.Objects;
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
     * This is the width and height at which the background dots are drawn at 
     * internally.
     */
    private static final double INTERNAL_BG_DOT_RENDER_SIZE = 256;
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
    public void paint(Graphics2D g, Component c, int width, int height) {
            // Check if the graphics context is null
        Objects.requireNonNull(g);
            // If either the width or height are less than or equal to zero 
            // (nothing would be rendered anyway)
        if (width <= 0 || height <= 0)
            return;
            // Create a copy of the given graphics context over the given area
        g = (Graphics2D) g.create(0, 0, width, height);
            // Configure the graphics context
        g = configureGraphics(g,c);
            // Paint the pixel grid
        paintBackground(g,0,0,width,height);
            // Dispose of the copy of the graphics context
        g.dispose();
    }
    /**
     * This is used to configure the graphics context used to render the background. 
     * It's assumed that the returned graphics context is the same as the given 
     * graphics context, or at least that the returned graphics context 
     * references the given graphics context in some way. 
     * @param g The graphics context to render to.
     * @param c A {@code Component} to get useful properties for painting.
     * @return The given graphics context, now configured for rendering the background.
     * @see #paint 
     * @see #paintBackground 
     * @see #paintPolkaDots 
     */
    protected Graphics2D configureGraphics(Graphics2D g, Component c){
            // Enable antialiasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
            // Prioritize rendering quality over speed
        g.setRenderingHint(RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
            // Prioritize quality over speed for alpha interpolation
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            // Enable dithering
        g.setRenderingHint(RenderingHints.KEY_DITHERING, 
                RenderingHints.VALUE_DITHER_ENABLE);
            // Prioritize color rendering quality over speed
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, 
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        return g;
    }
    /**
     * This returns the gradient to use to paint the background gradient. The 
     * gradient goes from {@link BACKGROUND_GRADIENT_COLOR} at the top to {@link 
     * BACKGROUND_GRADIENT_COLOR_2} at the bottom throughout the area to fill.
     * @param x The x-coordinate of the top-left corner of the area to fill.
     * @param y The y-coordinate of the top-left corner of the area to fill.
     * @param w The width of the area to fill.
     * @param h The height of the area to fill.
     * @return The gradient to use to paint the background gradient.
     * @see BACKGROUND_GRADIENT_COLOR
     * @see BACKGROUND_GRADIENT_COLOR_2
     * @see #paintBackground 
     */
    protected Paint getBackgroundGradient(double x,double y,double w,double h){
            // Get the center x-coordinate
        float x1 = (float)((w / 2.0)+x);
            // Create a vertical gradient that fades from the background 
            // gradient color to transparency over the area to fill
        return new GradientPaint(x1,(float)y,BACKGROUND_GRADIENT_COLOR,
                x1,(float)(y+h-1),BACKGROUND_GRADIENT_COLOR_2);
    }
    /**
     * This is used to calculate the offset for the background polka dots using 
     * the given size value.
     * @param size The value to use to get the offset.
     * @return The offset for the background polka dots.
     * @see #getPolkaDotOffsetX
     * @see #getPolkaDotOffsetY
     * @see #getPolkaDotSpacing
     */
    private double getPolkaDotOffset(double size){
        return (size%getPolkaDotSpacing())/2.0;
    }
    /**
     * This returns the x offset to use for the background polka dots. 
     * 
     * @implSpec The default implementation is equivalent to {@code (width % }
     * {@link getPolkaDotSpacing() getPolkaDotSpacing()}{@code )/2.0}.
     * 
     * @param width The width of the area to fill with the background.
     * @return The offset for the x-coordinate of the background polka dots.
     * @see #getPolkaDotOffsetY 
     * @see #getPolkaDot 
     * @see #paintPolkaDots
     * @see getPolkaDotSpacing
     * @see setPolkaDotSpacing
     */
    protected double getPolkaDotOffsetX(double width){
        return getPolkaDotOffset(width);
    }
    /**
     * This returns the y offset to use for the background polka dots. 
     * 
     * @implSpec The default implementation is equivalent to {@code (height % }
     * {@link getPolkaDotSpacing() getPolkaDotSpacing()}{@code )/2.0}.
     * 
     * @param height The height of the area to fill with the background.
     * @return The offset for the y-coordinate of the background polka dots.
     * @see #getPolkaDotOffsetX 
     * @see #getPolkaDot 
     * @see #paintPolkaDots
     * @see getPolkaDotSpacing
     * @see setPolkaDotSpacing
     */
    protected double getPolkaDotOffsetY(double height){
        return getPolkaDotOffset(height);
    }
    /**
     * This creates and returns the shape to use to draw a background polka dot 
     * centered at the given x and y coordinates. The background polka dot will 
     * be the width and height set for the {@link #getPolkaDotSize() 
     * background polka dot size}. If the background polka dots are {@link 
     * #getCircularBackgroundDots circular}, then the shape returned will be a 
     * circle. Otherwise, the shape returned will be a rhombus.
     * @param x The x-coordinate for the center of the background polka dot.
     * @param y The y-coordinate for the center of the background polka dot.
     * @return The shape object to use to draw a background polka dot.
     * @see #getCircularBackgroundDots
     * @see #setCircularBackgroundDots 
     * @see #getBackgroundDotSize 
     * @see #setBackgroundDotSize 
     * @see #paintPolkaDots 
     */
    protected Shape getPolkaDot(double x, double y){
            // This gets the shape that will be used to render the background 
            // dots
        RectangularShape shape;
            // Determine which shape to use for the polka dot
        switch(getPolkaDotShape()){
            case(CIRCLE_POLKA_DOTS):
                    // If the scratch Ellipse2D object has not been initialized 
                if (ellipse == null)    // yet
                    ellipse = new Ellipse2D.Double();
                shape = ellipse;
                break;
            case(SQUARE_POLKA_DOTS):
                    // If the scratch Rectangle2D object has not been 
                if (rect == null)   // initialized yet
                    rect = new Rectangle2D.Double();
                shape = rect;
                break;
            default:
                    // If the scratch Rhombus2D object has not been initialized 
                if (rhombus == null)    // yet
                    rhombus = new Rhombus2D.Double();
                shape = rhombus;
        }
            // Get half of the set size for a background polka dot
        double halfSize = getPolkaDotSize() / 2.0;
            // Set the frame of the shape from the center to be the size of a 
            // background polka dot.
        shape.setFrameFromCenter(x, y, x-halfSize, y-halfSize);
        return shape;
    }
    /**
     * This is used to render the background. The area is first filled with a 
     * solid {@link BACKGROUND_COLOR light blue} color. After that, the 
     * background polka dots are drawn using the {@link paintBackgroundDots#paintPolkaDots 
     * paintBackgroundDots} method. Finally, the {@link #getBackgroundGradient 
     * background gradient} is drawn over everything in the area. This renders 
     * to a copy of the given graphics context, so as to protect the rest of the 
     * paint code from changes made to the graphics context while rendering the 
     * background.
     * @param g The graphics context to render to.
     * @param x The x-coordinate of the top-left corner of the area to fill.
     * @param y The y-coordinate of the top-left corner of the area to fill.
     * @param w The width of the area to fill.
     * @param h The height of the area to fill.
     * @see #paint 
     * @see #paintPolkaDots 
     * @see BACKGROUND_COLOR
     * @see #BACKGROUND_DOT_COLOR
     * @see #BACKGROUND_GRADIENT_COLOR
     * @see #getBackgroundGradient 
     */
    protected void paintBackground(Graphics2D g, int x, int y, int w, int h){
            // Start by rendering a solid color background
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(x, y, w, h);
            // Paint the background dots
        paintPolkaDots(g,x,y,w,h);
            // Render the background gradient
        g.setPaint(getBackgroundGradient(x,y,w,h));
        g.fillRect(x, y, w, h);
    }
    /**
     * This is used to render the background polka dots. The background polka 
     * dots will be drawn in a {@link BACKGROUND_DOT_COLOR dark blue} color. 
     * Each polka dot will be {@link getBackgroundDot#getPolkaDot getBackgroundDot()} in 
     * width and height, and will be spaced diagonally by {@link 
     * #getBackgroundDotSpacing getBackgroundDotSpacing}. The polka dots will be 
     * either circular or rhombus-shaped, depending on whether {@link 
     * #getCircularBackgroundDots getCircularBackgroundDots} is set to {@code 
     * true} or not. Each polka dot is generated using the {@link 
     * #getPolkaDot getBackgroundDot} method. The polka dots will be offset 
     * horizontally by {@link #getPolkaDotOffsetX getBackgroundDotOffsetX} 
     * and vertically by {@link #getPolkaDotOffsetY 
     * getBackgroundDotOffsetY}. This renders to a copy of the given graphics 
     * context, so as to protect the rest of the paint code from changes made to 
     * the graphics context while rendering the background polka dots.
     * @param g The graphics context to render to.
     * @param x The x-coordinate of the top-left corner of the area to fill.
     * @param y The y-coordinate of the top-left corner of the area to fill.
     * @param w The width of the area to fill.
     * @param h The height of the area to fill.
     * @see #paint 
     * @see #paintBackground 
     * @see BACKGROUND_DOT_COLOR
     * @see #getPolkaDot 
     * @see #getPolkaDotOffsetX 
     * @see #getPolkaDotOffsetY 
     * @see #getBackgroundDotSize 
     * @see #getBackgroundDotSpacing 
     * @see #getCircularBackgroundDots 
     * @see #setCircularBackgroundDots 
     * @see #isBackgroundPainted 
     * @see #setBackgroundPainted 
     */
    protected void paintPolkaDots(Graphics2D g, int x, int y, int w, int h){
            // Create a copy of the given graphics context over the given area
        g = (Graphics2D) g.create(x, y, w, h);
        // Lazy way to implement the scaling of the background dots, but it works
            // Get the scale for the background dots
        double scale = Math.min(w, h) / INTERNAL_BG_DOT_RENDER_SIZE;
            // Scale the background dots
        g.scale(scale, scale);
            // Scale the width
        w /= scale;
            // Scale the height
        h /= scale;
            // Set the color to the background polka dot color
        g.setColor(BACKGROUND_DOT_COLOR);
            // Get the x offset for the background polka dots
        double x1 = getPolkaDotOffsetX(w);
            // Get the y offset for the background polka dots
        double y1 = getPolkaDotOffsetY(h);
            // Go through the multipliers for the y-coordinates for the centers 
            // of the background polka dots (to create the polka dot pattern, 
            // we need to know what row number we are on, so we can offset the 
            // x-coordinates accordingly)
        for (int i = 0; (i * getPolkaDotSpacing()) <= h; i++){
                // Get the y-coordinate for the centers of the polka dots on 
                // this row
            double yDot = (i * getPolkaDotSpacing())+y1;
                // Go through the x-coordinates for the centers of the 
                // background polka dots (polka dots on odd rows are offset 
                // compared to the polka dots on even rows)
            for (double xDot = getPolkaDotSpacing() * (i % 2); xDot <= w; 
                    xDot+=getPolkaDotSpacing()+getPolkaDotSpacing()){
                    // Fill the current background polka dot
                g.fill(getPolkaDot(xDot+x1,yDot));
            }
        }   // Dispose of the copy of the graphics context
        g.dispose();
    }
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
