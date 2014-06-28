class Franc(amount: Int) extends Money(amount){

  def times(multiplier: Int) = new Franc(amount * multiplier)

}
