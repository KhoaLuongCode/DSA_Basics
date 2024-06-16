import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;

public class ArtMuseum {

    private String museumName;

    private ArrayList<Art> artMuseum;

    public ArtMuseum(String museumName) {
        this.museumName = museumName;
        this.artMuseum = new ArrayList<>();
    }

    public boolean add(Art art) {

        if (art != null) {
            artMuseum.add(art);
            return true;
        }

        return false;
    }

    public List<Art> sort(String attribute, int direction) {
        if (artMuseum.isEmpty()) {
            return Collections.emptyList();
        }
        quicksort(artMuseum, attribute, direction, 0, artMuseum.size() - 1);
        return new ArrayList<>(artMuseum);
    }

    public static void quicksort(ArrayList<Art> artMuseum, String attribute, int direction, int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partition(artMuseum, attribute, direction, low, high);
        if (low < j){
            quicksort(artMuseum, attribute, direction, low, j);
        }
        if (j + 1 < high) {
            quicksort(artMuseum, attribute, direction, j + 1, high);
        }
    }

    public static int partition(ArrayList<Art> artMuseum, String attribute, int direction, int low, int high) {
        // the pivot will always be the first element
        Art pivot = artMuseum.get(low);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                // move i to the right until greater than or equal pivot
                i++;
            } while (compareArt(artMuseum.get(i), pivot, attribute, direction) < 0);
            do {
                // move j to the left until less than or equal pivot
                j--;
            } while (compareArt(artMuseum.get(j), pivot, attribute, direction) > 0);

