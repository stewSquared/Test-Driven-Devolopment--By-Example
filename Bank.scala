class Bank {

  def reduce(source: Expression, to: String): Money = source match {
    case sum: Sum => sum reduce to
    case _ => throw new ClassCastException
  }

}
