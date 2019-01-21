package company.evo.jmorphy2;


import java.util.List;

public class NewParsedWord {
    static List<NewParsedWord> allInfo;

    private String word;
    private Tag tag;
    private List<String> normalForm;
    private String foundWord;
    private float score;

    private SynoDictionary synos = new SynoDictionary();

    public NewParsedWord(String word, Tag tag, List<String> normalForm, String foundWord, float score) {
        this.word = word;
        this.tag = tag;
        this.normalForm = synos.getSyno(normalForm.get(0));
        this.foundWord = foundWord;
        this.score = score;

    }


    // get noramlForm
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
