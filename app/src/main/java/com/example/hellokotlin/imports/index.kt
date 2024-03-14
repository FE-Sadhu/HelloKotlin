package com.example.hellokotlin.imports

// 单独导入
import com.example.hellokotlin.controlflow.testForIn
// 全量导入
import com.example.hellokotlin.types.*


fun main() {
    com.example.hellokotlin.main()

    // 单独导入
    testForIn()

    // 全量导入
    transformType()
}