package org.farrukh.jon.experiments.types

/**
 * Arrays in Kotlin are Objects and represented By the Array class "kotlin.Array"
  */


fun main(args: Array<String>) {

    initializeArrayByFunction()

    initializeByConstructor()

}

fun initializeByConstructor() {

    val letters = Array(7, {i -> i})

}

fun initializeArrayByFunction() {
    val months = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
}