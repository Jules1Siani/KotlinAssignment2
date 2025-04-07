
// Question A: Caesar Cipher
fun caesarCipher(text: String, key: Int): String {

    val result = StringBuilder()
    for (char in text) {
        if (char.isLetter()) {
            val shift = key % 26
            val base = if (char.isUpperCase()) 'A' else 'a'
            val newChar = (((char - base + shift) % 26 + 26) % 26 + base.code).toChar()
            result.append(newChar)
        } else {
            result.append(char)
        }
    }
    return result.toString()
}

// Question B: Anagram Check
fun areAnagrams(word1: String, word2: String): Boolean {
    /**
     * Check if two words are anagrams of each other.
     * @param word1 The first word
     * @param word2 The second word
     * @return True if the words are anagrams, else False
     */
    return word1.lowercase().toCharArray().sorted() == word2.lowercase().toCharArray().sorted()
}

// Question C: Substring Check without contains()
fun isSubString(mainStr: String, subStr: String): Boolean {
    /**
     * Check if subStr is a substring of mainStr without using contains method.
     * @param mainStr The main string
     * @param subStr The substring to check
     * @return True if subStr is found in mainStr, else False
     */
    if (subStr.length > mainStr.length) return false
    for (i in 0..mainStr.length - subStr.length) {
        if (mainStr.substring(i, i + subStr.length) == subStr) {
            return true
        }
    }
    return false
}

// Question D: Longest Word in a String
fun findLongestWord(sentence: String): String {

    var longestWord = ""
    val words = sentence.split(" ", "\n", "\t", ",", ".", "!", "?", ";", ":")

    for (word in words) {
        if (word.length > longestWord.length) {
            longestWord = word
        }
    }
    return longestWord
}

// Main function to test all features
fun main() {
    // Test Caesar Cipher
    println("Caesar Cipher Test:")
    println(caesarCipher("Hello World!", 3)) // Khoor Zruog!
    println(caesarCipher("xyz", 2)) // zab

    // Test Anagram Check
    println("\nAnagram Check:")
    println(areAnagrams("dusty", "study")) // true
    println(areAnagrams("Love", "strings")) // false

    // Test Substring Check
    println("\nSubstring Check:")
    println(isSubString("Hello World!", "World")) // true
    println(isSubString("Hello!", "hellooo")) // false

    // Test Longest Word
    println("\nLongest Word:")
    println(findLongestWord("The quick brown fox jumped over the lazy dog.")) // jumped
    println(findLongestWord("Kotlin is a modern programming language.")) // programming
}
