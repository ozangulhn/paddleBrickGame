public class Display {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private GameMap box;
    Display(GameMap map){
        box = map;
    }
    public void printArray() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.print(box.map[i][j].charAt(0)); //renk icin commente al
                /*if(box.map[i][j].length()==4){
                    if (box.map[i][j].charAt(1) == 'R') {
                        System.out.print(ANSI_RED + box.map[i][j].charAt(0) + ANSI_RESET);
                    }else if(box.map[i][j].charAt(1) == 'G'){
                        System.out.print(ANSI_GREEN + box.map[i][j].charAt(0) + ANSI_RESET);
                    }else if(box.map[i][j].charAt(1) == 'B'){
                        System.out.print(ANSI_BLUE + box.map[i][j].charAt(0) + ANSI_RESET);
                    }else if(box.map[i][j].charAt(1) == 'Y'){
                        System.out.print(ANSI_YELLOW + box.map[i][j].charAt(0) + ANSI_RESET);
                    }
                }else{
                    System.out.print(box.map[i][j].charAt(0));
                }*/
                }
                System.out.println();
            }
        }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
