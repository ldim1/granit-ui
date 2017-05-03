package scheme

beanName = 'tsn1'
devX = 450
devY = 150
devCode = null
ledCode = 11
devName = 'ТСН-1'

evaluate(new File("./src/main/resources/scheme/templates/tsn.groovy"))

beanName = 'tsn2'
devX = 450
devY = 175
devCode = 1
ledCode = 11
devName = 'ТСН-2'

evaluate(new File("./src/main/resources/scheme/templates/tsn.groovy"))