/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raccoon;

import icons.Icon2D;
import java.awt.*;

/**
 *
 * @author Mosblinker
 */
public class RambleyIcon extends RambleyPainter implements Icon2D {
    
    private int width;
    
    private int height;
    
    public RambleyIcon(int width, int height){
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
    }
    
    public RambleyIcon(int size){
        this(size,size);
    }
    
    public RambleyIcon(){
        this(512);
    }
    
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
        g.translate(x, y);
        paint(g, c, getIconWidth(), getIconHeight());
    }
    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
    /**
     * This returns a String representation of this {@code RambleyIcon}. 
     * This method is primarily intended to be used only for debugging purposes, 
     * and the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this {@code RambleyIcon}.
     */
    @Override
    protected String paramString(){
        return getIconWidth() + "x" + getIconHeight()+
                ","+super.paramString();
    }
}
