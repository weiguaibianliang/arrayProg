package JAVA8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestStreamDate {
    @Test
    public void test01(){
        //创建指定日期
        LocalDate fj = LocalDate.of(1985,9,23);
        System.out.println("fj="+fj);
        //得到当前时间
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate="+nowDate);
        //获取日期时间
        System.out.println("年："+nowDate.getYear());
        System.out.println("月"+nowDate.getMonth());
        System.out.println("月"+nowDate.getMonthValue());
        System.out.println("日"+nowDate.getDayOfMonth());
        System.out.println("星期"+nowDate.getDayOfWeek());
        System.out.println("星期"+nowDate.getDayOfWeek().getValue());
    }

    @Test
    public void test02(){
        //日期时间的修改
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now="+now);
        //修改日期时间
        LocalDateTime setYear = now.withYear(2078);
        System.out.println("修改年份："+setYear);
        System.out.println("now == setYear:"+ (now == setYear));
        System.out.println("修改月份："+ now.withMonth(6));
        System.out.println("修改小时："+ now.withHour(9));
        System.out.println("修改分钟："+now.withMinute(11));
        //在当前对象的基础上加上或减去指定的时间
        //加5天，返回新对象
        LocalDateTime localDateTime = now.plusDays(5);
        System.out.println("5天后："+localDateTime);
        System.out.println("now == localDateTime:"+(now == localDateTime));
        System.out.println("10年后："+now.plusYears(10));
        System.out.println("20个月后"+now.plusMonths(20));
        System.out.println("20年前"+now.minusYears(20));
        System.out.println("5月前"+now.minusMonths(5));
        System.out.println("100天前："+now.minusDays(100));
    }

    @Test
    public void test03(){
        //日期时间的比较
        //LocalDate类中使用isBefore()、isAfter()、equals()方法来比较两个日期，可直接进行比较。
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2018,8,8);
        System.out.println(now.isBefore(date));
        System.out.println(now.isAfter(date));
        System.out.println(now.equals(date));
    }

    @Test
    //时间格式化
    public void test04(){
        //得到当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now ="+ now);
        //将日期时间格式化为字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(formatter);
        System.out.println("format = " + format);
        //将字符串解析为日期时间
        LocalDateTime dateTime = LocalDateTime.parse("1985-09-23 10:12:22",formatter);
        System.out.println("dateTime = " + dateTime);
    }

    @Test
    //Duration/Period类：计算日期时间差
    public void test05(){
        //Duration:计算2个时间（LocalTime,时分秒）的距离
        LocalTime now = LocalTime.now();
        LocalTime ofTime = LocalTime.of(22,42,0);
        Duration duration = Duration.between(ofTime,now);
        System.out.println("相差的天数="+duration.toDays());
        System.out.println("相差的小时数="+duration.toHours());
        System.out.println("相差的分钟数="+duration.toMinutes());

        //Period:计算2个日期（LocalDate.年月日）的距离
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.of(2021,3,3);
        Period between = Period.between(date1,date);
        System.out.println("相差的年 ="+between.getYears());
        System.out.println("相差的月 =" + between.getMonths());
        System.out.println("相差的天 =" + between.getDays());
    }

    @Test
    //时间矫正器
    public void test06(){
        LocalDateTime now = LocalDateTime.now();
        //将日期调整到下个月的第一天
        TemporalAdjuster adjuster = temporal -> {
            LocalDateTime temporal1 = (LocalDateTime) temporal;
            return temporal1.plusMonths(1).withDayOfMonth(1);
        };
        LocalDateTime localDateTime = now.with(adjuster);
        System.out.println("localDateTime ="+localDateTime);
    }
}
