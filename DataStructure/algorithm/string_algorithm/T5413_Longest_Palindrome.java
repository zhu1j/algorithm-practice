package string_algorithm;

public class T5413_Longest_Palindrome {
    public static void main(String[] args) {
        String s = "dbabdaa";
        System.out.println(longestPalindrome(s));  // 输出: "dbabd"
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数回文：中心i
            int len1 = expandAroundCenter(s, i, i);
            // 偶数回文：中心i和i+1之间
            int len2 = expandAroundCenter(s, i, i + 1);
            // 当前中心最长回文长度
            int maxLen = Math.max(len1, len2);

            // 如果当前回文比之前记录的更长，更新起止下标 （核心在这）
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;  //JAVA整数除法向0取整
                /** 我的理解
                 * i是中心坐标，后面的公式是找中间两位
                 *  1)奇数个数：start和end都是最中间的 2)偶数个数：中间缝隙的左右两个
                 *这段代码就是以 i 为中心，向两边按照maxLen的中心来扩展
                 *  这个if判断
                 *  # 就是以i为中心，根据maxLen长度，找到对应的最大回文字符串首尾下标
                 * */
            }
        }

        return s.substring(start, end + 1); //不包后
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;   //返回的是最大回文串长度（左右坐标为当前中心坐标），多走一步所以减1
    }
}
