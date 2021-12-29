package ru.geekbrains.dictionaryone.utils

class ClassForTests {
    val something = Something()

    fun method1(x: Int): Boolean{
        return x == 1
    }

    fun method2(x: Int): Int{
        return x
    }

    fun method3(): Array<Int>{
        return arrayOf(1,2,3)
    }

    fun method4(): Any?{
        return null
    }

    fun method5(): Any{
        return something
    }

    fun method6(): Any{
        return something
    }
}