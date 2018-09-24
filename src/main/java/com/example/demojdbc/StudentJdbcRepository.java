package com.example.demojdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Student findById(long id){

        Student student = jdbcTemplate.queryForObject("select * from student where id=?",new Object[] {id},new BeanPropertyRowMapper<Student>(Student.class));
        return student;
    }

    public List<Student> findAll(){
       return jdbcTemplate.query("select * from student", new RowMapper<Student>() {
           @Override
           public Student mapRow(ResultSet resultSet, int i) throws SQLException {
               Student student = new Student();
               student.setId(resultSet.getInt("id"));
               student.setName(resultSet.getString("name"));
               student.setSchool(resultSet.getString("school"));
               return student;
           }
       });
    }

    public int addStudent(Student student){

        int ret = jdbcTemplate.update("insert into student (id, name, school) values (?,?,?)", new Object[]{student.getId(),
        student.getName(), student.getSchool()});
        return ret;
    }

    public int deleteStudent(long id){
        int ret = jdbcTemplate.update("delete from student where id=?", new Object[]{id});
        return ret;
    }

    public int updateStudent(long id, Student student){
        int ret = jdbcTemplate.update("update student set name =?, school=? where id=?", new Object[]{
                student.getName(), student.getSchool(), id});
        return ret;
    }
}
