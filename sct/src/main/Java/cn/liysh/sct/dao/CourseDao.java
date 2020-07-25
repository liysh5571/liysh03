package cn.liysh.sct.dao;



import cn.liysh.sct.entity.Course;
import cn.liysh.sct.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDao {
    public void add(Course course)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="insert into Course(cName,id) values(?,?)";
        queryRunner.update(sql,course.getcName(),course.getId());
    }
    public void delete(Integer cId) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="delete from course where cId=?";
        queryRunner.update(sql,cId);
    }
    public void update(Course course) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="update Course set cName=?,id=? where cId=?";
        queryRunner.update(sql,course.getcName(),course.getId(),course.getcId());
    }
    public List<Course> list(Course course)throws SQLException{    //真的要传参数吗
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from Course";
        List<Course> list=queryRunner.query(sql,new BeanListHandler<>(Course.class));
        return list;
    }
    public Course findById(Integer cId)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from Course where cId=?";
        Course course=queryRunner.query(sql,new BeanHandler<>(Course.class),cId);
        return course;
    }
}
