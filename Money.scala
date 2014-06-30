class Money(protected val amount: Int, val currency: String) {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount &&
      this.getClass() == that.getClass()
    case _ => throw new ClassCastException
  }

  def times(multiplier: Int): Money = new Money(0, "NONE")

}

object Money {

  def dollar(amount: Int): Money = new Dollar(amount, "USD")
  def franc(amount: Int): Money = new Franc(amount, "CHF")

}
