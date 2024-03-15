package com.example.hellokotlin.classes

/***
 * 用 data 关键字修饰的类就是数据类
 *
 * 数据类在 kotlin 里的目的主要是用于保存数据的实例，编译器会为数据类的实例提供一些额外的自动生成的辅助方法。
 * 可用于利于阅读的可读输出(toString)、比较实例(==)、复制实例等
 *
 * 数据类的声明有以下限制条件：
 * 1. 主构造函数需要至少有一个参数。
 * 2. 主构造函数的所有参数需要标记为 val 或 var。
 * 3. 数据类不能是抽象、开放、密封或者内部的。
 *
 */

// 语法
data class User(val name: String = "", val age: Int = 0)


// 对于那些自动生成的辅助函数，编译器只使用在主构造函数内部定义的属性
data class Person2(val name: String) {
    // 用辅助方法不会识别在非主构造函数里声明的属性方法
    // 比如 ==、toString 或直接打印
    // 但是 age 属性确实是存在于实例上的
    var age: Int = 0
}

fun main() {
    val person1 = Person2("John")
    val person2 = Person2("John")
    person1.age = 10
    person2.age = 20

    // person1 == person2: true
    println("person1 == person2: ${person1 == person2}")

    // person1 with age 10: Person(name=John)
    println("person1 with age ${person1.age}: ${person1}")

    // person2 with age 20: Person(name=John)
    println("person2 with age ${person2.age}: ${person2}")

    // 复制
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)

    val jane = User("Jane", 35)
    // 解构
    val (name, age) = jane
    println("$name, $age years of age") // Jane, 35 years of age

}

