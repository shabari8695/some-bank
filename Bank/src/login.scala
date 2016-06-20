import check.checkAdmin
import adminAccess.adminPage
object login {
  def main(args: Array[String]) {
    val userName=readLine("Enter User Name: ")
    val password=readLine("Enter Password: ")
    val permission=(new checkAdmin).isAdmin(userName,password)
    if(permission)
      (new adminPage).mainPage(userName)
    else {
      println("Invalid User Name or Password!")
      main(Array(""))
    }
  }
}
