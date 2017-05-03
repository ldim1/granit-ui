package scheme

import com.ldim.granit.ui.model.Controller
import com.ldim.granit.ui.model.shape.Box
import com.ldim.granit.ui.model.shape.Bus
import com.ldim.granit.ui.model.shape.Lab
import com.ldim.granit.ui.model.shape.Led
import javafx.scene.paint.Color

suplyColor = [Color.GREEN, Color.RED]
alarmColor = [Color.RED, Color.GREEN]

beans {

    importBeans('classpath:/scheme/srcs.groovy')
    importBeans('classpath:/scheme/devs.groovy')
    importBeans('classpath:/scheme/sws.groovy')
    importBeans('classpath:/scheme/tsns.groovy')
    importBeans('classpath:/scheme/ctrls.groovy')

    controller2(Controller) {
        id = 2
        lays = [dev1]
    }

    tp9scheme(Bus) {
        code = 5
        color = suplyColor
        width = 6
        geom = [653, 764, 698, 687, 701, 631]
        lays = [new Bus(code: 29, color: suplyColor, width: 6, geom: [701, 631, 701, 602]),
                new Bus(code: 6, color: suplyColor, width: 6, geom: [701, 602, 705, 560, 840, 591]),
                new Led(geom:[4.5, 701, 631, 701, 602]),
                new Lab(text: '5092', geom: [705, 684]), new Lab(text: '5094', geom: [715, 612]), new Lab(text: '5093', geom: [764, 544]),
                new Lab(text: '19 микрорайон', geom: [595, 630]),
                new Box(code: 129, color: alarmColor, geom: [598, 593, 10, 10]),
                new Box(code: 130, color: alarmColor, geom: [598, 603, 10, 10]),
                new Box(color: [Color.GRAY], geom: [608, 593, 30, 20], lays: [new Lab(size: 11, text: 'ТП9', geom: [613, 607])])]
    }

    tp9(Controller) {
        id = 3
        lays = [src1, src2, src3,
                new Bus (color: [Color.BLUE], width: 8, geom: [40, 176, 380, 176]),
                dev1, dev2, dev3, dev4,
                new Bus (color: [Color.BLUE], width: 8, geom: [40, 276, 585, 276]),
                sw0, sw1, sw2, sw3, sw4, sw5, sw6,
                new Bus (code: 12, color: suplyColor, width: 8, geom: [30, 350, 615, 350]),
                lbl0, lbl1, lbl2, lbl3, lbl4,
                tsn1, tsn2,
                reqBtn, tstBtn, secBtn, okBtn]
        scheme = tp9scheme
    }
}