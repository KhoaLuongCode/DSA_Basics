import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Assignment5Testing {

    @Test
    public void testSort(){

        // Create some sample art objects
        Art art1 = new Art(100, 800, 600, "Ipad", "Khoa");
        Art art2 = new Art(25, 920, 730, "Door", "Harold");
        Art art3 = new Art(12, 240, 210, "World", "CBum");
        Art art4 = new Art(70, 790, 580, "Chair", "Lindan");
        // NAME: Chair -> Door -> Ipad -> World
        // ARTIST NAME: CBum -> Harold -> Khoa -> Lindan

        // Create an ArtMuseum object and add the art objects to it
        ArtMuseum museum = new ArtMuseum("Gallery");
        museum.add(art1);
        museum.add(art2);
        museum.add(art3);
        museum.add(art4);

        // Test sorting by height in ascending order
        List<Art> sortedList = museum.sort("height", 1);
        assertEquals(art3, sortedList.get(0));
        assertEquals(art2, sortedList.get(1));
        assertEquals(art4, sortedList.get(2));
        assertEquals(art1, sortedList.get(3));

        // Test sorting by height in descending order
        sortedList = museum.sort("height", -1);
        assertEquals(art1, sortedList.get(0));
        assertEquals(art4, sortedList.get(1));
        assertEquals(art2, sortedList.get(2));
        assertEquals(art3, sortedList.get(3));

        // Test sorting by price in ascending order
        sortedList = museum.sort("price", 1);
        assertEquals(art3, sortedList.get(0));
        assertEquals(art4, sortedList.get(1));
        assertEquals(art1, sortedList.get(2));
        assertEquals(art2, sortedList.get(3));

        // Test sorting by name in ascending order
        sortedList = museum.sort("name", 1);
        assertEquals(art4, sortedList.get(0));
        assertEquals(art2, sortedList.get(1));
        assertEquals(art1, sortedList.get(2));
        assertEquals(art3, sortedList.get(3));

        // Test sorting by artistName in ascending order
        sortedList = museum.sort("artistName", 1);
        assertEquals(art3, sortedList.get(0));
        assertEquals(art2, sortedList.get(1));
        assertEquals(art1, sortedList.get(2));
        assertEquals(art4, sortedList.get(3));
    }

    @Test
    public void testRandomizedArt(){
        ArtMuseum museum = new ArtMuseum("Galley");
        Art art1 = new Art(100, 800, 600, "Ipad", "Khoa");
        Art art2 = new Art(25, 920, 730, "Door", "Harold");
        Art art3 = new Art(12, 240, 210, "World", "CBum");
        Art art4 = new Art(70, 790, 580, "Chair", "Artist");
        Art art5 = new Art(212, 240, 2, "Hello", "Ronnie");
        Art art6 = new Art(730, 790, 3, "Bag", "Coleman");

        museum.add(art1);
        museum.add(art2);
        museum.add(art3);
        museum.add(art4);
        museum.add(art5);
        museum.add(art6);

        List<Art> randomizedArts = museum.randomizeArts(3);
        for (Art randomizedArt : randomizedArts) {
            System.out.println(randomizedArt.getArtistName());
        }
        System.out.println("3 random arts have been generated as demonstrated by three random artist name");
    }

    @Test
    public void testFindArt(){
        Art art1 = new Art(100, 800, 600, "Ipad", "Khoa");
        Art art2 = new Art(25, 920, 730, "Door", "Harold");
        Art art3 = new Art(12, 240, 210, "World", "CBum");
        Art art4 = new Art(70, 790, 580, "Chair", "Khoa");
        ArtMuseum museum = new ArtMuseum("Gallery");
        museum.add(art1);
        museum.add(art2);
        museum.add(art3);
        museum.add(art4);

        List<Art> KhoaTheArtist = museum.findArts("Khoa");
        assertEquals(2, KhoaTheArtist.size());
        assertEquals("Khoa", KhoaTheArtist.get(0).getArtistName());
        assertEquals("Khoa", KhoaTheArtist.get(1).getArtistName());
    }

    @Test
    public void testRandomSortDivisbleBy5() {
            ArtMuseum museum = new ArtMuseum("Test Museum");
            List<Art> arts = new ArrayList<>();

            Art art1 = new Art( 10, 20, 30, "A", "B");
            Art art2 = new Art( 2, 25, 35, "B", "C");
            Art art3 = new Art( 10, 30, 40, "D", "F");
            Art art4 = new Art( 20, 20, 30, "A", "B");
            Art art5 = new Art(30, 40, 50, "I", "j");
            Art art6 = new Art( 35, 45, 55, "L", "M");
            Art art7 = new Art( 40, 50, 60, "M", "D");
            Art art8 = new Art(45, 55, 65, "C", "N");
            Art art9 = new Art(50, 60, 70, "S", "D");
            Art art10 = new Art( 55, 65, 75, "A", "V");

            // Add some Art objects to the museum
            arts.add(art1);
            arts.add(art2);
            arts.add(art3);
            arts.add(art4);
            arts.add(art5);
            arts.add(art6);
            arts.add(art7);
            arts.add(art8);
            arts.add(art9);
            arts.add(art10);

            // Add the Arts to the museum
            for (Art art : arts) {
                museum.add(art);
            }

            // Randomly sort the Arts
            List<Art> sortedArts = museum.randomSort(arts);

            // Check that the size of the sorted list is the same as the original list
            assertEquals(arts.size(), sortedArts.size());

            // Check that each Art object is still in the list
            for (Art art : arts) {
                assertTrue(sortedArts.contains(art));
            }

            // FIRST TWO SORTED ACCORDING TO HEIGHT
            assertEquals(art2, sortedArts.get(0));
            assertEquals(art1, sortedArts.get(1));

            // SECOND TWO SORTED ACCORDING TO PRICE
            assertEquals(art4, sortedArts.get(2));
            assertEquals(art3, sortedArts.get(3));

            // THIRD TWO SORTED ACCORDING TO WIDTH
            assertEquals(art5, sortedArts.get(4));
            assertEquals(art6, sortedArts.get(5));

            // FOUR TWO SORTED ACCORDING TO NAME: C < M => art8 > art7
            assertEquals(art8, sortedArts.get(6));
            assertEquals(art7, sortedArts.get(7));

            // LAST SORTED ACCORDING TO ARTIST NAME: D < V => art 9 first
            assertEquals(art9, sortedArts.get(8));
            assertEquals(art10, sortedArts.get(9));
    }

    @Test
    public void testRandomSortNotDivisbleBy5(){
        ArtMuseum museum = new ArtMuseum("Test Museum");
        List<Art> arts = new ArrayList<>();

        Art art1 = new Art( 10, 20, 30, "A", "B");
        Art art2 = new Art( 2, 25, 35, "B", "C");
        Art art3 = new Art( 10, 30, 40, "D", "F");
        Art art4 = new Art( 20, 20, 30, "A", "B");
        Art art5 = new Art(30, 40, 50, "I", "j");
        Art art6 = new Art( 35, 45, 55, "L", "M");
        Art art7 = new Art( 40, 50, 60, "M", "D");
        Art art8 = new Art(45, 55, 65, "C", "N");
        Art art9 = new Art(50, 60, 70, "S", "D");
        Art art10 = new Art( 55, 65, 75, "A", "V");
        Art art11 = new Art(12, 20, 35, "Test", "Rietnam");
        Art art12 = new Art(30,28, 83, "Test2", "WorldMap");

        arts.add(art1);
        arts.add(art2);
        arts.add(art3);
        arts.add(art4);
        arts.add(art5);
        arts.add(art6);
        arts.add(art7);
        arts.add(art8);
        arts.add(art9);
        arts.add(art10);
        arts.add(art11);
        arts.add(art12);

        List<Art> sortedArts = museum.randomSort(arts);

        // FIRST TWO SORTED ACCORDING TO HEIGHT
        assertEquals(art2, sortedArts.get(0));
        assertEquals(art1, sortedArts.get(1));

        // SECOND TWO SORTED ACCORDING TO PRICE
        assertEquals(art4, sortedArts.get(2));
        assertEquals(art3, sortedArts.get(3));

        // THIRD TWO SORTED ACCORDING TO WIDTH
        assertEquals(art5, sortedArts.get(4));
        assertEquals(art6, sortedArts.get(5));

        // FOUR TWO SORTED ACCORDING TO NAME: C < M => art8 > art7
        assertEquals(art8, sortedArts.get(6));
        assertEquals(art7, sortedArts.get(7));

        // LAST FOUR SORTED ACCORDING TO ARTIST NAME: D < V => art 9 first
        assertEquals(art9, sortedArts.get(8));
        assertEquals(art11, sortedArts.get(9));
        assertEquals(art10, sortedArts.get(10));
        assertEquals(art12, sortedArts.get(11));

    }






}






