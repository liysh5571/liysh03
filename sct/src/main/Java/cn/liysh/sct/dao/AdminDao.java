package cn.liysh.sct.dao;

import cn.liysh.sct.entity.Admin;
import cn.liysh.sct.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
/*
* 会使用DBUtils工具类
*/
public class AdminDao {
    public void add(Admin admin)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="insert into admin(admName,userName,userPwd) values(?,?,?)";
        queryRunner.update(sql,admin.getAdmName(),admin.getUserName(),admin.getUserPwd());
    }
    public void delete(Integer admId) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="delete from admin where admId=?";
        queryRunner.update(sql,admId);
    }
    public void update(Admin admin) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="update admin set admName=?,userName=?,userPwd=? where admId=?";
        queryRunner.update(sql,admin.getAdmName(),admin.getUserName(),admin.getUserPwd(),admin.getAdmId());
    }
    public List<Admin> list(Admin admin)throws SQLException{   //真的要传参数吗
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from admin";
        List<Admin> list=queryRunner.query(sql,new BeanListHandler<>(Admin.class));
        return list;
    }
    public Admin findById(Integer admId)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from admin where admId=?";
        Admin admin=queryRunner.query(sql,new BeanHandler<>(Admin.class),admId);
        return admin;
    }
    public Admin login(Admin admin)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from admin where admName=? and userPwd=?";
        Admin entity=queryRunner.query(sql,new BeanHandler<>(Admin.class),admin.getAdmName(),admin.getUserPwd());
        return entity;
    }
}
