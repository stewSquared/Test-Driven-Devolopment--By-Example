class Franc(amount: Int, currency: String) extends Money(amount, currency) {

  override def times(multiplier: Int): Money = new Money(amount * multiplier, currency)

}
