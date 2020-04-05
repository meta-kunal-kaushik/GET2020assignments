package Cricket;

public class Bowler {
    String name;
    int balls;

    Bowler(String name, int balls) {
        this.name = name;
        this.balls = balls;
    }

    @Override
    public String toString() {
        return "Bowler [name=" + name + ", balls=" + balls + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

}