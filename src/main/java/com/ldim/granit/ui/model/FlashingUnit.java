package com.ldim.granit.ui.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ldim on 26.04.2017.
 */
public abstract class FlashingUnit<T> extends Unit<T> {
    private static Logger log = LoggerFactory.getLogger(FlashingUnit.class);

    @Override
    public void next() {
        log.debug("{} next()", this);
        if (getState() != null && node != null) {
            node.setVisible(!getState().isChanged() || !node.isVisible());
        }
    }
}
