package practice;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//序列化和文件的输入与输出
public class Test0014 {
}
/*
序列化-存储对象，将序列对象写入文件。
//创建出FileOutputStream
FileOutputStream fileStream = new FileOutputStream("MyGame.ser");

//创建出ObjectOutputStream
ObjectOutputStream os = new ObjectOutputStream(fileStream);

//写入对象
os.writeObject(characterOne);
os.writeObject(characterTwo);
os.writeObject(characterThree);

//关闭ObjectOutputStream,关闭所关联的输出串流
os.close();
 */


/*
解序列化-还原对象
//创建FileInputStream
FileInputStream fileStream = new FileInputStream("MyGame.ser");

//创建ObjectInputStream
ObjectInputStream os = new ObjectInputStream(fileStream);

//读取对象
Object one = os.readObject();
Object two = os.readObject();
Object three = os.readObject();

//转换对象类型,返回值是Object类型，因此必须要转换类型。
GameCharacter elf = (GameCharacter) one;
GameCharacter troll = (GameCharacter) two;
GameCharacter magician = (GameCharacter) three;

//关闭ObjectInputStream,FileInputStream会自动跟着关掉。
os.close();
 */
class GameCharacter implements Serializable{
    //这三个实例变量就是对象，之后会先存储对象，然后再还原对象。
    int power;
    String type;
    //技能
    String [] weapons;
    public GameCharacter(int p,String t,String[] w){
        power = p;
        type = t;
        weapons = w;
    }
    public int getPower(){
        return power;
    }
    public String getType(){
        return type;
    }
    public String getWeapons(){
        String weaponList = "";
        for (int i =0;i<weapons.length;i++){
            weaponList +=weapons[i]+" ";
        }
        return weaponList;
    }
}
//存储与恢复游戏人物
class GameSaverTest{
    public static void main(String[] args) {
        //创建人物
        GameCharacter one = new GameCharacter(50,"Elf",new String[]{"bow","sword","dust"});
        GameCharacter two = new GameCharacter(200,"Troll",new String[]{"bare hands","big ax"});
        GameCharacter three = new GameCharacter(120,"Magician",new String[]{"spells","invisibility"});
        //假设此处有改变人物状态值的程序代码
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        //设定为null，因此无法存储堆上的这些对象
        one = null;
        two = null;
        three = null;
        try{
            //再从文件中把对象读回来
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();
            //看看是否成功
            System.out.println("one's type:"+ oneRestore.getType());
            System.out.println("two's type:"+ twoRestore.getType());
            System.out.println("three's type:"+ threeRestore.getType());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
//将字符串写入文本文件
class WriteAFile{
    public static void main(String[] args) {
        try{
            //输入/输出相关的操作都必须包在try catch块中。
            //如果使用缓冲区会提高使用效率
            BufferedWriter writer = new BufferedWriter(new FileWriter("Foo.txt"));
            //FileWriter writer = new FileWriter("Foo.txt");
            writer.write("hello foo");
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
/*
写入文件
 */
class WriteFile{
    public static void main(String[] args) {
        //创建出代表表现存盘文件的File对象
        File f = new File("MyCode.txt");
        //建立新的目录
        File dir = new File("Chapter7");
        dir.mkdir();
        //列出目录下的内容,判断读取的目录是不是正确的。
        if(dir.isDirectory()){
            String[] dirContents = dir.list();
            for(int i =0;i<dirContents.length;i++){
                System.out.println(dirContents[i]);
            }
        }
        //取得文件或目录的绝对路径
        System.out.println(dir.getAbsolutePath());
        //删除文件或目录
        boolean isDeleted = f.delete();
    }
}
/*
读取文本文件
 */
class ReadFile{
    public static void main(String[] args) {
        try{
            File myFile = new File("MyText.txt");
            //FileReader是字符的连接到文本文件的串流
            FileReader fileReader = new FileReader(myFile);
            //将FileReader连接到BufferedReader以获取更高的效率。
            BufferedReader reader = new BufferedReader(fileReader);
            //用String变量来承接所读取的结果
            String line= null;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
/*
String 的spilt()解析
 */
class SpiltTest{
    public static void main(String[] args) {
        String toTest = "What is blue +yellow?/green";
        //这个方法的作用就是可以把字符串拆开。
        String[] result = toTest.split("/");
        for (String token:result){
            //把数组中的每个元素逐一地列出来
            System.out.println(token);
        }
    }
}
/*
存储BeatBox节奏
 */
class MySendListener implements ActionListener{
    //按下按钮触发执行
    @Override
    public void actionPerformed(ActionEvent a) {
        //此数组用来保存复选框的状态
        boolean[] checkboxState = new boolean[256];
        for(int i =0;i<256;i++){
            //JCheckBox check = (JCheckBox) checkboxList.get(i);
            //
        }
    }
}
//练习题，排排看
class DungeonGame implements Serializable{
    public int x = 3;
    transient long y = 4;
    private short z = 5;
    int getX(){
        return x;
    }
    long getY(){
        return y;
    }
    short getZ(){
        return z;
    }
}
class DungeonTest{
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        System.out.println(d.getX()+d.getY()+d.getZ());
        try{
            //进行序列化，相当于存储对象
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            //进行解序列化，还原对象
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d=(DungeonGame) ois.readObject();
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d.getX()+d.getY()+d.getZ());
    }
}
