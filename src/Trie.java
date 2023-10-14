public class Trie {
    static class Node{
        Node[] children;
        boolean endOfWord;
        public Node(){
            children = new Node[26]; // a-z
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            endOfWord = false;
        }
    }
    static Node root = new Node();

    // insert words
    public static void insert(String word){
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a'; 
            if(current.children[index] == null){
                // add new node
                current.children[index] = new Node();
            }
            if(i == word.length() - 1){
                current.children[index].endOfWord = true;
            }
            current = current.children[index];
        }
    }

    // search words
    public static boolean search(String word){
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            if((i == word.length() - 1) && (current.children[index].endOfWord == false)){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
