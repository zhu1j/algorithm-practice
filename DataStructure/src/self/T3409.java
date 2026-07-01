package self;

import java.util.*;

public class T3409 {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String,Integer> cnt = new HashMap<>();

        for (String word: words){
            cnt.put(word,cnt.getOrDefault(word,0)+1);
        }

       List<Map.Entry<String,Integer>> ans = new ArrayList<>();

        for (Map.Entry<String,Integer> entry:cnt.entrySet()){
            if (entry.getValue() >= 3){
                ans.add(entry);
            }
        }

        ans.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }

                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String,Integer> entry : ans){
            System.out.println(entry.getKey());
        }
    }
}
