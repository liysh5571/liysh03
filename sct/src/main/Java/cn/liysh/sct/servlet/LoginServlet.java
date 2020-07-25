package cn.liysh.sct.servlet;

import cn.liysh.sct.dao.DaoFactory;
import cn.liysh.sct.entity.Admin;
import cn.liysh.sct.entity.Student;
import cn.liysh.sct.entity.Teacher;
import cn.liysh.sct.utils.MD5;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
         String userName=req.getParameter("userName");
         String password=req.getParameter("password");
         String type=req.getParameter("type");
         if(StringUtils.isBlank(userName)||StringUtils.isBlank(password)||StringUtils.isBlank(type)){
             req.setAttribute("error","录入信息不能为空！");
             req.getRequestDispatcher("/login.jsp").forward(req,resp);
             return;
         }
         HttpSession session=req.getSession();
          if(StringUtils.isNotBlank(type)){
              try {
                  if ("0".equals(type)) {
                      //学生登录验证
                      Student student= DaoFactory.getInstance().getStudentDao().login(userName,MD5.encrypByMd5(MD5.encrypByMd5(password)));
                      if(student!=null){
                          session.setAttribute("user",student);
                          session.setAttribute("type",type);
                          resp.sendRedirect("sct/index.jsp");
                      }else{
                          req.setAttribute("error","用户名或密码错误！");
                          req.getRequestDispatcher("/login.jsp").forward(req,resp);
                      }
                  } else if ("1".equals(type)) {
                      //老师登录验证
                      Teacher teacher=DaoFactory.getInstance().getTeacherDao().login(userName,MD5.encrypByMd5(MD5.encrypByMd5(password)));
                      if(teacher!=null){
                          session.setAttribute("user",teacher);
                          session.setAttribute("type",type);
                          resp.sendRedirect("index.jsp");
                      }else{
                          req.setAttribute("error","用户名或密码错误！");
                          req.getRequestDispatcher("login.jsp").forward(req,resp);
                      }
                  } else {
                      //管理员登录验证
                      Admin admin = new Admin();
                      admin.setAdmName(userName);
                      admin.setUserPwd(MD5.encrypByMd5(MD5.encrypByMd5(password)));
                      Admin entity = DaoFactory.getInstance().getAdminDao().login(admin);
                      if (entity != null) {
                          //执行跳转
                          session.setAttribute("user",entity);
                          session.setAttribute("type",type);
                          resp.sendRedirect("index.jsp");
                      } else {
                          //用户名或密码错误
                          req.setAttribute("error","用户名或密码错误！");
                          req.getRequestDispatcher("login.jsp").forward(req,resp);
                      }
                  }
              }catch(SQLException e){
                  e.printStackTrace();
              }
          }else{

          }
    }
}
