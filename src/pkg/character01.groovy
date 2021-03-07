package pkg
/**
 * 章节回顾《第一章》
 * 内容：
 * 一、groovy基础语法(变量、字符串、循环等)
 * 二、groovy闭包讲解
 * 三、groovy数据结构（列表、映射、范围用法）
 * 四、groovy面向对象
 * */

//println "hello groovy"


/**
 * 一、groovy基础语法
 * groovy变量
 * 1、变量的类型：基本类型 + 对象类型
 * 2、变量的定义：强类型定义方式 + 弱类型def定义方式
 * */

/*
//用于其他模块/其他类，强定义（不能改变类型，是确定的）
int x01 = 10
println x01.class     //class java.lang.Integer

double y01 = 1.1
println y01.class     //class java.lang.Double


//自己当前使用，弱定义（随时动态转换为其他的类型）
def x02 = 10
println x02.class

def name01 = 'android'
println name01.class      //class java.lang.String

x02 = 'android'
println x02.class          //class java.lang.String
*/



/**
 * 字符串--class java.lang.String
 * 1、String
 * 2、GString
 *      常用的三种定义方式
 *      新增操作符
 *      新增API讲解
 *
 * */
/*

//单引号字符串，如果有格式需要拼接
def name02 = 'a single string'
println name02.class

//三引号，任意格式
def name03 = '''第一行
第二行
第三行
'''
println name03

//有扩展时，真正的实现类，class org.codehaus.groovy.runtime.GStringImpl
def name04 = "android"
def sayHello = "hello: ${name04}"
println sayHello
println sayHello.class

def sum = "the sum of 2 and 3 equals ${2 + 3}"//可扩展做任意的表达式
println sum

def result = echo(sum)  //虽然不指定类型，运行过程自动转换
println result.class    //class java.lang.String
String echo(String msg){
    return msg
}*/


/**
 * String方法
 * 1、java.lang.String
 * 2、DefaultGroovyMethods
 * 3、StringGroovyMethods：普通类型的参数、闭包类型的参数
 * */
/*
def str = "groovy Hello"
//指定长度和填充字符，对已知字符的填充
println str.center(18,'a')
println str.padLeft(18,'a')

//字符串的比较操作符
def str2 = 'Hello'
println str > str2

//获取字符串的index对应值
println str[0]

//获取字符串的一段子串
println str[0..1]

//删掉字串
println str - str2

//字符串反向输出
println str.reverse()

//字符串首字母大写
println str.capitalize()

//字符串是否数字的判断
println str.isNumber()

//字符串转Integer类型/Double类型等
def str3 = "123"
println str3.toInteger()
println str3.toInteger().class
*/



/**
 * 基础语法
 * groovy变量详解
 * groovy的字符串详解
 *
 * 逻辑控制
 * 1、顺序逻辑：单步往下执行
 * 2、条件逻辑：if/else、switch/case
 * 3、循环逻辑：while循环、for循环
 * */
/*
def  x = 1.23
def result
//switch类型可以是任意类型
switch (x){
//switch (x.class){
    case 'foo' : result = 'found foo'
        break
    case [1.23,4,5,6,'inlist'] : result = 'list'//列表
        break
    case 12..30 : result = 'range'//范围
        break
    case Integer : result = 'integer'
        break
    case BigDecimal:result = 'big decimal'
        break
    default :result = 'default'
}
println result
*/

/**
 * 对范围的for循环
 * */
/*
def sum = 0
for(i in 0..9){
    sum += i
}
println sum
*/

/**
 * 对list的循环
 * */
/*
for(i in [1,2,3,4,5,6,7,8,9]){
    sum += i
}
println sum
*/

/**
 * 对map的循环
 * */
/*
for(i in ['lili':1,'luck':2,'xiaoming':3]){
    sum += i.value
}
println sum
*/

//def result = str.replace(".","/").split("/")
//def result = str.split("\\.")
//def result1 = str1.split("\\.")
//
//println result.size()
//for(int index=0;index<result.size();index++){
//    println result[index]
//}
//println result1.size()
//for(int index=0;index<result1.size();index++){
//    println result1[index]
//}

