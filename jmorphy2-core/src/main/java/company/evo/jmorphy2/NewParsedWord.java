package company.evo.jmorphy2;


import java.util.List;

public class NewParsedWord {

    private String word;
    private Tag tag;
    private List<String> normalForm;
    private String foundWord;
    private float score;

    private SynoDictionary synos = new SynoDictionary();

    public NewParsedWord(String word, Tag tag, String normalForm, String foundWord, float score) {
        this.word = word;
        this.tag = tag;
        this.normalForm = synos.getSyno2(normalForm);
        this.foundWord = foundWord;
        this.score = score;

    }


    public List<String> normalForm() {
        return this.normalForm;
    }

    public String word() {
        return this.word;
    }

    public Tag tag() {
        return this.tag;
    }

    public String foundWord() {
        return this.foundWord;
    }

    public float score() {
        return this.score;
    }

    @Override
    public String toString() {
        return String.format("<NewParsedWord: \"%s\", \"%s\", \"%s\", \"%s\", %.6f>",
                word, tag, normalForm, foundWord, score);

    }


}
