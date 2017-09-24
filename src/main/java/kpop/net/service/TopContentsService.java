package kpop.net.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;


import kpop.net.dto.MovieDto;
//import kpop.net.dto.TagDto;

/**
 * TOPページに表示するコンテンツを取得するサービス
 * @author shotaro
 *
 */
public class TopContentsService {
	// ====================================================
	//                                         DI
	//                                        =============
	@Resource
	protected JdbcManager jdbcManager;
	
	// ====================================================
	//                                         定数
	//                                        =============
	
	// ====================================================
	//                                         処理
	//                                        =============
	
	/**
	 * 新着動画を取得
	 * @param
	 * @return newMovieDtoList
	 */
	public MovieDto getNewMovieDtoList(){
		Connection con = null;
		MovieDto newMovieDtoList = new MovieDto();
		try{
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://http://59.106.214.173/:3306/null", "root", "1man1sh1");
			System.out.println("MySQLに接続できました。");

			Statement stm = con.createStatement();
			String sql = "select * from movie";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()){
				//MovieDto movie = new MovieDto();
				//String name = rs.getString("name");
				newMovieDtoList.movieId = rs.getString("group_id");
				//System.out.println("取得結果 -> " + id );
				//newMovieDtoList.add(movie);
			}
			
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
		return newMovieDtoList;

	}
	
	/**
	 * 人気動画を取得
	 * @param
	 * @return rankMovieDtoList
	 */
	public List<MovieDto> getRankMovieDtoList(){
		return jdbcManager
				.from(MovieDto.class)
				.getResultList();
	}
	
	

	
	
}
