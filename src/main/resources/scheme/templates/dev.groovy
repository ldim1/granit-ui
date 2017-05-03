package scheme.templates

import com.ldim.granit.ui.model.shape.Box
import com.ldim.granit.ui.model.shape.Bus
import com.ldim.granit.ui.model.shape.Lab
import javafx.scene.paint.Color

devX = 40
devY = 200

beans {

    "${beanName}lbl"(Lab) {
        bean -> bean.scope = 'prototype'
            code = devCode
            text = devName
            size = 9
            color = [Color.BLACK, Color.BLACK]
            geom = [devX + 11 + offsetX, devY + 36]
    }

    "${beanName}btn"(Box) {
        bean -> bean.scope = 'prototype'
            code = swCode
            color = [Color.GREEN, Color.RED]
            press = true
            geom = [devX + 11 + offsetX, devY + 8, 18, 18]
    }

    "${beanName}box"(Box) {
        bean -> bean.scope = 'prototype'
            code = devCode
            color = [Color.GRAY, Color.PINK]
            geom = [devX + offsetX, devY, 50, 50]
            lays = [ref("${beanName}btn"), ref("${beanName}lbl")]
    }

    "${beanName}"(Bus) {
        bean -> bean.scope = 'prototype'
            color = [Color.BLUE]
            width = 4
            geom = [devX + 20 + offsetX, devY - 20, devX + 20 + offsetX, devY + 70]
            lays = [ref("${beanName}box")]
    }
}