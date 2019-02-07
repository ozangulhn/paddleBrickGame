public class Movement {
    private Ball ball;
    private GameMap map;
    private Location ballNextLocation; //next location of the ball is always stored.
    private Location NFN = new Location(47,100);
    private Location NSN = new Location(47,100); //NFN(NextlocationFirstNeighbor) is the neighbor on the x and the NSN(NextlocationSecondNeighbor) is the neighbor on the y
    private int round;
    Movement(Ball ball,GameMap map){
        this.ball = ball;
        this.map = map;
        ballNextLocation = new Location(ball.getX()+ball.getXvector(),ball.getY()+ball.getYvector());
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public void bounceFromBrick(){
        if(!isThereBrick(NFN) && !isThereBrick(NSN)){ //if both neighbors empty,it means ball colliding with the corner of a brick
            changeVector("corner");
        }
        else if(ball.getYvector() < 0 ){ //if ball is going to left
            if(!isThereBrick(NSN)){ //while going left, if NSN is empty, the ball will bounce from right.
                changeVector("left");
                return;
            }
            if(!isThereBrick(NFN)){
                if(ball.getXvector()<0){
                    changeVector("up");
                }
                else if(ball.getXvector()>0){
                    changeVector("down");
                }
            }
        }
        else if(ball.getYvector() > 0){ // if ball is going to right
            if(!isThereBrick(NSN)){
                changeVector("right");
                return;
            }
            if(!isThereBrick(NFN)){
                if(ball.getXvector()>0){
                    changeVector("down");
                }
                else if(ball.getXvector()<0){
                    changeVector("up");
                }
            }
        }
    }
    public boolean isThereBrick(Location loc){
     if(map.map[loc.getX()][loc.getY()].charAt(0) == 'T') {
         return true;
     }
        else return false;
    }
    private void setNeighbors(){
        NFN.setX(ballNextLocation.getX()-ball.getXvector());
        NFN.setY(ballNextLocation.getY());
        NSN.setX(ballNextLocation.getX());
        NSN.setY(ballNextLocation.getY()-ball.getYvector());
    }
    private void changeVector(String direction){
        if(direction.equals("right")|| direction.equals("left")){ //if ball is colliding from right or left, y vector always reverses.
            ball.setYvector(-ball.getYvector());
        }
        else if (direction.equals("up")  || direction.equals("down")){
            ball.setXvector(-ball.getXvector());
        }
        else if(direction.equals("corner")){
            ball.setXvector(-ball.getXvector());
            ball.setYvector(-ball.getYvector());
        }
    }
    public void doTheWork() {
        setBallNextLocation();
        if (map.map[ballNextLocation.getX()][ballNextLocation.getY()].charAt(0)==' ') {
            ball.moveBall(ballNextLocation.getX(),ballNextLocation.getY());
            setBallNextLocation();
        } else if (map.map[ballNextLocation.getX()][ballNextLocation.getY()].charAt(0) =='=') {
            //paddledan sekme
            changeVector("down");
        } else if (map.map[ballNextLocation.getX()][ballNextLocation.getY()].charAt(0) == '+') {
            setNeighbors();
            if(map.map[NFN.getX()][NFN.getY()].charAt(0)=='+' && map.map[NSN.getX()][NSN.getY()].charAt(0)=='+' ){
                changeVector("corner");
            }
            else if(map.map[NFN.getX()][NFN.getY()].charAt(0)=='+' && map.map[NSN.getX()][NSN.getY()].charAt(0)==' '){
                changeVector("right");
            }
            else if(map.map[NSN.getX()][NSN.getY()].charAt(0)=='+' && map.map[NFN.getX()][NFN.getY()].charAt(0)==' '){
                changeVector("up");
            }
        } else if (map.map[ballNextLocation.getX()][ballNextLocation.getY()].charAt(0) == 'x') {
            ball.setXvector(0);
            ball.setYvector(0);
        } else if(map.map[ballNextLocation.getX()][ballNextLocation.getY()].charAt(0) =='T'){
            setNeighbors();
            bounceFromBrick();
            deleteBrick(map.map[ballNextLocation.getX()][ballNextLocation.getY()]);
            setBallNextLocation();
            ball.moveBall(getBallNextLocation().getX(),getBallNextLocation().getY());
        }
    }
    public boolean isBallMoving(){
        return ball.getXvector() != 0 || ball.getYvector() != 0;
    }
    public void shootBall(Character direction){
        if(direction=='a' || direction=='A'){
            ball.setXvector(-1);
            ball.setYvector(-1);
        }
        else if(direction=='d' || direction=='D'){
            ball.setXvector(-1);
            ball.setYvector(1);
        }
    }
    public Location getBallNextLocation() {
        return ballNextLocation;
    }
    public void setBallNextLocation() {
        ballNextLocation.setX(ball.getX()+ball.getXvector());
        ballNextLocation.setY(ball.getY()+ball.getYvector());
    }
    public void deleteBrick(String b){
        int x = 2 + (b.charAt(2)-49)*3;
        int y = 2 + (b.charAt(3)-65)*15;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 15 ; j++){
                map.map[x+i][y+j]=" ";
            }
        }
    }

}