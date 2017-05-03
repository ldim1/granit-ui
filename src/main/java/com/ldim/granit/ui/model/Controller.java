package com.ldim.granit.ui.model;

import com.ldim.granit.ui.util.Stringify;
import javafx.scene.Node;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ldim on 18.04.2017.
 */
public class Controller extends Unit {
    private int id;
    private final Root root;
    private final Map<Integer, State> states = new HashMap<>();

    private Unit scheme;

    @Autowired
    public Controller(Root root) {
        this.root = root;
    }

    @PostConstruct
    void init() {
        super.init(states);
        if (scheme != null) {
            scheme.init(states);
        }
        root.addController(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState(int code) {
        return states.get(code);
    }

    public int getId() {
        return id;
    }

    public void setScheme(Unit scheme) {
        this.scheme = scheme;
    }

    public Unit getScheme() {
        return scheme;
    }

    @Override
    protected Node createShape(double[] geom) {
        return null;
    }

    @Override
    public void render() {
        states.values().forEach(Render::render);
    }

    @Override
    public void next() {
        states.values().forEach(Render::next);
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Controller\"" +
                ", \"id\":" + id +
                ", \"states\":" + new Stringify<Integer, State>().from(states) +
                ", \"scheme\":" + scheme +
                '}';
    }
}