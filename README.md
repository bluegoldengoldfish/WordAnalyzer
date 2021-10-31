# Word Frequency Analysis
**Version 1.0** | **Author**: Edwin Barahona | **Development time**: 5 hours


### Scope

---

This version contains the initial implementation of the **Word Frequency Analyzer** features, 
the method returns two parameters:

| Parameter | Type | Description|
|---|---|---|
| frequency | long | Number of types the defined word (search key) is found in the text|
| similarities | Array of String | Similar words based on the levenshtein distance |

**Note**: the word used as search key is not included in the list of similar words

### Methods

---


Method | Implementation
---|---
frequencyAnalysis | GET /WordAnalysis?{notebookText}&{searchKey}

### Dependencies

---
Built with Spring boot framework

**Additional Libraries**:

Levenshtein distance is implemented from [Java String Similarity](https://github.com/tdebatty/java-string-similarity)

### Future improvement

---

Additional functionality can be implemented but require additional effort out of the scope:
* case validation 
* variable index for the levenshtein similarity 
* synonyms lookup