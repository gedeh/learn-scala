class Employee {
  var firstName: String = ""
  var lastName: String = ""

  override def toString: String = s"$firstName $lastName"
}

val bob = new Employee
bob.firstName = "Bob"
bob.lastName = "Martin"

bob

bob.firstName = "Jane"
bob.lastName = "Doe"

bob