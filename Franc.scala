class Franc(amount: Int, val currency: String) extends Money(amount){

  def times(multiplier: Int): Money = Money.franc(amount * multiplier)

}
