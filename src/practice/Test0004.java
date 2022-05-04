package practice;

public class Test0004 {
}
/*
 class BeerSong{
     public static void main(String[] args) {
         int beerNum = 99;
         String word = "bottles";
         while(beerNum > 0){
             if(beerNum==1){
                 word = "bottle";//单数的瓶子
             }
             System.out.println(beerNum+""+word+"of beer on the wall");
             System.out.println(beerNum+""+word+"of beer");
             System.out.println("Take one down.");
             System.out.println("Pass it around.");
             beerNum = beerNum -1;
             if(beerNum > 0){
                 System.out.println(beerNum + ""+word+"of beer on the wall");
             }else {
                 System.out.println("No more bottles of beer on the wall");
             }//else结束
         }//while循环结束
     }//main方法结束
}//class结束

 */
/*
class PhraseOMatic{
    public static void main(String[] args) {
        String[] wordListOne = {"24/7","multi-Tier","30,000 foot","B-to-B","win-win","front-end","web-based","pervasive",
        "smart","six-sigma","critical-path","dynamic"};
        String[] wordListTwo = {"empowerd","sticky","value-added","oriented","centric","distributed","clustered","branded",
        "outside-the-box","positioned","networked","focused","leveraged","aligned","targeted","shared","cooperative","accelerated"};
        String[] wordListThree = {"process","tipping-point","solution","archiecture","core competency","strategy","mindshare","portal","space","vision","paradigm","mission"};
        //计算每一组有多少个名词术语
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        //随机产生数字
        int rand1 = (int) (Math.random()*oneLength);
        int rand2 = (int) (Math.random()*twoLength);
        int rand3 = (int) (Math.random()*threeLength);
        //组合出专家术语
        String phrase = wordListOne[rand1] + "" +wordListTwo[rand2] + "" +wordListThree[rand3];
        //输出
        System.out.println("What we need is a "+ phrase);
    }
}

 */
/*
class Shufflel{
    public static void main(String[] args) {
        int x = 3;
        while(x > 0){
            if(x > 2){
                System.out.print("a");
            }
            if(x == 2){
                System.out.print("b c");
            }

            x = x- 1;
            System.out.print("-");
            if(x == 1){
                System.out.print("d");
                x = x -1;
            }
        }
    }
}
class PoolPuzzleOne{
    public static void main(String[] args) {
        int x = 0;
        while(x < 4){
            System.out.println("a");
            if(x < 1){

            }

            if(x > 1){
                System.out.println("an");
                System.out.println("noys");
            }
            if(x==1){

            }
        }
    }
}

 */
/*
//创建第一个对象
class Dog{
    int size;
    String breed;
    String name;
    void bark(){
        System.out.println("Ruff! Ruff!");
    }
}
class DogTestDrive{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.size = 40;
        d.bark();
    }
}

 */
/*
class Movie{
    String title;
    String genre;//电影类型
    int rating;//电影评分
    void playIt(){
        System.out.println("Playing the movie");
    }
}
 class MovieTestDrive{
     public static void main(String[] args) {
         Movie one = new Movie();
         one.title = "Gone with the stovk";
         one.genre = "Tragic";
         one.rating = -2;
         Movie two  = new Movie();
         two.title = "Lost in Cubicle Space";
         two.genre = "Comedy";
         two.rating = 5;
         two.playIt();
         Movie three = new Movie();
         three.title = "Byte Club";
         three.genre = "Tragic but ultimataly uplifting";
         three.rating = 127;
     }
}

 */
/*
class GuessGame{
    Player p1;
    Player p2;
    Player p3;
    public void startGame(){
        //用三个实例变量分别表示3个player对象
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        //声明三个变量来保存是否猜中
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;
        //声明三个变量来保存猜测的数字
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;
        //产生谜底数字
        int targetNumber = (int) (Math.random()*10);
        System.out.println("I‘m thinking of a number between 0 and 9...");
        while(true){
            System.out.println("Number to guess is "+ targetNumber);
            //调用Player的guess（）方法
            p1.guess();
            p2.guess();
            p3.guess();
            //取得每个Player 所猜测的数字并将它列出
            guessp1 = p1.number;
            System.out.println("Player one guessed"+guessp1);
            guessp2 = p2.number;
            System.out.println("Player two guessed"+guessp2);
            guessp3 = p3.number;
            System.out.println("Player three guessed"+guessp3);
            //检查是否猜中，若是猜中则去设定是否猜中的变量
            if(guessp1 == targetNumber){
                p1isRight = true;
            }
            if(guessp2==targetNumber){
                p2isRight = true;
            }
            if(guessp3==targetNumber){
                p3isRight = true;
            }
            //如果有一个或多个被猜中
            if(p1isRight||p2isRight||p3isRight){
                System.out.println("We have a winner!");
                System.out.println("Player one got it right?"+p1isRight);
                System.out.println("Player two got it right?"+p2isRight);
                System.out.println("Player three got it right?"+p3isRight);
                System.out.println("Game is over.");
                //游戏结束，中止循环
                break;
            }else {
                //都没猜到，所以要继续下去
                System.out.println("Player will have to try again.");
            }//if/else结束
        }//循环结束
    }//方法结束
}//类结束
class Player{
    //要被猜的数字
    int number =0;
    public void guess(){
        number = (int) (Math.random()*10);
        System.out.println("I’m guessing"+number);
    }
}
class GameLauncher{
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}
 */
/*
//排排看

class DrumKitTestDrive{
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.snare = false;
        d.playSnare();
        if(d.snare==true){
            d.playSnare();
        }
        d.playTopHat();

    }
}
class DrumKit{
    boolean topHat = true;
    boolean snare = true;
    void playSnare(){
        System.out.println("bang bang ba-bang");
    }
    void playTopHat(){
        System.out.println("ding ding da-ding");
    }
}

 */
class EchoTestDrive{
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2 = new Echo();
        int x = 0;
        while (x < 4){
            e1.hello();
            e1.count = e1.count + 1;
            if(x>0){
                e2.count = e2.count + 1;
            }
            if(x>1){
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);
    }
}
class Echo{
    int count = 0;
    void hello(){
        System.out.println("helloooo...");
    }

}
class Mix4{
    int counter = 0;

    public static void main(String[] args) {
        int count = 0;
        Mix4[] m4a = new Mix4[20];
        int x = 0;
        while(x < 19){
            m4a[x] = new Mix4();
            m4a[x].counter = m4a[x].counter +1;
            count = count +1;
            count = count + m4a[x].maybeNew(x);
            x= x+1;
        }
        System.out.println(count+ " " +m4a[1].counter);
    }
    public int maybeNew(int index){
        if(index < 1){
            Mix4 m4 = new Mix4();
            m4.counter = m4.counter + 1;
            return 1;
        }
        return 0;
    }
}
class Puzzle4{
    public static void main(String[] args) {
        Puzzle4b [] obs = new Puzzle4b[6];
        int y = 1;
        int x =0;
        int result = 0;
        while(x < 6){
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            y = y*10;
            x = x+1;
        }
        x = 6;
        while(x>0){
            x = x - 1;
            result = result + obs[x].doStuff(x);
            System.out.println("result"+result);
        }

    }
}
class Puzzle4b{
    int ivar;
    public int doStuff(int factor){
        if(ivar>100){
            return ivar *factor;
        }
        else {
            return ivar*(5 - factor);
        }
    }
}