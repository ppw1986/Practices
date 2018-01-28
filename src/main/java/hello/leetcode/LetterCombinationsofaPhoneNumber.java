package hello.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pandeyu on 17/11/26.
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.trim().length()==0)
            return new ArrayList<String>();

        Map<String, String[]> numMap = new HashMap<String,String[]>();
        numMap.put("0",new String[]{"-"});
        numMap.put("1",new String[]{"_"});
        numMap.put("2",new String[]{"a","b","c"});
        numMap.put("3",new String[]{"d","e","f"});
        numMap.put("4",new String[]{"g","h","i"});
        numMap.put("5",new String[]{"j","k","l"});
        numMap.put("6",new String[]{"m","n","o"});
        numMap.put("7",new String[]{"p","q","r","s"});
        numMap.put("8",new String[]{"t","u","v"});
        numMap.put("9",new String[]{"w","x","y","z"});

        List<String>[] numResult  =  new ArrayList[digits.length()];

        List<String> result  = new ArrayList<String>();
        for(int i =0; i<digits.length();i++){
            List<String> num = new ArrayList<String>();
            numResult[i] = num;

            String ch = digits.substring(i,i+1);
            String[] chMlist = numMap.get(ch);
            for (int j=0;j<chMlist.length;j++){
                if(i==0){
                    num.add(chMlist[j]);
                }else {
                    for(int k=0; k<numResult[i-1].size();k++){
                        num.add(numResult[i-1].get(k)+chMlist[j]);
                    }

                }

            }
        }

        for (String s : numResult[digits.length()-1])
            System.out.println(s);
        return numResult[digits.length()-1];
    }


    public List<String> letterCombinations2(String digits) {
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<String>();
        if(digits.equals(""))
            return result;

        helper(result, new StringBuilder(), digits, 0, map);

        return result;

    }

    public void helper(List<String> result, StringBuilder sb, String digits, int index, HashMap<Character, char[]> map){
        if(index>=digits.length()){
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        char[] arr = map.get(c);

        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            helper(result, sb, digits, index+1, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args){
        LetterCombinationsofaPhoneNumber l  = new LetterCombinationsofaPhoneNumber();
//        l.letterCombinations("23");
        for(String s: l.letterCombinations2("34")){
            System.out.println(s);
        }
    }
}
