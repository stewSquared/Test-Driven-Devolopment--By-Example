import org.specs2.mutable._

class MoneySpec extends Specification {
  "The amount of five dollars" should {
    "equal 10 after it's multiplied by 2" in {
      val five = new Dollar(5)
      five times 2
      five.amount mustEqual 10
    }
  }
}
