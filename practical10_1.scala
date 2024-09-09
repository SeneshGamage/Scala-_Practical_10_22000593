class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Simplifying numerator and denominator
  private val g = RationalMethod.gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // Negation method to return a negated rational number
  def neg: Rational = RationalMethod.negate(this)

  override def toString: String = if (denom == 1) s"$numer" else s"$numer/$denom"
}

object RationalMethod {
  // Method to compute the greatest common divisor
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  // Method to negate a Rational number
  def negate(r: Rational): Rational = new Rational(-r.numer, r.denom)
}

object MainMethod {
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    println(x.neg)  // Output: -3/4
  }
}

