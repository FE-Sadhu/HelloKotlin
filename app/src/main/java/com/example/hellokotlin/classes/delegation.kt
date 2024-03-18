package com.example.hellokotlin.classes

import kotlin.reflect.KProperty

/**
 *
 * Kotlin 委托的语法关键字是 by，其本质上是面向编译器的语法糖，三种委托（类委托、对象委托和局部变量委托）在编译时都会转化为 “无糖语法”。
 *
 *  1. 类委托：编译器会为类实例实现基础接口的所有方法，并直接委托给基础对象来处理。
 *  语法：class <类名>(b : <基础接口>) : <基础接口> by <基础对象>
 *
 *  2. 属性委托和局部变量委托：在编译时会生成辅助属性（prop$degelate），而属性 / 变量的 getter() 和 setter() 方法只是简单地委托给辅助属性的 getValue() 和 setValue() 处理。
 *  语法：val/var <属性名> : <类型> by <基础对象>
 *
 *
 *  委托给另一个属性：
 *  一个属性可以把它的 getter 与 setter 委托给另一个属性。这种委托对于顶层和类的属性（成员和扩展）都可用。
 *  为将一个属性委托给另一个属性，应在委托名称中使用 :: 限定符。
 *
 *  提供委托：
 *  如果基础对象有 provideDelegate 方法，那么会调用该方法，以结果作为真正的委托对象。这部分可以想看提供委托的例子。
 */

// 一、类委托
interface Base3 {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base3 {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

// 委托给 b
class Derived3(b: Base3) : Base3 by b {
    override fun printMessage() { print("abc") }
}

// 二、属性委托
class Example {
    // 委托给 Delegate 对象，其必须实现 getValue 、setValue 方法
    // 对委托属性 p getter setter 的访问其实就是调用 getValue、setValue
    var p: String by Delegate()
}
class Delegate {
    // 第一个参数是 thisRef 是被代理的属性的对象
    // 第二个参数是 property 是被代理的属性的包装对象
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    // 第三个参数 value 就是 setter 待改变的值
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}


// :: 把一个属性的 getter setter 委托给另一个属性
var topLevelInt: Int = 0
class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}
var MyClass.extDelegated: Int by ::topLevelInt


// 提供委托

/*

class C {
    var prop: Type by MyDelegate()
}

如果 MyDelegate 没有 provideDelegate 方法，由编译器生成的代码：

class C {
    private val prop$delegate = MyDelegate()(this, this::prop)
    var prop: Type
        get() = prop$delegate.getValue(this, this::prop)
        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
}

如果提供了 provideDelegate 方法,由编译器生成的代码:
class C {
    // 调用 “provideDelegate” 来创建额外的 “delegate” 属性
    private val prop$delegate = MyDelegate().provideDelegate(this, this::prop)
    var prop: Type
        get() = prop$delegate.getValue(this, this::prop)
        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
}
*/

fun main() {
    val obj = BaseImpl(10)
    // 为 Derived3 实例实现基础接口 Base3 的所有方法，调用时直接委托给基础对象 obj 来处理
    Derived3(obj).printMessage() // override 是生效的
    Derived3(obj).printMessageLine()
}