import scala.io.StdIn._

class Account(private var balance: Double) {

  // Deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. Current balance: $$${balance}")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // Withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. Current balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  // Transfer money from this account to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to the other account.")
    } else {
      println("Transfer failed due to insufficient funds or invalid amount.")
    }
  }

  // Check current balance
  def getBalance: Double = balance
}

// Usage Example
object MoneyTransferMethod {
  def main(args: Array[String]): Unit = {
    // Creating two accounts
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    // Get user input for deposit, withdrawal, and transfer
    println("Enter deposit amount for Account 1:")
    val depositAmount = readLine().toDouble
    account1.deposit(depositAmount)

    println("Enter withdrawal amount for Account 1:")
    val withdrawAmount = readLine().toDouble
    account1.withdraw(withdrawAmount)

    println("Enter transfer amount from Account 1 to Account 2:")
    val transferAmount = readLine().toDouble
    account1.transfer(transferAmount, account2)

    // Display final balances
    println(s"Account 1 Balance: $$${account1.getBalance}")
    println(s"Account 2 Balance: $$${account2.getBalance}")
  }
}
