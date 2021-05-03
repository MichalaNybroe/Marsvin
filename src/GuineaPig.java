public class GuineaPig implements Comparable<GuineaPig> {
    private String name;
    private String breed;
    private int foodInGrams;

    public GuineaPig(String name, String breed, int foodInGrams) {
        this.name = name;
        this.breed = breed;
        this.foodInGrams = foodInGrams;
    }

    @Override
    public int compareTo(GuineaPig guineaPig) {
        return this.name.compareTo(guineaPig.getName());
    }
    /*
    @Overwrite
    public int compareTo(GuineaPig guineaPig) {
        return this.foodInGrams.compareTo(guineaPig.getFoodIngrams());
     */

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getFoodInGrams() {
        return foodInGrams;
    }

    @Override
    public String toString() {
        return name + " " + breed + " " + foodInGrams;
    }
}
