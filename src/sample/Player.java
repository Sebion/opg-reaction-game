package sample;

import sample.Controllers.PlayController;

public class Player implements Comparable{

    private String name="Default";
    private float highScore=0;
    private float actualScore;


    public Player() {

    }

    public Player(String name, float highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Object comparestu) {
        long compareage= (int) ((Player)comparestu).getHighScore();
        /* For Ascending order*/
        return (int) (this.highScore-compareage);

        /* For Descending order do like this */
        //return compareage-this.studentage;
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
