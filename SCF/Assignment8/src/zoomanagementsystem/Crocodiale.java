package zoomanagementsystem;

/**
 * This class extends animal and reptile class.
 * @author kunal
 *
 */
public class Crocodiale extends Reptiles {
    public Crocodiale(int age, String name, String category, float weight,
            String canSwim, String sound) {
        super(age, name, category, weight, canSwim, sound);
    }
    public String getSound() {
        return super.soundOfAnimal;
    }
    public String swimSpeed() {
        return super.swim;
    }
}
