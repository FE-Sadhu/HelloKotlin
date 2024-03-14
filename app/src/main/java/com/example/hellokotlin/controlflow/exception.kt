package com.example.hellokotlin.controlflow

fun main(){
    try {
        throw Exception("hi there");
    } catch (e: Exception) {
        println("catch 住了 $e")
    } finally {
        println("finally ")
    }

    println("结尾")
}