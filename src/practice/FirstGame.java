package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class FirstGame {
}
/*
//测试代码
class SimpleDotComTestDrive{
    public static void main(String[] args) {
        //初始化一个对象
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
    }
}
//真实代码
class SimpleDotCom{
    int[] locationCells;
    int numOfHits = 0;
    public void setLocationCells(int[] locs){

        locationCells = locs;
    }
    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        //如果没有猜中，结果返回值为miss
        String result = "miss";
        for (int cell:locationCells) {
            if(guess==cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        //如果命中数为3，返回击沉信息。
        if(numOfHits==locationCells.length){
            result = "kill";
        }
        //列出信息，将结果显示出来
        System.out.println(result);
        //将结果返回给调用方
        return result;
    }
}
class SimpleDotComGame {

    public static void main(String[] args) {
        //记录玩家猜测数量的变量
        int numOfGuesses = 0;
        //用下面的类初始化一个对象
        GameHelper helper = new GameHelper();
        //创建dot com对象
        SimpleDotCom theDotCom = new SimpleDotCom();
        //用随机数产生第一格的位置，然后以此制作数组。
        int randomNum = (int)(Math.random()*5);
        int[] locations = {randomNum,randomNum+1,randomNum+2};
        //赋值位置，调用上面的测试类的方法
        theDotCom.setLocationCells(locations);
        //创建出记录游戏是否继续进行的boolean变量，用在while循环当中
        boolean isAlive = true;
        while (isAlive==true){
            //取得玩家输入的字符串
            String guess = helper.getUserInput("enter a number");
            //检查玩家的猜测并将结果存储在String中
            String result = theDotCom.checkYourself(guess);
            //增量猜测的结果
            numOfGuesses++;
            //是否击沉？若击沉，则设定isAlive为false并印出猜测次数
            if(result.equals("kill")){
                isAlive = false;
                System.out.println("You took"+numOfGuesses+"guesses");
            }
        }

    }
}
class GameHelper{
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt+" ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        }
            catch(IOException e){
                System.out.println("IOException:"+e);
            }
            return inputLine;
        }
    }

 */
/*
//更加优化的攻击网络游戏版本，运用到ArrayList集合，使这个方法更有说服力
class DotCom{
    //将带有String的数组改成承载String的ArrayList
    private ArrayList<String> locationCells;
    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }
    //参数有了新的名称
    public String checkYourself(String userInput){
        String result = "miss";
        //判别玩家猜测值是否出现在ArrayList中，没有的话会返回-1
        int index = locationCells.indexOf(userInput);
        //如果索引值大于或等于0，命中！
        if(index>=0){
            //删除已经命中的格子
            locationCells.remove(index);
            //如果全部命中清空了，那就表示击沉了。
            if(locationCells.isEmpty()){
                result = "kill";
            }
            else {
                result = "hit";
            }
        }
        return result;
    }
}

 */
class DotComBust{
    //声明并初始化变量
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;
    private void setUpGame(){
        //first make some dot coms and give them locations
        //创建3个DotCom对象并指派名称并置于Arraylist
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        //列出简单的提示
        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com,eToys.com,Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        //对list中的每个DotCom重复一次
        for(DotCom dotComToSet:dotComsList){
            //要求DotCom的位置
            ArrayList<String> newLocation = helper.placeDotCom(3);
            //调用这个DotCom的setter方法来指派刚取得的位置
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        //判断DotCom的list是否为空
        while(!dotComsList.isEmpty()){
            //取得玩家输入
            String userGuess = helper.getUserInput("Enter a guess");
            //调用checkUserGuess方法
            checkUserGuess(userGuess);
        }
        //调用finish方法
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        //递增玩家猜测次数的计数
        numOfGuesses++;
        //先假设没有命中
        String result = "miss";
        //对list中所有DotCom进行重复
        for(DotCom dotComToTest : dotComsList){
            //要求DotCom检查是否命中或击沉
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("hit")){
                //提前跳出循环
                break;
            }
            if(result.equals("kill")){
                //这家伙被挂掉了
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        //列出结果
        System.out.println(result);
    }
    private void finishGame(){
        //列出玩家成绩
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if(numOfGuesses<=18){
            System.out.println("It only took you"+numOfGuesses+"guesses.");
            System.out.println("You got out before your options sank");
        }
        else{
            System.out.println("Took you long enough."+numOfGuesses+"guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        //创建游戏对象
        DotComBust game = new DotComBust();
        //要求游戏对象启动
        game.setUpGame();
        //要求游戏对象启动游戏的主要循环
        game.startPlaying();
    }//关闭方法
}
class DotCom{
    //声明DotCom的实例变量，保存位置的ArrayList,DotCom的名称
    private ArrayList<String> locationCells;
    private String name;
    //更新DotCom位置的setter方法
    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }
    //基本的setter方法
    public void setName(String n){
        name = n;
    }
    public String checkYourself(String userInput){
        String result = "miss";
        //使用到indexOf()方法！如果玩家猜中的话，这个方法会返回它的位置。如果没有的话会返回-1.
        int index = locationCells.indexOf(userInput);
        if(index>=0){
            //删除被猜中的元素
            locationCells.remove(index);
            //用这个方法判断是否击沉
            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! You sunk"+name+" : (");
            }else {
                result = "hit";
            }
        }
        return result;
    }
}
class GameHelper{
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;
    public String getUserInput(String prompt){
        String inputline = null;
        System.out.print(prompt+" ");
        try{
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            inputline = is.readLine();
            if(inputline.length()==0)
                return null;
        }
        catch (IOException e){
            System.out.println("IOException:"+ e);
        }
        return inputline.toLowerCase();
    }
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<>();
        //保存字符串
        String[] alphacoords = new String[comSize];
        //临时字符串
        String temp= null;
        //现有字符串
        int [] coords = new int[comSize];
        //目前测试的字符串
        int attempts=0;
        //找到合适的位置吗？
        boolean success = false;
        //目前起点
        int location = 0;
        //现在处理到第n个
        comCount++;
        //水平增量
        int incr = 1;
        //如果是单数号的
        if((comCount%2)==1){
            //垂直增量
            incr = gridLength;
        }
        //主要搜索循环
        while (!success&attempts++<200){
            //随机起点
            location = (int)(Math.random()*gridSize);
            int x = 0;
            //假定成功
            success = true;
            //查找未使用的点
            while (success&& x< comSize){
                //如果没有使用
                if(grid[location]==0){
                    //存储位置
                    coords[x++] = location;
                    //尝试下一个起点
                    location+=incr;
                    //超出下边缘
                    if(location>=gridSize){
                       //失败
                       success = false;
                    }
                    //超出右边缘
                    if (x>0&&(location%gridLength==0)){
                        //失败
                        success = false;
                    }
                }
                else {
                    success = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int column = 0;
        while (x<comSize){
            grid[coords[x]]=1;
            row = (int)(coords[x]/gridLength);
            column = coords[x]%gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;

    }
}

