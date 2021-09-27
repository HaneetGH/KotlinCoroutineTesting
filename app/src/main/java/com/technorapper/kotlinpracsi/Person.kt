package com.technorapper.kotlinpracsi

class Person(s: String, i: Int, s1: String) {

    lateinit var name: String
    lateinit var objective: String
    lateinit var founder: String
}

data class Person2(var name: String, var age: Int, var city: String)