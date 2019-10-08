object VariancesTest extends App {
    abstract class Animal {
        def name: String
        def species: String = "unknown"
        override def toString: String = name
    }

    case class Cat(name: String, override val species: String = "cat") extends Animal
    case class Dog(name: String, override val species: String = "dog") extends Animal

    def covariance(): Unit = {
        def printAnimalNames(animals: List[Animal]): Unit = {
            animals.foreach { animal =>
              println(animal.name)
            }
          }

          val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
          val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
          printAnimalNames(cats)
          printAnimalNames(dogs)
    }

    def contravariance(): Unit = {
        abstract class Printer[-A] {
            def print(value: A): Unit
        }

        class AnimalPrinter extends Printer[Animal] {
            def print(animal: Animal): Unit =
                println(s"The ${animal.species}'s name: $animal")
        }

        class CatPrinter extends Printer[Cat] {
            def print(cat: Cat): Unit =
              println(s"The ${cat.species}'s name: $cat")
        }

        val cat: Cat = Cat("Puss")
        def printCat(catPrinter: Printer[Cat]): Unit = {
            catPrinter.print(cat)
        }

        val catPrinter: Printer[Cat] = new CatPrinter
        val animalPrinter: Printer[Animal] = new AnimalPrinter
        printCat(catPrinter)
        printCat(animalPrinter)
    }

    def invariance(): Unit = {
        class Container[A](value: A) {
            private var _value: A = value
            def getValue: A = _value
            def setValue(value: A): Unit = {
                _value = value
                value match {
                    case animal: Animal => println(s"The ${animal.species}'s name: $animal")
                    case other => println(s"The object's name: $value")
                }
            }
        }

        val catContainer: Container[Cat] = new Container(Cat("Felix"))
        val animalContainer: Container[Animal] = new Container(Dog("Bruno"))
        animalContainer.setValue(Cat("Sion"))
    }

    covariance()
    contravariance()
    invariance()
}