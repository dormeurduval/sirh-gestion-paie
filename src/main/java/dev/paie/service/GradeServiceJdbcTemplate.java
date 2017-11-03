/**
 * 
 */
package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (id,code,nbHeuresBase,tauxBase) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql,nouveauGrade.getId(),nouveauGrade.getCode(),nouveauGrade.getNbHeuresBase()
		,nouveauGrade.getTauxBase());
		
	}


	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade set code=?,nbHeuresBase=?,tauxBase=? where id=?";
		this.jdbcTemplate.update(sql,grade.getCode(),grade.getNbHeuresBase(),grade.getTauxBase(),grade.getId());
	}


	@Override
	public List<Grade> lister() {
		String sql="SELECT * FROM grade";
		return this.jdbcTemplate.query(sql,new GradeMapper());
	}
	
	public class GradeMapper implements RowMapper<Grade>{

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		@Override
		public Grade mapRow(ResultSet rs, int arg1) throws SQLException {
			Grade grade = new Grade();
			grade.setId(rs.getInt("id"));
			grade.setCode(rs.getString("code"));
			grade.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			grade.setTauxBase(rs.getBigDecimal("tauxBase"));
			return grade;
		}
		
	}
}