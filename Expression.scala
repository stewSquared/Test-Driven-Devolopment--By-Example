trait Expression {

  def reduce(bank: Bank, to: String): Money

  def plus(addend: Expression): Expression

}
