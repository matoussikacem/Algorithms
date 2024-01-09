package word.ladder;

import java.util.*;

/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

        Every adjacent pair of words differs by a single letter.
        Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
        sk == endWord
        Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



        Example 1:

        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        Output: 5
        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
        Example 2:

        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
        Output: 0
        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


        Constraints:

        1 <= beginWord.length <= 10
        endWord.length == beginWord.length
        1 <= wordList.length <= 5000
        wordList[i].length == beginWord.length
        beginWord, endWord, and wordList[i] consist of lowercase English letters.
        beginWord != endWord
        All the words in wordList are unique.*/
public class Solution1 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println("shorest street : "+ladderLength(beginWord, endWord, wordList));

        List<String> wordList2 = new ArrayList<>(List.of("hot","dot","dog","lot","log"));
        System.out.println("shorest street 2 : "+ladderLength(beginWord, endWord, wordList2));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord,1));

        if(!wordList.contains(endWord))
            return 0;
        wordList.add(endWord);
        Set<String> setWords = new HashSet<>(wordList);



        while(!queue.isEmpty()){
            WordNode top = queue.removeFirst();

            if(top.getWord().equals(endWord))
                return top.getNodeStep();

            char[] topArray = top.getWord().toCharArray();
            for(int i = 0; i<topArray.length; i++) {
                for(char c='a';  c<'z'; c++){
                    if(topArray[i] != c){
                        char temp = topArray[i];
                        topArray[i] = c;
                        String newString = String.valueOf(topArray);
                        if(setWords.contains(newString)){
                            queue.add(new WordNode(newString,top.getNodeStep()+1));
                            setWords.remove(newString);
                        }
                        topArray[i] = temp;
                    }
                }
            }

        }
        return 0;
    }
}

class WordNode {
    private String word;
    private int nodeStep;

    public WordNode(String word, int nodeStep) {
        this.word = word;
        this.nodeStep = nodeStep;
    }

    public String getWord(){
        return this.word;
    }

    public int getNodeStep(){
        return this.nodeStep;
    }

}
