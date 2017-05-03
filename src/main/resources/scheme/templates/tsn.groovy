package scheme.templates

import com.ldim.granit.ui.model.shape.Box
import com.ldim.granit.ui.model.shape.Lab
import com.ldim.granit.ui.model.shape.Led
import javafx.scene.paint.Color

beans {

    "${beanName}led"(Led) {
        bean -> bean.scope = 'prototype'
            code = ledCode
            color = [Color.GREEN, Color.RED]
            geom = [7, devX + 9, devY + 10]
    }

    "${beanName}lbl"(Lab) {
        bean -> bean.scope = 'prototype'
            code = devCode
            text = devName
            size = 9
            color = [Color.BLACK, Color.BLACK]
            geom = [devX + 20, devY + 13]
    }

    "${beanName}"(Box) {
        bean -> bean.scope = 'prototype'
            code = devCode
            color = [Color.GRAY, Color.PINK]
            geom = [devX, devY, 50, 20]
            lays = [ref("${beanName}led"), ref("${beanName}lbl")]
    }
}