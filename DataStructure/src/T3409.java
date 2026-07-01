import java.util.*;

public class T3409 {

    static void main() {
        /**
         * 推荐系统
         * 中等
         * 哈希表
         * 题目描述
         * 统计热点词频；输入一个字符串，统计词频后，按照词频从高到低打印热搜单词（出现次数大于等于3的单词）
         * 对于两个词频相同的单词，要按单词字典序打印。
         * */

            Scanner scanner = new Scanner(System.in);

            // 读取一整行输入，按空格分割成字符串数组（每个元素是一个单词）
            String[] words = scanner.nextLine().split(" ");

            // 创建HashMap：key=单词，value=单词出现的次数
            Map<String, Integer> cnt = new HashMap<>();

            // 遍历所有单词，统计每个单词出现次数
            for (String word : words) {
                // 有就取次数+1，没有就默认0+1，再存回map
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }

            // 创建集合ans：用来存放 出现次数>=3次 的单词
            List<Map.Entry<String, Integer>> ans = new ArrayList<>();

            // 遍历HashMap里的每一个键值对（单词+次数）
            for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
                // 如果这个单词出现次数 >= 3次
                if (entry.getValue() >= 3) {
                    // 就把这个键值对加入到ans集合中
                    ans.add(entry);
                }
            }

            // 对ans集合进行排序（核心排序逻辑）
                //升序：从小到大    降序：从大到小
            ans.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    // 如果两个单词出现次数一样
                    if (entry1.getValue().equals(entry2.getValue())) {
                        // 按 单词的字典序（字母顺序） 升序排列
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    // 如果次数不一样，按 出现次数 降序排列（次数多的排前面）
                    return entry2.getValue().compareTo(entry1.getValue()); //反着写就是降序，其实就是程序和存储顺序的关系，顺则升序，逆则降序
                }
            });

            // 遍历排序后的结果，只输出单词（key）
            for (Map.Entry<String, Integer> entry : ans) {
                System.out.println(entry.getKey());
            }
        }

    /**
     * List：有序、能重复、有下标
     * Set：去重、有无序看实现、无下标
     * Map：无重复、有无序看实现、无下标
     */

}
