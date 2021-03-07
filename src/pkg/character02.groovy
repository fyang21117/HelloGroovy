package pkg

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

/**
 * 章节回顾《第二章》
 * Gradle 高级用法实战
 * 1、groovy json操作
 * 2、groovy xml文件操作
 * 3、groovy 文件操作
 * 4、groovy与Java的对比总结
 *      （1）写法上：没有Java那么多的限制
 *      （2）功能上：对Java已有的功能进行了极大的扩展
 *      （3）作用上：既可以编写应用，也可以编写脚本
 *
 * 课后练习：json字符串经过JsonSlurper-->实体对象-->MarkupBuilder-->xml格式数据
 * */

/**
 * 1、json
 * 网络请求方面，参照Java做法，例如url申请
 * */
/*

def list = [new Person(name: 'Tom',age: 20),
            new Person(name: 'Jerry',age: 21)]
println JsonOutput.toJson(list)

//优化输出格式
def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)



//从网络请求返回数据，转换json获取内容字段
def response = getNetworkData('http://yuexibo.top/yxbApp/home_data.json')
println response.data.head.name

def getNetworkData(String url){
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text

    //将json转化为实体对象
    def jsonSlpuer = new JsonSlurper()
    return jsonSlpuer.parseText(response)
}
*/


/**
 * 2、xml文件
 * Java处理方法：DOM文件驱动处理 + SAX文件驱动处理
 *
 * （1）groovy如何解析一个xml格式数据
 * （2）groovy如何创建一个xml格式数据
 * */
/*

final String xml =
        '''
        <resources>
        <value>
                <books id="1" classification="android">
                        <book available="20" id="1">
                                <title>疯狂Android讲义</title>
                                <author id="1">李刚</author>
                        </book>
                        
                        <book available="14" id="2">
                                <title>第一行代码</title>
                                <author id="2">郭霖</author>
                        </book>
                </books>
                <books id="2" classification="web">
                        <book available="16" id="3">
                                <title>第一行代码（第二版）</title>
                                <author id="3">郭霖</author>
                        </book>
                </books>
        </value>
        </resources>
        '''

final String xml1 =
        '''
        <resources>
        <value>
            <string id='1' name="app_name1">
               <title>标题1</title>
               <content>内容2</content>
            </string>
            
            <string name="app_name2">
               <title>标题2</title>
               <content>内容2</content>
            </string>
            
            <string name="app_name3">test_lib3</string>
            
            <integer name="appId">5</integer>
            <color name="white">#30F5F5</color>
        </value>
        </resources>
        '''
//开始解析
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)

//获取<string id='1' name="app_name1">的属性name
//println response.value.string[0].@name

//获取
//println response.value.string[1].title.text()
//println response.value.string[1].content.text()

//println response.value.books[0].book[0].title.text()
//println response.value.books[0].book[0].author.text()
//println response.value.books[1].book[0].@available

//对书节点进行遍历
def list = []
response.value.books.each{ books ->
        books.book.each{ book ->
                def author = book.author.text()
                if(author.equals('郭霖')){
                        list.add(book.title.text())
                }
        }
}
println list.toListString()


//深度遍历xml数据
def titles = response.depthFirst().findAll { book ->
        return book.author.text() == '李刚'?true : false
}
println titles.toListString()

//广度遍历xml数据
def name = response.value.books.children().findAll{ node ->
        node.name() == 'book' && node.@id == '2'
}.collect { node ->
        return node.title.text()
}
println name

*/

/**
 * （2）groovy如何创建一个xml格式数据
 * */

/*


def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)//用来生成xml数据的核心类

//静态创建
xmlBuilder.langs(type:'current',count:'3',mainstream:'true'){
        //第一个language节点
        language(id:'1',name:"app_name1",'应用名称'){
                //添加属性数据
                age('20')
        }
        language(id:'2',version:"1.7",'应用简称')
        language(id:'3',type: "string",'应用简称')
}
//打印xml数据
//println sw

//动态创建xml数据
def langs = new Langs()
xmlBuilder.langs(type:langs.type,count:langs.count,mainstream:langs.mainstream){
        //遍历所有的子节点
        langs.languages.each{ lang ->
                language(flavor:lang.flavor,version: lang.version,value: lang.value)
        }
}
println sw

//规范性创建:对饮给langs根节点
class Langs{
        String type = 'current'
        int count = 3
        boolean  mainstream = true
        def languages = [
                new Language(flavor:'static',version: '1.7',value: 'java'),
                new Language(flavor:'dynamic',version: '1.9',value: 'android'),
                new Language(flavor:'static',version: '2.3',value: 'groovy')
        ]
}
//对应languages节点
class Language{
        String flavor
        String version
        String value
}

*/



