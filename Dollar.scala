class Dollar(amount: Int, currency: String) extends Money(amount, currency) {

  override def times(multiplier: Int): Money = new Dollar(amount * multiplier, currency)

}
