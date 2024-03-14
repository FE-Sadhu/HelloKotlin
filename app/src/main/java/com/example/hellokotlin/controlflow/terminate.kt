package com.example.hellokotlin.controlflow

/**
 * 返回与跳转有三种表达式
 *
 * 1. return: 默认从最直接包裹它的函数或匿名函数返回 （lambda 表达式需要用标签语法返回）
 * 2. break: 终止最直接包裹它的循环
 * 3. continue: 继续下一次最直接包裹它的循环
 *
 * 以上三种方式都可以通过标签语法进行制定中断。
 * 标签语法是以 @ 符号结尾
 *
 * */


fun main() {
    // 1. 跳出外层循环(continue 同理)
    sadhu@ for (i in 1..10) {
        for (j in 2..7) {
            if (i < j ) {
                break; // 默认调出最直接包裹它的内层循环
            } else {
                break@sadhu; // 跳出标签指定循环
            }

        }
    }

    // 2. 跳出函数和 lambda 表达式
    fun foo() {
        listOf(1, 2 ,3 ,4 ,5).forEach sadhu@ {
            println("lambda 表达式里面 $it");
            if (it == 3) {
                println("直接跳到 foo() 的调用者后面")
                return; // 直接返回 foo() 的调用者
            } else {
                println("跳过本轮迭代 lambda 的执行，继续下一次迭代")
                return@sadhu; // lambda 表达式都有隐式标签，与接受 lambda 函数同名。如果不显式声明 sadhu@ 的话，此处可以直接 return@forEach
            }
        }

        println("forEach 之后")
    }

    foo();
    println("foo 之后")

    // 3. 上面跳出的 forEach 类似于循环里的 continue，要实现打断循环执行的话，只能通过外层再包裹一个 lambda 表达式来模拟
    fun foo1() {
        run sadhu@ {
            listOf(1, 2 ,3 ,4 ,5).forEach {
                println("lambda 表达式里面 $it");
                if (it == 3) {
                    println("直接跳到 foo1() 的调用者后面")
                    return; // 直接返回 foo1() 的调用者
                } else {
                    println("跳出 run lambda 的后面")
                    return@sadhu;
                }
            }
        }

        println("forEach 之后")
    }

    foo1();
    println("foo1 之后")
}