import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Main{
    public static void main(String[] args){
        //经过计算观察，我们会发现左上角的数就是 1 2 3 5 8 13 ..
        //次方数值最大是10000
        int[] arr = new int[10001];//浪费一个空间，让下标值直接和次方值可以直接对应起来
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3;i < 10001;i++){
            //只存结果的最后四位
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] = arr[i] % 10000;
        }

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            for(int i = 0;i < n;i++){
                int j = scan.nextInt();
                System.out.print(String.format("%04d",arr[j]));
            }
        }

    }
    public static void main7(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = 2 * n - 1;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1 - i; j < (n - 1 - i) + (2 * i + 1); j++) {
                if (i <= 1) {
                    arr[i][j] = 1;
                } else if (j == n - 1 - i || j == n + i - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1];
                    if (i == n - 1 && arr[i][j] % 2 == 0) {
                        System.out.println(j + 1);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);

    }

    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        if(str1.length() > str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        String ret = "";
        for(int i = 0;i < str1.length();i++){
            int tmp = i;
            int flag = 0;//标志位
            int left = 0;
            int right = 0;
            for(int j = 0;j < str2.length();j++){
                if(str2.charAt(j) == str1.charAt(tmp)){
                    if(flag == 0){
                        flag = 1;
                        left = tmp;
                    }
                    if(tmp == str1.length() - 1){
                        right = str1.length();
                        if(str1.substring(left,right).length() > ret.length()){
                            ret = str1.substring(left,right);
                        }
                        break;
                    }
                    tmp++;
                }else{
                    if(flag == 1){
                        flag = 0;
                        right = tmp;
                    }
                    if(str1.substring(left,right).length() > ret.length()){
                        ret = str1.substring(left,right);
                    }
                }
            }
        }
        System.out.println(ret);

    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer(scan.next());
        for(int i = 0;i < stringBuffer.length();i++){
            char ch = stringBuffer.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u'){
                stringBuffer.setCharAt(i,(char)(ch-32));
            }
        }
        System.out.println(stringBuffer.toString());
    }
    public static  int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int sum = 0;//用来记录当某一个颜色手套数量为0的时候，另一个对应手上的数量
        int leftSum = 0;//记录左手手套要取的数量
        int rightSum = 0;//记录右手手套要取的数量
        int leftMin = Integer.MAX_VALUE;//记录左手手套数量的最小值
        int rightMin = Integer.MAX_VALUE;//记录右手手套数量的最小值
        for(int i = 0;i < n;i++){
            if(left[i]*right[i] == 0){
                sum = sum + left[i] + right[i];
            }else{
                leftSum += left[i];
                if(left[i] < leftMin){
                    leftMin = left[i];
                }
                rightSum += right[i];
                if(right[i] < rightMin){
                    rightMin = right[i];
                }
            }
        }

        return sum + Math.min(leftSum - leftMin + 1,rightSum - rightMin + 1) + 1;
    }
    public static void main4(String[] args) {
        int[] left = new int[]{1,2,0,1,3,1};
        int[] right = new int[]{0,0,0,2,0,1};
        int ret = findMinimum(6, left, right);
        System.out.println(ret);

    }
    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine().toLowerCase();
        String str2 = scan.nextLine().toLowerCase();
        int index = 0;
        for(int i = 0;i < str1.length();i++){
            if(str1.charAt(i) == '?' || str1.charAt(i) == '*'){
                if(str1.charAt(i) == '?'){
                    //匹配一个字符
                    if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' || str2.charAt(i) >= '0' || str2.charAt(i) <= '9'){
                        //只能匹配到数字，字母
                        System.out.println(false);
                        return;
                    }else{
                        continue;
                    }
                }else{
                    //如果是*号是需要匹配多个字符的
                    if(i != str1.length() - 1){
                        char ch = str1.charAt(i+1);
                        index = i;
                        while(str2.charAt(index) != ch){
                            if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' || str2.charAt(i) >= '0' || str2.charAt(i) <= '9'){
                                System.out.println(false);
                                return;
                            }
                            index++;
                        }
                    }else{
                        //就从index位置开始遍历str2看是否可以进行合法匹配

                        while(index < str2.length()){
                            if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' || str2.charAt(i) >= '0' || str2.charAt(i) <= '9'){
                                System.out.println(false);
                                return;
                            }
                            index++;
                        }
                    }
                }
            }else if(str1.charAt(i) != str2.charAt(i)){
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
    public static void main1(String[] args){
        //就是一个简单的分割问题，中间比较麻烦的就是需要处理下双引号中的空格的问题
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //先求出参数的个数，这里注意，参数个数是空格数加1，当然这个空格不是双引号中的空格
        int count = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '"'){
                //如果这个字符是双引号，那就一直加加直到遇到第二个双引号
                do{
                    i++;
                }while(str.charAt(i) != '"');//遇到第二个“就会跳出循环
            }
            if(str.charAt(i) == ' '){
                //遇到了不是在双引号中的空格
                count++;
            }
        }
        System.out.println(count+1);
        //开始进行分割
        int flag = 0;//用来标记遇到了双引号
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '"'){
                if(flag == 0){
                    flag = 1;//说明是第一次遇到"
                }else if(flag == 1){
                    //说明这是遇到了与之前双引号匹配的第二个"
                    flag = 0;//重新置为0，方便下次寻找
                }
            }
            //双引号，以及不是双引号中的空格都是不需要输出的
            if(str.charAt(i) != '"' && str.charAt(i) != ' '){
                System.out.print(str.charAt(i));//先不输出换行
            }
            //等于空格还需要判断一下是双引号中的空格是需要输出的
            if(str.charAt(i) == ' ' && flag == 1){
                System.out.print(str.charAt(i));//把这个空格输出
            }
            if(str.charAt(i) == ' ' && flag == 0){
                //遇到空格。但是这个空格不是双引号中的，所以不输出，并且要换行
                System.out.println();
            }

        }

    }
