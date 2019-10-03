package sample;

public class Player {

    private String name="Default";
    private float highScore=0;
    private float actualScore;


    public Player() {

    }

    public Player(String name, float highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    public String  getName() {
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
