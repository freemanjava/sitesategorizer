package search.impl;

import search.Searchable;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm implements Searchable {

    private void strongSuffixPreprocessing(int[] shift, int[] bpos, char[] pat, int m){
        // m is the length of pattern
        int i = m, j = m + 1;
        bpos[i] = j;

        while(i > 0)
        {
        /*if character at position i-1 is not
        equivalent to character at j-1, then
        continue searching to right of the
        pattern for border */
            while(j <= m && pat[i - 1] != pat[j - 1])
            {
            /* the character preceding the occurrence of t
            in pattern P is different than the mismatching
            character in P, we stop skipping the occurrences
            and shift the pattern from i to j */
                if (shift[j] == 0)
                    shift[j] = j - i;

                //Update the position of next border
                j = bpos[j];
            }
        /* p[i-1] matched with p[j-1], border is found.
        store the beginning position of border */
            i--; j--;
            bpos[i] = j;
        }
    }

    //Preprocessing for case 2
    private void determinationWidestBorderPreprocessing(int[] shift, int[] bpos, char[] pat, int m){
        int i, j;
        j = bpos[0];
        for(i = 0; i <= m; i++)
        {
        /* set the border position of the first character
        of the pattern to all indices in array shift
        having shift[i] = 0 */
            if(shift[i] == 0)
                shift[i] = j;

        /* suffix becomes shorter than bpos[0],
        use the position of next widest border
        as value of j */
            if (i == j)
                j = bpos[j];
        }
    }

    private char[] searchPreparation(String string){
        String resultString = " " + string + " ";
        return resultString.toLowerCase().toCharArray();
    }

    /*Search for a pattern in given text using
    Boyer Moore algorithm with Good suffix rule */
    @Override
    public boolean searchFirstOccurrence(String textString, String pattern){
        char[] text = searchPreparation(textString);
        char[] pat = searchPreparation(pattern);
        // s is shift of the pattern
        // with respect to text
        int s = 0, j;
        int m = pat.length;
        int n = text.length;

        int[] bpos = new int[m + 1];
        int[] shift = new int[m + 1];

        //initialize all occurrence of shift to 0
        for (int i = 0; i < m + 1; i++)
            shift[i] = 0;

        //do preprocessing
        strongSuffixPreprocessing(shift, bpos, pat, m);
        determinationWidestBorderPreprocessing(shift, bpos, pat, m);

        while (s <= n - m) {
            j = m - 1;

        /* Keep reducing index j of pattern while
        characters of pattern and text are matching
        at this shift s*/
            while (j >= 0 && pat[j] == text[s + j])
                j--;

        /* If the pattern is present at the current shift,
        then index j will become -1 after the above loop */
            if (j < 0) {
//                System.out.printf("pattern occurs at shift = %d\n", s);
                return true;
//                    s += shift[0];
            } else

            /*pat[i] != pat[s+j] so shift the pattern
            shift[j+1] times */
                s += shift[j + 1];
        }
        return false;
    }
    @Override
    public Map<String, Integer> searchAllOccurrences(String textString, String pattern){
        int occurrencesCounter = 0;
        Map<String, Integer> searchResult = new HashMap<>();
        char[] text = searchPreparation(textString);
        char[] pat = searchPreparation(pattern);
        // s is shift of the pattern
        // with respect to text
        int s = 0, j;
        int m = pat.length;
        int n = text.length;

        int[] bpos = new int[m + 1];
        int[] shift = new int[m + 1];

        //initialize all occurrence of shift to 0
        for (int i = 0; i < m + 1; i++)
            shift[i] = 0;

        //do preprocessing
        strongSuffixPreprocessing(shift, bpos, pat, m);
        determinationWidestBorderPreprocessing(shift, bpos, pat, m);

        while (s <= n - m) {
            j = m - 1;

        /* Keep reducing index j of pattern while
        characters of pattern and text are matching
        at this shift s*/
            while (j >= 0 && pat[j] == text[s + j])
                j--;

        /* If the pattern is present at the current shift,
        then index j will become -1 after the above loop */
            if (j < 0) {
                occurrencesCounter += 1;
                System.out.printf("pattern occurs at shift = %d\n", s);
                s += shift[0];
            } else

            /*pat[i] != pat[s+j] so shift the pattern
            shift[j+1] times */
                s += shift[j + 1];
        }
        searchResult.put(pattern, occurrencesCounter);
        return searchResult;
    }
}
