import org.specs2.mutable._

class MoneySpec extends Specification {
    val five: Money = Money.dollar(5)
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank: Bank = new Bank
    bank.addRate("CHF", "USD", 2)

  "When an expression is multiplied by n, the result" should {
    "equal the original Money's amount * n" in {
      fiveBucks times 2 mustEqual Money.dollar(10)
    }

    "equal the original Expression's reduced amount * n" in {
      val sum: Expression = new Sum(fiveBucks, tenFrancs) times 2
      val result: Money = bank.reduce(sum, "USD")
      result mustEqual Money.dollar(20)
    }
  }

  "A comparison of two money objects" should {
    "show them to be equal iff they have the same amount/currency" in {
      (Money.dollar(5) mustEqual Money.dollar(5)) &&
      (Money.dollar(5) mustNotEqual Money.dollar(6))
    }

    "show two units of differing currency to be unequal" in {
      Money.franc(1) mustNotEqual Money.dollar(1)
    }
  }

  "All money denominations" should {
    "have currency" in {
      (Money.dollar(1).currency mustEqual "USD") &&
      (Money.franc(1).currency mustEqual "CHF")
    }
  }

  "The sum of two expressions" should {
    "contain the original objects as addend and augend" in {
      val result: Expression = five plus five
      val sum: Sum = result match {
        case s: Sum => s
        case _ => throw new ClassCastException
      }
      (five mustEqual sum.augend) and (five mustEqual sum.addend)
    }

    "reduce to 10 dollars from two 5 dollar objects" in {
      val sum: Expression = five plus five
      val reduced: Money = bank.reduce(sum, "USD")
      reduced mustEqual Money.dollar(10)
    }

    "reduce to 10 dollars from 5 dollars and 10 francs" in {
      val result: Money = bank.reduce(fiveBucks plus tenFrancs, "USD")
      result mustEqual Money.dollar(10)
    }

    "reduce properly from a sum and money object" in {
      val sum: Expression = new Sum(fiveBucks, tenFrancs) plus fiveBucks
      val result: Money = bank.reduce(sum, "USD")
      result mustEqual Money.dollar(15)
    }

  }

  // If the currencies in the Sum areall the same,
  // and the target currency is also th same, then
  "the result of Bank.reduce(Sum)" should {
    "be a Money whose amount is the sum of amounts" in {
      val sum: Expression = new Sum(Money.dollar(3), Money.dollar(4))
      val bank: Bank = new Bank
      val result: Money = bank.reduce(sum, "USD")
      result mustEqual Money.dollar(7)
    }
  }

  "A new bank" should {
    "reduce 2 CHF to 1 USD if the exchange rate is 2:1" in {
      val rate = 2
      val bank = new Bank
      bank.addRate("CHF", "USD", 2)
      val result: Money = bank.reduce(Money.franc(2), "USD")
      result mustEqual Money.dollar(1)
    }

    "reduce 1 USD to 1 USD" in {
      val result: Money = (new Bank).reduce(Money.dollar(1), "USD")
      result mustEqual Money.dollar(1)
    }

    " return a rate of 1 for identical currencies" in {
      ((new Bank).rate("USD", "USD") mustEqual 1) &&
      ((new Bank).rate("EUR", "EUR") mustEqual 1)
    }
  }
}
