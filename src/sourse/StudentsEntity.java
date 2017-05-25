package sourse;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zcy on 2017/5/22.
 */
@Entity
@Table(name = "students", schema = "myzcy")
public class StudentsEntity {
    private Integer sid;
    private String sname;
    private String gender;
    private String birthday;
    private String address;
    public  StudentsEntity(Integer sid,String sname,String gender,String birthday,String address)
    {
        this.sid=sid;
        this.sname=sname;
        this.gender=gender;
        this.birthday=birthday;
        this.address=address;
    }

    public StudentsEntity() {
    }


    @Id
    @Column(name = "sid", nullable = false)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = true, length = 20)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 20)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (sname != null ? !sname.equals(that.sname) : that.sname != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
