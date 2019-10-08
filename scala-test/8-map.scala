// map declaration
var cities = Map("DPS" -> "Denpasar", "BDO" -> "Bandung", "JKT" -> "Jakarta")
assert(cities.size == 3)

// map can't have duplicated key
val citiesDeduped = Map("DPS" -> "Denpasar", "BDO" -> "Bandung", "JKT" -> "Jakarta", "BDO" -> "Kertajati")
assert(citiesDeduped.size == 3)

// adding new element to a map
cities = cities + ("PDG" -> "Padang")
assert(cities.contains("PDG") == true)

// head and last wont change
val cityNames = citiesDeduped.values
assert(cityNames.head == "Denpasar")
assert(cityNames.last == "Jakarta")

// duplicated key replaced with latest
assert(citiesDeduped("BDO") == "Kertajati")

// map keys and values can be mixed type
val mixedMap = Map(1 -> "one", "1" -> "one-string", "one" -> 1)
assert(mixedMap(1) == "one")
assert(mixedMap("1") == "one-string")
assert(mixedMap("one") == 1)

// map using default value
val mapDefaulted = Map( "yes" -> "Yes", "no" -> "No").withDefaultValue("Not sure")
assert(mapDefaulted("umm") == "Not sure")
assert(mapDefaulted.getOrElse("uh", "Dunno") == "Dunno")

// element can be removed by key using "-"
val citiesNoBdo = citiesDeduped - "BDO"
assert(citiesDeduped.contains("BDO") == true)
assert(citiesNoBdo.contains("BDO") == false)
val citiesRemoveNonExistantKeys = cities - "JYP"
assert(cities == citiesRemoveNonExistantKeys)

// elements can be removed by list using "--"
var citiesNoJava = citiesDeduped -- List("JKT", "BDO")
assert(citiesNoJava.contains("BDO") == false)
assert(citiesNoJava.contains("JKT") == false)

// elements can be removed by tuple using "-"
citiesNoJava = citiesDeduped
assert(citiesNoJava.contains("BDO") == true)
assert(citiesNoJava.contains("JKT") == true)
citiesNoJava = citiesDeduped - ("JKT", "BDO")
assert(citiesNoJava.contains("BDO") == false)
assert(citiesNoJava.contains("JKT") == false)
citiesNoJava = citiesDeduped - ("JKT", "JKT") // tuple with duplicated value
assert(citiesNoJava.contains("BDO") == true)
assert(citiesNoJava.contains("JKT") == false)

// map equal regardless key positions
val citiesTryEqual = Map("BDO" -> "Bandung", "DPS" -> "Denpasar", "JKT" -> "Jakarta")
assert(cities == citiesTryEqual)
