package org.farrukh.jon.experiments.objects

class SomeClass {

    fun doSomething(
            name: String,
            age: Int = 30,
            salary: Double = 100.123) {

        println("$name, $age, $salary")
    }

}

fun main(args: Array<String>) {

    val someObject = SomeClass()

    someObject.doSomething("Ali")
    someObject.doSomething("Ali", 30)
    someObject.doSomething("Ali", 30, 100.123)

    println("Calling with parameters names:")

    someObject.doSomething(name = "Ali")
    someObject.doSomething(name = "Ali", age = 30)
    someObject.doSomething(name ="Ali", age = 30, salary = 100.123)


}