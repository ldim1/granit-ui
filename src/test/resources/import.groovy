import com.ldim.granit.ui.model.shape.Led
import javafx.scene.paint.Color

beans {

    label1(Led) {
        bean -> bean.scope = 'prototype'
        code = 1
        color = [Color.RED, Color.GREEN]
        geom = [10, 50, 50]
    }

    label2(Led) {
        code = 2
        color = [Color.RED]
        geom = [50, 70, 100]
    }

    labell(Led) {
        code = 1
        color = [Color.RED]
        geom = [70, 100, 100]
    }
}