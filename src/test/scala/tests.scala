import org.specs2.mutable._

class MoneySpec extends Specification {
  "When multiplied by n, the amount of the yielded money object" should {

    val fiveDollars: Money = Money.dollar(5)
    val fiveFrancs = Money.franc(5)

    "equal [the original money's amount] * n" in {
      fiveDollars times 2 mustEqual Money.dollar(10)
      fiveDollars times 3 mustEqual Money.dollar(15)

      fiveFrancs times 2 mustEqual Money.franc(10)
      fiveFrancs times 3 mustEqual Money.franc(15)
    }
  }

  "A comparison of two money objects" should {
    "show dollars to be equal iff they have the same amount" in {
      Money.dollar(5) mustEqual Money.dollar(5)
      Money.dollar(5) mustNotEqual Money.dollar(6)
    }
    "show francs to be equal iff they have the same amount" in {
      Money.franc(5) mustEqual Money.franc(5)
      Money.franc(5) mustNotEqual Money.franc(6)
    }
    "show two units of differing currency to be unequal"
    "yield false if they are not the same currency, but share the same amount" in {
      Money.franc(1) mustNotEqual Money.dollar(1)
    }
  }

  "All money denominations" should {
    "have currency" in {
      Money.dollar(1).currency mustEqual "USD"
      Money.franc(1).currency mustEqual "CHF"
    }
  }

  "Different Money classes" should {
    "be equal if they have the same currency" in {
      new Money(10, "CHF") mustEqual new Franc(10, "CHF")
    }
  }

}
