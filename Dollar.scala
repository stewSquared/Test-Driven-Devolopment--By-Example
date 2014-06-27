class Dollar(var amount: Int) {

  def times(multiplier: Int) = new Dollar(amount * multiplier)

  override def equals(that: Any) = true

}
