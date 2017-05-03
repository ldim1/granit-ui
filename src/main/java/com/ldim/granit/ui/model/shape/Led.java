package com.ldim.granit.ui.model.shape;

import com.ldim.granit.ui.model.FlashingUnit;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by ldim on 22.04.2017.
 */
public class Led extends FlashingUnit<Integer> {
    private Color[] color = {Color.BLACK};
    private Group group;

    @Override
    protected Node createShape(double[] geom) {
        group = new Group();
        for (int i = 1; i < geom.length; i+=2) {
            group.getChildren().add(new Circle(geom[i], geom[i+1], geom[0]));
        }
        return group;
    }

    public void setColor(Color[] color) {
        this.color = color;
    }

    @Override
    public void render() {
        final Color[] c = new Color[]{color[0]};
        if (getState() != null) {
            getState().initValue(0);
            c[0] = color[getState().getValue()];
        }
        group.getChildren().forEach(e -> ((Circle)e).setFill(c[0]));
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Led\"" +
                ", \"code\":" + getCode() +
                ", \"hash\":" + hashCode() +
                '}';
    }
}
