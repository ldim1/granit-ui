package scheme.templates

import com.ldim.granit.ui.model.shape.Box
import com.ldim.granit.ui.model.shape.Bus
import com.ldim.granit.ui.model.shape.Lab
import com.ldim.granit.ui.model.shape.Led
import javafx.scene.paint.Color

devX = 40
devY = 100

beans {

    "${beanName}led1"(Led) {
        bean -> bean.scope = 'prototype'
            code = led1Code
            color = [Color.GREEN, Color.RED]
            geom = [9, devX + 14 + offsetX, devY + 16]
    }

    "${beanName}lbl1"(Lab) {
        bean -> bean.scope = 'prototype'
            code = devCode
            text = 'МТЗ'
            size = 9
            color = [Color.BLACK, Color.BLACK]
            geom = [devX + 5 + offsetX, devY + 35]
    }

    if (reserved) {
        "${beanName}led2"(Led) {
            bean ->
                bean.scope = 'prototype'
                code = led2Code
                color = [Color.GREEN, Color.RED]
                geom = [9, devX + 38 + offsetX, devY + 16]
        }

        "${beanName}lbl2"(Lab) {
            bean ->
                bean.scope = 'prototype'
                code = devCode
                text = 'АВР'
                size = 9
                color = [Color.BLACK, Color.BLACK]
                geom = [devX + 30 + offsetX, devY + 35]
        }
    }

    "${beanName}btn"(Box) {
        bean -> bean.scope = 'prototype'
            code = swCode
            color = [Color.GREEN, Color.RED]
            press = true
            geom = [devX + 66 + offsetX, devY + 8, 23, 23]
    }

    "${beanName}box"(Box) {
        bean -> bean.scope = 'prototype'
            code = devCode
            color = [Color.GRAY, Color.PINK]
            geom = [devX + offsetX, devY, 95, 40]
            lays = reserved ? [ref("${beanName}btn"),
                    ref("${beanName}led1"), ref("${beanName}lbl1"),
                    ref("${beanName}led2"), ref("${beanName}lbl2")]
                    : [ref("${beanName}btn"),
                       ref("${beanName}led1"), ref("${beanName}lbl1")]

    }

    "${beanName}"(Bus) {
        bean -> bean.scope = 'prototype'
            color = [Color.BLUE]
            width = 4
            geom = [devX + 77 + offsetX, devY - 30, devX + 77 + offsetX, devY + 70]
            lays = [ref("${beanName}box")]
    }
}