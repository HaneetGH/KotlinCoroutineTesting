package com.technorapper.kotlinpracsi

abstract class Person<out T, out Z, in Y>(s: T, i: Z, s1: Y) {

    abstract fun test(yes: Y): T


}

data class Person2<T, Z, Y>(var name: T, var age: Z, var city: Y)

