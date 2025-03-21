import java.util.*;
public class P6 {

    public static void main(String[] args){
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog"));
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple"));
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog"));
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day"));
        System.out.println(wordPattern("adxp", ' ', "ice cream taco day"));

    }


    /*
        n=pattern.length()
        m=s.length()
        p=max length word prior to delimiter or end of string in s ex: "apple|banana|grape|apple" p=6
        O(n)+O(m*(p+n))+O(p)+O(n)+O(n)=O(3n+mp+mn+p)=O(m*p+m*n)

        Space complexity
        O(n)
     */
    public static boolean wordPattern(String pattern, char delimeter, String s) {
        int count = 0; //O(1)
        int count2 = 0; //O(1)
        HashMap<Character, String> words = new HashMap<>(); //O(1)
        String temp2 = ""; //O(1)
        String numPat = uniq(pattern); //O(n)
        String tempString = "";
        for(int i = 0; i < s.length(); i++){ //O(m)
            if(s.charAt(i) == delimeter){ //O(m)+O(n)
                //System.out.println(s.substring(count,i));
                tempString = s.substring(count,i);//O(p)
                if(!words.containsValue(tempString) && !words.containsKey(pattern.charAt(count2)))//O(n)
                    words.put(pattern.charAt(count2), tempString);//O(1)cle
                count = i+1;//O(1)
                count2++;//O(1)
            }
            else
                temp2 += s.charAt(i);
        }

        //System.out.println(s.substring(count,s.length()));
        tempString = s.substring(count);
        if(numPat.length() != words.size() && count2 < pattern.length() && count < s.length()){ //O(1)
            if(!words.containsValue(tempString)) //O(n)
                words.put(pattern.charAt(count2),tempString); //O(1)
        }

        String temp = ""; //O(1)
        for(int i = 0; i < pattern.length(); i++){//O(n)
            temp += words.get(pattern.charAt(i));//O(1)
        }

        //System.out.println(words);
        // System.out.println(temp);
        // System.out.println(temp2);

        return temp.equals(temp2);//O(1)
    }

    /*
    n = pattern.length()
    O(n)+O(26)=O(n)
     */
    public static String uniq(String pattern){
        int[] count = new int[26];
        for(int i = 0; i < pattern.length(); i++){//O(n)
            count[(int)pattern.charAt(i) % 96]++;
        }

        String s = "";
        for(int i = 0; i < count.length; i++){//O(26)
            if(count[i] != 0){
                s += (char) (i + 96);
            }
        }
        return s;
    }
}
