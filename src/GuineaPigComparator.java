import java.util.Comparator;

public class GuineaPigComparator implements Comparator<GuineaPig> {
    @Override
    public int compare(GuineaPig pig1, GuineaPig pig2) {
        return pig1.getFoodInGrams() - pig2.getFoodInGrams();
    }
}
