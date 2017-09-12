package org.farrukh.jon.experiments.collections

fun main(args: Array<String>) {

    iterateOverArray(args)

}

fun iterateOverArray(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }
}