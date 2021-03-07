package pkg

import groovy.xml.slurpersupport.GPathResult


/**
 * 章节回顾《第三章》
 * Gradle生命周期
 *
 * 介绍：
 * 1、gradle基本概念
 *  作用：构建工具（Maven、ant）---其实是一个编程框架
 *  组成：groovy核心语法 + build script block + gradle api
 *
 * 2、gradle优势
 *  灵活性：可以修改构建过程（自定义产出）
 *  粒度性：源代码编译、直到生成apk，整个生成过程的每一个task可见可修改
 *  （eg： tinker动态修改gradle打包过程，在生成apk的同时生成各种补丁文件）
 *  扩展性：支持插件机制，可以复用已有插件Android插件、Java插件、library插件
 *
 *  兼容性：兼容所有ant、maven的功能
 *
 * 3、gradle执行流程
 *  Initialization初始化阶段：解析整个工程中所有project，构建所有project对应的project对象；
 *
 *  configuration配置阶段：解析所有的projects对象中的task，构建好所有的task的拓扑图；
 *
 *  Execution执行阶段：执行具体的task及其依赖task
 *
 * */

//具体工程参考：E:\project\helloGradle



/*
def str = 'a single \' \' " "string'
def str2 = "a double ' ' \" \" " +
        "string "
def str3 = '''a thuple ' ' " " 
string'''

println str
println str2
println str3

println str.class
println str2.class
println str3.class

def str4 = "double string : ${str2}"
println str4.class

def str5 = ''' double string : ${str2} '''

def clouser = { String name -> println "clouser println ${name}"}
clouser("test")*/



////填充
//def str = "groovy"
//println str.center(10,'-')
//println str.padLeft(10,'+')
//str.eachLine {
//
//}
////比较
//def str2 = 'l'
//println str > str2
//
////索引
//println str[0]
//println str[0..3]
//
////删掉
//def str3 = "groovy Hello"
//println str3 - "str2"
//
//
//def clouser = { String name -> println "clouser println ${name}"}
//clouser("test")
//clouser.call("test call")

//
//
////2021年1月20日17:16:47
////第一步，创建XmlSlurper类
//def xparser = new XmlSlurper()
//def targetFile = new File("testxml.xml")
////轰轰的GPath出场
//GPathResult gpathResult =xparser.parseText("${projectDir}/src/testxml.xml")
//
////开始玩test.xml。现在我要访问id=4的book元素。
////下面这种搞法，gpathResult代表根元素response。通过e1.e2.e3这种
////格式就能访问到各级子元素....
//def book4 = gpathResult.value.books.book[3]
//
////得到book4的author元素
//def author = book4.author
//
////再来获取元素的属性和textvalue
//assert author.text() == ' Manuel De Cervantes '
//
////获取属性更直观
//author.@id == '4'
////或者
////author['@id'] == '4'
//
////属性一般是字符串，可通过toInteger转换成整数
//author.@id.toInteger() == 4
//
////好了。GPath就说到这。再看个例子。我在使用Gradle的时候有个需求，就是获取AndroidManifest.xml版本号（versionName）。有了GPath，一行代码搞定，请看：
//def androidManifest = newXmlSlurper().parse("AndroidManifest.xml")
//println androidManifest['@android:versionName']
//
////或者
////println androidManifest.@'android:versionName'




import groovy.util.slurpersupport.GPathResult

def replaceManifest() {
    GPathResult androidManifest = new XmlSlurper().parse("AndroidManifest.xml")
    String versionName = androidManifest['@android:versionName']
    versionName += ' beta'
    androidManifest.setProperty('@android:versionName', versionName + "")

    groovy.xml.XmlUtil.serialize(androidManifest, new PrintWriter(new File("AndroidManifest.xml")))
    println "------groovy.xml.XmlUtil.serialize AndroidManifest end-------"
}




