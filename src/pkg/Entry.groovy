package pkg

class Entry {
    static void main(def args){
        println '这是程序入口...'
        ApplicationManager.init()
        def person = PersonManager.createPerson('suibian',99)
        println person.name + "and "+ person.age
    }
}
