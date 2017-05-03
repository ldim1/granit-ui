package com.ldim.granit.ui.model.shape;

import com.ldim.granit.ui.model.FlashingUnit;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

/**
 * Created by ldim on 22.04.2017.
 */
public class Bus extends FlashingUnit<Integer> {
    private Color[] color;
    private double width;
    private Polyline shape;

    public void setColor(Color[] color) {
        this.color = color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected Node createShape(double[] geom) {
        (shape = new Polyline(geom)).setStrokeWidth(width);
        return shape;
    }

    @Override
    public void render() {
        Color c = color[0];
        if (getState() != null) {
            getState().initValue(0);
            c = color[getState().getValue()];
        }
        shape.setStroke(c);
    }
    @Override
    public String toString() {
        return "{\"_class\":\"Bus\"" +
                ", \"code\":" + getCode() +
                ", \"hash\":" + hashCode() +
                '}';
    }
}
