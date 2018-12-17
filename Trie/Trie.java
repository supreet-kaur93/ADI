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

    boolean delete(String str, Trie root, int index) {
        if(str.length() == index) {
            if(root.isEndOfWord == true) {
                root.isEndOfWord = false;
                for(int i=0; i<26; i++) {
                    if(root.map.get('a'+i) != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        char ch = str.charAt(index);
        if(root.map.get(ch) == null) {
            return false;
        }
        if(delete(str, root.map.get(ch), index+1)) {
            char c = str.charAt(index);
            root.map.put(c, null);
            for(int i=0; i<26; i++) {
                if(root.map.get('a' + i) != null) {
                    return false;
                }
                return true;
            }
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
        System.out.println(trie.delete("hell", trie.root, 0));
        System.out.println(trie.Search("hell"));
    }
}
