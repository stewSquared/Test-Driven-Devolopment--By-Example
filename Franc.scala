class Franc(amount: Int) extends Money(amount){

  val currency = "CHF"

  def times(multiplier: Int): Money = new Franc(amount * multiplier)

}
