package com.example.hellokotlin.controlflow

// 一、if
// kotlin 中 if 是个表达式，是有返回值的，所以 kotlin 没设计专门的三元运算符
// 如果 if 表达式的分支是个代码块（{}）,那么代码块里最后的表达式作为该代码块的值
// 如果最后的表达式不是值，那么返回 Kotlin.Unit

fun testIf(a: Int, b: Int) {
    var max: String;

    if (a < b) max = "没有 else 和 花括号"

    if (a > b) {
        max = "有花括号大于"
    } else {
        max = "有花括号小于"
    }

    max = if (a > b) "三元是" else "三元否"

    val maxLimit = 1;
    val value = if (maxLimit > a) maxLimit else if (a > b) a else b;

    println("$max $value")

    // 如果对代码块应用了返回值，那么 else 分支是必须有的
    val codeBlock = if (a > b) {
        println("代码块的值 ${a}")
        a
    } else {
        // 该代码块没有返回值，返回 kotlin.Unit
        println("else 分支的值 ${b}")
    }
    println("代码块返回值 $codeBlock")
}

// 二、when
// 与 C-Like 语言的 switch 语法类似，会将参数与所有分支条件顺序比较，直到某个分支满足条件。（如有多个满足条件，只认第一个满足的分支）
// 可以作为表达式也可以作为语句， 作为表达式的话，与 if 一样代码块里最后一个表达式的值就是代码块的值，无值就是 Unit
enum class Bit {
    ZEOR, ONE
}

fun testWhen(x: Int, b: Bit) {
    // 语法
    when (x) {
        1 -> println("x === 1")
        // 希望定义多个情况共享一个分支的处理，用 , 结合
        2, 3 -> println("x === 2")
        else -> {
            println("剩余情况，如果为表达式的话，如果各分支没满足所有情况那么必须要有 else 代码块")
        }
    }

    // 表达式
    val numberic = when (b) {
        Bit.ZEOR -> 0
        Bit.ONE -> 1
        // 不需要 else，因为分支已经覆盖所有情况
    }
    println("分支满足所有情况值: $numberic")

    // 分支条件可以是任意表达式，不只可以是变量
    when (x) {
        x.toInt() -> println("to Int");
        3 + 2 -> println("1 + 2")
        in 1..10 -> println("in 区间")
        is Int -> println("is 判断类型")
        else -> println("else")
    }

    // 不带参数，当 if 使用，当某个分支的条件为真时执行该分支
    when {
        x > 10 -> println("满足分支条件")
        else -> println("不满足分支条件")
    }

    // when 的参数可以是一个表达式。 当然也包含函数执行了，利用函数的返回值
    when (x + 1) {
        6 -> println("参数可以是表达式")
    }
}

fun main() {
    testIf(2, 3);
    testIf(3, 2);
    testWhen(5, Bit.ZEOR)
}