class Sum (val augend: Expression, val addend: Expression) extends Expression {

  def reduce(bank: Bank, to: String) = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }

  def plus(addend: Expression): Expression =
    new Sum(this, addend)

  def times(multiplier: Int) =
    new Sum(augend times multiplier, addend times multiplier)
}
