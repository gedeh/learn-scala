// simple example of option
val someValue: Option[String] = Some("I am wrapped in something")
val emptyValue: Option[String] = None

assert(someValue == Some("I am wrapped in something"))
assert(emptyValue == None)

// get value or something else if it's a none
def mayItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Option("Some value") else None
}

val value1 = mayItWillReturnSomething(true)
assert(value1.getOrElse("No value") == "Some value")

val value2 = mayItWillReturnSomething(false)
assert(value2.getOrElse("No value") == "No value")
assert(value2.getOrElse("default") == "default")

assert(value1.isEmpty == false)
assert(value2.isEmpty == true)

// use pattern matching to extract value
var optionPattern: Option[Double] = Some(20.0)
var option = optionPattern match {
    case Some(v) => v
    case None => 0.0
}
assert(option == optionPattern.getOrElse(0.0))

optionPattern = None
option = optionPattern match {
    case Some(v) => v
    case None => 0.0
}
assert(option == 0.0)

// extract value by treating it as collection
var number: Option[Int] = Some(3)
var noNumber: Option[Int] = None
var result1 = number.map(_ * 1.5)
var result2 = noNumber.map(_ * 1.5)

assert(result1 == Some(4.5))
assert(result2 == None)

number.foreach{ x => println(s"Got ${x} from option") }
noNumber.foreach{ x => println(s"Got ${x} from option") }

number = Some(3)
noNumber = None
// add each values using 1 as the strating point
val foldResult1 = number.fold(1)(_ + 3)
val foldResult2 = noNumber.fold(1)(_ * 3)

assert(foldResult1 == 6)
assert(foldResult2 == 1)