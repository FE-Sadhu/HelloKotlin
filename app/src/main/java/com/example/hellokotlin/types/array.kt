package com.example.hellokotlin.types

/**
在 kotlin 里数组是一种保存固定数量元素的数据结构
一般来说 kotlin 里用得比较多的是集合，一般除非是性能超过了常规应用程序的需要才用数组。
与数组相比，集合有以下优点：
    1. 集合可以定义为只读，提供了开发者更多控制权以编写具有明确意图的健壮代码。
    2. 易于对集合增删元素，因为数组大小是固定的，对数组元素增删的唯一方式是每次创建一个新数组，效率很低。
    3. 可以使用 == 来校验两个集合是否在结构上相等，但数组必须用特殊方法。
*/

// 创建数组
// 方式一：使用函数
//  1. arrayOf(挨个传值) 会创建传入值的数组
//  2. arrayOfNulls(传个数量) 会创建传入数量的数组，每个元素是 null
//  3. emptyArray() 会创建空数组
// 方式二：Array 构造函数
//  接收数量作为参数，会有个函数，返回值为元素，构建每个元素时都会调用一次，以索引作为参数。
// 方式三：原生类型数组
//  为了高性能，创建原生类型数组时不用方式一、二，使用该方式：
//  booleanArray(), IntArray(), ByteArray(), CharArray() 等
fun main() {
    // 创建数组
    var arr1 = arrayOf(1, 2, "3");
    println(arr1.joinToString())

    val arr2 = arrayOfNulls<Int?>(3);
    arr2[1] = 2
    println(arr2.joinToString())

    val arr3 = Array<Int>(3) {
        i -> i * i
    }
    println(arr3.joinToString())

    // 多维数组
    val arr4 = Array(2) {
        Array(2) { 0 }
    }
    println(arr4.contentDeepToString())

    // 操作数组元素
        // 改 -- 通过下标
        arr1[1] = "a"
        println(arr1.joinToString())
        // 增删
        arr1 += "Sadhu"; // 该操作会创建一个新的数组，复制老元素并添加新元素
        println(arr1.joinToString())

    // 比较数组
    println(arr1.contentEquals(arr2))

    // 转换数组为集合
    val arr5 = arrayOf(1, 2, 3, 3, 4);
    println(arr5.toSet()) // 转换成非重复集合 [1, 2, 3, 4]
    println(arr5.toList()) // 转换成列表 [1, 2, 3, 3, 4]

    val arr6 = arrayOf("apple" to 120, "banana" to 150)
    println(arr6.toMap()) // 转换成 Map {apple=120, banana=150}
}