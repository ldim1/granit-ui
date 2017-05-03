package scheme

import com.ldim.granit.ui.model.Controller
import com.ldim.granit.ui.model.Root

beans {

    importBeans('classpath:import.groovy')

    root(Root) {
    }

    controller(Controller) {
        id = 1
        lays = [label1, label1, labell,
                label2, label2]
    }

    controller2(Controller) {
        id = 2
        lays = [label2]
    }

    controller3(Controller) {
        id = 3
        lays = [label1, label2]
    }
}