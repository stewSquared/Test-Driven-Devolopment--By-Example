import collection.mutable.HashMap

class Bank {

  private val rates = new HashMap[Pair, Int]

  class Pair(val from: String, val to: String) {

    override def equals(that: Any) = that match {
      case pair: Pair => from.equals(pair.from) && to.equals(pair.to)
      case _ => throw new ClassCastException
    }

    override def hashCode() = 0
  }

  def reduce(source: Expression, to: String) = source.reduce(this, to)

  def rate(from: String, to: String) = 
    if (from.equals("CHF") && to.equals("USD")) 2 else 1

  def addRate(from: String, to: String, rate: Int) = ???
}
