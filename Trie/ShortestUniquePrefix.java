import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class ShortestUniquePrefix {

    private class Trie {
        Map<Character, Trie>map;
        boolean isEndOfWord;
        int freq;
        Trie() {
            map = new HashMap<>();
        }
    }

    Trie root;

    void insert(String str) {
        Trie curr = root;
        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            if(curr.map.get(ch) == null) {
                curr.map.put(ch, new Trie());
            }
            (curr.map.get(ch).freq)++;
            curr = curr.map.get(ch);
        }
        curr.isEndOfWord = true;
    }

    String Prefix(String str) {
        String res = "";
        Trie curr = root;
        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            if(curr.map.get(ch).freq == 1) {
                res = res + ch;
                break;
            }
            else if(curr.map.get(ch).freq  > 1) {
                res = res + ch;
            }
            curr = curr.map.get(ch);
        }
        return res;
    }

    void FindPrefix(ArrayList<String>arl) {
        root = new Trie();
        for(int i=0; i<arl.size(); i++) {
            String str = arl.get(i);
            insert(str);
        }
        ArrayList<String>res = new ArrayList<>();
        for(int i=0; i<arl.size(); i++) {
            res.add(Prefix(arl.get(i)));
        }
        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ShortestUniquePrefix obj = new ShortestUniquePrefix();
        ArrayList<String>arl = new ArrayList<>();
        arl.add("zebra");
        arl.add("dog");
        arl.add("duck");
        arl.add("dove");
        obj.FindPrefix(arl);
    }
}
