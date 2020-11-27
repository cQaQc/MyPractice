package mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("all")
public class Bookes {

  private long bookId;
  private String bookName;
  private long bookCounts;
  private String detail;
  private List<Admins> admins;

}