//    public static int getLCA(int a, int b) {
        // write code here
//        if(a == 1 || b == 1){
//            return 1;
//
//        }
//        if(a + 1 == b || b + 1 == a){
//            return a/2;
//        }
//
//        if(a%b == 0 || a%b == 1){
//            return b;
//        }
//        if(b%a == 0 || b%a == 1){
//            return a;
//        }
//
//        while(a != b){
//            a /= 2;
//            b /= 2;
//        }
//
//        return a;

//        while(a != b){
//            if(a > b){
//                a /= 2;
//            }else{
//                b /= 2;
//            }
//        }
//        return a;
//
//    }

//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNextInt()){
//            int n = scan.nextInt();
//            int count = 0;
//            int flag = 0;
//            int max = 0;
//            for(int i = 0;i < 32;i++){
//                if(((n>>i)&1) == 1){
//                    if(flag == 0){
//                        flag = 1;
//                        count = 0;
//                    }
//                    count++;
//                    if(count > max){
//                        max = count;
//                    }
//                }else{
//                    flag = 0;
//                }
//            }
//            System.out.println(max);
//        }
//    }
//    public static void main(String[] args) {
//        int ret = getLCA(12,15);
//        System.out.println(ret);
//    }
//    public static boolean isDictSort(String[] arr,int n){
//        for(int i = 1;i < n;i++){
//            int len1 = arr[i].length();
//            int len2 = arr[i-1].length();
//            int minLen = (len1 < len2) ? len1 : len2;
//            for(int j = 0;j < minLen;j++){
//                if(arr[i].charAt(j) == arr[i-1].charAt(j)){
//                    continue;
//                }else if(arr[i].charAt(j) > arr[i-1].charAt(j)){
//                    break;
//                }else{
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static boolean isLenSort(String[] arr,int n){
//        for(int i = 1;i < n;i++){
//            if(arr[i].length() >= arr[i-1].length()){
//                continue;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        String[] arr = new String[n];
//        for(int i = 0;i < n;i++){
//            arr[i] = scan.next();
//        }
//        boolean ret1 = isDictSort(arr,n);
//        boolean ret2 = isLenSort(arr,n);
//        if(ret1 && ret2){
//            System.out.println("both");
//        }else if(ret1){
//            System.out.println("lexicographically");
//        }else if(ret2){
//            System.out.println("lengths");
//        }else{
//            System.out.println("none");
//        }
//    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int w = scan.nextInt();//列数
//        int h = scan.nextInt();//行数
//        int[][] arr = new int[h][w];
//        for (int[] tmp:arr) {
//            Arrays.fill(tmp,1);//注意二维数组是不能直接使用fill的
//        }
//        for(int i = 0;i < h;i++){
//            for(int j = 0;j < w;j++){
//                if(i == 0 && j == 0){
//                    //第一个直接放
//                    arr[0][0] = 1;
//                }else{
//                    if(arr[i][j] != -1){
//                        //标记为-1的位置不能放
//                        arr[i][j] = 0;
//                    }
//                }
//                if(arr[i][j] != -1){
//                    if(i+2 < h){
//                        arr[i+2][j] = -1;
//                    }
//                    if(j+2 < w){
//                        arr[i][j+2] = -1;
//                    }
//                }
//            }
//        }
//        int count = 0;
//        for(int i = 0;i < h;i++){
//            for(int j = 0;j < w;j++){
//                if(arr[i][j] == 0){
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0;i < n;i++){
//            arr[i] = scan.nextInt();
//        }
//        long maxSum = Long.MIN_VALUE;//记录最大和
//        long sum = 0;
//        for(int i = 0;i < n;i++){
//            if(arr[i] > 0){
//                if(arr[i-1] < 0){
//                    sum = arr[i];
//                }else{
//                    sum += arr[i];
//                }
//                if(sum > maxSum){
//                    maxSum = sum;
//                }
//            }else{
//                sum = arr[i];
//                if(sum > maxSum){
//                    maxSum = sum;
//                }
//            }
//        }
//        System.out.println(maxSum);
//    }
//    public static void main(String[] args) {
//        //排序子序列
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();//输入数据的个数
//        int[] arr = new int[n];
//        for(int i = 0;i < n;i++){
//            arr[i] = scan.nextInt();
//        }
//
//        int count = 1;//不管怎样，至少有一个子序列
//        int flag = 0;//用来标记当前是处在非递减还是非递增序列中
//        for(int i = 1;i < n;i++){//从第二个元素开始
//            //相等的值可以不用管，因为算在哪个序列里面都可以，所以不影响结果的
//            if(arr[i] > arr[i-1]){
//                if(flag == 0){
//                    flag = 1;//说明现在是在非递减序列里面
//                }else if(flag == -1){
//                    //表示现在是由非递增序列变到非递减序列里面的，也就是发现了一个突变点
//                    flag = 0;//
//                    count++;
//                }
//            }else if(arr[i] < arr[i-1]){
//                if(flag == 0){
//                    flag = -1;//说明现在是在非递增序列里面
//                }else if(flag == 1){
//                    //表示现在是由非递减序列变到非递增序列里面的，也就是发现了一个突变点
//                    flag = 0;
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
//        int start = 0;
//        int end = 0;
//        int flag = -1;//默认开始不是数字字符
//        ArrayList<String> list = new ArrayList<>();
//        for(int i = 0;i < s.length();i++){
//            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
//                //说明是数字字符
//                if(flag == -1){
//                    start = i;
//                    flag = 1;
//                }else if(i == s.length() - 1){
//                    end = i + 1;
//                    list.add(s.substring(start,end));
//                }
//            }else{
//                if(flag == 1){
//                    //先判断一下当前flag，可能是从数字字符变为不是数字字符
//                    flag = -1;//遇到不是数字字符，就置为-1
//                    end = i;
//                    list.add(s.substring(start,end));
//                }
//
//            }
//        }
//        String ret = "";
//        int max = 0;
//        for(int i = 0;i < list.size();i++){
//            if(list.get(i).length() > max){
//                max = list.get(i).length();
//                ret = list.get(i);
//            }
//        }
//        System.out.println(ret);
//    }

//    public static void main(String[] args){
//
//        Scanner scan = new Scanner(System.in);
//        int m = scan.nextInt();
//        int n = scan.nextInt();
//        StringBuffer stringBuffer = new StringBuffer();
//        if(m == 0){
//            System.out.println(0);
//            return ;
//        }
//        boolean flag = true;//标记当前m就是正数
//        if(m < 0){
//            m = Math.abs(m);//转换成正数算
//            flag = false;
//        }
//        while(m!= 0){
//            int ret = m%n;
//            m = m/n;
//            if(ret > 9){
//                if(ret == 10){
//                    stringBuffer.append("A");
//                }else if(ret == 11){
//                    stringBuffer.append("B");
//                }else if(ret == 12){
//                    stringBuffer.append("C");
//                }else if(ret == 13){
//                    stringBuffer.append("D");
//                }else if(ret == 14){
//                    stringBuffer.append("E");
//                }else{
//                    stringBuffer.append("F");
//                }
//            }else{
//                stringBuffer.append(ret);
//            }
//        }
//
//        if(flag == false){
//            stringBuffer.append("-");
//        }
//        stringBuffer.reverse();
//        System.out.println(stringBuffer.toString());
//
//    }
//    public static void main(String[] args) {
//        String s1 = "admin";
//        String s2 = s1.toLowerCase(Locale.ROOT);
//        System.out.println(s1 == s2);
//
//       String s3 = "Admin";
//       String s4 = s3.toLowerCase(Locale.ROOT);
//       System.out.println(s3 == s4);
//
//    }

}