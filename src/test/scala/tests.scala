import org.specs2.mutable._

class MoneySpec extends Specification {
  "When multiplied by n, the amount of the yielded money object" should {

    val fiveDollars: Money = Money.dollar(5)
    val fiveFrancs = new Franc(5)

    "equal [the original money's amount] * n" in {
      fiveDollars times 2 mustEqual Money.dollar(10)
      fiveDollars times 3 mustEqual Money.dollar(15)

      fiveFrancs times 2 mustEqual new Franc(10)
      fiveFrancs times 3 mustEqual new Franc(15)
    }
  }

  "A comparison of two money objects" should {
    "show dollars to be equal iff they have the same amount" in {
      Money.dollar(5) mustEqual Money.dollar(5)
      Money.dollar(5) mustNotEqual Money.dollar(6)
    }
    "show francs to be equal iff they have the same amount" in {
      new Franc(5) mustEqual new Franc(5)
      new Franc(5) mustNotEqual new Franc(6)
    }
    "show two units of differing currency to be unequal"
    "yield false if they are not the same currency, but share the same amount" in {
      new Franc(1) mustNotEqual Money.dollar(1)
    }
  }
}
