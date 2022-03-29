public class Word {
    String english;
    String spanish;
    String french;

    public Word(String english, String spanish, String french) {
        this.english = english;
        this.spanish = spanish;
        this.french = french;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
