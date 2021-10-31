package com.labforward.wordanalyzer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.debatty.java.stringsimilarity.Levenshtein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Edwin Barahona
 * @version 1.0
 * This API implements methods for WordAnalysis specific to count word occurrence within a text and search
 * for similar words
 */
@RestController
public class FrequencyAnalysisController {

    /**
     *
     * @param notebookText text to analyze
     * @param searchKey word that needs to be found
     * @return frequency: number of times the search key exists within the text,
     * similarities: list of similar words based on levenshtein distance
     */
    @GetMapping("/WordAnalysis")
    public FrequencyAnalysis frequencyAnalysis(@RequestParam(value = "notebookText") String notebookText,
                                               @RequestParam(value = "searchKey") String searchKey){

        List<String> tokens = Arrays.stream(notebookText.split(" ")).collect(Collectors.toList());
        return new FrequencyAnalysis(wordCount(searchKey,tokens),
                findSimilarities(searchKey,tokens).toArray(String[]::new));
    }

    /**
     *
     * @param searchKey Word to find within the text
     * @param items list containing every word in the text
     * @return list containing similar words based on Levensthein index
     */
    private List<String> findSimilarities(String searchKey, List<String> items){
        Levenshtein lv = new Levenshtein();
        List<String> similarWords = new ArrayList<>();

        for (String item: items){
            if (lv.distance(searchKey, item) <= 1 && ! item.equals(searchKey)){
                similarWords.add(item);
            }
        }

        return similarWords.stream().distinct()
                .collect(Collectors.toList());
    }

    /**
     *
     * @param searchKey Word to find within the text
     * @param items list containing every word in the text
     * @return count of how many times the search key is found in the text
     */
    private long wordCount(String searchKey, List<String> items){
        return items.stream().filter(searchKey :: equals).count();
    }

}
