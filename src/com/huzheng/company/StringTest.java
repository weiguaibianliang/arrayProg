package com.huzheng.company;

public class StringTest {
    /*
    给出一句英文句子:“let there be light"
    得到一个新的字符串，每个单词的首字母都转换为大写
     */
    public static void main(String[] args) {
        /*
        String s = "let there be light";
        String [] s1 = s.split("");
        for(int i = 0;i<s1.length;i++){
            String s2 = s1[i];
            char chars = Character.toUpperCase(s2.charAt(0));
            String rest = s2.substring(1);
            String capitalizeWord = chars+rest;
            s1[i] = capitalizeWord;
        }
        String result ="";
        for (String s2: s1) {
            result +=s2+"";
        }
        System.out.println(result);

         */
        String sentence = "let there be light";
        String s[] = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
         String s1 = str.substring(0, 1);//substring是截取字符串的意思
            //System.out.println(s1);
         String sss = s1.toUpperCase();
            //System.out.println(sss);
         String sU = s[i].replaceFirst(s1, sss);//把每个单词的s1转换成sss
            System.out.print(sU + " ");
         }

    }



    }

