package com.example.hellokotlin.classes

/**
 * 属性声明的语法
 *
 * 除了语法还需注意两点：
 * 1. 手动声明 getter setter
 * 2. 用于编译器类型识别的懒赋值修饰符 lateinit
 *
 * */

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    lateinit var zip: String

    fun getZip() {
        // 因为用 lateinit 懒修饰了，所以编译器不会推断为 null
        zip.length
    }

}

fun copyAddress(address: Address): Address {
    val result = Address() // Kotlin 中没有“new”关键字
    result.name = address.name // 将调用访问器 getter
    result.street = address.street
    // ……
    return result
}

class Rectangle1(val width: Int, val height: Int) {
    val area: Int // 类型也可以被 getter 返回值隐式推断出来的
        get() = this.width * this.height // getter

    var stringRepresentation = ""
        get() { // getter
            println("做一些其他的逻辑")
            return this.toString()
        }
        set (value) { // setter
            println("做一些其他的逻辑")

            field = value // 不能用 stringRepresentation = value，此时会递归触发 setter，可以用 field 关键字代表
        }
}

