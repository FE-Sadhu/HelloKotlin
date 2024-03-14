package com.example.hellokotlin.classes

/**
 * 一、继承
 * 继承的关键字就是一个冒号 :
 * 要支持继承，有两种方式：
 * 1. 直接继承抽象类
 * 2. 给父类的声明加上 open 关键字，表示开启被继承权限
 *
 */
open class Base(p: Int) {
    constructor(p: Int, c: String): this(p) {}
}


// 对于子类有主构造函数，那么继承时写法只能如下，父类() 代表执行父类的构造函数，类比 super()
class Derived(p: Int) : Base(p)


// 对于子类无主构造函数，继承时写法如下，每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个做到这点的构造函数。
class MyView : Base {
    constructor(p: Int) : super(p)

    // 在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数
    constructor(p: Int, c: String) : super(p, c)

}

/**
 * 二、重写父类方法和属性 override
 * 要支持重写，父类与被重写的方法或属性都必须用 open 修饰。
 * 在子类里若重写了父类的方法或属性，那么必须用 override 修饰。
 *
 * 重写还有几点要求：
 * 1. 重写属性必须是兼容的类型
 * 2. 可以用一个 var 属性重写一个 val 属性，但反之则不行
 * 3. 子类中标记为 override 的方法或属性都支持被再次继承重写。如果想禁止再次重写，可以使用 final 关键字
 *
 * */

open class Shape {
    open val vertexCount: Int = 0 // 支持重写
    open fun draw() { /*……*/ } // 支持重写
    fun fill() { /*……*/ } // 不支持被重写
}

class Circle() : Shape() {
    final override val vertexCount = 4 // 重写属性必须是兼容的类型。 用 final 修饰禁止再次重写。
    override fun draw() { /*……*/ } // override 修饰
}


/**
 * 三、继承的执行顺序
 * 优先父类，再到子类
 *
 * */

open class Base1(val name: String) {

    init { println("初始化基类 Init ") }

    open val size: Int =
        name.length.also { println("初始化基类 Size 字段: $it") }
}

class Derived1(
    name: String,
    val lastName: String,
) : Base1(name.replaceFirstChar { it.uppercase() }.also { println("给基类构造的传参: $it") }) {

    init { println("初始化派生类") }

    override val size: Int =
        (super.size + lastName.length).also { println("初始化派生类的 size 字段: $it") }
}

fun testExecuteOrder() {
    println("构造派生类实例(\"hello\", \"world\")")
    val ins = Derived1("hello", "world")
    println("ins $ins")
}

/**
 * 四、调用基类的实现（可以不被重写的属性或方法调用）
 * 语法：super.XXX
 *
 * 如果是内部类调用外部类的基类，那么语法使用 super@外部类名.外部类基类的方法
 *
 * */

open class Rectangle {
    open fun draw() { println("父类 Draw") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw() // 调用父类实现
        println("子类 Draw $fillColor")

        val filler = Filler()
        filler.drawAndFill()
    }

    val fillColor: String get() = super.borderColor // 调用父类实现（不同字段）

    // 定义内部类 Filler
    inner class Filler {
        fun fill() { println("内部类 fill ") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("内部类打印外部类的基类 ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
        }
    }
}

fun testInvokeBase() {
    val fr = FilledRectangle()
    fr.draw()
}


/**
 * 五、继承多个基类或接口
 *
 * 如果多个父类有相对成员的实现，那么子类必须要重写它，以消除歧义。
 * 此时 super 语法是： super<目标基类或接口>.XXX
 * */

interface Polygon {
    fun draw() { /* …… */ } // 接口成员默认就是“open”的
}

class Square() : Rectangle(), Polygon {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle>.draw() // 调用 Rectangle.draw()
        super<Polygon>.draw() // 调用 Polygon.draw()
    }
}

fun main() {
//    testExecuteOrder();
    testInvokeBase()
}