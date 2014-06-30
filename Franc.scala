class Franc(amount: Int, currency: String) extends Money(amount, currency) {

  override def times(multiplier: Int): Money = new Franc(amount * multiplier, currency)

}
