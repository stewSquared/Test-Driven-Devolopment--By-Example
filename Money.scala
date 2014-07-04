class Money(val amount: Int, val currency: String)
    extends Expression {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount && currency == money.currency
    case _ => throw new ClassCastException
  }

  override def toString = amount + " " + currency

  def times(multiplier: Int): Expression =
    new Money(amount * multiplier, currency)

  def plus(addend: Expression): Expression =
    new Sum(this, addend)

  def reduce(bank: Bank, to: String) = {
    val rate = bank.rate(currency, to)
    new Money(amount / rate, to)
  }
}

object Money {

  def dollar(amount: Int): Money = new Money(amount, "USD")

  def franc(amount: Int): Money = new Money(amount, "CHF")

}
