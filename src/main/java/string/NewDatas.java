package string;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class NewDatas {
    public static void main(String[] args) {

//      LocalDate 只会获取年、月、日、星期几
        LocalDate now = LocalDate.now();
        System.out.println("本地日期：" + now);

        LocalDate now1 = LocalDate.of(1997,12,17);
        System.out.println(now1 + "\t, 星期:" + now1.getDayOfWeek());
        now1 = now1.minusMonths(2);
        now1 = now1.plusDays(6);
        System.out.println(now1 + "\t, 星期:" + now1.getDayOfWeek());

//      LocalTime只会获取时、分、秒、毫秒
        LocalTime time = LocalTime.now();
        LocalTime time1 = LocalTime.of(13,14);
        System.out.println("本地时间：" + time + "\n" + time1);

//      LocalDataTime 获取年、月、日、时、分、秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime +"/"+ localDateTime.getDayOfWeek());


    }
}
