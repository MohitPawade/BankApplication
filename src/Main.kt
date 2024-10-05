//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var accountType = " "
    var userChoice = 0
    var isSystemOpen = true
    var option = 0
    val accountDetails = AccountDetails()
    println("Welcome to your banking system")
    println("What type of account would you like to create?")
    println("1. Debit account \n2. Credit account \n3. Checking account")

    while(accountType.isNotEmpty()) {

        println("Choose an option (1, 2, or 3)")
        userChoice = (1..5).random()
        println("The selected option is $userChoice")

        when(userChoice) {
            AccountType.DEBIT.accountType -> accountType = "DEBIT"
            AccountType.CREDIT.accountType -> accountType = "CREDIT"
            AccountType.CHECKING.accountType -> accountType = "CHECKING"
            else -> {
                println("Invalid Input")
                continue;
            }
        }

        println("$accountType account created");
        accountDetails.accountBalance = (1..1000).random()
        println("Account Balance: ${accountDetails.accountBalance}")
        println("Amount to be deposited/withdrawn: ${accountDetails.money}")
        break
    }

    while (isSystemOpen){
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()

        println("The selected option is $option")

        when(option){
            1 -> println("The current balance is ${accountDetails.accountBalance}")
            2 -> accountDetails.transfer(accountType,"Withdraw",300)
            3 -> accountDetails.transfer(accountType,"Deposit",300)
            4 -> { isSystemOpen = false
                    println("The system is closed")}
            else -> continue
        }
    }


}