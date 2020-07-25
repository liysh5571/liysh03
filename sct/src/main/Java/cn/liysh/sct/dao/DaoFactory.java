package cn.liysh.sct.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaoFactory {
    //类似工厂+单例模式
    private static DaoFactory factory=new DaoFactory();
    private Map<String ,Object> map=new ConcurrentHashMap<>();

    private DaoFactory(){

    }
    public static DaoFactory getInstance(){
          return factory;
    }
    public AdminDao getAdminDao(){
        AdminDao dao =(AdminDao)map.get("AdminDao");
        if(dao!=null){
            return dao;
        }else{
            dao=new AdminDao();
            map.put("AdminDao",dao);
        }
       return dao;
    }
    public StudentDao getStudentDao(){
        StudentDao dao=(StudentDao)map.get("StudentDao");
        if(dao!=null){
            return dao;
        }else{
            dao=new StudentDao();
            map.put("StuentDao",dao);
        }
        return dao;
    }
    public CourseDao getCourseDao(){
        CourseDao dao=(CourseDao)map.get("CourseDao");
        if(dao!=null){
            return dao;
        }else{
            dao=new CourseDao();
            map.put("CourseDao",dao);
        }
        return dao;
    }
    public StucouDao getStucouDao(){
        StucouDao dao=(StucouDao)map.get("StucouDao");
        if(dao!=null){
            return dao;
        }else{
            dao=new StucouDao();
            map.put("StucouDao",dao);
        }
        return dao;
    }
    public TeacherDao getTeacherDao(){
        TeacherDao dao=(TeacherDao)map.get("TeacherDao");
        if(dao!=null){
            return dao;
        }else{
            dao=new TeacherDao();
            map.put("TeacherDao",dao);
        }
        return dao;
    }


}
