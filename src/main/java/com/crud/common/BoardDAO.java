package com.crud.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import javax.swing.tree.TreePath;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
public void setTemplate(JdbcTemplate template) {
this.jdbcTemplate = template;
}


	private final String BOARD_INSERT = "insert into BOARD2 (title, singer, genre, writer, composer, releaseD, label, addD, seq) values (?,?,?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD2 set title=?, singer=?, genre=?, writer=?, composer=?, releaseD=?, label=?, addD=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD2  where seq=?";
	private final String BOARD_GET = "select * from BOARD2  where seq=?";
	private final String BOARD_LIST = "select * from BOARD2 order by seq desc";


	public int insertBoard(BoardVO vo) {

		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getSinger(), vo.getGenre(), vo.getWriter(), vo.getComposer(), vo.getReleaseD(), vo.getLabel(), vo.getAddD(), vo.getSeq());
	}
	// 글 삭제
	public int deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_DELETE, id);
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getSinger(), vo.getGenre(), vo.getWriter(), vo.getComposer(), vo.getReleaseD(), vo.getLabel(), vo.getAddD(), vo.getSeq());

	}	
	
	public BoardVO getBoard(int seq) {
		return jdbcTemplate.queryForObject(BOARD_GET,
				new BeanPropertyRowMapper<BoardVO>(BoardVO.class),
				seq);
	}


	public List<BoardVO> getBoardList(){
		return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>(){
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setSeq(rs.getInt("seq"));
			data.setTitle(rs.getString("title"));
				data.setSinger(rs.getString("singer"));
				data.setGenre(rs.getString("genre"));
				data.setWriter(rs.getString("writer"));
				data.setComposer(rs.getString("composer"));
				data.setReleaseD(rs.getString("releaseD"));
				data.setAddD(rs.getString("addD"));
				data.setLabel(rs.getString("label"));

			return data;

			}
		});
	}

	}

