class Dollar(private val amount: Int) {

  def times(multiplier: Int) = new Dollar(amount * multiplier)

  override def equals(that: Any) = that match {
    case dollar: Dollar => amount == dollar.amount
    case _ => throw new ClassCastException
  }

}
