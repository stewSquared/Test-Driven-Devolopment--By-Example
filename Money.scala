class Money(protected val amount: Int, val currency: String)
    extends Expression {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount && currency == money.currency
    case _ => throw new ClassCastException
  }

  override def toString = amount + " " + currency

  def times(multiplier: Int) = new Money(amount * multiplier, currency)

  def plus(addend: Money): Expression = new Money(amount + addend.amount, currency)

}

object Money {

  def dollar(amount: Int): Money = new Money(amount, "USD")
  def franc(amount: Int): Money = new Money(amount, "CHF")

}
