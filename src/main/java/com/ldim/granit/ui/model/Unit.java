package com.ldim.granit.ui.model;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ldim on 18.04.2017.
 */
public abstract class Unit<T> implements Render {
    private static Logger log = LoggerFactory.getLogger(Unit.class);
    private Integer code;
    private State<T> state;
    Node node;
    List<Unit> lays = new LinkedList<>();

    public void init(Map<Integer, State> states) {
        lays.forEach(e -> e.init(states));
        initState(states);
    }

    private void initState(Map<Integer, State> states) {
        if (code != null) {
            State<T> state = states.get(code);
            if (state == null) {
                state = new State<>(code);
                states.put(code, state);
            }
            state.addSlave(this);
            this.state = state;
        }
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public State<T> getState() {
        return state;
    }

    public void setGeom(double[] geom) {
        node = createShape(geom);
        initNodeEvents();
    }

    private void initNodeEvents() {
        if (node != null) {
            node.setOnMousePressed(this::mousePressed);
            node.setOnMouseReleased(this::mouseReleased);
        }
    }

    public void setLays(List<Unit> lays) {
        this.lays = lays;
    }

    public void render(Group group) {
        if (node != null) {
            group.getChildren().add(node);
        }
        render();
        lays.forEach(e -> e.render(group));
    }

    protected void mousePressed(MouseEvent e) {
        log.debug(e.toString());
    }

    protected void mouseReleased(MouseEvent e) {
        log.debug(e.toString());
    }

    protected abstract Node createShape(double[] geom);
}
