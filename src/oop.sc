class Employee {
  var firstName: String = ""
  var lastName: String = ""

  override def toString: String = s"$firstName $lastName"
}

val bob = new Employee
bob.firstName = "Bob"
bob.lastName = "Mars"

bob.firstName = "John"
bob.lastName = "Doe"

class EmployeeImmutable(first: String, last: String) {
  override def toString: String = s"$first $last"
}

val bobImmutable = new EmployeeImmutable("Bob", "Martin")
bobImmutable

class EmployeeImmutablePublic(val first: String, private val last: String, private var stock: Int) {
  override def toString: String = s"$first $last: $stock"
  def getLast: String = last
  def bumpStock(add: Int): Unit = stock += add
}

val bobImmutablePublic = new EmployeeImmutablePublic("Bob", "Martin", 0)
bobImmutablePublic.first
bobImmutablePublic.getLast
bobImmutablePublic.bumpStock(10)
bobImmutablePublic
bobImmutablePublic.bumpStock(10)
bobImmutablePublic
