package  databaseConnection {

  import java.sql.Connection
  import java.sql.DriverManager

  class connectToSomeBank{
    def connection(): Connection = {
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost/someBank"
      val userName = "root"
      val psswd = ""
      var connection: Connection = null

      Class.forName(driver)
      connection = DriverManager.getConnection(url, userName, psswd)
      connection
    }
  }

}