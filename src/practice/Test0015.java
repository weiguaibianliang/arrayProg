package practice;

import javax.imageio.IIOException;
import java.io.*;
import java.net.*;

public class Test0015 {
}
/*
网络与线程
 */
/*
1、使用BufferedReader从Socket上读取数据
//建立对服务器的Socket连接
Socket chatSocket = new Socket("127.0.0.1",5000);
//建立连接到Socket上底层输入串流的InputStreamReader
InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
//建立BufferedReader来读取
BufferedReader reader = new BufferedReader(stream);
String message = reader.readLine();

2、用PrintWriter写数据到Socket上
//对服务器建立Socket连接
Socket chatSocket = new Socket("127.0.0.1",5000);
//建立链接到Socket的PrintWriter
PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
//写入数据
writer.println("message to send");
writer.print("another message");
 */
class DailyAdviceClient{
    public void go(){
        BufferedReader reader = null;
        try{
            //有可能出状况
            //此接口可能不存在，有问题的IP地址和端口号
            Socket s = new Socket("127.0.0.1",4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            //来读取数据串流
             reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Today you should :"+advice);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
//URL类的使用
class Test5{
    public static void main(String[] args) throws MalformedURLException {
        URL u = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
        System.out.println("获取与此URL关联的协议的默认端口:"+u.getDefaultPort());
        //获取端口号后面的内容
        System.out.println("getFile:"+u.getFile());
        System.out.println("主机名:"+u.getHost());
        System.out.println("路径:"+u.getPath());
        System.out.println("端口:"+u.getPort());
        System.out.println("协议:"+u.getProtocol());
        System.out.println("参数部分:"+u.getQuery());
        System.out.println("锚点:"+u.getRef());
        URL u1 = new URL("http://www.abc.com/aa/");
        //相对路径构建URL对象
        URL u2 = new URL(u,"2.html");
        //获得u2的字符串内容
        System.out.println(u2.toString());
    }
}
//最简单的网络爬虫
class Test6{
    public static void main(String[] args) {
        basicSpider();
    }
    //网络爬虫
    static void basicSpider(){
        URL url = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        try{
            //读取网络内容
            url = new URL("http://www.baidu.com");
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            /*
            这样就可以将网络内容下载到本地机器
            然后进行数据分析，建立索引。
             */
            while ((temp=br.readLine())!=null){
                sb.append(temp);
            }
            System.out.println(sb);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(br!=null){
                    br.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(is!=null){
                    is.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
/*
//单向通信Socket之服务器端
//最简单的服务器代码
class BasicSocketServer{
    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bw = null;
        try{
            //建立服务器端套接字:指定监听的端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端建立监听");
            //监听、等待客户端请求，并愿意接收连接
            socket = serverSocket.accept();
            //获取socket的输出流，并使用缓冲流进行包装
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //向客户端发送反馈信息
            bw.write("hhhh");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            //关闭流及socket连接
            try{
                if(bw!=null){
                    bw.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(socket!=null){
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

 */

//单向通信Socket之客户端
/*
class BasicSocketClient{
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try{
            /*
            创建Socket对象，指定要连接的服务器的IP地址和端口不是自己机器的端口，发送端口是随机的
             */
/*
            socket = new Socket(InetAddress.getLocalHost(),8888);
            //获取socket的缓冲流，并使用缓冲流进行包装
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //接收服务器端发送的消息
            System.out.println(br.readLine());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(socket!=null){
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(br!=null){
                    br.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

 */
//双通信Socket之服务器端
class Server{
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        BufferedReader br = null;
        try{
            //创建服务器端套接字:指定监听接口
            ServerSocket server = new ServerSocket(8888);
            //监听客户端的连接
            socket = server.accept();
            //获取socket的输入输出流接收和发送消息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                //接收客户端发送的信息
                String str = in.readLine();
                System.out.println("客户端说:"+str);
                String str2 = "";
                //如果是客户端发送的是end，则中止连接
                if(str.equals("end")){
                    break;
                }
                //否则发送反馈信息
                str2 = br.readLine();
                //读取到\n为止
                out.write(str2+"\n");
                //清空缓冲区的数据流
                out.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(br!=null){
                    br.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(out!=null){
                    out.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(socket!=null){
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//双向通信之客户端
class Client{
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        BufferedReader wt = null;
        try{
            //创建Socket对象，指定服务器端的IP地址与端口
            socket = new Socket(InetAddress.getLocalHost(),8888);
            //获取socket的输入输出流接收和发送消息
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            wt = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                //发送信息
                String str = wt.readLine();
                out.write(str+"\n");
                out.flush();
                if(str.equals("end")){
                    break;
                }
            }
            System.out.println("服务器端说:"+in.readLine());

        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(wt!=null){
                    wt.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(out!=null){
                    out.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(socket!=null){
                    socket.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
//多线程技术
/*
java中如何实现多线程
1、通过继承Thread类实现多线程
2、通过Runnable接口实现多线程
 */
class TestThread extends  Thread{
    //自定义继承Thread类
    //run()方法是线程体
    public void run(){
        for(int i =0;i<10;i++){
            //getName()方法用于返回线程名称
            System.out.println(this.getName()+":"+i);
        }
    }
    //主线程和新建线程是同时进行的，如果涉及的比较多，最后的输出结果是交替进行的。
    //总结：注意，线程开启不一定立即执行，由cpu调度执行。
    public static void main(String[] args) {
         //main线程，主线程
        //创建线程对象
        TestThread thread1 = new TestThread();
        //调用start方法，启动线程
        thread1.start();
        TestThread thread2 = new TestThread();
        thread2.start();
    }
}

//练习Thread,实现多线程同步下载图片,要创建一个下载器，线程是同时进行的，并没有顺序之分。
class TestThread02 extends Thread{

}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        //FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}

//通过Runnable接口实现多线程,推荐使用这个方法，方便同一个对象被多个线程使用。
class TestThread2 implements Runnable{
    //run()方法里是线程体
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
    //创建线程和主线程不是同时进行的，而是由cpu进行调度，是交替进行的。
    public static void main(String[] args) {
        /*
        //创建线程对象，把实现了Runnable接口的对象作为参数传入，要把这个参数丢进去。
        Thread thread1 = new Thread(new TestThread2());
        //启动线程
        thread1.start();
        //再创建一个线程对象，把实现了Runnable接口的对象作为参数传入
        Thread thread2 = new Thread(new TestThread2());
        thread2.start();

         */
        TestThread2 t1 = new TestThread2();
        TestThread2 t2 = new TestThread2();
        new Thread(t1).start();
        new Thread(t2).start();

    }
}

//多个线程同时操作同一个对象
//买火车票的例子
//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱。
//这是一个并发问题，要知道什么时候会出现并发问题。
class TestThread003  implements Runnable{
    //票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNums==0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---拿到了第"+ticketNums--+"票");
        }

    }

    public static void main(String[] args) {
        TestThread003 testThread003 = new TestThread003();
        new Thread(testThread003,"小明").start();
        new Thread(testThread003,"老师").start();
        new Thread(testThread003,"黄牛党").start();

    }
}

//多线程模拟龟兔赛跑问题
class Race implements Runnable{
    //胜利者,保证只有一个winner。
    private static String winner;
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束,调用gameover方法。
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"----跑了"+i+"步");
        }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if(winner!=null){
            //已经存在了胜利者了
            return true;
        }
        else if(steps>=100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //定义一个主线程
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}


//实现静态代理对比Thread//结婚-实现结婚接口
//总结：真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事。
class StaticProxy{
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMary();
    }

}
interface Marry{
    void HappyMary();
}
//真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMary() {
        System.out.println("秦老师要结婚了，超开心");
    }
}
//代理角色，帮助你结婚
class WeddingCompany implements Marry{
    //定义一个结婚对象，目标
    //代理真实目标角色
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMary() {
        before();
        //这就是真实对象
        this.target.HappyMary();
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
    private void after(){
        System.out.println("结婚之后，收尾款");
    }

}


/*
终止线程的典型方式
 */
//测试线程周期
class TestThreadCiycle implements Runnable{
    String name;
    //标记变量，表示线程是否可终止
    boolean live = true;
    public TestThreadCiycle(String name){
        super();
        this.name = name;
    }
    public void run(){
        int i = 0;
        //当live的值是true时，继续线程体，是false则结束循环，继而终止线程体
        while (live){
            System.out.println(name+(i++));
        }
    }
    //创建一个终止方法
    public void terminate(){
        live = false;
    }

    public static void main(String[] args) {
        TestThreadCiycle ttc = new TestThreadCiycle("线程A：");
        //新生状态
        Thread t1 = new Thread(ttc);
        //就绪状态
        t1.start();
        for(int i =0;i<100;i++){
            System.out.println("主线程"+i);
        }
        ttc.terminate();
        System.out.println("ttc stop!");
    }
}
/*
暂停线程执行的常用方法,常用方法有sleep()和yield()。
 */
//测试线程状态,用sleep()方法
class TestThreadState{
    public static void main(String[] args) {
        StateThread thread1 = new StateThread();
        thread1.start();
        StateThread thread2 = new StateThread();
        thread2.start();
    }
}
class StateThread extends Thread{
    public void run(){
        for(int i =0;i<100;i++){
            System.out.println(this.getName()+":"+i);
            try{
                //调用线程的sleep()方法
                //用这个方法可以感受每条结果输出之前的延迟
               Thread.sleep(2000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
//测试线程的状态，用yield()方法
class TestThreadState1{
    public static void main(String[] args) {
        StateThread1 thread1 = new StateThread1();
        thread1.start();
        StateThread1 thread2 = new StateThread1();
        thread2.start();
    }
}
class StateThread1 extends  Thread{
    public void run(){
        for (int i =0;i<100;i++){
            System.out.println(this.getName()+":"+i);
            //调用线程的yield()方法
            //可以引起线程的切换，但没有明显延迟。
            Thread.yield();
        }
    }
}
/*
联合线程的方法
比如：线程A在运行期间，可以调用线程B的join()方法，让线程B和线程A联合。
只有等线程B执行完毕才能继续执行线程A。
 */
class TestThreadState2{
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        Thread father = new Thread(new FatherThread());
        father.start();
    }
}
//使用Runnable接口实现多线程
class FatherThread implements Runnable{
    public void run(){
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("爸爸让儿子去买包红塔山");
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("爸爸等儿子买烟回来");
        try{
            son.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("爸爸出门去找儿子跑去哪了");
            //结束JVM，如果是0表示正常结束，如果是非0则表示非正常结束。
            System.exit(1);
        }
        System.out.println("爸爸把烟接了过来，并把钱给了儿子");
    }
}
//使用Runnable接口实现多线程
//暂停儿子的这个线程的执行
class SonThread implements  Runnable{
    public void run(){
        System.out.println("儿子出门去买烟");
        System.out.println("儿子买烟需要十分钟");
        try{
            for(int i =0;i<=10;i++){
                System.out.println("第"+i+"分钟");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("儿子买烟回来了");
    }
}
//线程的常用方法
class TestThread3{
    public static void main(String[] args) throws Exception {
        Runnable r = new MyThread();
        //定义线程对象并传入参数
        Thread t = new Thread(r,"Name test");
        //启动线程
        t.start();
        //输入线程名称
        System.out.println("name is:"+t.getName());
        //线程暂停5分钟
        Thread.currentThread().sleep(5000);
        //用于判断线程还在运行吗
        System.out.println(t.isAlive());
        System.out.println("over!");
    }
}
class MyThread implements Runnable{
    //线程体
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println(i);
        }
    }
}
//多线程操作同一对象(使用线程同步)
class TestSync{
    public static void main(String[] args) {
        Account a1 = new Account(100,"高");
        Drawing draw1 = new Drawing(80,a1);
        Drawing draw2 = new Drawing(80,a1);
        //你取钱
        draw1.start();
        //你老婆取钱
        draw2.start();

    }
}
//简单的表明银行账户
class Account{
    int money;
    String aname;
    public Account(int money,String aname){
        super();
        this.money = money;
        this.aname = aname;
    }
}
//模拟提款操作
class Drawing extends Thread{
    //取多少钱
    int drawingNum;
    //要取钱的账户
    Account account;
    //总共取的钱数
    int expenseTotal;
    public Drawing(int drawingNum,Account account){
        super();
        this.drawingNum = drawingNum;
        this.account = account;
    }
    //重写方法
    public void run(){
        draw();
    }
    void draw(){
        synchronized (account){
            if(account.money - drawingNum<0){
                System.out.println(this.getName()+"取款，余额不足！");
                return;
            }
            try{
                //判断完后阻塞，其他线程开始运行
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            account.money -= drawingNum;
            expenseTotal += drawingNum;
        }
        System.out.println(this.getName()+"--账户余额:"+account.money);
        System.out.println(this.getName()+"--总共取了:"+expenseTotal);
    }
}

/*
推到lambda表达式
 */
class TestLambda1{
    //3、静态内部类
    static  class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like2  = new Like2();
        like2.lambda();
        ILike like = new Like();
        like.lambda();

        //4、局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();


        //5、匿名内部类,没有类的名称，必须借助接口或父类。
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //6、用lambda简化
        like = ()->{
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
    /*

    //局部内部类
    class TreeSet<String> implements comparator<String>(){
    @Override
    public int compare(String o1,String o2){
    return Integer.compare(o1.length(),o2.length());
    }
    TreeSet<String> ts = new TreeSet<String>();

    //匿名内部类
    TreeSet<String> ts = new TreeSet<>(new Comparator<String>(){
    @Override
    public int compare(String o1,String o2){
    return Integer.compare(o1.length(),o2.length());
    }
    }
    );

    //用lambda表达式表示
    TreeSet<String> ts2 = new TreeSet<>(
    //在这里数据的类型可以省略。
    (o1,o2) -> Integer.compare(o1.length(),o2.length())
    );

     */


}
//定义一个函数式接口
interface ILike{
    void lambda();
}
//实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}


/*
定义一个有参数的lambda表达式
 */
class TestLambda2{
    //2、实现一个静态内部类
      static class Love2 implements ILove{

        @Override
        public void love(int a) {
            System.out.println("i love you"+a);
        }
    }
    public static void main(String[] args) {

        ILove love2 = new Love2();
        love2.love(6);
        ILove love = new Love();
        love.love(5);
        //3、内部类
        class Love3 implements ILove{

            @Override
            public void love(int a) {
                System.out.println("i love you"+a);
            }
        }
        ILove love3 = new Love3();
        love3.love(7);
        
        //4、匿名内部类，没有类的名称，必须借助父类或接口。
        love = new ILove(){
            @Override
            public void love(int a) {
                
            }
        };
        love.love(8);
        
        //5、love用正则表达式
        love = (int a)->{
            System.out.println("i love you"+a);
        };
        love.love(9);
    }

}
//实现一个函数式接口
interface ILove{
    void love(int a);
}
//1、实现类
class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("i love you"+a);
    }
}
