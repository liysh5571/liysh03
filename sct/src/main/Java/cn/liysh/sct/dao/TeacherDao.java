package cn.liysh.sct.dao;

import cn.liysh.sct.entity.Teacher;
import cn.liysh.sct.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class TeacherDao {
    public void add(Teacher teacher)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="insert into tec(name,userName,userPwd) values(?,?,?)";
        queryRunner.update(sql,teacher.getName(),teacher.getUserName(),teacher.getUserPwd());
    }
    public void delete(Integer id) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="delete from tec where id=?";
        queryRunner.update(sql,id);
    }
    public void update(Teacher teacher) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="update teacher set name=?,userPwd=? where id=?";
        queryRunner.update(sql,teacher.getName(),teacher.getUserPwd(),teacher.getId());
    }
    public List<Teacher> list(Teacher teacher)throws SQLException{  //真的要传参数吗
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from tec";
        List<Teacher> list=queryRunner.query(sql,new BeanListHandler<>(Teacher.class));
        return list;
    }
    public Teacher findById(Integer id)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from teacher where id=?";
        Teacher teacher=queryRunner.query(sql,new BeanHandler<>(Teacher.class),id);
        return teacher;
    }
    public Teacher login(String userName,String userPwd)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from teacher where userName=? and userPwd";
        Teacher teacher=queryRunner.query(sql,new BeanHandler<>(Teacher.class),userName,userPwd);
        return teacher;
    }
}
