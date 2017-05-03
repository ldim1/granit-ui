package com.ldim.granit.ui.model.shape;

import com.ldim.granit.ui.model.FlashingUnit;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Created by ldim on 22.04.2017.
 */
public class Btn extends FlashingUnit<Integer> {
    private Color[] color;
    private Rectangle r;
    private Line p;
    private Arc l;
    private Arc a;
    private boolean pressed;

    public void setColor(Color[] color) {
        this.color = color;
    }

    @Override
    protected Node createShape(double[] g) {
        r = new Rectangle(g[0], g[1], g[2], g[3]);
        r.setStrokeWidth(1.5);
        r.setArcHeight(g[3]);
        r.setArcWidth(g[3]);
        p = new Line(g[0] + g[3] * 0.5, g[1], g[0] + g[2] - g[3] * 0.5, g[1]);
        p.setStrokeWidth(1.5);
        l = new Arc(g[0] + g[3] * 0.5, g[1] + g[3] * 0.5, g[3] * 0.5, g[3] * 0.5, 90, 125);
        l.setStrokeWidth(1.5);
        l.setFill(Color.TRANSPARENT);
        a = new Arc(g[0] + g[2] - g[3] * 0.5, g[1] + g[3] * 0.5, g[3] * 0.5, g[3] * 0.5, 60, 30);
        a.setStrokeWidth(1.5);
        a.setFill(Color.TRANSPARENT);
        return new Group(r, p, l, a);
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
        l.setStroke(light);
        a.setStroke(light);
    }

    @Override
    protected void mousePressed(MouseEvent e) {
        pressed = true;
        render();
    }

    @Override
    protected void mouseReleased(MouseEvent e) {
        pressed = false;
        render();
    }
}
