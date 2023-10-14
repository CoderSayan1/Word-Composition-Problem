Longest Compound Word


To solve this problem I am using "Trie data structure".

1) At first, I create Trie data structure.
2) Next I create an arraylist called 'word'.
3) Use a BufferedReader and FileReader to read words from the input file and save them in a string type array to be used with the Trie data structure.
4) And take startTime and endTime to check how much time taken to process the input file.
5) Create a string type method calls 'longestCompound'. Herre I pass the words as a parameter. Initialize 'longest' and 'secondLongest' as empty string variable and for loop to iterate through each word of the file and compare them. Here also I use a method 'wordsBreak'. This method checks each words one by one that the word is compound or not by using the count variable, if the count is greater than 1, then it returns true.
	In the 'wordsBreak' method, using for loop I divide the word into two parts and in the if statement search for the first part and recursive call for the second part, if both return true then the result is true and in the 'longestCompound' method, inside the for loop if the 'wordsBreak' is return true, then it check the length of the word, if the length is greater than the 'longest' then current word is stored in 'longest' and the previous value is stored in 'secondLongest'. Finally, return the 'longest' and 'secondLongest'.
