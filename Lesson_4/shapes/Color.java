package shapes;

public enum Color {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    BLACK("Black"),
    WHITE("White"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    PINK("Pink"),
    BROWN("Brown"),
    GRAY("Gray"),
    CYAN("Cyan");
    
    private final String name;
    
    Color(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}