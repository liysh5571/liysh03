package cn.liysh.sct.dao;



import cn.liysh.sct.entity.Stucou;
import cn.liysh.sct.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StucouDao {
    public void add(Stucou stucou)throws SQLException {
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="insert into Stucou(stuId,cId,score) values(?,?,?)";
        queryRunner.update(sql,stucou.getStuId(),stucou.getcId(),stucou.getScore());
    }
    public void delete(Integer scId) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="delete from stucou where scId=?";
        queryRunner.update(sql,scId);
    }
    public void update(Stucou stucou) throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource()) ;
        String sql="update Stucou set score=? where scId=?";
        queryRunner.update(sql,stucou.getScore(),stucou.getScId());
    }
    public List<Stucou> list(Stucou stucou)throws SQLException{    //真的要传参数吗
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from Stucou";
        List<Stucou> list=queryRunner.query(sql,new BeanListHandler<>(Stucou.class));
        return list;
    }
    public Stucou findById(Integer scId)throws SQLException{
        QueryRunner queryRunner=new QueryRunner(PropertiesUtils.getDataSource());
        String sql="select * from Stucou where scId=?";
        Stucou Stucou=queryRunner.query(sql,new BeanHandler<>(Stucou.class),scId);
        return Stucou;
    }
}
