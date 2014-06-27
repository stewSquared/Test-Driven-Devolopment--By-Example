import org.specs2.mutable._

class MoneySpec extends Specification {
  "The amount of five dollars" should {

    val five = new Dollar(5)

    "equal 10 after it's multiplied by 2" in {
      five times 2
      five.amount mustEqual 10
    }

    "equal 10 after it's multiplied by 2" in {
      five times 3
      five.amount mustEqual 15
    }

  }
}