/*

def str1 = '3.2.1'
boolean isGradleToolsBuildVersionLow() {
    //3.2.1----3.3.0
    String targetVersion = "3.2.1"
    def str = "2.2.1.1"
    boolean equalValue = false
    String[] versions = str.split("\\.")
    String[] targets = targetVersion.split("\\.")
    int size = versions.size() < targets.size() ? versions.size() : targets.size()

    for(int index = 0 ; index < size ; index++){
        if(targets[index] > versions[index]){
            return true
        }else if(targets[index] < versions[index]){
            return false
        }else {
            equalValue = true
        }
    }
    if(equalValue){
        return true
    }else{
        return false
    }
}
println isGradleToolsBuildVersionLow()

*/



//println str
//println str.class
//def result1 = str1.split('.')
//println str.split('.')
//def versions = str.split('.')
//int size = versions.size()
//println result.size()
//println result1.length
//if(versions[size-2]<'3' && versions[size-1]<'3' && versions[size]<'0'){
//    println 'true'
//}
/**
 * 二、groovy闭包讲解
 * 1、groovy种闭包基础
 * （1）闭包概念：闭包的定义、调用
 * （2）闭包参数：普通参数、隐式参数
 * （3）闭包返回值：总是有返回值的
 * 2、闭包使用
 * (1)与基本类型的结合使用
 * （2）与string结合使用
 * （3）与数据结构结合使用
 * （4）与文件等结合使用
 * 3、闭包进阶
 * */
/*

//（1）定义和调用:参数 -> 执行体
def clouser = {String name ->
    println 'hello test'
    println "heloo ${name}"
}

clouser.call("android")

def name = "java"
clouser(name)

//多个参数
def MyClouser = {String names ,int ages ->
    println "heloo ${names}, my ages is ${ages} "
}
def names = 'my_clouser'
MyClouser(names,100)


//所有闭包的隐式默认参数it，可以不声明的
def itClouser = {
    println "hello ${it}"
}
itClouser('it_clouser')


//闭包的返回值,没有return的话，返回null
def returnClouser = {
    println "hello ${it}"
//    return "hello ${it}"
}
def result = returnClouser('return_clouser')
println result
*/


/*
//闭包的用法
int x = fab(5)
println "fab(5) = "+x
int fab(int number){
    int result = 1
    1.upto(number,{ num -> result *= num})
    return result
}

int y = fab2(5)
println "fab2(5) = "+y
int fab2(int number){
    int result = 1
    number.downto(1){
        num -> result *= num
    }
    return result
}

println "cal(101) = "+cal(101)
int cal(int number){
    int result
    //初始值为0，不适合用于阶乘。闭包参数的设定，可以源码中使用的参数情况，再决定传一个还是两个
    number.times {
        num -> result += num
    }
    return result
}
*/


/**
 * 字符串与闭包的结合使用
 * */
/*

String str = 'the 2 and 3 is 5'
//each的遍历
str.each {
    String temp -> print temp.multiply(2)//每个字符拷贝一份,返回值还是str本身
}

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
println list2.toListString()

*/



/**
 * 闭包进阶
 * 三个重要变量：this,owner,delegate
 * */

/*
def scriptClouser = {
    println "scriptClouser this : " + this  //代表闭包定义处的类
    println "scriptClouser owner : " + owner    //代表闭包定义处的类或者对象
    println "scriptClouser delegate : " + delegate  //代表任意对象，默认和owner一致
}
scriptClouser.call()
*/


//定义内部类
class Person{
    //1、声明static方法
    def classClouser = {
//        def classClouser = {
            println "classClouser this : " + this
            println "classClouser owner : " + owner
            println "classClouser delegate : " + delegate
    }
    def  say(){
        def methodClouser = {
            println "methodClouser this : " + this
            println "methodClouser owner : " + owner
            println "methodClouser delegate : " + delegate
        }
        methodClouser.call()
    }
}
//1、输出person，三者都指向当前的类
//Person.classClouser.call()
//Person.say()

//2、非static方法调用示例
Person innerPerson = new Person()
//person.classClouser.call()
//person.say()


//输出具体的实现类Person@1ca25c47
//Person person = new Person()
//person.classClouser.call()
//person.say()

