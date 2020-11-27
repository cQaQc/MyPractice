package mybatis.pojo;

import lombok.Data;

/**
 *作者: 柯神_
 *时间: 15:09
 *日期: 2020/11/9
 *User: 蜘蛛啊全是腿儿
**/
@Data
public class Admins {

  private long adminId;
  private String adminName;
  private String adminPassword;
  private Bookes bookes;

  public Admins() {
  }

  public Admins(long adminId, String adminName, String password, Bookes bookes) {
    this.adminId = adminId;
    this.adminName = adminName;
    this.adminPassword = password;
    this.bookes = bookes;
  }
}
