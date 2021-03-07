package pkg

/**
 * 构建过程中默认implements GroovyObject
 *
 * */
//def  person = new Person(name:'android',age:20)
class outerPerson implements Serializable {
    String name
    Integer age

    def increaseAge(Integer years){
        this.age += years
    }

    //groovy元编程的应用，一个方法找不到时，调用替代
    def invokeMethod(String name,Object args){
        return "this is invokeMethod"
    }

    //methodMissing优先级高于invokeMethod，防止程序崩溃
     def methodMissing(String name, Object args){
        return "this is missingMethod"
    }
}