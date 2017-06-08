package sample.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.seasar.struts.annotation.Execute;

public class MysqlAction {
	
	@Execute(validator=false)
	public String index() {
		Connection con = null;
		try{
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1man1sh1");
			System.out.println("MySQLに接続できました。");

			//Statement stm = con.createStatement();
			//String sql = "select * from programing";
			//ResultSet rs = stm.executeQuery(sql);

			//while(rs.next()){
				//int id = rs.getInt("id");
				//String name = rs.getString("name");
				//System.out.println("取得結果 -> " + id + ":" + name);
			//}
			
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}

			}
		}

		return "mysql.jsp";
	}
}
