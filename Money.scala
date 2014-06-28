class Money(protected val amount: Int) {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount
    case _ => throw new ClassCastException
  }

}
