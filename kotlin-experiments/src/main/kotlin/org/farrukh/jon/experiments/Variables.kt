package org.farrukh.jon.experiments


/**
 * val - value, is immutable reference. Like 'final' variable in Java
 * var - variable, is mutable reference. Like 'non-final' variable in Java
 */
fun main(args: Array<String>) { // Here is the Main/Entry point function

    var name = "Ali" // The 'name' is mutable variable.

    println(name) // Prints Ali

    name = "Vali"

    println(name) // Prints Vali

    val surname = "Samiev" // The surname is immutable variable.

    println(surname) // Prints Samiev

    //surname = "Ganiev" // Cannot be reassigned. Error: Val cannot be reassigned.

}