            if (i < j) Collections.swap(artMuseum, i, j);
            else {
                return j;
            }
        }
    }

    public static int compareArt(Art a1, Art a2, String attribute, int direction) {
        // helper method that compares art with different attribute cases
        int result = 0;
        if (attribute.equals("height")) {
            result = Integer.compare(a1.getHeight(), a2.getHeight());
        } else if (attribute.equals("width")) {
            result = Integer.compare(a1.getWidth(), a2.getWidth());
        } else if (attribute.equals("name")) {
            result = a1.getName().compareTo(a2.getName());
        } else if (attribute.equals("price")) {
            result = Integer.compare(a1.getPrice(), a2.getPrice());
        } else if (attribute.equals("artistName")) {
            result = a1.getArtistName().compareTo(a2.getArtistName());
        }

        if (direction > 0) {
            return result;
        } else {
            return -result;
        }
    }

    public List<Art> findArts(String artistName){
        ArrayList<Art> newArray = new ArrayList<>();
        // every time see the artist name added to the new array
        for (Art art : artMuseum) {
            if (art.getArtistName().equals(artistName)) {
                newArray.add(art);
            }
        }
        return new ArrayList<>(newArray);
    }

    public List<Art> randomizeArts(int n){

        if (n < 0){
            return new ArrayList<>();
        }

        if (n > artMuseum.size()){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }

        // create a variable fixed so can decrement after has added to the new art museum randomized
        int fixed = artMuseum.size();
        ArrayList<Art> randomizedArtList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            // find the index using math ranodm
            int index = (int) (Math.random() * fixed);
            // add to the new museum
            randomizedArtList.add(artMuseum.get(index));
            // remove the art from the old art museum
            artMuseum.remove(index);
            // decrement the size of the art museum by one because the art has been removed
            fixed--;
        }
        return new ArrayList<>(randomizedArtList);
    }

    public List<Art> randomSort(List<Art> arts) {

        if (arts.size() < 2) {
            return new ArrayList<>(arts);
        }

        ArrayList<Art> everythingSorted;

        // if divisble by 5
        if (isDivisbleBy5(arts)) {

            int oneFifth = arts.size() / 5;

            // create five new array list of arts for five attributes
            ArrayList<Art> sortedHeight = new ArrayList<>();
            ArrayList<Art> sortedPrice = new ArrayList<>();
            ArrayList<Art> sortedWidth = new ArrayList<>();
            ArrayList<Art> sortedName = new ArrayList<>();
            ArrayList<Art> sortedArtistName = new ArrayList<>();

            // loop through the the five portions of the old art museum and add to the respective array list of arts
            for (int i = 0; i < oneFifth; i++) {
                sortedHeight.add(arts.get(i));
            }
            for (int i = oneFifth; i < oneFifth * 2; i++) {
                sortedPrice.add(arts.get(i));
            }
            for (int i = oneFifth * 2; i < oneFifth * 3; i++) {
                sortedWidth.add(arts.get(i));
            }
            for (int i = oneFifth * 3; i < oneFifth * 4; i++) {
                sortedName.add(arts.get(i));
            }
            for (int i = oneFifth * 4; i < oneFifth * 5; i++) {
                sortedArtistName.add(arts.get(i));
            }

            // perform quick sort on each of the new array list of arts according to the attribute
            quicksort(sortedHeight, "height", 1, 0, sortedHeight.size() - 1);
            quicksort(sortedPrice, "price", 1, 0, sortedPrice.size() - 1);
            quicksort(sortedWidth, "width", 1, 0, sortedWidth.size() - 1);
            quicksort(sortedName, "name", 1, 0, sortedName.size() - 1);
            quicksort(sortedArtistName, "artistName", 1, 0, sortedArtistName.size() - 1);

            // add everything to the new sorted everything
            everythingSorted = new ArrayList<>();
            everythingSorted.addAll(sortedHeight);
            everythingSorted.addAll(sortedPrice);
            everythingSorted.addAll(sortedWidth);
            everythingSorted.addAll(sortedName);
            everythingSorted.addAll(sortedArtistName);
        }
        else {
            // if not divisble by five then still divide to five portion and find the remainder, the remainder will be added to the last attribute artistName
            int oneFifth = arts.size() / 5;
            int remainder = arts.size() % 5;

            ArrayList<Art> sortedHeight = new ArrayList<>();
            ArrayList<Art> sortedPrice = new ArrayList<>();
            ArrayList<Art> sortedWidth = new ArrayList<>();
            ArrayList<Art> sortedName = new ArrayList<>();
            ArrayList<Art> sortedArtistName = new ArrayList<>();

            for (int i = 0; i < oneFifth; i++) {
                sortedHeight.add(arts.get(i));
            }
            for (int i = oneFifth; i < oneFifth * 2; i++) {
                sortedPrice.add(arts.get(i));
            }
            for (int i = oneFifth * 2; i < oneFifth * 3; i++) {
                sortedWidth.add(arts.get(i));
            }
            for (int i = oneFifth * 3; i < oneFifth * 4; i++) {
                sortedName.add(arts.get(i));
            }
            // add to the sorted artist name with the remainder of the arts
            for (int i = oneFifth * 4; i < (oneFifth * 5) + remainder; i++){
                sortedArtistName.add(arts.get(i));
            }

            quicksort(sortedHeight, "height", 1, 0, sortedHeight.size() - 1);
            quicksort(sortedPrice, "price", 1, 0, sortedPrice.size() - 1);
            quicksort(sortedWidth, "width", 1, 0, sortedWidth.size() - 1);
            quicksort(sortedName, "name", 1, 0, sortedName.size() - 1);
            quicksort(sortedArtistName, "artistName", 1, 0, sortedArtistName.size() - 1);

            everythingSorted = new ArrayList<>();
            everythingSorted.addAll(sortedHeight);
            everythingSorted.addAll(sortedPrice);
            everythingSorted.addAll(sortedWidth);
            everythingSorted.addAll(sortedName);
            everythingSorted.addAll(sortedArtistName);
        }
        return new ArrayList<>(everythingSorted);
    }

    public boolean isDivisbleBy5(List<Art> arts){
        return arts.size() % 5 == 0;
    }

}
