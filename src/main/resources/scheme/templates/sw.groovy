package scheme.templates

import com.ldim.granit.ui.model.shape.Box
import com.ldim.granit.ui.model.shape.Bus
import com.ldim.granit.ui.model.shape.Lab
import javafx.scene.paint.Color

devX = 40
devY = 300

beans {

    "${beanName}lbl"(Lab) {
        bean -> bean.scope = 'prototype'
            code = devCode
            text = devName
            size = 9
            color = [Color.BLACK, Color.BLACK]
            geom = [devX + 25 + offsetX, devY + 100]
    }

    "${beanName}btn1"(Box) {
        bean -> bean.scope = 'prototype'
            code = sw1Code
            color = [Color.GREEN, Color.RED]
            press = true
            geom = [devX + 11 + offsetX, devY + 8, 18, 18]
    }

    "${beanName}btn2"(Box) {
        bean -> bean.scope = 'prototype'
            code = sw0Code
            color = [Color.GREEN, Color.RED]
            press = true
            geom = [devX + 11 + offsetX, devY + 72, 18, 18]
    }

    if (!reserve) {
        "${beanName}bus1"(Bus) {
            bean ->
                bean.scope = 'prototype'
                code = bus1Code
                color = [Color.GREEN, Color.RED]
                width = 4
                geom = [devX + 20 + offsetX, devY + 79, devX + 20 + offsetX, devY + 124]
        }
    }

    "${beanName}bus"(Bus) {
        bean -> bean.scope = 'prototype'
            color = [Color.BLUE]
            width = 4
            geom = [devX + 20 + offsetX, devY - 20, devX + 20 + offsetX, devY + 79]
            lays = reserve ? [ref("${beanName}btn1")]
                    : [ref("${beanName}btn1"), ref("${beanName}bus1")]
    }

    "${beanName}bus0"(Bus) {
        bean -> bean.scope = 'prototype'
            code = bus0Code
            color = [Color.GREEN, Color.RED]
            width = 4
            geom = [devX + 20 + offsetX, devY + 79, devX + 45 + offsetX, devY + 79, devX + 45 + offsetX, devY + 50]
            lays = [ref("${beanName}bus"), ref("${beanName}btn2")]
    }

    "${beanName}"(Box) {
        bean -> bean.scope = 'prototype'
            code = devCode
            color = [Color.GRAY, Color.PINK]
            geom = [devX + offsetX, devY, 64, 104]
            lays = [ref("${beanName}bus0"), ref("${beanName}lbl")]
    }
}