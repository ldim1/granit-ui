package com.ldim.granit.ui.model;

import com.ldim.granit.ui.util.Stringify;
import javafx.scene.Group;
import org.springframework.dao.DuplicateKeyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ldim on 19.04.2017.
 */
public class Root implements Render {
    private final Map<Integer, Controller> controllers = new HashMap<>();

    void addController(Controller controller) {
        if (controllers.containsKey(controller.getId())) {
            throw new DuplicateKeyException(String.format("Controller id %d already exists",controller.getId()));
        }
        controllers.put(controller.getId(), controller);
    }

    public Controller getController(int id) {
        return controllers.get(id);
    }

    public State getState(int controllerId, int code) {
        Controller controller = controllers.get(controllerId);
        if (controller != null) {
            return controller.getState(code);
        }
        return null;
    }

    public void render(Group group) {
        controllers.values().stream().map(Controller::getScheme)
                .filter(Objects::nonNull).forEach(r -> r.render(group));
    }

    @Override
    public void render() {
        controllers.values().forEach(Render::render);
    }

    @Override
    public void next() {
        controllers.values().forEach(Render::next);
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Root\"" +
                ", \"controllers\":" + new Stringify<Integer, Controller>().from(controllers) +
                '}';
    }
}
