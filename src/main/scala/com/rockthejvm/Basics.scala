package com.rockthejvm

object Basics extends App {
  //Define a value
  val age: Int = 30 // const int age = 30;

  // Int, Boolean, Char, Double, Float
  val aBoolean = false // type is mostly optional

  //Strings
  val aString = "I love Scala"
  val aComposedString = "I am" + " 30 years old."
  val anInterpolatedString = s"$aString but also love Python."

  println(aComposedString)
  println(anInterpolatedString)

  //Expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  //if-expression
  val ifExpression = if (age > 20) 100 else 0

  println(ifExpression)

  val chainedIfExpression = {
    if (age > 20) 100
    else if (age == 0) 0
    else if (age < 20) 50
    else 999
  }

  println(chainedIfExpression)

  //code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 49

    //The last line in the code block is what is returned
    aLocalValue + 3
  }

  println(aCodeBlock)

  // define a function
  def myFunction(x: Int, y: String): String = y + " " + x

  def myFunction2(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  println(factorial(5))

  // In Scala we don't use loops or Iterations, we use RECURSION!

  //the Unit type = no meaningful value == void in other languages
  println("I love Scala too")

  def myUnitReturningFunction(): Unit = {
    println("I am returning a Unit.")
  }

  println(myUnitReturningFunction())

}





