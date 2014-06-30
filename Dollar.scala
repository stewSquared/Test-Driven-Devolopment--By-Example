class Dollar(amount: Int, val currency: String) extends Money(amount) {

  def times(multiplier: Int): Money = Money.dollar(amount * multiplier)

}
