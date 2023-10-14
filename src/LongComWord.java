import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LongComWord extends Trie{
    public static String[] longestCompound(List<String> words){
        String longest = "";
        String secondLongest = "";
        for(String word : words){
            if(wordsBreak(word, 0)){
                if (word.length() > longest.length()) {
                    secondLongest = longest;
                    longest = word;
                }
                else if(word.length() > secondLongest.length() && !word.equals(longest)){
                    secondLongest = word;
                }
            }
        }
        String[] ans = {longest, secondLongest};
        return ans;
    }

    public static boolean wordsBreak(String key, int count){
        if(key.length() == 0 && count > 1){
            return true;
        }
        for(int i = 1; i <= key.length(); i++){
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if(search(firstPart) && wordsBreak(secondPart, count + 1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        ArrayList<String> words = new ArrayList<>();
        long startTime = System.currentTimeMillis();  // time start

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("Input_01.txt"));
            String line;

            while ((line = buffer.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                    Trie.insert(word);
                }
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

        String[] ans = longestCompound(words);

        long endTime = System.currentTimeMillis(); // time end
        long totalTime = endTime - startTime;

        System.out.println("Longest compound word: " + ans[0]);
        System.out.println("Second longest compound word: " + ans[1]);
        System.out.println("Total time taken: " + totalTime + "ms");
    }
}
