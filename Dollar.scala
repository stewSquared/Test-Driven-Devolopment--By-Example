class Dollar(amount: Int) extends Money(amount) {

  def times(multiplier: Int): Money = new Dollar(amount * multiplier)

}
