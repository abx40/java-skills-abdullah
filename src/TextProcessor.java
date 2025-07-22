public class TextProcessor {
    // Count words in a sentence
    public static int countWords(String sentence) {
    // Split the sentence and count words
    // Handle empty strings
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String
            newWord) {
    // Replace all occurrences of oldWord with newWord

    String[] words = text.split(" ");
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(oldWord)) {
            result.append(newWord);
        } else {
            result.append(words[i]);
        }

        if (i < words.length - 1) {
            result.append(" ");
        }
    }

return result.toString();
    }
    public static void main(String[] args) {
    // Test with: "Java is fun and Java is powerful"
    // Count words
    // Replace "Java" with "Programming"
        String sentence = "Java is fun and Java is powerful";
        int wordCount = countWords(sentence);
        System.out.println("Word Count: " + wordCount);
        String replacedText = replaceWord(sentence, "Java", "Programming");
        System.out.println("Replaced Text: " + replacedText);
    }
}
