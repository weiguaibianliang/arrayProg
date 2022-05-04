package practice;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.*;

/*
IO流,主要四大流，OutputStream、IntputStream、Writer、Reader。
 */
public class FistPractice16 {
}
class TestBufferedWriter{
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("test.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "Hello Word";
        bw.write(str);
        //bw.flush();
        //fw.close();
        bw.close();
        System.out.println(str);
    }
}
//编程题
/*
利用FileInputStream和FileOutputStream
 */
class TestFile{
    /*
    public static void main(String[] args) throws IOException{
		//运用字节流的方法
		FileOutputStream fos=new FileOutputStream("D:\\Java测试\\test.txt");
		FileInputStream fis=new FileInputStream("D:\\Java测试\\test.txt");
		try {
			fos.write("HelloWorld".getBytes());
			int len=0;
			while((len=fis.read())!=-1)
				System.out.print((char)len);
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			fos.close();
			fis.close();
		}
	}
     */
    public static void main(String[] args) {
        //定义一个输出字符串
        String str = "Hello World";
        //在当前目录下创建一个文件“test.txt"
        try{
            FileOutputStream  fw = new FileOutputStream("test.txt");
            ObjectOutputStream ow = new ObjectOutputStream(fw);
            ow.writeObject(str);
            if(fw!=null){
                fw.close();
            }
            FileInputStream fs = new FileInputStream("test.txt");
            ObjectInputStream os = new ObjectInputStream(fs);
            str = (String) os.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {


        }

    }
}
/*
使用流读取文件内容
 */
class TestIO1{
    public static void main(String[] args) {
        try{
            //创建输入流
            FileInputStream fis = new FileInputStream("D:\\aaa\\a.txt.txt");
            //一个字节一个字节的读取数据"D:\aaa\a.txt.txt"
            int s1 = fis.read();
            int s2 = fis.read();
            int s3 = fis.read();
            int s4 = fis.read();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            //流对象用完之后，必须要关闭
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
//使用流读取文件内容，为了保证出现异常后流的正常关闭。
class TestIO2{
    public static void main(String[] args) {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("D:\\aaa\\a.txt.txt");
            //每次是对StringBuilder对象本身进行修改，而不是产生新的对象
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            //当temp=-1时，表示已经到了文件结尾，停止读取。
            while((temp = fis.read())!= -1){
                sb.append((char) temp);
            }
            System.out.println(sb);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                //这种写法，保证了即使遇到异常情况，也会关闭流对象
                fis.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//将字符串/字节数组的内容写入到文件中
class TestFileOutputStream{
    public static void main(String[] args) {
        FileOutputStream fos  = null;
        String string = "北京尚学堂欢迎您！";
        try {
            //true表示内容会加在文件末尾，false表示重写整个文件的内容。
            fos = new FileOutputStream("D:\\aaa\\a.txt.txt",true);
            //该方法是将一个字节写入到文件中，而write(int n)是写入一个字节到文件中
            fos.write(string.getBytes());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //这种方法是即使遇到了异常情况，也会正常关闭流对象。
            try {
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//利用文件流实现文件的复制
class TestFileCopy{
    public static void main(String[] args) {
        //将a文件的内容复制到b文件
        copyFile("D:\\aaa\\a.txt.txt","D:\\aaa\\b.txt.txt");
    }
    //将src文件的内容复制到dec文件
    static void copyFile(String src,String dec){
        FileInputStream fis = null;
        FileOutputStream  fos = null;
        //为了提高效率，设置缓存数组（读取的字节数据会缓存在字节数组中）
        byte[] buffer = new byte[1024];
        int temp = 0;
        try{
            //这个进行对文件的读取，把src文件的内容读取
            fis = new FileInputStream(src);
            //这个进行对文件的写入，写入到文件dec中。
            fos = new FileOutputStream(dec);
            //边读边写
            while ((temp=fis.read(buffer))!=-1){
                fos.write(buffer,0,temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
class TestIO3{
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String string = "Hello World";
        try {
            //先将字符串写入文件
            fos = new FileOutputStream("D:\\aaa\\a.txt.txt");
            fos.write(string.getBytes());
            //然后再依次读取文件中的字符串。
            fis = new FileInputStream("D:\\aaa\\a.txt.txt");
            //建立这个方法是对本对象进行修改，而不是产生了新的对象。
            StringBuilder buff = new StringBuilder();
            int temp = 0;
            while((temp = fis.read())!= -1){
                buff.append((char) temp);
            }
            System.out.println(buff);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//处理文本文件时一般可以使用文件字符流，在处理Unicode字符时防止出现乱码现象。
//使用FileReade和FileWriter来实现文本文件的复制。
class TestCopyFile2{
    public static void main(String[] args) {
        //基本用法和stream差不多
        FileReader fr = null;
        FileWriter fw = null;
        int len = 0;
        try{
            fr = new FileReader("D:\\aaa\\a.txt.txt");
            fw = new FileWriter("D:\\aaa\\b.txt.txt");
            //为了提高效率，创建缓冲用的字符数组
            char[] buffer = new char[1024];

            //边读边写
            while ((len=fr.read(buffer))!=-1){
                fw.write(buffer,0,len);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(fr!=null){
                    fr.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(fw!=null){
                    fw.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
//缓冲字节流
class TestBufferedFileCopy1{
    public static void main(String[] args) {
        //使用缓冲字节流实现复制
        long time1 = System.currentTimeMillis();
        copyFile1("D:\\aaa\\a.txt.txt","D:\\aaa\\b.txt.txt");
        long time2 = System.currentTimeMillis();
        System.out.println("缓冲字节流需要花费的时间为:"+(time2-time1));
        //使用普通字节流实现复制
        long time3 = System.currentTimeMillis();
        copyFile2("D:\\aaa\\a.txt.txt","D:\\aaa\\b.txt.txt");
        long time4 = System.currentTimeMillis();
        System.out.println("使用普通节流花费的时间为:"+(time4-time3));
    }
    //缓冲字节流实现文件复制的方法
    static void copyFile1(String src,String dec){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int temp = 0;
        try{
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            //使用缓冲字节流包装文件字节流，增加缓冲功能，提高效率。
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //先进行读取，然后再写入
            while ((temp=bis.read())!=-1){
                //利用缓冲流进行写入
                bos.write(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //增加处理流后，注意流的关闭顺序，先开的后关闭
            try{
                if(bos!=null){
                    bos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(bis!=null){
                    bis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //普通节流实现文件复制的方法
    static void copyFile2(String src,String dec){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int temp = 0;
        try{
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            while ((temp = fis.read())!=-1){
                fos.write(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
//编程题2,这是我自己的答案。
class TestCopyFile3{
    /*
    事先在当前目录下准备好一个test.txt的文本文件，要求该文本文件使用GBK的
    多行文本文件。读取这个文件，然后按照行的顺序，以UTF-8的编码方式，写到test2.txt文件中。

     */
    public static void main(String[] args) {
        copyFile5("D:\\aaa\\test.txt","D:\\aaa\\test2.txt");
    }
    static void copyFile5(String src,String dec){
        List<String> list = new ArrayList<String>();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int temp = 0;
        try{
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            //使用缓冲字节流包装文件字节流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            while((temp=bis.read())!=-1){
                bos.write(temp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(bis!=null){
                    bis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
//编程题的正确答案2
class TestPoem {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;
        try{
            //实现倒序
            List<String> list = new ArrayList<String>();
            //GBK编码读进来
             fis = new FileInputStream("D:\\\\aaa\\\\test.txt");
             //字符节点流，将字节转换为字符
            isr = new InputStreamReader(fis,"UTF-8");
            //字符过滤流，可写一行，支持换行符
             br = new BufferedReader(isr);
            //按照一定的顺序以UTF-8的方式写入
            fos = new FileOutputStream("D:\\aaa\\test2.txt");
            osw = new OutputStreamWriter(fos,"UTF-8");
            //字符过滤流，支持写入后换行
            pw = new PrintWriter(osw);
            //读一行写一行
            String line;
            while ((line=br.readLine())!=null){
                //按照顺序添加到集合中
                list.add(line);
            }
            for(int i=list.size()-1;i>=0;i--){
                pw.println(list.get(i));
            }
        }
        catch (Exception e){
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
                if(pw!=null){
                    pw.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(isr!=null){
                    isr.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(osw!=null){
                    osw.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null){
                    fis.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fos!=null){
                    fos.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

class Test42{
    /*
    已知一个二维数组A表示一个矩阵，求A的转置矩阵
     */
    public static void main(String[] args) {
        /*
        int[][] A = new int[2][];
        A[0] = new int[]{1,2,3};
        A[1] = new int[]{4,5,6};
        int[][] B = new int[3][];
        B[0] = new int[]{1,2};
        B[1] = new int[]{2,5};
        B[2] = new int[]{3,6};
         */
        int[][] A = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        //一个新的数组调用transposition方法，实现矩阵的转置
        int[][] newNums = transposition(A);
        //运用一个for循环方便把转置后的矩阵打印在控制台
        for(int i =0;i<newNums.length;i++){
            //将一个新的数组转为字符串的形式
            System.out.println(Arrays.toString(newNums[i]));
        }
    }
    public static int[][] transposition(int[][] A){
        //m代表整个二维数组的长度，每一个长度包含一个一维数组。
        int m = A.length;
        //n代表一个二维数组第一行的长度。
        int n = A[0].length;
        int[][] newNums = new int[n][m];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                newNums[j][i] = A[i][j];
            }
        }
        return newNums;
    }
}
class Test43{
    public static void main(String[] args) {
        int[] a = new int[4];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        //for(int i =0;i<a.length;i++){
            for(int j=a.length-1;j>=0;j--){
                System.out.print(a[j]+"\t");
            }
        //}
    }
}