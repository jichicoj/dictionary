public class Entry {
    private String key;
    private Word word;

    public Entry() {
    }

    public Entry(String key, Word word) {
        this.key = key;
        this.word = word;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
