package com.example.hellokotlin.classes

/**
 * 函数式接口的主要目的是为了 SAM 服务的
 * SAM -> Single Abstract Method
 *
 * 也就是接口里面只能定义一个抽象方法，可以有别的非抽象成员。对于这种接口，我们可以用 fun 修饰，修饰后它就是所谓函数式接口。
 *
 * 有什么好处？ 可以通过 lambda 表达式实现 SAM 转换，从而使代码更简洁、更有可读性
 *
 */

// 函数式接口
fun interface IntPredicate {
    fun accept(i: Int): Boolean
    val propA
        get() = 1
}

// 如果不用 SAM 特性，实现一个接口需要这样写
/*
// 创建一个类的实例
val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}
*/
// 用 SAM 特性，如下写法完全等于以上注释内写法
private val isEven = IntPredicate { it % 2 == 0 }

fun main() {
    println("Is 7 even? - ${isEven.accept(7)} - ${isEven.propA}")
}