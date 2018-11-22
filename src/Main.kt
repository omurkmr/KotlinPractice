@file:JvmName("KotlinFile")

import java.math.BigInteger

fun main (args: Array<String>){

    //Hello world print
    println("Hello World")
    println()


    //mutable
    var mutableText: String
    mutableText = "first init mutableText"
    mutableText = "second init mutableText"
    println(mutableText)
    println()


    //immutable
    val immutableText: String
    immutableText = "first init immutableText"
    //immutableText = "second init immutableText"
    println(immutableText)
    println()


    //if as an expression
    val ifCount = 22
    var ifText = if (ifCount in 1..20)
                    "in 1 to 20"
                else
                    "not in 1 to 20"
    println(ifText)
    println()


    //when as an expression
    var whenNumber = 5
    var whenText: String = when (whenNumber){
        1 -> "first"
        in 2..4 -> "between 2 to 4"
        else -> "more than 4"
    }
    println(whenText)
    println()


    //for loop
    for (i in 3 downTo 1)
        println("for loop counter $i")
    println()



    //while loop
    var whileCondition = 1
    while (whileCondition < 4){
        println("while loop counter $whileCondition")
        whileCondition++
    }
    println()


    //do while loop
    var doCondition = 1
    do {
        println("do while counter $doCondition")
        doCondition++
    }while (doCondition < 4)
    println()


    //break statement
    breakLoop@ for (i in 1..3){
        for (j in 1..3){
            println("i = $i, j = $j")
            if (i == 2 && j == 2)
                break@breakLoop
        }
    }
    println()

    //continue statement
    continueLoop@ for (i in 1..3){
                    for (j in 1..3){
            if (i == 2 && j == 2)
                continue@continueLoop
            println("i = $i, j = $j")
        }
    }
    println()

    //void function
    add(1,2)

    //return function
    var divideNumber = subtraction(5,2)
    println("a minus b = $divideNumber")
    println()

    //function as an expression
    var maxNumber = max(5,9)
    println("max number is $maxNumber")
    println()

    //default function
    var fieldValue = field(10,20)
    println("field size is $fieldValue")
    println()

    //named parameters
    multiplication(thirdNum = 40, firstNum = 10, secondNum = 20)

    //extention functions
    val extendedFuncText = "Hello "
    val extendedFuncText2 = "Kotlin "
    val extendedFuncText3 = "World!!"

    println(extendedFuncText.add(extendedFuncText2,extendedFuncText3))
    println()

    //infix function
    var greaterNumber = 50
    println(greaterNumber greaterValue 100)
    println()

    //tailrec function
    println(getFibonacciNumber(10000, BigInteger("0"), BigInteger("1")))
    println()

    //primary,secondary constructor
    var primaryConst = PrimaryClass("Kotlin",10)
    println("id : ${primaryConst.id}")
    println()

    //all classes in kotlin are "static" and "final" default

    //inheritance
    var inheritTest = InheritTest()
    inheritTest.eat()

    var inheritUsage = InheritClass("Ahmet")
    inheritUsage.eat()
    println()

    //access modifiers
    var turkishPerson = Turkish()
    // a and b not visible

    //Abstract class
    val bmwEngine = BMWEngine()
    bmwEngine.startEngine()
    println()

    //Interface
    val screen = Screen()
    screen.onTouch()
    screen.onClick()
    println()

    //data class
    val user1 = User("Ahmet",15)
    val user2 = User("Ahmet",15)

    //user1 equals to user2 because with data class deal with data not the object
    //also we can copy with changing some values
    //and by using print function we will see meaningful data instead of @asd1fsdf23vd structure
    val user3 = user1.copy(name = "Osman")
    println(user3)
    println()


}
fun add(a: Int, b: Int){
    println("a plus b = ${a+b}")
    println()
}

fun subtraction(a: Int, b: Int): Int{
    return a-b
}

fun max(a: Int , b: Int) = if (a>b) a else b

@JvmOverloads
fun field(length: Int, breadth: Int, height: Int = 10): Int{
    return length*breadth*height
}

fun multiplication (firstNum: Int, secondNum: Int, thirdNum: Int = 5){
    println("first number = $firstNum")
    println("second number = $secondNum")
    println("third number = $thirdNum")
    println()
}

fun String.add(str1: String, str2: String): String {
    return this + str1 + str2
}

infix fun Int.greaterValue(value : Int): Int {

    if (this>value)
        return this
    else
        return value
}

tailrec fun getFibonacciNumber(totalCall: Int, firstNum: BigInteger, secondNum: BigInteger): BigInteger {

    if (totalCall == 0)
        return secondNum
    else
        return getFibonacciNumber(totalCall-1,firstNum+secondNum,firstNum)
}

class PrimaryClass(var name: String){
    var id : Int = -1

    init {
        println("Name : $name")
        println()
    }

    //secondary constructor body called after primary constructor
    constructor(n: String, id: Int): this(n){
        this.id = id
    }

}

open class InheritTest{
    var color: String = ""

    open fun eat(){
        println("Eat")
    }
}

class InheritClass(var name: String) : InheritTest(){
    override fun eat(){
        println("$name Eat")
    }

}

open class Person(){
    private val a = 1
    protected val b = 2
    internal  val c = 3
    val d = 4
}

class Turkish: Person() {
    fun test(){
        //a not visible
        //b,c,d visible
    }
}

class TestClass(){
    fun test(){
        var turkishPerson = Turkish()

        //a and b not visible
        //c and d visible
    }
}

abstract class Engine{
    abstract var engine: String
    abstract fun startEngine()
}

class BMWEngine : Engine() {
    override var engine = "BMW Engine"

    override fun startEngine() {
        println("Started $engine")
    }
}

interface ClickListener {
    fun onClick(){
        println("Listener onClick")
    }

    fun onTouch()
}

class Screen: ClickListener {

    override fun onTouch() {
        println("Screen onTouch")
    }

    override fun onClick() {
        super.onClick()
        println("Screen onClick")
    }
}

data class User(var name: String,var id: Int)
