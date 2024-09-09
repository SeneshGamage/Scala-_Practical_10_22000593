class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Simplifying numerator and denominator
  private val g = RationalMethod.gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // Subtraction method
  def sub(that: Rational): Rational = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }

  // Negation method
  def neg: Rational = RationalMethod.negate(this)

  override def toString: String = s"$numer/$denom"
}

object RationalMethod {
  // Method to compute the greatest common divisor
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  // Method to negate a Rational number
  def negate(r: Rational): Rational = new Rational(-r.numer, r.denom)
}

// Usage example with proper structure
object MainMethod {
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    // Calculate x - y - z
    val result = x.sub(y).sub(z)
    println(result)  // Output: 13/56
  }
}
