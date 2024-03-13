package com.example.hellokotlin.types

// is 和 !is 操作符可以在运行时检测、转换对象类型
// as 可以断言类型。如果断言的值（含 null）在运行时类型非断言的类型，那么会抛出异常

fun testType(params: Any) {
    if (params is String) {
        // 自动把 params 类型转换为 String
        println(params.length)
    }

    if (params !is String) {
        println("Not a String")
    } else {
        // 自动把 params 类型转换为 String
        println(params.length)
    }

    // || 和 && 的右边也会自动转换类型
    if (params !is String || params.length === 0) {};
    if (params is String && params.length > 0) {};

    // when 也会自动转换
    var a = 1;
    when (params) {
        is String -> println(params.length)
        is Int -> a += params
        is IntArray -> println(params.sum())
    }

    // 断言
    var aa = "aa";
    var bb: Int = aa as Int // 如果断言的值（含 null）在运行时类型非断言的类型，那么会抛出异常
    println(bb)
}
fun main() {
    testType(1)
}