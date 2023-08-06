package com.rockthejvm

object MyPlayground extends App{

  //Yield will return a list of all the outputs of the Loop
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"

  // List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a, 3-b, 3-c)
  println(alternativePairs)

  val aRange = 1 to 1000
  val twoBytwo = aRange.map(number => number * 2).toList //Without toList, it returns a Vector
  print(twoBytwo)
}
