package com.rockthejvm

object ObjectOrientation extends App{
  /*
  Extending App automatically implements the main method in App class which allows you to
  run this object body as an app. Same as Java's public static void main(String[] args).
   */

  //class and instance
  class Animal {
    //members
    val age: Int = 0
    //methods
    def eat()  = println("I'm eating.")
  }
  val anAnimal = new Animal

  //Inheritance
  class Dog(val name: String) extends Animal  //constructor definition
  val aDog = new Dog("Bingo")

  //Constructor arguments are not fields
  //Add val to make a constructor a member (field)
  class Cat(val name: String)
  val aCat = new Cat(name = "Mew")

  println(aCat.name)

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() //the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, restrict by using private or protected before the val
    def walk(): Unit //Implementation can be provided by other class that inherits it
  }

  //Interface = ultimate abstract type
  trait Canivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit //?! is a valid method name
  }
  //Extend as many traits as you want with the with command
  // Scala has single-class inheritance and multi-trait "mixing"
  class Crocodile extends Animal with Canivore with Philosopher {
    override def eat(animal: Animal): Unit = println("This is a nice animal.")
    override def eat(): Unit = super.eat() //This will overwrite the eat in the Class

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //Arguments to a method with only ONE param can also be passed this way (infix notation)
  aCroc ?! "What if we could try"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) //equivalent

  //anonymous classes

  //singleton object
  object MySingleton {//the only instance of MySingleton type
    val mySpecialValue = 52387
    def mySpecialMethod(): Int = 7645
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  println(MySingleton.apply(35))
  println( MySingleton(35) ) //equivalent to a call to the apply() method

  //Case classes
  case class Person(name: String, age: Int)
  //case classes can be constructed without the constructor new
  val bob = Person("Bob", 45) // Person.apply("Bob",54)

  //exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception =>"Some faulty error message"
  } finally {
    //executes some code no matter what
  }

  //generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail

  println(first) //1
  println(rest)  //List(2, 3)

  val aStringList = List("Hello", "Santa", "My Friend")
  val firstString = aStringList.head
  val restString = aStringList.tail

  print(firstString)
  //print(restString)

  // Point #1: In Scala we operate with IMMUTABLE values/objects
  // Any modification to an object must return another object
  val reversedList = aList.reverse // returns a NEW list

  //Point #2: Scala is closest to the Object Oriented ideal
}
