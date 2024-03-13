package com.example.hellokotlin.types

// 有 true false 两个值、支持可空?
// 操作符支持 || 、 && 、 !

fun main() {
    val b1 = false;
    var b2 = true;
    val b3: Boolean? = null;

//    println(b3 || b2) // 必须要布尔类型才能用操作符
//    println(!b3) // 必须要布尔类型才能用操作符
//    println(b1 || (b2 = false)) // 不能是表达式
    println(b1 || b2);
    println(b1 && b2);
    println(!b1)
}
