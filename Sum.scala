class Sum (val augend: Money, val addend: Money) extends Expression {

  def reduce(bank: Bank, to: String) = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
