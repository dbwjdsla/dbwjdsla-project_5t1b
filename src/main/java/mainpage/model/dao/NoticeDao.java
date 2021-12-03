package mainpage.model.dao;

import static com.otlb.semi.common.JdbcTemplate.close;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mainpage.model.vo.Notice;

public class NoticeDao {

	private Properties prop = new Properties();

	public NoticeDao() {
		File file = new File(NoticeDao.class.getResource("/main-query.prop").getPath());

		try {
			prop.load(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 공지사항 조회
	public List<Notice> selectContent(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeSelect");
		ResultSet rset = null;
		List<Notice> notice = new ArrayList<>();
		Notice list = null;
		
		try {
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			list = new Notice(); 
			list.setTitle(rset.getString("TITLE"));
			list.setTitle(rset.getString("CONTENT"));
			notice.add(list);
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

}
