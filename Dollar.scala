class Dollar(var amount: Int) {

  def times(multiplier: Int) = new Dollar(amount * multiplier)

}
