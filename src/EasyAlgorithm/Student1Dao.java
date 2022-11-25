package EasyAlgorithm;

public class Student1Dao {
    //创建Student1Dao类，用来获取学生的平均成绩的工具类
        static Student1 stu;
        static double avg;
        public static double getAvg(Student1 student1){
            stu = student1;
            double cw;
            double en;
            double ma;

            cw = stu.getChinese();
            en = stu.getEnglish();
            ma = stu.getMath();

            avg = (cw + en + ma)/3;
            return avg;
        }
    }
