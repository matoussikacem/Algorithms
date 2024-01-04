package isomorphic.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Isomorphic {

/*    Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
    For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.*/

    public static void main(String[] args) {
        System.out.println("Bdd and egg are isomorphic ? "+(isIsomorphic("bdd","egg")));
        System.out.println("Bdd and egg are isomorphic ? "+(isIsomorphic("Acha","ldml")));
        System.out.println("Bdd and egg are isomorphic ? "+(isIsomorphic("chaa","leep")));
    }

    public static boolean isIsomorphic(String string1, String string2){
        if(string1==null || string2 ==null)
            return false;
        if(string1.length() != string2.length())
            return false;
        if(string1.length() ==0 || string2.length() ==0)
            return false;

        Map<Character,Character> maps = new HashMap<>();

        for(int i =0; i<string1.length();i++){
            Character charString1 = Character.toLowerCase(string1.charAt(i));
            Character charString2 = Character.toLowerCase(string2.charAt(i));

            Optional<Character> valOptional = getValueKey(maps,charString2);
            if(valOptional.isPresent()){
                Character val = valOptional.get();
                if(val !=charString1)
                    return false;
            }
            if(maps.containsKey(charString1)) {
                if (maps.get(charString1) != charString2)
                    return false;
            }
            else
               maps.put(charString1,charString2);
        }
        return true;
    }
    public static Optional<Character> getValueKey(Map<Character,Character> map, Character target){
        Optional<Character> value= map.entrySet().stream().filter(entry -> entry.getValue() ==target).map(Map.Entry::getKey).findFirst();
        return value;
    }

}
