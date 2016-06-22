package org.examples.string;

def javaString = 'The java string'
println javaString

def groovyString = "${javaString}"
println groovyString

def a = "1" // "1" is the GString

println a*3 // multiplication

println a+"12" // concatation


