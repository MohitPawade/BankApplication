class AccountDetails {
    var accountBalance : Int = 0
    val money = (1..1000).random()
    var output: Int = 0

    fun withdraw(amount: Int) : Int {

        output = amount
        accountBalance -= amount
        println("Amount withdrawn: $amount,\nUpdated account balance is $accountBalance")

        return amount
    }

    fun debitWithdraw(amount : Int): Int{
        if(accountBalance == 0 || amount > accountBalance){
            println("Insufficient Balance to withdraw \nAccount Balance: $accountBalance")
            return 0;
        }

        return withdraw(amount);
    }

    fun deposit(amount :Int ) : Int {
        output = amount
        accountBalance += amount
        println("Amount deposited: $amount,\nUpdated account balance is $accountBalance")

        return amount
    }

    fun creditDeposit(amount : Int) : Int{
        if(accountBalance ==0){
            println("No need to deposit as balanced due is $accountBalance")
            return 0
        }

        if((accountBalance+amount) > 0){
            println("Deposit failed. AccountBalance : $accountBalance")
            return 0
        }

        if(amount == -accountBalance){
            accountBalance = 0
            println("You have paid off this account!")
            return accountBalance
        }else{
            return deposit(amount)
        }
    }

    fun transfer(accountType: String, mode: String, transferAmount : Int) {

        when(mode) {
            "Withdraw" -> {
                if(accountType == "DEBIT"){
                    debitWithdraw(transferAmount)
                } else {
                    withdraw(transferAmount)
                }
            }
            "Credit" -> {
                if(accountType == "CREDIT"){
                    creditDeposit(transferAmount)
                } else {
                    deposit(transferAmount)
                }
            }
            else -> println("Invalid mode")
        }


    }

}