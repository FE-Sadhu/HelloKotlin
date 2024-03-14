package com.example.hellokotlin.controlflow

// 一、for-in 循环
// 可以对任何提供迭代器（iterator）的对象进行遍历

fun testForIn() {
    // 遍历区间
    for (i in 1..3) {
        println("遍历区间 $i")
    }

    // 遍历 String
    val str = "abc1233d"
    for(c in str) {
        print("$c ")
    }

    // 遍历数组或 list
    var array = arrayOf("1", 2, "s")
    for (i in array) {
        println("遍历数组或 list $i")
    }

    // 遍历索引用 .indiex，也可以利用库函数 withIndex
    for ((index, value) in array.withIndex()) {
        println(" withIndex $index-$value")
    }
}

// 二、while 循环
// 与 JS 一样，也有 do While

fun testWhile(x: Int) {
    var v = x;
    while (v > 0) {
        v--
    }

    var copy = x;
    do {
        copy--;
        println(copy);
    } while (copy > 0)
}

fun main() {
    testForIn()
    testWhile(3)
}