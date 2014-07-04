class Bank {

  def reduce(source: Expression, to: String) = source.reduce(this, to)

  def rate(from: String, to: String) = 
    if (from.equals("CHF") && to.equals("USD")) 2 else 1

  def addRate(from: String, to: String, rate: Int) = ???

}
