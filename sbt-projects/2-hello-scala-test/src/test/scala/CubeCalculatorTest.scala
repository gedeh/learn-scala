class CubeCalculatorTest extends org.scalatest.FunSuite {
  test("Cube of 3 is 27") {
    assert(CubeCalculator.cube(3) === 27)
  }
  test("Cube of 0 is 0") {
    assert(CubeCalculator.cube(0) === 0)
  }
}
