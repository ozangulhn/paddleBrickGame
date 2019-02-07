public class Paddle {
    private int length;
    private Location shapeLocation;
    private GameMap box;
    Paddle(GameMap map,int length,int x,int y){
        shapeLocation = new Location(x,y);
        this.length = length;
        box = map;
        putObject();
    }
    private int getLength() {
        return length;
    }
    public void movePaddle(char direction) {
        if (direction == 'd') {
            box.map[shapeLocation.getX()][shapeLocation.getY()] = " ";
            box.map[shapeLocation.getX()][shapeLocation.getY()+length] = "=";
            shapeLocation.setY(shapeLocation.getY()+1);

        }
        else if (direction == 'a'){
            box.map[shapeLocation.getX()][shapeLocation.getY()+length] = " ";
            box.map[shapeLocation.getX()][shapeLocation.getY()-1] = "=";
            shapeLocation.setY(shapeLocation.getY()-1);
        }
    }
    public void putObject() {
        for(int i = 0 ; i < getLength() ; i++ ){
            box.map[shapeLocation.getX()][shapeLocation.getY()+i] = "=";
        }
    }
}
