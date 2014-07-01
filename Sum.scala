class Sum (val augend: Money, val addend: Money) extends Expression {

  def reduce(to: String) = new Money(augend.amount + addend.amount, to)

}
