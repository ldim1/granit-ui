package com.ldim.granit.ui.service;

import com.ldim.granit.ui.model.State;
import com.ldim.granit.ui.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ldim on 22.04.2017.
 */
@Component
public class Simulator {
    @Autowired
    private Root root;

    @Scheduled(fixedDelay = 1000)
    public void changeState() {
        State<Integer> state = root.getState(3, 1);
        state.setValue(state.getValue().equals(0) ? 1 : 0);
    }
}
