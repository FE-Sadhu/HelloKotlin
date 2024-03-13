package com.example.hellokotlin.types

// 字符用单引号表示，类型是 Char
// 只能存储单个字符，UTF-16 编码，通常占用 2 字节
// 可以直接使用 == 操作符来比较两个字符是否相等

fun main() {
//    val a = 'ad'; // 存储多个字符会报错
    val a = 'a';
    val b = "a";
    println(a)
//    println(a == b) // 不同类型不能比较
    println('好')
    println("好")

    println('\n') // 换行字符也生效
    println('啊')
    println("\n") // 换行字符串也生效
    println("这")
    println('\uFF00'); // 编码 Unicode 字符
    println("\uFF00") // 编码 Unicode 字符
    println("\\uFF00") // 直接打印 \uFF00
}

/**
Kotlin 字符与字符串的区别：

在Kotlin中，字符和字符串是两种不同的数据类型，它们之间有一些重要的区别：
字符 (Char)：
1. 用单引号括起来，例如 'A'。
2. 存储单个字符。
3. 在内存中占据 2 个字节（UTF-16 编码）。

字符串 (String)：
1. 用双引号括起来，例如 "Hello"。
2. 存储零个或多个字符组成的序列。
3. 在内存中以 UTF-16 编码存储。每个字符可能占用 1 或 2 个字节，取决于具体的字符。

因此，在 Kotlin 中，字符表示单个字符，而字符串表示一个字符序列。
 */