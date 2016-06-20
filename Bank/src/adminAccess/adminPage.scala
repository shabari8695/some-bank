package adminAccess

import adminPage.clientInfo.basicClientDetails
import adminAccess.loanInfo.basicLoanDetails
import adminAccess.generalQuery.basicGeneralQuery
import adminAccess.accountInfo.basicAccountDetails
import adminAccess.eligibilityCheck.getUserValues

class adminOption{
  def customerDetails(userName:String): Unit ={
    (new basicClientDetails).printDetails()
  }

  def loanDetails(userName:String): Unit ={
    (new basicLoanDetails).printDetails()
  }

  def accountDetails(username:String): Unit ={
    (new basicAccountDetails).printDetails()
  }

  def query(userName:String): Unit ={
    print("enter query\n["+userName+"]$")
    val query=readLine()
    (new basicGeneralQuery).printQueryResult(query)
  }
  //currently check for getting data;change it so it will get the page for eligibility check
  def getData(userName:String): Unit ={
    (new getUserValues).getValues
  }

}

class adminPage{
  def mainPage(userName:String): Unit ={

    val adminOperation=new adminOption

    print("Enter Command (customerDetails,loanDetails,accountDetails,specificQuery,eligibility)\n["+userName+"]$")
    val option=readLine()

    if(option=="customerDetails"){
      adminOperation.customerDetails(userName)
    }

    else if(option=="loanDetails"){
      adminOperation.loanDetails(userName)
    }

    else if(option=="accountDetails"){
      adminOperation.accountDetails(userName)
    }

    else if(option=="specificQuery"){
      adminOperation.query(userName)
    }
    else if(option=="eligibility"){
      adminOperation.getData(userName)
    }
    else{
      println("enter valid command")
    }
  }

}