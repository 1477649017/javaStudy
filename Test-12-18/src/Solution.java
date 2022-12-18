//import java.util.*;
//public class Solution {
//    /**
//     * 验证IP地址
//     * @param IP string字符串 一个IP地址字符串
//     * @return string字符串
//     */
//    public boolean isIPv4(String IP){
//        //IPv4地址 点分十进制表示 分隔符是. 一共四个字节
//        if(!IP.contains(".")){
//            //不包含分隔符.
//            return false;
//        }
//        String[] s = IP.split("\\.");
//        if(s.length != 4){
//            //不是四个字节
//            return false;
//        }
//        //每个数值不为0的时候 不可以以0开头
//        for(int i = 0;i < s.length;i++){
//            if(s[i].length() == 0){
//                //存在一个字节的字符串长度为0 也就是空字符串 会导致..相连
//                return false;
//            }
//            if(s[i].length() > 3){
//                //对于一个IPv4地址的一个字节而言 它的值最大是255 所以字符串长度不会超过3
//                return false;
//            }
//            //IPv4地址点分十进制表示 所以每个字节的值不可能超过255 并且字符串的话每一个字符只能是数字字符
//            for(int j = 0;j < s[i].length();j++){
//                char ch = s[i].charAt(j);
//                if(ch < '0' || ch > '9'){
//                    return false;
//                }
//            }
//            if(Integer.parseInt(s[i]) > 255 || Integer.parseInt(s[i]) < 0){
//                 return false;
//            }
//            if(Integer.parseInt(s[i]) != 0 && s[i].charAt(0) == '0'){
//                //这个字节的值不是0，但是是以0开头的
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isIPv6(String IP){
//        if(!IP.contains(":")){
//            return false;
//        }
//        //IPv6地址 16字节 128位 十六进制表示 一个十六进制数占4位
//        //一共八组 每组两个字节 每个字节包含两个十六进制数 字符数也就是4个
//        String[] s = IP.split(":");
//        if(s.length != 8){
//            //不是8组
//            return false;
//        }
//        for(int i = 0;i < s.length;i++){
//            if(s[i].length() == 0 || s[i].length() > 4){
//                //每个字符串不能是空字符串 不然会::相连 长度也不会大于4
//                return false;
//            }
//            //IPv6十六进制 允许0开头 判断每个字符是不是数字 或者是a~f A~F
//            for(int j = 0;j < s[i].length();j++){
//                char ch = s[i].charAt(j);
//                if(!(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A'&& ch <= 'Z')){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public String solve (String IP) {
//        // write code here
//        //遍历按照IPv4 IPv6的规则去一个个的对比
//        if(isIPv4(IP)){
//            return "IPv4";
//        }else if(isIPv6(IP)){
//            return "IPv6";
//        }else{
//            return "Neither";
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solve("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
//        String s = "a:b:c:d:";
//        String[] arr1 = s.split(":");
//        String[] arr2 = s.split(":",-1);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//    }
//}

//大数加法
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */

    //大数加法 直接加肯定不行 那就遍历字符串模拟相加进位的过程即可
    public String getSumStr(String s,String t){
        int carry = 0;//记录一下进位
        StringBuilder str = new StringBuilder();
        int j = s.length() - 1;//记录s的位置下标
        for(int i = t.length() - 1;i >= 0;i--){
            char ch1 = t.charAt(i);
            char ch2;
            if(j < 0){
                ch2 = '0';//s遍历完了就把它值当作0即可
            }else{
                ch2 = s.charAt(j);
                j--;
            }
            int sum = ch1 - 48 + ch2 - 48 + carry;
            if(sum >= 10){
                //需要进位
                carry = 1;
                sum %= 10;
            }else{
                //不需要进位 把carry置为0
                carry = 0;
            }
            str.append(String.valueOf(sum));//添加到StringBuilder对象中
        }
        if(carry == 1){
            //最后可能前面还需要补进1一位
            str.append("1");
        }
        return str.reverse().toString();//需要逆序一下才是结果
    }
    public String solve (String s, String t) {
        // write code here
        String ret = "";
        if(s.length() < t.length()){
            ret = getSumStr(s,t);
        }else{
            ret = getSumStr(t,s);
        }
        return ret;
    }
}