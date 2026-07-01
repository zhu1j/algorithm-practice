package string_algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 5406. 字符串中的第一个唯一字符
 * 简单 算法 字符串
 *
 * 给定一个字符串 s，输出字符串中第一个不重复的字符。
 *
 * 输入格式
 * 一个字符串 s。
 *
 * 输出格式
 * 第一个不重复字符。如果没有不重复字符，输出 no。
 */
public class T5406_UniqueCharacter {

    static void main() {
        String s = "suanfazifuchuan";
        System.out.println(new T5406_UniqueCharacter().firstUniqueCharacter(s));
    }
    public char firstUniqueCharacter(String s){

        Map<Character,Integer> count = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            count.put(ch,count.getOrDefault(ch,0)+1);
        }
        for (char ch : s.toCharArray()){
            if (count.get(ch) == 1){
                return ch;
            }
        }
        return 'n';
    }
}
