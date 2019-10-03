import javax.swing.JFrame;
import javax.swing.JLabel;


public class jogo2048 extends JFrame{
   
    public static void main (String args[]){

        jogo2048 game = new jogo2048();
        Grid board = new Grid(game);
                   
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        
        
        game.add(board);

}
    
    public jogo2048(){
        setSize(600,600);       
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
}


