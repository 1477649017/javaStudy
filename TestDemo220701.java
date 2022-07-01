/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-01
 * Time: 9:33
 */
class Solution {
    public int relevantInt(char c){
        int ret = 0;
        switch(c){
            case 'I':
                ret = 1;
                break;
            case 'V':
                ret = 5;
                break;
            case 'X':
                ret = 10;
                break;
            case 'L':
                ret = 50;
                break;
            case 'C':
                ret = 100;
                break;
            case 'D':
                ret = 500;
                break;
            case 'M':
                ret = 1000;
                break;
            case 'a':
                ret = 4;
                break;
            case 'b':
                ret = 9;
                break;
            case 'c':
                ret = 40;
                break;
            case 'd':
                ret = 90;
                break;
            case 'e':
                ret = 400;
                break;
            case 'f':
                ret = 900;
                break;
        }
        return ret;

    }
    public int romanToInt(String s) {
        String[] roman = new String[]{"IV","IX","XL","XC","CD","CM"};
        for(int i = 0;i < roman.length;i++){
            if(s.contains(roman[i]) && roman[i] == "IV"){
                s = s.replace(roman[i],"a");
            }else if(s.contains(roman[i]) && roman[i] == "IX"){
                s = s.replace(roman[i],"b");
            }else if(s.contains(roman[i]) && roman[i] == "XL"){
                s = s.replace(roman[i],"c");
            }else if(s.contains(roman[i]) && roman[i] == "XC"){
                s = s.replace(roman[i],"d");
            }else if(s.contains(roman[i]) && roman[i] == "CD"){
                s = s.replace(roman[i],"e");
            }else if(s.contains(roman[i]) && roman[i] == "CM"){
                s = s.replace(roman[i],"f");
            }
        }

        int count = 0;
        for(int i = 0;i < s.length();i++){
            count += relevantInt(s.charAt(i));
        }
        return count;

    }
}
public class TestDemo {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int reu = sl.romanToInt("MCMXCIV");
        System.out.println(reu);
    }
}
