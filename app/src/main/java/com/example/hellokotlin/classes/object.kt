package com.example.hellokotlin.classes

/**
 * 1. 对象表达式
 *  (匿名对象) object {...}
 *
 * 2. 对象声明
 *  创建单例。
 *  并不是一个表达式，不能放在赋值语句的右边。
 *  定义的对象与 JS 一样也是按引用赋值。
 *
 * 对象表达式和对象声明之间有一个重要的语义差别：
 * (1)对象表达式是在使用他们的地方立即执行的
 * (2)对象声明是在第一次被访问到时延迟初始化的
 * (3)伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
 *
 */

// 一、对象表达式
fun testObj1() {
    // 对象表达式
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"
        // 默认继承自 Any, so `override` is required on `toString()`
        // 改写了 toString 才能在控制台打印
        override fun toString() = "$hello $world"
    }
    print(helloWorld)
}

// 对象表达式继承
open class A(x: Int) {
    public open val y: Int = x
}

interface B { /*……*/ }

val ab: A = object : A(1), B {
    override val y = 15
}

// 对象表达式作为类共有方法的返回值时会有类型推断的异常！
class C {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

// 二、对象声明
object Site {
    var url:String = ""
    val name: String = "菜鸟教程"
}
fun testSite(args: Array<String>) {
    var s1 =  Site
    var s2 = Site
    s1.url = "www.runoob.com"
    println(s1.url)
    println(s2.url)
}

class Site1 {
    var name = "菜鸟教程"
    object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
            print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量 （但是用对象表达式声明的就能访问到！）
        }
    }
}

fun testSite1(args: Array<String>) {
    var site = Site1()
    site.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    Site.DeskTop.url // 正确
}


fun main() {
    testObj1()
}