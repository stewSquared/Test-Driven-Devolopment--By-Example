import org.specs2.mutable._

class MoneySpec extends Specification {
  "A five dollar object" should {

    val five = new Dollar(5)

    // test multiplication
    "equal 10 after it's multiplied by 2" in {
      five times 2 mustEqual new Dollar(10)
    }

    "equal 10 after it's multiplied by 2" in {
      five times 3 mustEqual new Dollar(15)
    }

    // test equality
    "be equivalent to another five dollar object" in {
      five mustEqual new Dollar(5)
    }

    "not be equivalent to a six dollar object" in {
      five mustNotEqual new Dollar(6)
    }
  }
}
