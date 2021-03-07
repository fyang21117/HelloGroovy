package pkg

class ApplicationManager {
    static void init(){
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
//        outerPerson.metaClass.static.createPerson = {
//            String name,int age -> new outerPerson(name:name,age:age)
//        }
    }
}
