package EasyAlgorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveAverageToStud {
    //主类，用来获取学生的信息和把学生的信息输入到本地文件stud中
        static ArrayList<Student1> list = new ArrayList<>();
        static BufferedWriter out = null;

        public static void main(String[] args) throws Exception{
            getStu();
            saveStu();


        }

        //从键盘获取学生信息
        public static void getStu(){
            Scanner scanner = new Scanner(System.in);
            int count = 1;
            while (list.size() < 3){
                System.out.println("-----请输入学生的信息------");
                System.out.println("请输入" +count+ "学生的学号");
                int num = scanner.nextInt();
                System.out.println("请输入" +count+ "学生的姓名");
                String name = scanner.nextLine();
                System.out.println("请输入" +count+ "学生的语文成绩");
                double cw = scanner.nextDouble();
                System.out.println("请输入" +count+ "学生的数学成绩");
                double ma = scanner.nextDouble();
                System.out.println("请输入" +count+ "学生的英语成绩");
                double en = scanner.nextDouble();

                Student1 student1 = new Student1();
                //判断学生成绩是否正确
                if(!(cw < 0)&&!(ma < 0)&&!(en < 0)){
                    student1.setNum(num);
                    student1.setName(name);
                    student1.setChinese(cw);
                    student1.setEnglish(en);
                    student1.setMath(ma);
                    student1.setAvg(Student1Dao.getAvg(student1));
                    list.add(student1);
                    count += 1;
                }
                else {
                    System.out.println("成绩输入错误！");
                    continue;
                }
            }
            System.out.println(list);
        }

        //把学生信息录入本地文件
        public static void saveStu(){
            //创建一个字符缓冲流
            try {
                out = new BufferedWriter(new FileWriter("stud.txt"));
                for(int i = 0;i < list.size(); i++){
                    out.write("姓名：" + list.get(i).getName() + "学号：" +list.get(i).getNum() + "语文成绩："
                            + list.get(i).getChinese() + "数学成绩" + list.get(i).getMath() + "英语成绩" + list.get(i).getEnglish() + "平均成绩" + list.get(i).getAvg());
                    out.newLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try {
                    if(out != null){
                        out.close();
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

