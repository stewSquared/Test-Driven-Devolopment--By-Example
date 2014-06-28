class Franc(amount: Int) extends Money(amount){

  def times(multiplier: Int) = new Franc(amount * multiplier)

  override def equals(that: Any) = that match {
    case franc: Franc => amount == franc.amount
    case _ => throw new ClassCastException
  }

}
