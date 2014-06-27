import org.specs2.mutable._

class MoneySpec extends Specification {
  "The amount of five dollars" should {

    val five = new Dollar(5)

    "equal 10 after it's multiplied by 2" in {
      val product: Dollar = five times 2
      product.amount mustEqual 10
    }

    "equal 10 after it's multiplied by 2" in {
      val product: Dollar = five times 3
      product.amount mustEqual 15
    }
  }

  "A five dollar object" should {

    val five = new Dollar(5)

    "be equivalent to another five dollar object" in {
      five mustEqual new Dollar(5)
    }
  }
}
