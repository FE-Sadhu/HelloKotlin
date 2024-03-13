package com.example.hellokotlin.types

/* 数字 */
// 一、整数类型
// 1. 有符号整型
// 四个类型 Byte、Short、Int、Long，对应四个范围：8 位、16 位、32 位、64 位，对应十进制 [-2^(位 - 1), 2^(位 - 1) - 1]
// 不显示声明类型，编译器默认从 Int 开始推断
const val num1 = 1; // Int
const val num2 = 3000000000; // > 2^31 -1，被推断为 Long

// 显示声明类型，值超过了类型对应的范围编译器就会报错
//const val num3: Byte = 128; // > 2^7 -1 ，超过 Byte 范围编译器就会报错
const val num4: Long = 1;
const val num5 = 1L; // 后缀 L 也是显示声明 Long 类型的一种方式

// 2. 无符号整型
// 四个类型 UByte、UShort、UInt、ULong，对应四个范围：8 位、16 位、32 位、64 位，对应十进制 [0, 2^位 - 1]
const val num6: ULong = 1u; // 就算显示声明也必须加后缀 u

// 二、浮点类型
// 两个类型 Float、Double，对应两个十进制位数范围： 6-7、15-16 位，当小数部分超过对应位数时，会被编译器舍入。
// 不显示声明类型，编译器默认推断为 Double
const val pi = 3.14;
const val noInt = 1.0;
const val eFloat = 2.7182818284f // f 后缀代表指定为 Float 精度，超过 6-7 位时会被舍入为 2.7182817

fun testPrintNumber() {
    println(eFloat)
    println(num10) // 引用上层作用域变量
    println(num11)
}

// 三、字面量表示
const val num7 = 123; // 十进制
const val num8 = 0x0F; // 十六进制
const val num9 = 0b01011; // 二进制
// 支持用下划线声明让数字更易读
const val num10 = 1_23; // 输出 123
const val num11 = 0x0_F; // 输出 15

// 四、可空数字
// 在类型后面加问号 ?，表示变量可以被传空引用 null
// 不加问号则不能赋值空
var a: Int? = 1;
//val num12: Int = a; // 会类型报错

fun testNumType(num: Int) {
    a = null; // Int? 可为空
}

// 五、显示类型转换
// 不同类型不能互相赋值，必须类型转换。
// 转换方式：to各类型()，比如 toByte()

fun transformType() {
    //    testNumType(num5) // Long 类型不能赋值给 Int
    testNumType(num5.toInt())
    //    testNumType(pi) // Double 类型不能赋值给 Int
    testNumType(pi.toInt())

    var a = 3000000000;
    println(" Long 转 Int " + a.toInt()) // 大范围转小范围，数字会被截
    var b = 3.74
    println(" Double 转 Int " + b.toInt()) // 直接抛弃小数位
    var c = 200;
    println(" Int 转 Double " + c.toDouble()) // 补小数位 0
}

// 六、操作符
// 支持 +、-、*、/、%，其中（整数 除 整数）会丢弃任何小数部分。
// 支持位运算
// 比较：==、!=、>、<、>=、<=、a..b、 x in a..b、x !in a..b

fun operator() {
    val x = 5 / 2;
    println(x); // 2，整数除以整数会抛弃小数

    val y = 5 / 2.toDouble();
    println(y); // 2.5，当其中某个数为浮点数时，保留小数

    println(0..10); // 区间
    println(1 in 0..10);
    println(1 !in 0..10);
}
fun main() {
    testPrintNumber()
    transformType()
    operator()
}