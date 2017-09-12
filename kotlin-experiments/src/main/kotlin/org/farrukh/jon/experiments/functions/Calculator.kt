package org.farrukh.jon.experiments.functions

fun main(args: Array<String>) {

    val a = 10
    val b = 20

    val result = add(a, b)

    println(result)

}

fun add(a: Int, b: Int): Int {
    return a + b
}
