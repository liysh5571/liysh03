package cn.liysh.sct.dao;


import cn.liysh.sct.entity.Student;
import cn.liysh.sct.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    public void add(Student student)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="insert into stu(stuName,stuNo,stuPwd) values(?,?,?)";
        queryRunner.update(sql,student.getStuName(),student.getStuNo(),student.getStuPwd());
    }
    public void delete(Integer stuId) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="delete from stu where stuId=?";
        queryRunner.update(sql,stuId);
    }
    public void update(Student student) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="update stu set stuName=?,stuNo=?,stuPwd=? where stuId=?";
        queryRunner.update(sql,student.getStuName(),student.getStuNo(),student.getStuPwd(),student.getStuId());
    }
    public List<Student> list(Student student)throws SQLException{    //真的要传参数吗
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from stu";
        List<Student> list=queryRunner.query(sql,new BeanListHandler<>(Student.class));
        return list;
    }
    public Student findById(Integer stuId)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from stu where stuId=?";
        Student student=queryRunner.query(sql,new BeanHandler<>(Student.class),stuId);
        return student;
    }
    public Student login(String stuNo,String stuPwd)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select *from stu where stuNo=? and stuPwd=?";
        Student student=queryRunner.query(sql,new BeanHandler<>(Student.class),stuNo,stuPwd);
        return student;
    }
}
