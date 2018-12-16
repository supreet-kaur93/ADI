import java.util.Map;
import java.util.HashMap;

class Trie {

    Map<Character, Trie>map;
    boolean isEndOfWord;
    Trie() {
        map = new HashMap<>();
    }

    Trie root;

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

    boolean Search(String str) {
        Trie curr = root;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(curr.map.get(ch) == null) {
                return false;
            }
            curr = curr.map.get(ch);
        }
        if(curr.isEndOfWord == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        System.out.println(trie.Search("hell"));
        System.out.println(trie.Search("hel"));
    }
}
