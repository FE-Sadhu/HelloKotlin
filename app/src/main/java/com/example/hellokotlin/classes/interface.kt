package com.example.hellokotlin.classes

/**
 * 语法是 interface 定义，被类实现时与接口之间继承的语法都是一样，是个冒号 :
 *
 * 接口里可以只定义抽象（声明），也可以定义实现。
 *
 * 对于只定义声明的属性或方法，必须在派生类中实现。
 *
 *
 * */

// 接口定义与使用语法
interface MyInterface {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29 // 对于抽象的属性或方法必须在派生类中实现
}


// 接口继承
interface Named {
    val name: String
}

interface Person1 : Named {
    val firstName: String
    val lastName: String

    // 如果在派生接口里实现了基类接口的抽象，那么抽象就不用在该接口的派生类里实现，否则必须实现
    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    // 不必实现“name”
    override val firstName: String,
    override val lastName: String,

) : Person1