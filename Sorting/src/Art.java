public class Art {

    private int height;
    private int price;
    private int width;
    private String name;
    private String artistName;

    public Art(int height, int price, int width, String name, String artistName) {
        this.height = height;
        this.price = price;
        this.width = width;
        this.name = name;
        this.artistName = artistName;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPrice() {
        return price;
    }

    public int getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }


}
