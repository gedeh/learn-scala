class Point(x: Int, y: Int) {
  override def toString(): String = "(" + x + ", " + y + ")"
}

val pt = new Point(1, 2)
println(s"Point is: ${pt}")

class ClassWithValParameter(val name: String)

val aClass = new ClassWithValParameter("Gandalf")
assert(aClass.name == "Gandalf")