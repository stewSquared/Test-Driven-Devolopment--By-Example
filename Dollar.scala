class Dollar(amount: Int) extends Money(amount) {

  val currency = "USD"

  def times(multiplier: Int): Money = new Dollar(amount * multiplier)

}
