
/**
 * Class Shuffle
 *
 * @author (Nikhitha Nair)
 * @version (204)
 */
import java.util.Random;
public class Shuffle
{
    private static void swap(int [] s, int i, int change){
        int helper = s[i];
        s[i] = s[change];
        s[change] = helper;

    }

    public static void shuffle(int [] s)
    {
        int n = s.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++){
            int change = i + random.nextInt(n - i);
            swap(s, i, change);
        }
    }

    public static void main(String [] args){
        int [] s = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15, 16, 17, 18, 19, 20};
        shuffle(s);

        for (int i:s){
            System.out.println(i);
        }

    }

}
