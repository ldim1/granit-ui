package scheme

import com.ldim.granit.ui.model.shape.Btn
import com.ldim.granit.ui.model.shape.Lab
import javafx.scene.paint.Color

/**
 * Created by agent on 28.04.2017.
 */

btnX = 560
btnY = 30

lblX = 450
lblY = 43

beans {

    lbl0(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 89
            text = 'СН'
            size = 12
            color = [Color.BLACK, Color.RED]
            geom = [lblX , lblY]
    }

    lbl1(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 93
            text = 'ТН'
            size = 12
            color = [Color.BLACK, Color.RED]
            geom = [lblX , lblY + 14]
    }

    lbl2(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 95
            text = 'ПОЖАР'
            size = 12
            color = [Color.BLACK, Color.RED]
            geom = [lblX , lblY + 28]
    }

    lbl3(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 98
            text = 'ЗЕМ. ЗАЩИТА'
            size = 12
            color = [Color.BLACK, Color.RED]
            geom = [lblX , lblY + 42]
    }

    lbl4(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 111
            text = 'ВОДА'
            size = 12
            color = [Color.BLACK, Color.RED]
            geom = [lblX , lblY + 56]
    }

    reqLbl0(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 129
            text = 'Группа0'
            size = 9
            color = [Color.BLACK, Color.RED]
            geom = [btnX + 14, btnY + 11]
    }

    reqLbl1(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 130
            text = 'Группа1'
            size = 9
            color = [Color.BLACK, Color.RED]
            geom = [btnX + 14, btnY + 24]
    }

    reqBtn(Btn) {
        bean ->
            bean.scope = 'prototype'
            color = [Color.GRAY]
            geom = [btnX, btnY, 60, 30]
            lays = [reqLbl0, reqLbl1]
    }

    btnY += 35

    tstLbl(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 109
            text = 'ТЕСТКП'
            size = 9
            color = [Color.BLACK, Color.RED]
            geom = [btnX + 14, btnY + 13]
    }

    tstBtn(Btn) {
        bean ->
            bean.scope = 'prototype'
            color = [Color.GRAY]
            geom = [btnX, btnY, 60, 20]
            lays = [tstLbl]
    }

    btnY += 25

    secLbl(Lab) {
        bean ->
            bean.scope = 'prototype'
            code = 97
            text = 'ОХРАНА'
            size = 9
            color = [Color.BLACK, Color.RED]
            geom = [btnX + 14, btnY + 13]
    }

    secBtn(Btn) {
        bean ->
            bean.scope = 'prototype'
            color = [Color.GRAY]
            geom = [btnX, btnY, 60, 20]
            lays = [secLbl]
    }

    btnY += 25

    okLbl(Lab) {
        bean ->
            bean.scope = 'prototype'
            text = 'OK'
            size = 9
            color = [Color.BLACK]
            geom = [btnX + 24, btnY + 13]
    }

    okBtn(Btn) {
        bean ->
            bean.scope = 'prototype'
            color = [Color.GRAY]
            geom = [btnX, btnY, 60, 20]
            lays = [okLbl]
    }
}
