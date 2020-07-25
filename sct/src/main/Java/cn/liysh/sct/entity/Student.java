package cn.liysh.sct.entity;

public class Student {
    private Integer stuId;
    private String stuName;
    private String StuNo;
    private String stuPwd;


    public Integer getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuNo() {
        return StuNo;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public void setStuNo(String stuNo) {
        StuNo = stuNo;
    }
    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }
}
