package com.example.hellokotlin.functions

/**
 * fun 关键字声明
 *
 * 特殊: 内联函数
 * 内联函数的语义很简单： 把函数体复制粘贴到函数调用处 。使用起来也毫无困难，用 inline 关键字修饰函数即可。
 * 好处是为了为了优化 kotlin lambda 表达式对 java 的兼容
 */

// 花括号调用
fun double(x: Int): Int {
    return 2 * x
}

// 表达式调用
fun double1(x: Int): Int = x * 2

// 具名参数
fun foo(
    bar: Int = 0,
    baz: Int,
) { /*……*/ }

fun testFoo() {
    // 具名参数 baz 调用，可以无序传入
    // 如此调用的话，bar 使用默认值 0
    foo(baz = 1)
}

// 如果函数最后一个参数为 lambda，那么有省略的简洁写法
fun fooLambda(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) { /*……*/ }


fun testLambda() {
    fooLambda(1) { println("hello") }     // 使用默认值 baz = 1
    fooLambda(qux = { println("hello") }) // 使用两个默认值 bar = 0 与 baz = 1
    fooLambda { println("hello") }        // 简洁写法，使用两个默认值 bar = 0 与 baz = 1
}

// ！ 可变数量的参数（varargs）
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts 是一个数组
        result.add(t)
    return result
}

fun testVarargs() {
    val list = asList(1, 2, 3)

    val a = arrayOf(1, 2, 3)
    // 如果函数参数声明用了 vararg 关键字，那么传参可以用 * 关键字展开一个数组
    val list1 = asList(-1, 0, *a, 4)
}

fun main() {

}
