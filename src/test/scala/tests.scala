import org.specs2.mutable._

class MoneySpec extends Specification {
  "A five dollar object" should {

    val five = new Dollar(5)

    // test multiplication, immutability
    "equal n*5 Dollars after it's multiplied by n" in {
      five times 2 mustEqual new Dollar(10)
      five times 3 mustEqual new Dollar(15)
    }

    // test equality
    "only be equivalent to another five dollar object" in {
      five mustEqual new Dollar(5)
      five mustNotEqual new Dollar(6)
    }
  }

  "A five franc object" should {

    val five = new Franc(5)

    // test multiplication, immutability
    "equal n*5 Francs after it's multiplied by n" in {
      five times 2 mustEqual new Franc(10)
      five times 3 mustEqual new Franc(15)
    }

    // test equality
    "only be equivalent to another five franc object" in {
      five mustEqual new Franc(5)
      five mustNotEqual new Franc(6)
    }
  }
}
