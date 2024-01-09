package word.ladder;

import java.util.*;

public class Solution2 {
    int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println("shorest street : " + ladderLength(beginWord, endWord, wordList));

        List<String> wordList2 = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"));
        System.out.println("shorest street 2 : " + ladderLength(beginWord, endWord, wordList2));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);

        if(!wordList.contains(endWord))
            return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        int result = 1, size = beginWord.length();

        while(!queue.isEmpty()){
            for(int queueSize=queue.size(); queueSize>0;queueSize--){
                String currString = queue.poll();
                for(int i=0;i<size;i++){
                    for(char c ='a';c<'z';c++){
                       String newString = currString.substring(0,i)+String.valueOf(c)+currString.substring(i+1);
                       if(wordSet.contains(newString)){
                           if(newString.equals(endWord)){
                               return ++ result;
                           }
                           queue.offer(newString);
                           wordSet.remove(newString);
                       }
                    }
                }

            }
            result++;
        }
        return 0;
    }


}