/**
 * gradle处理manifest文件
 * */
/*

project.afterEvaluate {  //3.1
    android.applicationVariants.all { ApplicationVariant variant ->  //3.2
        String variantName = variant.name.capitalize()  //3.3
        def processManifestTask = project.tasks.getByName("process${variantName}Manifest")  //3.4

        processManifestTask.doLast { pmt ->  //3.5
            String manifestPath = "$pmt.manifestOutputDirectory/AndroidManifest.xml"  //3.6
            def manifest = file(manifestPath).getText()  //3.7

            if (project.hasProperty("channel")) {
                def channelNo = project.property("channel")

                def xml = new XmlParser().parseText(manifest)  //3.8
                xml.application[0].appendNode("meta-data", ['android:name': 'channel', 'android:value': channelNo])
                def serialize = XmlUtil.serialize(xml)
                file(manifestPath).write(serialize)
            }
        }
    }
}
*/

/*
//demo2
debugXml.application[0].each { comp ->
    if (comp.name() == 'activity') {
        comp.each { filter ->
            // 搜索入口Activity
            if (filter.toString().contains('android.intent.category.LAUNCHER')) {
                // 添加data节点，隐藏桌面icon
                filter.appendNode('data', ['android:host': 'localhost', 'android:scheme': '${applicationId}'])
                return true // break each闭包
            }
        }
    }
}
releaseFile.write(XmlUtil.serialize(debugXml))
}*/

/**
 * 3、groovy 文件操作
 * 对比：Java文件处理
 * （1）节点流，InputStream，OutputStream及其子类
 * （2）处理流，Reader、Writer及其子类
 *
 * 注意：所有Java对文件的处理类，groovy都可以使用；
 * groovy扩展了更多的方法！！
 *
 * 更多：为了减少代码量，使用groovy的遍历方法如each，而不使用for循环
 * **/

/*

def file = new File('../../hellogroovy.iml')
//遍历文件内容
//file.eachLine { line ->
//        println line
//}

//groovy封装类获取文件内容
//def allLine = file.getText()
//println allLine

//读取文件内容方式3
def allresult = file.readLines()

//读取文件部分内容方式4
//def reader = file.withReader { reader ->
//        char[] buffer = new char[1000]
//        reader.read(buffer)
//        return buffer
//}
//println reader


//文件读写
def result = copy('../../hellogroovy.iml','../../hellogroovy2.iml')
def copy(String srcPath,String destationPath){
        try{
                def desFile = new File(destationPath)
                if(!desFile.exists()){
                        desFile.createNewFile()
                }
                //开始copy
                new File(srcPath).withReader { reader ->
                        def lines = reader.readLines()
                        desFile.withWriter { writer ->
                                lines.each { line ->
                                        writer.append(line + "\r\n")
                                }
                        }
                }
                return true
        }catch (Exception e){
                e.printStackTrace()
        }
}


//对象的读写：先创建，存储，读取打印
def writePerson = new Person(name:'testObject',age:25)
saveObject(writePerson,'../../testObject.bin')

def readPerson = (Person)readObject('../../testObject.bin')
println "testObject的name = ${readPerson.name} ,age = ${readPerson.age}"

def saveObject(Object object,String path){
        try{
                //创建目标文件
                def desFile = new File(path)
                if(!desFile.exists()){
                        desFile.createNewFile()
                }

                desFile.withObjectOutputStream { out ->
                        out.writeObject(object)
                }
                return true
        }catch (Exception e){
                e.printStackTrace()
        }
        return false
}
def readObject(String path){
        def obj = null
        try {
                def file = new File(path)
                if(file == null || !file.exists()) return null

                //从文件中读取对象
                file.withObjectInputStream { input ->
                        obj = input.readObject()
                }
        } catch (Exception e){
                e.printStackTrace()
        }
}

*/



File file = new File("../../hellogroovy.iml")
def path = file.absolutePath
println 'testPath : ' +path







