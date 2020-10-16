package sample;

public class Word {
    private String word_target;
    private String word_explain;
    public Word(String target, String explain){
        this.word_target = target;
        this.word_explain = explain;
    }
    public Word(){
    }

    public void setWord_target(String target){
        this.word_target = target;
    }
    public String getWord_target(){
        return word_target;
    }
    public void setWord_explain(String explain){
        this.word_explain = explain;
    }
    public String getWord_explain(){
        return word_explain;
    }

}
