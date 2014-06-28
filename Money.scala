class Money(protected val amount: Int) {

  override def equals(that: Any) = that match {
    case money: Money => amount == money.amount &&
      this.getClass() == that.getClass()
    case _ => throw new ClassCastException
  }

}
