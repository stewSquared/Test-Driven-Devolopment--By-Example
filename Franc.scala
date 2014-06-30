class Franc(amount: Int) extends Money(amount){

  def times(multiplier: Int): Money = new Franc(amount * multiplier)

}
