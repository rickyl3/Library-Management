public class Shelf {
    private String name = "Shelf";
    private static int rows = 3;

    public String getName() {
        return name;
    }
    public static int getRows() {
        return rows;
    }
    public String toString() {
        return "This Shelf has " + rows + " rows"; 
    }
}