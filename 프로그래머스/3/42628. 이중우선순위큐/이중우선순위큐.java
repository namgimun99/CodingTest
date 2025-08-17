import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] result = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i< operations.length; i++) {
            String[] parts = operations[i].split(" ");
            if(parts[0].equals("I")) {
                if(map.containsKey(Integer.parseInt(parts[1]))) {
                    map.put(Integer.parseInt(parts[1]), map.get(Integer.parseInt(parts[1])) +1);
                } else {
                    map.putIfAbsent(Integer.parseInt(parts[1]), 1);
                }
            } else {
                if(!map.isEmpty()) {
                    if(Integer.parseInt(parts[1]) < 0) {
                        if(map.get(map.firstKey()) > 1) {
                            map.put(map.firstKey(), map.get(map.firstKey())-1);
                        } else {
                            map.remove(map.firstKey());
                        }
                    } else {
                        if(map.get(map.lastKey()) > 1) {
                            map.put(map.lastKey(), map.get(map.lastKey())-1);
                        } else {
                            map.remove(map.lastKey());
                        }
                    }
                }
            }
        }

        if(map.isEmpty()) {
            result[0] = 0;
            result[1] = 0;
        } else {
            result[0] = map.lastKey();
            result[1] = map.firstKey();
        }
        
        return result;
    }
}