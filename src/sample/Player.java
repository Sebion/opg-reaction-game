package sample;

public class Player {

    private String name;
    private float highScore;
    private float actualScore;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHighScore() {
        return highScore;
    }

    public void setHighScore(float highScore) {
        this.highScore = highScore;
    }

    public float getActualScore() {
        return actualScore;
    }

    public void setActualScore(float actualScore) {
        this.actualScore = actualScore;
    }
}
