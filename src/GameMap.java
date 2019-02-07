import java.util.Random;
public class GameMap {
    private int width;
    private int height;
    String[][] map;
    GameMap(int x, int y){
        width = y;
        height = x;
        map = new String[x][y];
        createMap(x,y);
        fillBricks();
    }
    public void createMap( int x, int y) {
        for (int i = 0; i < x; i++) {//column
            for (int j = 0; j < y; j++) {//row
                if (((j == y-1) && (i < x)) || ((i == 0) && (j < y)) || ((j == 0) && (i < x))) {
                    this.map[i][j] = "+";
                } else if (((i == x-1) && (j < y))) {
                    this.map[i][j] = "x";
                } else {
                    this.map[i][j] = " ";
                }
            }
        }
    }
    public void putBrick(int x, int y, int m, char n){
        Random generator = new Random();
        int c = generator.nextInt(4);
        int i ,j;
        for(i = 0; i < 3 ; i++){
           for(j = 0 ; j < 15 ; j++){

               if(c==0){
                   map[x+i][y+j] = "TR" + m + n;
               }else if(c==1){
                   map[x+i][y+j] = "TG" + m + n;
               }else if(c==2) {
                   map[x+i][y+j] = "TB" + m + n;
               }else if(c==3){
                   map[x+i][y+j] = "TY" + m + n;
                   }
               }
           }
        }
    public void fillBricks(){

        int a=2,b=2;
        char n = 'A';
        int m = 1;
        for(int i = 0; i<3;i++){
            for(int j = 0 ; j < 13 ; j++){
                putBrick(b,a,m,n);
                a=a+15;
                n++;
            }
            m++;
            a=2;
            b=b+3;
            n='A';
        }
    }
}
