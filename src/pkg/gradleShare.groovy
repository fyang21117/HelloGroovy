package pkg


/**
 * 2、xml文件
 * Java处理方法：DOM文件驱动处理 + SAX文件驱动处理
 *
 * （1）groovy如何解析一个xml格式数据
 * （2）groovy如何创建一个xml格式数据
 * */

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

final String manifestXml =
        '''
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.sq.seasdk.demo">

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="com.android.vending.BILLING" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" tools:node="remove"/>

    <application
        android:name="com.sysdk.official.OfficialApplication"
        android:allowBackup="true"
        android:icon="@mipmap/demo_ic_launcher"
        android:label="@string/demo_app_name"
        android:roundIcon="@mipmap/demo_ic_launcher_round"
        android:appComponentFactory="android.support.v4.app.CoreComponentFactory"
        android:requestLegacyExternalStorage="true"
        tools:replace="android:appComponentFactory"
        android:supportsRtl="true"
        android:networkSecurityConfig="@xml/network_security_config"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:screenOrientation="portrait"
            android:theme="@style/Theme.AppCompat.NoActionBar"
            android:windowSoftInputMode="stateAlwaysHidden"
            android:configChanges="keyboardHidden|orientation|screenSize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- facebook login-->
        <meta-data
            android:name="com.facebook.sdk.ApplicationId"
            android:value="@string/facebook_app_id" />

        <activity
            android:name="com.facebook.FacebookActivity"
            android:configChanges="keyboard|keyboardHidden|screenLayout|screenSize|orientation" />
        <activity
            android:name="com.facebook.CustomTabActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data android:scheme="@string/fb_login_protocol_scheme" />
            </intent-filter>
        </activity>

        <receiver
            android:name="com.appsflyer.MultipleInstallBroadcastReceiver"
            android:exported="true">
            <intent-filter>
                <action android:name="com.android.vending.INSTALL_REFERRER" />
            </intent-filter>
        </receiver>

        <meta-data
            android:name="com.google.android.gms.version"
            android:value="@integer/google_play_services_version" />
        <meta-data
            android:name="appsflyer_key"
            android:value="KVypxtJELxgHnrtrxTiKoB" />
        <meta-data
            android:name="gp_server_client_id"
            android:value="229089348010-epnqf4runbmullpi4gpe4dtor1930t87.apps.googleusercontent.com"/>
        <meta-data
            android:name="gp_pay_key"
            android:value="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv8V2XrIFXSVr/t78Gy9Cf/GmHPFirrIJ/DwS/70Vj5K7nq0b0Mz/F2dM8PMgqnWxr5vkg+SBQSYyEttvCecSRCITyo3AYSJro23ldXPCrJv9x0ZsY/CxPborKYbSSjkKqEYmlEP0oZsqFpXc8qq0m0UT3Enz4smZuvhDk/W0PGAyZ3V1LFMenwgRmdhgu3q4RbJ7VF2D2bpyB/iXu6088s53W2W/z2BMxprfji+1YSwF8AhuAjydorkUFZj22p8UVcqobguPZBp3FVHjyd19snp5OOjAEaj46NJYT82JIRyoOmKdcPOnORWG+Wpt3veSZAop1pk4w20Od4+gSqS0rQIDAQAB"
        />
    </application>
</manifest>
        '''
//开始解析
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(manifestXml)

//获取<string id='1' name="app_name1">的属性name
//println response.value.string[0].@name

//获取
//println response.value.string[1].title.text()
//println response.value.string[1].content.text()

//println response.value.books[0].book[0].title.text()
//println response.value.books[0].book[0].author.text()
//println response.value.books[1].book[0].@available

//对书节点进行遍历
//def list = []
//response.value.books.each{ books ->
//        books.book.each{ book ->
//                def author = book.author.text()
//                if(author.equals('郭霖')){
//                        list.add(book.title.text())
//                }
//        }
//}
//println "作者郭霖的书籍："+list.toListString()

//遍历permission节点，补充权限
def sdkPermissionList = [
        "android.permission.ACCESS_NETWORK_STATE" ,
        "android.permission.INTERNET",
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.READ_EXTERNAL_STORAGE",
        "com.android.vending.BILLING",
        "android.permission.ACCESS_WIFI_STATE"
]
sdkPermissionList.each { String sdkpermission
    def cpPermissionList = []


}



//深度遍历xml数据
//def titles = response.depthFirst().findAll { book ->
//        return book.author.text() == '李刚'?true : false
//}
//println "作者李刚的书籍："+titles.toListString()

//广度遍历xml数据
//def name = response.value.books.children().findAll{ node ->
//        node.name() == 'book' && node.@id == '2'
//}.collect { node ->
//        return node.title.text()
//}
//println "特定id的书籍："+name


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

