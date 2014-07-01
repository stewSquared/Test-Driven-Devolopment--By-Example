import org.specs2.mutable._

class MoneySpec extends Specification {
  "When multiplied by n, the amount of the yielded money object" should {

    val fiveDollars = Money.dollar(5)

    "equal the original money object's amount * n" in {
      fiveDollars times 2 mustEqual Money.dollar(10)
      fiveDollars times 3 mustEqual Money.dollar(15)
    }
  }

  "A comparison of two money objects" should {
    "show them to be equal iff they have the same amount" in {
      Money.dollar(5) mustEqual Money.dollar(5)
      Money.dollar(5) mustNotEqual Money.dollar(6)
    }
    "show two units of differing currency to be unequal" in {
      Money.franc(1) mustNotEqual Money.dollar(1)
    }
  }

  "All money denominations" should {
    "have currency" in {
      Money.dollar(1).currency mustEqual "USD"
      Money.franc(1).currency mustEqual "CHF"
    }
  }

  "The addition of money objects" should {
    val bank: Bank = new Bank

    "yield a sum object containing the original objects" in {
      val five: Money = Money.dollar(5)
      val result: Expression = five plus five
      val sum: Sum = result match {
        case s: Sum => s
        case _ => throw new ClassCastException
      }
      //sum.augend mustEqual five and sum.addend mustEqual five
      (five mustEqual sum.augend) and (five mustEqual sum.addend)
    }

    "reduce to 10 dollars from two 5 dollar objects" in {
      val five: Money = Money.dollar(5)
      val sum: Expression = five plus five
      val reduced: Money = bank.reduce(sum, "USD")
      reduced mustEqual Money.dollar(10)
    }
  }

  // If the currencies in the Sum areall the same,
  // and the target currency is also th same, then
  "the result of Bank.reduce(sum)" should {
    "be a money whose amount is the sum of amounts" in {
      val sum: Expression = new Sum(Money.dollar(3), Money.dollar(4))
      val bank: Bank = new Bank
      val result: Money = bank.reduce(sum, "USD")
      result mustEqual Money.dollar(7)
    }
  }

}
