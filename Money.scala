abstract class Money(protected val amount: Int) {

  def currency: String

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount &&
      this.getClass() == that.getClass()
    case _ => throw new ClassCastException
  }

  def times(multiplier: Int): Money

}

object Money {

  def dollar(amount: Int): Money = new Dollar(amount, "USD")
  def franc(amount: Int): Money = new Franc(amount, "CHF")

}
