package scheme

beanName = 'src1'
offsetX = 0
reserved = true
devCode = 1
swCode = 11
led1Code = 11
led2Code = 11

evaluate(new File("./src/main/resources/scheme/templates/src.groovy"))

beanName = 'src2'
offsetX = 120
reserved = false
devCode = 1
swCode = 11
led1Code = 11
led2Code = 11

evaluate(new File("./src/main/resources/scheme/templates/src.groovy"))

beanName = 'src3'
offsetX = 240
reserved = false
devCode = 1
swCode = 11
led1Code = 11
led2Code = 11

evaluate(new File("./src/main/resources/scheme/templates/src.groovy"))