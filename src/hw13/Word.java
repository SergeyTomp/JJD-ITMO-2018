package hw13;

public class Word {
    private String word;
    private Integer quantity;
    private int lttrNum;

    Word (String word, int quantity){
        this.word = word;
        this.quantity = quantity;
        lttrNum = word.length();
    }

    int getQty (){
        return quantity;
    }

    public String getWord() {
        return word;
    }

    int getLttrNum (){
        return lttrNum;


    }
}
