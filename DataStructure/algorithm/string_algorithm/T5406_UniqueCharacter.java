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
 *
 *学到了：
 * 1.String.toCharArray()
 * 作用：把字符串转为char 字符数组，每个元素对应字符串单个字符。
 * 常用场景：1）遍历字符串每个字符。 2）修改单个字符（String 不可变，数组可改）
 * 特点：1)原字符串不变，返回全新数组. 2)空字符串返回长度 0 的空数组
 *
 * 2.Map.getOrDefault (key, defaultValue)  （Java Map 接口）
 * 作用:获取 Map 中 key 对应的值：1)key 存在 → 返回对应 value。 2)key 不存在 → 返回你传入的默认值，不会返回 null
 * 常用场景：计数、配置读取、兜底默认参数，不用手动判空 if。
 * 对比普通 get ():
 *      map.get("香蕉"); // 不存在返回null，数字接收会空指针
 *      map.getOrDefault("香蕉", 0); // 兜底，避免NPE
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
