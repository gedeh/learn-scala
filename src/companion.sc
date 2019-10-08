// this is singleton
object Application {
  def main(args: Array[String]): Unit = {
    println("Entry point")
    args.foreach(println)
  }
}
Application.main(Array("Hello", "there"))

// this is companion object
object Employee {
  private val departments = Map(
    "HR" -> "Human Resources",
    "IT" -> "Information Technology",
    "RND" -> "Research and Development"
  )

  def apply(name: String, department: String): Employee =
    new Employee(name, departmentName(department))

  def departmentName(code: String): String = departments.getOrElse(
    code,
    "Department code not found"
  )
}

class Employee(val name: String, val department: String) {
  override def toString: String = s"$name from $department"
}

val employeeHr = Employee("John", "HR")
val employeeUnknown = Employee("John", "XY")

// this is companion object and functional object
// object with state and has function to change state
// without modifying its internal state
object EmployeeImmutable {
  def apply(name: String, stock: Int): EmployeeImmutable =
    new EmployeeImmutable(name, stock)
}

class EmployeeImmutable(val name: String, val stock: Int) {
  def awardStock(noOfStocks: Int): EmployeeImmutable =
    EmployeeImmutable(name, stock + noOfStocks)
  override def toString: String = s"$name has stock $stock"
}

var employee = EmployeeImmutable("John", 10)
employee = employee.awardStock(10)
employee