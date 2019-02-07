public class Ball {
    private int [] direction = {'0','0'};
    private GameMap box;
    private Location shapeLocation;
    Ball (GameMap box,int x,int y){
        this.box = box;
        shapeLocation = new Location(x,y);
        putObject(x,y);
    }
    public void putObject(int x,int y) {
        box.map[x][y] = "O";
        setX(x);
        setY(y);
    }
    public void deleteBall(){
        box.map[getX()][getY()] = " ";
    }
    public void moveBall(int x,int y){
        deleteBall();
        putObject(x,y);
    }
    public int getX(){
        return shapeLocation.getX();
    }
    public int getY(){
        return shapeLocation.getY();
    }
    public void setX(int a){
        shapeLocation.setX(a);
    }
    public void setY(int b){
        shapeLocation.setY(b);
    }
    public int getXvector(){
        return direction[0];
    }
    public int getYvector(){
        return direction[1];
    }
    public void setXvector(int x){
        direction[0]=x;
    }
    public void setYvector(int y){
        direction[1]=y;
    }

}
