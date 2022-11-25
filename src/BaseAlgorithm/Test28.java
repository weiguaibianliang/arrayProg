package BaseAlgorithm;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Test28 {
    public static void main(String[] args) {
        //获取时间戳
        long milliseconds = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        //将时间戳转为当前时间
        LocalDate localDate = Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        //输出当前时间
        System.out.println(localDate);
        System.out.println(milliseconds);

    }
}
