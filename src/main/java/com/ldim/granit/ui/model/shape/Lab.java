package com.ldim.granit.ui.model.shape;

import com.ldim.granit.ui.model.FlashingUnit;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by ldim on 19.04.2017.
 */
public class Lab extends FlashingUnit<Integer> {
    private Color[] color = {Color.BLACK};
    private String text;
    private Double size = 9.0;
    private Text shape;

    @Override
    protected Node createShape(double[] geom) {
        //Can't set text without graphic context
        shape = new Text(geom[0], geom[1], "");
        if (size != null) {
            shape.setFont(Font.font(size));
        }
        return shape;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setColor(Color[] color) {
        this.color = color;
    }

    @Override
    public void render(Group group) {
        shape.setText(text);
        super.render(group);
    }

    @Override
    public void render() {
        final Color[] c = new Color[]{color[0]};
        if (getState() != null) {
            getState().initValue(0);
            c[0] = color[getState().getValue()];
        }
        shape.setFill(c[0]);
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Lab\"" +
                ", \"code\":" + getCode() +
                ", \"text\":\"" + text + '\"' +
                ", \"hash\":" + hashCode() +
                '}';
    }
}
