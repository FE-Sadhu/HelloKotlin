package com.example.hellokotlin.classes

/**
 * 可见性修饰符
 *
 * 在 package 里的顶层声明：
 * 如果你不使用任何可见性修饰符，默认为 public，这意味着你的声明将随处可见。
 * 如果你声明为 private，它只会在声明它的文件内可见。
 * 如果你声明为 internal，它会在相同模块内随处可见。
 * protected 修饰符不适用于顶层声明。
 *
 * 在类内部成员的声明：
 * private 意味着只该成员在这个类内部（包含其所有成员）可见；
 * protected 意味着该成员具有与 private 一样的可见性，但也在子类中可见。
 * internal 意味着能见到类声明的本模块内的任何客户端都可见其 internal 成员。
 * public 意味着能见到类声明的任何客户端都可见其 public 成员。
 *
 */

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected
    override val c = 7   // 'c' is internal
}

class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
}