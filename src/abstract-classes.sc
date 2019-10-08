abstract class Employee {
  val first: String
  val last: String
}

class Company(val name: String) {
  override def toString: String = s"$name"
}

class SalaryMan(firstName: String,
                lastName: String,
                company: Company) extends Employee {
  override val first = firstName
  override val last = lastName
  override def toString: String = s"$first $last work for $company"
}

val japanese = new SalaryMan(
  "Kotaro",
  "Minami",
  new Company("Gorgom"))
