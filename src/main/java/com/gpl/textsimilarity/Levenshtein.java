package com.gpl.textsimilarity;
/*
 * 编辑距离算法：将两个字符串之间，由一个字符串转化为另一个字符串所需的最少编辑次数（编辑操作插入、删除、替换）
 */
public class Levenshtein {  
	  
    public static void main(String[] args) {
        Levenshtein ls = new Levenshtein();
        //要比较的两个字符串  
        String str1 = "今天星期四";  
        String str2 = "今天是星期五";
        ls.levenshtein(str1,str2);
        System.out.println("距离："+ls.ld(str1,str2));
    }

    //得到最小值
    private static int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
    public float levenshtein(String str1,String str2) {  
        //计算两个字符串的长度。  
        int len1 = str1.length();  
        int len2 = str2.length();
        if(len1 == 0)
            return len2;
        if(len2 == 0)
            return len1;
        //建立上面说的数组，比字符长度大一个空间  
        int[][] dif = new int[len1 + 1][len2 + 1];  
        //赋初值，步骤B。  
        for (int a = 0; a <= len1; a++) {  
            dif[a][0] = a;  
        }  
        for (int a = 0; a <= len2; a++) {  
            dif[0][a] = a;  
        }  
        //计算两个字符是否一样，计算左上的值  
        int temp;  
        for (int i = 1; i <= len1; i++) {
            char ch = str1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {  
                if (ch == str2.charAt(j - 1)) {
                    temp = 0;  
                } else {  
                    temp = 1;  
                }  
                //取三个值中最小的  
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,  
                        dif[i - 1][j] + 1);  
            }  
        }  
        System.out.println("字符串\""+str1+"\"与\""+str2+"\"的比较");  
        //取数组右下角的值，同样不同位置代表不同字符串的比较
        System.out.println("差异步骤："+dif[len1][len2]);  
        //计算相似度  
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());  
        //System.out.println("相似度："+similarity); 
        return similarity;
    }  
  


    //改进算法
    //http://blog.selfup.cn/826.html#more-826
    public static int ld(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n == 0) return m;
        if(m == 0) return n;

        int[] rowA = new int[n];
        int[] rowB = new int[n];
        for(int i = 0; i < n; i++){
            rowB[i] = i + 1;
        }

        boolean even = true;
        for(int i = 0; i < m; i++) {
            char ch1 = str2.charAt(i);
            even = i % 2 == 0;
            for(int j = 0; j < n; j++) {
                char ch2 = str1.charAt(j);
                int temp = ch1 == ch2 ? 0: 1;
                if(even) //若为偶数行，rowA记录新结果，rowB为历史结果
                    rowA[j] = min(j==0? i+1: rowA[j-1]+1,
                            rowB[j]+1, j==0? i: rowB[j-1]+temp);
                else //若为奇数行，rowB记录新结果，rowA为历史结果
                    rowB[j] = min(j==0? i+1: rowB[j-1]+1,
                            rowA[j]+1, j==0? i: rowA[j-1]+temp);
            }
        }
        return even ? rowA[n-1] : rowB[n-1]; //根据最后是奇数行还是偶数行返回对应的值
    }

}
