package adminAccess.eligibilityCheck
import adminAccess.eligibilityCheck.getData.getData
import adminAccess.eligibilityCheck.eligibileLoanAmount.allowedAmount

class getUserValues{
  def getValues(): Unit ={
    println("enter customer account balance:")
    val customerAccountBalance=readLine("").toInt
    (new getData).storeALMDetails()
    val loanAmount=(new allowedAmount).getAllowdAmount(customerAccountBalance)
    println("allowed amount for the customer would be around: Rs"+loanAmount)
    println("Thank you for using our service")
  }
}