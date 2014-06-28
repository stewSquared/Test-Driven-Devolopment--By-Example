class Dollar(amount: Int) extends Money(amount) {

  def times(multiplier: Int) = new Dollar(amount * multiplier)

}
