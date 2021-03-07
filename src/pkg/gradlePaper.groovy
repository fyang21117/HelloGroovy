package pkg


/**
 * @Author : fengyang
 * @Time : 2021/1/31 10:35
 * */
//class gradlePaper {
//}


/*
//（1）闭包定义
def clouser = { String name ->
    println "1、println:clouser ${name}"
}

//（2）调用方式
clouser("test")
clouser.call("test call")

//（3）多个参数
def MyClouser = {String names ,int ages ->
    println "2、println MyClouser:heloo ${names}, my ages is ${ages} "
}
def names = 'my_clouser'
MyClouser(names,100)

//（4）所有闭包的隐式默认参数it，可以不声明的
def itClouser = {
    println "3、println itClouser: hello ${it}"
}
itClouser('it_clouser')

//（5）闭包的返回值,没有return的话，返回null
def returnClouser = {
    println "4、println returnClouser:hello ${it}"
//    return "hello ${it}"
}
def result = returnClouser('return_clouser')
println "5、println returnClouser result："+result

*/


/*
String str = 'the 2 and 3 is 5'
//each的遍历
str.each {
    String temp -> print temp.multiply(2)//每个字符拷贝一份,返回值还是str本身
}
println ""

//find来查找符合条件的第一个
println str.find {
    String s -> s.isNumber()
}

//查找所有符合条件的
def list =  str.findAll {
    String s -> s.isNumber()
}
println list.toListString()

//查找是否有符合条件的
def anyresult = str.any {
    String s -> s.isNumber()
}
println anyresult

//查找是否全部都符合条件
def everyresult = str.every {
    String s -> s.isNumber()
}
println everyresult

//将小写字母转换为大写
def list2 = str.collect {
    it.toUpperCase()
}
println list2.toListString()*/


class ClosureOutput{
    String name
    def method = {  "The output of this time is ${name}"    }

    String toString(){
        method.call()
    }
}

class ClosureDelegationOutput{
    String name

}

def output01 = new ClosureOutput(name:'ClosureOutput')
def output02 = new ClosureDelegationOutput(name:'ClosureDelegationOutput')
println "output01："+output01.toString()

//修改delegate对象，添加委托策略，从delegate开始寻找
output01.method.delegate = output02
output01.method.resolveStr ategy = Closure.TO_SELF
println "output01："+output01.toString()