//outerPerson person1 = new outerPerson()
//person1.classClouser.call()
//person1.say()


//闭包中定义一个闭包，三者不一致
def nestClouser = {
    def innerClouser = {
        println "innerClouser this : " + this   //指向实例对象character01@3e2822
        println "innerClouser owner : " + owner //指向真正的内部类character01$_run_closure2@439a8f59
        println "innerClouser delegate : " + delegate   //指向最近的闭包对象character01$_run_closure2@439a8f59
    }
    //可选：指定innerClouser的delegate(但this，owner无法改变的，)
//指定外部类
//    innerClouser.delegate = outerPerson
//指定内部类
    innerClouser.delegate = innerPerson
    innerClouser.call()
}
nestClouser.call()




//闭包的委托策略
/*
class Student{
    String name
    def pretty = {  "my name is ${name}"    }

    String toString(){
        pretty.call()
    }
}
class Teacher{
    String name
}
def stu = new Student(name:'stu')
def tea = new Teacher(name:'tea')
println stu.toString()
//修改delegate对象，添加委托策略，从delegate开始寻找
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()  //tea
*/
/*

class Student{
    String name
    def pretty = {  "my name is ${name}"    }

    String toString(){
        pretty.call()
    }
}
class Teacher{
    String name1
}
def stu = new Student(name:'stu')
def tea = new Teacher(name1:'tea')
println stu.toString()
//修改delegate对象，添加委托策略，如果delegate找不到，从参数查找
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST //DELEGATE_ONLY：delegate和name属性都找不到会报错
println stu.toString()  //stu
*/



/**
 * 三、数据结构
 * 1、groovy列表
 * (1)列表的定义
 * （2）列表的操作：增删查排
 * 2、groovy映射
 * 3、groovy范围
 * */

/*

//1、列表定义
//java列表：def list = new ArrayList()
def list = [1,2,3,4,5]
println list.class
println list.size()

//groovy数组定义
def array = [1,2,3,4,5] as int[]
int[] array2 = [1,2,3,4,5]

//2、列表的操作
def sortList = [6,-3,9,2,-7,1,5]
//按从小到大排序
Collections.sort(sortList)
println sortList

//按绝对值大小排序
Comparator mc = { a,b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
Collections.sort(sortList,mc)
println sortList

//groovy的排序,从大到小,不需要collection
sortList.sort { a,b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortList

//groovy排序，字符串列表,按长度排序
def sortStringList = ['abc','a','heloo','githubcom']
sortStringList.sort{ it -> return it.size()}
println sortStringList


//列表的查找
def findList = [6,-3,9,2,-7,1,5]
int result = findList.find { return it % 2 == 0}
def result2 = findList.findAll { return it % 2 != 0}
def result3 = findList.any { return it % 2 != 0}
def result4 = findList.every { return it % 2 != 0}
def result5 = findList.count{ return it % 2 == 0}

println result
println result2.toListString()
println result3
println result4
println findList.min {return Math.abs(it)}//返回列表绝对值最小的一个
println findList.max()
println result5


//list的添加元素
def addList = [6,-3,9,2,-7,1,5]
addList.add(100)
addList.leftShift(7)
addList << 1
println addList.toListString()

def plusList = addList + 10
println plusList.toListString()

//list的删除元素
addList.remove((Object) 6)
println addList.toListString()

addList.remove(0)
println addList.toListString()

addList.removeAll{ return it % 2 == 0}
println addList.toListString()

println addList - [1,5]

*/



/**
 * 2、groovy映射
 * */
