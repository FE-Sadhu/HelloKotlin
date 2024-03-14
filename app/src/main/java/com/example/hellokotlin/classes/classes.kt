package com.example.hellokotlin.classes

/**
 * 主构造函数 Demo
 */
// 想在对象初始化时执行一些逻辑，那么用 init 包裹就行
// 属性的声明赋值、init 内的逻辑，按声明顺序执行
class InitOrderDemo(name: String) {
    // 声明属性
    val firstProperty = "First property: $name".also(::println)
    init {
        println("First initializer block that prints $name")
    }
    val secondProperty = "Second property: ${name.length}".also(::println)
    init {
        println("Second initializer block that prints ${name.length}")
    }

    init {
        println(" 已声明好之前的所有属性 ${this.firstProperty} ${this.secondProperty}")
    }
}

// 在 constructor 里声明属性
class Person(
    name: String,
    val firstName: String,
    val lastName: String,
    var isEmployed: Boolean = true) {
    init {
        println("传参 name 并不是属性 ${name}")
        println("在构造函数里声明属性 ${this.firstName} ${this.lastName} ${this.isEmployed}")
    }
}

// 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
//class Customer public @Inject constructor(name: String) { /*……*/ }

/**
 * 次构造函数 Demo
 * 类里面前缀有 constructor 的写法都算次构造函数。
 * 目前我对次构造函数的理解是给类提供了构造函数重载的能力
 *
 * 次构造函数只能传参，不拥有主构造函数里直接用 val 声明参数字段的能力
 *
 * */

class Student(val sno: String, val grade: Int, val name: String, val age: Int)  {

    // 次构造函数 1 --- 通过 this(传参) 语法调用主构造。
    // 传入部分参数默认值
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }

    // 次构造函数 2 --- 间接调用主构造
    // 传入部分默认值
    constructor() : this("", 0) {
    }
}

// 因为用次构造函数重载了，外部调用就拥有了三种调用方式
val student1 = Student()
val student2 = Student("Jack", 19)
val student3 = Student("a123", 5, "Jack", 19)


fun main() {
    // 创建类的实例。 在 kotlin 中没有 new 关键字
    val a = InitOrderDemo("hello");
    println("a > $a")
    Person("Sadhu", "W", "SS");
}