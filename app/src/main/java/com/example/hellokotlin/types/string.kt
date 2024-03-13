package com.example.hellokotlin.types

// 字符串用双引号表示，类型是 String
// 可以存储 0 个或多个字符，UTF-16 编码，每个字符可能占用 1 或 2 个字节，取决于具体的字符

// 一、 可遍历、索引访问

fun testIndex() {
    val str = "abcd"
    // 遍历
    for(c in str) {
        print("$c ")
    }

    // 索引访问
    for(c in str.indices) {
        print("$c~${str[c]} - ")
    }
}


// 二、无法改变原值、可用 + 号拼接
fun testStrOperator() {
    val str = "abcd"

//    str[2] = "ccc" // 不能改变原值
    val str2 = str + 1; // 可 + 号拼接其他类型的值
    println(str2)

//    val str3 = 1 + str;  // + 号拼接时必须保证表达式中第一个元素是字符串
}

// 三、字面量
fun testLiterals() {
    // 多行字符串
    val text = """
        ${'$'}a // 打印 $ 符号的方式
        for(c in "foo")
            print(c)
    """.trimIndent()

    println(text)

    // 模板字符串
    // 变量用 $ 修饰，表达式用 ${} 修饰
    val str = "abc12"
    println("$str 的长度是 ${str.length}")
}

fun main() {
    testIndex()
    testStrOperator()
    testLiterals()
}