/*

//def map = new HashMap()
//注意：key会被默认指定为单引号字符串
def colors = [red : '000001', blue:'000002',black:'000003']
println colors.getClass()   //默认class java.util.LinkedHashMap

//指定hashmap
//HashMap colors = [red : '000001', blue:'000002',black:'000003']

//索引方式
println "colors['red']="+colors['red']
println "colors.red="+colors.red

//添加元素
colors.yello = '000004'
println colors.toMapString()

//添加任意类型的元素
colors.complex = [a:1,b:2]
println colors.toMapString()


//Map操作详解
def students = [
        1:[num:'001',name:'Tom',score:100],
        2:[num:'002',name:'Bosco',score:101],
        3:[num:'003',name:'Caton',score:90],
]
//遍历
students.each {def student ->
    println "key is ${student.key},"+
            "value is ${student.value}"
}
//带索引的遍历,注意接收参数的顺序，先接收key-value，再到index
students.eachWithIndex { def student,int index  ->
    println "index is ${index},key is ${student.key},"+
            "value is ${student.value}"
}

//直接遍历key-value
students.eachWithIndex {key,value,index  ->
    println "index is ${index},key is ${key},"+
            "value is ${value}"
}

//Map的查找
def entry = students.find {def student ->
    return student.value.score >= 100
}
println entry

def entry2 = students.findAll {def student ->
    return student.value.score >= 100
}
println entry2

//统计
def count = students.count {
    def student ->
        return student.value.score >= 100 && student.value.name == 'b'
}
println count

//只打印名字
def entry3 = students.findAll {def student ->
    return student.value.score >= 100
}.collect {
    return it.value.name
}
println entry3.toListString()


//分组
def group = students.groupBy {def student ->
    return student.value.score >=100 ? '及格':'不及格'
}
println group.toMapString()

//排序,成绩从低到高
def sort = students.sort{def s1,def s2->
    Number score1 = s1.value.score
    Number score2 = s2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? -1 :1
}
println sort.toMapString()
*/

/**
 * 3、groovy范围
 * Range
 * 1、each
 * 2、switch-case
 *
 * */
/*

//range是list的简单子类
def range = 1..10
println range[0]
println range.contains(1)
println range.from
println range.to

//遍历1、each
range.each {
    println it
}
for(i in range){
    println i
}

//2、switch-case
def  getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result = '不及格'
            break
        case 60..<90:
            result = '良好'
            break
        case 90..100:
            result = '优秀'
            break
    }
}
def result = getGrade(75)
println result
*/


/**
 * 四、面向对象(单独创建一个class文件)
 * 1、groovy中默认都是public
 * 2、groovy元编程
 * */
//class person{
//    String name
//    Integer age
//
//    def increaseAge(Integer years){
//        this.name += years
//    }
//}
//def  person = new Person(name:'android',age:20)
//println "name: ${person.getName()}," +
//        "age:${person.getAge()}"
//person.increaseAge(10)

//接口中不允许定义非public方法
//interface Action{
//    void eat()
//    void play()
//    abstract void drink()
//}


/**
 * 2、元编程
 * 开始调用：
 *  判断类中有此方法---直接调用类中方法
 *  否则--MetaClass是否有此方法---调用MetaClass中的方法
 *      否则--是否重写了methodMissing（）方法---调用methodMissing（）方法-
 *      否则--是否重写了invokeMethod（）方法---调用该invokeMethod（）方法
 *          否则--抛出MissingMethodException
 *
 * 作用：扩展类中的方法
 * 对比java：一般继承父类，再拓展自定义方法，限制：如果父类是final方法无法继承（eg：string类）
 * 先groovy：不修改父类、不继承父类，通过metaClass添加自定义方法和属性，就能够达到拓展的目的
 *
 * 更多作用：做框架的时候可以使用
 *
 * 普及：
 * metaClass来自DefaultGroovyMethods.class
 *
 * 特别注意：
 * 从外部动态添加方法和类，只限本脚本使用。
 * 如果需要只注入一次，其他脚本可用，参考ApplicationManager + Entry + PersonManager
 * 类似工厂方法
 * */
/*

def person = new Person(name:'android',age:20)
println person.cry()

//从外部为类动态添加一个属性
Person.metaClass.sex = 'male'
def person1 = new Person(name:'android',age:20)
println person1.sex
//修改属性
person1.sex = 'femal'
println "the new sex value is " + person1.sex


//从外部为类动态添加一个方法（指定一个闭包）
Person.metaClass.sexUpperCase = { -> sex.toUpperCase()}
println person1.sexUpperCase()

//为类动态添加一个静态方法
Person.metaClass.static.createPerson = {
    String name,int age -> new Person(name:name,age:age)
}
def person2 = Person.createPerson("suibian",1000)
println person2.name + "and "+ person2.age

*/
















