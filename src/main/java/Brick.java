public enum Brick {

    LAST_BRICK_OF_WALL("■■"), NORMAL_BRICK("■■|"), FIRST_HALF_BRICK("■|"), LAST_HALF_BRICK("|■");

    private String characters;

    Brick(String characters){
        this.characters = characters;
    }

    @Override
    public String toString(){
        return this.characters;
    }

}
