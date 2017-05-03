package com.ldim.granit.ui.model.shape;

import com.ldim.granit.ui.model.FlashingUnit;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

/**
 * Created by ldim on 22.04.2017.
 */
public class Box extends FlashingUnit<Integer> {
    private Color[] color;
    private boolean press;
    private Rectangle r;
    private Polyline p;
    private boolean pressed;

    public void setColor(Color[] color) {
        this.color = color;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

    @Override
    protected Node createShape(double[] g) {
        r = new Rectangle(g[0], g[1], g[2], g[3]);
        r.setStrokeWidth(1.5);
        p = new Polyline(g[0], g[1] + g[3], g[0], g[1], g[0] + g[2] - 1.5, g[1]);
        p.setStrokeWidth(1.5);
        return new Group(r, p);
    }

    @Override
    public void render() {
        Color c = color[0];
        if (getState() != null) {
            getState().initValue(0);
            c = color[getState().getValue()];
        }
        Color dark = c.darker();
        Color light = c.brighter();
        if (pressed) {
            dark = c.brighter();
            light = c.darker();
        }
        r.setStroke(dark);
        r.setFill(c);
        p.setStroke(light);
    }

    @Override
    protected void mousePressed(MouseEvent e) {
        if (press) {
            pressed = true;
            render();
        }
    }

    @Override
    protected void mouseReleased(MouseEvent e) {
        if (press) {
            pressed = false;
            render();
        }
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Box\"" +
                ", \"code\":" + getCode() +
                ", \"hash\":" + hashCode() +
                '}';
    }
}
