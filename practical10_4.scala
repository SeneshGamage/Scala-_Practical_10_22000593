import scala.io.StdIn._

class Account(val id: String, private var balance: Double) {

  // Check if the balance is negative
  def isNegative: Boolean = balance < 0

  // Deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  // Withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  // Get current balance
  def getBalance: Double = balance

  // Apply interest based on balance
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // 5% interest for positive balance
    } else {
      balance += balance * 0.1  // 10% overdraft interest for negative balance
    }
  }

  override def toString: String = s"Account($id, balance: $$${balance})"
}

// Bank class to manage a list of accounts
class Bank(accounts: List[Account]) {

  // List of Accounts with negative balances
  def accountsWithNegativeBalance: List[Account] = accounts.filter(_.isNegative)

  // Calculate the sum of all account balances
  def sumOfAllBalances: Double = accounts.map(_.getBalance).sum

  // Calculate the final balances after applying the interest function
  def applyInterestToAllAccounts(): Unit = accounts.foreach(_.applyInterest())

  // Display all accounts
  def displayAccounts(): Unit = accounts.foreach(println)
}

// Usage example with user input
object BankModel extends App {

  // Function to create accounts by taking user input
  def createAccounts(num: Int): List[Account] = {
    (1 to num).map { i =>
      println(s"Enter account ID for account $i:")
      val id = readLine()

      println(s"Enter initial balance for account $i:")
      val balance = readLine().toDouble

      new Account(id, balance)
    }.toList
  }

  // Get the number of accounts to be created
  println("How many accounts do you want to create?")
  val numberOfAccounts = readLine().toInt

  // Create accounts based on user input
  val accounts = createAccounts(numberOfAccounts)

  // Create a Bank instance
  val bank = new Bank(accounts)

  // List of Accounts with negative balances
  val negativeBalanceAccounts = bank.accountsWithNegativeBalance
  println("Accounts with negative balance:")
  negativeBalanceAccounts.foreach(println)

  // Calculate the sum of all account balances
  val totalBalance = bank.sumOfAllBalances
  println(s"Total balance of all accounts: $$${totalBalance}")

  // Apply interest and display updated accounts
  bank.applyInterestToAllAccounts()
  println("Accounts after applying interest:")
  bank.displayAccounts()
}
