package pkg

// x = 1
// y = 1.02
//
////三引号任意格式
//def z = '''\
//a
//c
//d
//e
//'''

//${任意表达式}
//def str = "hello ${z}"
//println x.class
//println y.class
//println z
//println str


/**
 * 2020/10/19
 * */
//def method = { println "hello ${it}"
//}
//def str = "str"
//method(str)

//闭包的基础使用
//def method = { String name ->
//return  "hello ${name}"
//}
//def str = "groovy"
//def result = method(str)
//println result


////求阶乘
//int x = fab2(5);
////println x
//
//def fab(int number){
// int result = 1
// 1.upto(number,{num -> result *= num})
// return result
//}
//
//int fab2(int number){
// int result = 1
// number.downto(1){
//  num -> result *= num
// }
// return result
//}
//
//
//int x2 = cal(5);
////println x2
//
//int cal(int number){
//int result = 0
// number.times {
//  num -> result += num
// }
// return result
//}



/**
 * 字符串与闭包结合使用
 * */
//String str = "a b c d e f ! 3 2 1 "
//each遍历
//println str.each {
// String temp -> print temp
//}

//find查找符合条件的第一个
//println str.find {
// String s -> s.isNumber()
//}

//def list = str.findAll {
// String s -> s.isNumber()
//}
//println list.toListString()

//def result = str.any{
// String s -> s.isNumber()
//}
//println result

//println str.every { String  s -> s.isNumber()}
//def list2 = str.collect { it.toUpperCase()}
//println list2.toListString()


/**
 * 闭包进阶
 * */

//task helloworld {
// doLast{
//  println 'hello world'
// }
//}





































