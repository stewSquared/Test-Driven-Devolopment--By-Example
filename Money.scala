class Money(protected val amount: Int, val currency: String) {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount && currency == money.currency
    case _ => throw new ClassCastException
  }

  override def toString = amount + " " + currency

  def times(multiplier: Int): Money = new Money(amount * multiplier, currency)

}

object Money {

  def dollar(amount: Int): Money = new Dollar(amount, "USD")
  def franc(amount: Int): Money = new Franc(amount, "CHF")

}
