import java.util.Arrays;
import java.util.*;

public class P5 {
    public static void main(String[] args){
        String[] arr = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "hydra", "amazonia", "vueltiao", "aaa"};
        System.out.println(Arrays.toString(radixSort(arr)));
    }


    /*
    n = s.length;
    m = max string length in s
    O(n)+O(m(n))
    O(n+m(n))=O(m*n)


    Space complexity
    O(1)+O(n)=O(n)
     */
    public static String[] radixSort(String[] s){
        int maxLength = calcMax(s);

        for (int i = maxLength - 1; i >= 0; i--) {//O(m)
            s = buckets(s, i);//O(n)
        }

        return s;
    }

    /*
        n=s.length

        O(2n)+O(27(n))
        O(29(n))=O(n)

        Space Complexity
        O(27*n)+O(n)+O(27)=O(28n+27)=O(28n)=O(n)
     */
    public static String[] buckets(String[] s, int charIndex){
         String[][] buckets = new String[27][s.length];//O(1)
         int bucketIndex = 0;//O(1)
         for(int i = 0; i < s.length; i++){//O(n)
             bucketIndex = getIndex(s[i], charIndex);//O(1)
             buckets[bucketIndex][i] = s[i];//O(1)
         }

        String[] temp = new String[s.length];//O(1)
        int count = 0;//O(1)
        for(int i = 0; i < buckets.length; i++){//O(27)
            for(int j = 0; j < buckets[i].length; j++){//O(s.length)
                if(buckets[i][j] != null){
                    temp[count] = buckets[i][j];
                    count++;
                }
            }
        }
        
         return temp;
    }

    public static int calcMax(String[] s){
        int maxLength = 0; //O(1)
        for(String q : s){ //O(n)
            if(q.length() > maxLength)
                maxLength = q.length();
        }

        return maxLength;
    }


    /*
//             if (s[i].charAt(charIndex) != ' ') {
//                 bucketIndex = (s[i].charAt(charIndex) - 97) + 1;
//             }
//             else
//                 bucketIndex = 0;
     */
    public static int getIndex(String s, int index){
        int bucketIndex = 0; //O(1)
        if(s.length() > index){ //O(1)
            bucketIndex = (s.charAt(index) - 97) + 1; //O(1)
        }
        return bucketIndex; //O(1)
    }



//    public static String[] padString(String[] s){
//        int max = calcMax(s);
//        int difference = 0;
//        int j = 0;
//        for(int i = 0; i < s.length; i++){
//            if(s[i].length() < max){
//                difference = max - s[i].length();
//                for(j = 0; j < difference; j++ ){
//                    s[i] += " ";
//                }
//            }
//        }
//
//        return s;
//    }
//
//    public static String[] unpadString(String[] s){
//        String[] temp = new String[s.length];
//        String tempString = "";
//        int j = 0;
//        for(int i = 0; i < s.length; i++){
//            for(j = 0; j < s[i].length(); j++){
//                if(s[i].charAt(j) != ' ')
//                    tempString += s[i].charAt(j);
//            }
//            temp[i] = tempString;
//            tempString = "";
//        }
//
//        return temp;
//    }
}
