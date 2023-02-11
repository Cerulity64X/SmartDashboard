package edu.wpi.first.smartdashboard.gui.elements;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.BooleanProperty;
import edu.wpi.first.smartdashboard.properties.ColorProperty;
import edu.wpi.first.smartdashboard.properties.NumberProperty;
import edu.wpi.first.smartdashboard.properties.Property;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Rect extends StaticWidget {
    public final ColorProperty clr = new ColorProperty(this, "Color", Color.BLACK);
    public final NumberProperty thickness = new NumberProperty(this, "Thickness", 1);
    public final BooleanProperty fill = new BooleanProperty(this, "Fill", false);

    public Rect() {
        setObstruction(false);
    }

    @Override
    public void propertyChanged(Property property) {
        revalidate();
        repaint();
    }

    @Override
    public void init() {
        update(clr, Color.BLACK);
        setPreferredSize(new Dimension(100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(clr.getValue());
        float thick = thickness.getValue().floatValue();
        g2d.setStroke(new BasicStroke(thick));
        if (fill.getValue()) {
            g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        } else {  
            g2d.drawRect((int)(thick / 2), (int)(thick / 2), getWidth() - (int)thick, getHeight() - (int)thick);
        }
    }
    
}
