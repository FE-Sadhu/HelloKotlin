package com.example.hellokotlin.functions

/**
 * 一、Lambda 表达式的完整语法形式如下：
 *      val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
 *      - lambda 表达式总是括在花括号中。
 *      - 完整语法形式的参数声明放在花括号内，并有可选的类型标注。
 *      - 函数体跟在一个 -> 之后。
 *      - 如果推断出的该 lambda 的返回类型不是 Unit，那么该 lambda 主体中的最后一个（或可能是单个）表达式会视为返回值。
 *
 *  二、如果函数只有唯一一个参数是 lambda 表达式，那么在调用函数时可以省略括号调用比如：
 *      run { println("...") }
 *
 *  三、一个 lambda 表达式只有一个参数很常见，此时可以省略 (a) -> ，用 it 关键字代替，比如：
 *      ints.filter { it > 0 } // 这个字面值是 “(it: Int) -> Boolean” 类型的
 *
 * 四、有闭包特性，能保存外部作用域的上下文。
 *
 * 五、带有接收者的函数字面值，定义类型的格式：A.(B) -> C。
 *      其中 (B) -> C 代表该函数的真正定义。  A 表示该函数只能被 A 类型的值调用。并且函数体里的 this 就代表接收者。
 */

// 带有接收者的函数字面值
// lambda 表达式的声明
val sum: Int.(Int) -> Int = { other -> plus(other) }
// 匿名函数的声明
val sum1 = fun Int.(other: Int): Int = this + other // this 代表接收者的值

fun testReceiver() {
    // 以下两种方式全等
    println(sum(1, 2)) // 3
    println(1.sum(2)) // 3
}
fun main() {
    testReceiver()
    // 一些用法例子
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas 表达式是花括号括起来的代码块。
    items.fold(0, {
        // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // lambda 表达式中的最后一个表达式是返回值：
        result
    })

    // lambda 表达式的参数类型是可选的，如果能够推断出来的话：
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

    // 函数引用也可以用于高阶函数调用：
    val product = items.fold(1, Int::times)

    println("joinedToString = $joinedToString")
    println("product = $product")
}