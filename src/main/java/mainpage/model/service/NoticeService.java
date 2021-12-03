package mainpage.model.service;

import mainpage.model.dao.NoticeDao;
import mainpage.model.vo.Notice;

import static com.otlb.semi.common.JdbcTemplate.getConnection;
import static com.otlb.semi.common.JdbcTemplate.close;
import java.sql.Connection;
import java.util.List;


public class NoticeService {
 NoticeDao noticeDao = new NoticeDao(); 

 // 공지사항 조회
	public List<Notice> selectContent() {
		
		Connection conn = getConnection();
		List<Notice> notice = noticeDao.selectContent(conn);
		close(conn);
		
		return notice;
	}

}
