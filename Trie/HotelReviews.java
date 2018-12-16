import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class HotelReviews {

    class Trie {
        Map<Character, Trie>map;
        boolean isEndOfWord;
        Trie() {
            map = new HashMap<>();
        }
    }

    Trie root;

    class Pair {
        int index;
        int count;
        Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    void insert(String str) {
        Trie curr = root;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(curr.map.get(ch) == null) {
                curr.map.put(ch, new Trie());
            }
            curr = curr.map.get(ch);
        }
        curr.isEndOfWord = true;
    }

    boolean Search(Trie curr, String str, int index) {
        if(str.length() == index) {
            if(curr.isEndOfWord == true) {
                return true;
            }
            return false;
        }
        char ch = str.charAt(index);
        if(curr.map.get(ch) == null) {
            return false;
        }
        return Search(curr.map.get(ch), str, index+1);
    }

    ArrayList<Integer> Find(String str, ArrayList<String>arl) {
        String[] arr = str.split("_");
        root = new Trie();
        ArrayList<Pair>res = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        for(int i=0; i<arl.size(); i++) {
            String[] words = arl.get(i).split("_");
            int count = 0;
            for(int j=0; j<words.length; j++) {
                if(Search(root, words[j], 0) == true) {
                    count = count+1;
                }
            }
            Pair pair = new Pair(i, count);
            res.add(pair);
        }
        Collections.sort(res, new Comparator<Pair>() {

            public int compare(Pair a, Pair b) {
                return -1*(((Integer)a.count).compareTo((Integer)b.count));
            }
        });
        ArrayList<Integer>fres = new ArrayList<>();
        for(int i=0; i<res.size(); i++) {
            fres.add(res.get(i).index);
        }
        return fres;
    }

    void display(ArrayList<Integer>res) {
        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        ArrayList<String>arl = new ArrayList<>();
        arl.add("water_is_cool");
        arl.add("cold_ice_drink");
        arl.add("cool_wifi_speed");
        String str = new String("cool_ice_wifi");
        HotelReviews obj = new HotelReviews();
        ArrayList<Integer>res = obj.Find(str, arl);
        obj.display(res);
    }

}
