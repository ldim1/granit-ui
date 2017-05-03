package com.ldim.granit.ui.model;

import javafx.application.Platform;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ldim on 18.04.2017.
 */
public class State<T> implements Render {
    private final int id;
    private T value;
    private boolean changed;
    private List<Render> slaves = new LinkedList<>();

    public synchronized void initValue(T value) {
        if (this.value == null) {
            this.value = value;
        }
    }

    public State(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized T getValue() {
        return value;
    }

    public synchronized void setValue(T value) {
        if (!value.equals(this.value)) {
            this.value = value;
            changed = true;
            render();
        }
    }

    public synchronized boolean isChanged() {
        return changed;
    }

    public synchronized void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void addSlave(Render unit) {
        slaves.add(unit);
    }

    @Override
    public void render() {
        Platform.runLater(() -> slaves.forEach(Render::render));
    }

    @Override
    public void next() {
        Platform.runLater(() -> slaves.forEach(Render::next));
    }

    @Override
    public String toString() {
        return "{\"_class\":\"State\"" +
                ", \"id\":" + id +
                ", \"value\":" + value +
                ", \"changed\":" + changed +
                ", \"slaves\":" + slaves +
                '}';
    }
}
