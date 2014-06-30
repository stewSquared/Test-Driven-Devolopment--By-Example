class Franc(amount: Int, val currency: String) extends Money(amount){

  def times(multiplier: Int): Money = new Franc(amount * multiplier)

}
