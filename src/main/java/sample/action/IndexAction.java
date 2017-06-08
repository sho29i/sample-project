/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package sample.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.seasar.struts.annotation.Execute;



public class IndexAction {

	@Execute(validator = false)
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

		return "index.jsp";
	}
}

