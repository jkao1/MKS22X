import java.util.*;

public class Quiz2Redux {

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur
     *in the original string.
     */

    public static ArrayList<String> combinations(String s){
        ArrayList<String>words = new ArrayList<String>();
        help( words, s, 0, "" );
        Collections.sort(words);
        return words;
    }

    private static void help(ArrayList<String> words, String s, int start, String built)
    {
        if (start == s.length()) {
            words.add(built);
            return;
        }

        help( words, s, start+1, s.substring(start,start+1) + built );
        help( words, s, start+1, built);
    }
}
