import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Grid extends jogo2048{
    final jogo2048 host;
    ArrayList<String> list = new ArrayList();
    
    
    public Grid (jogo2048 main){
    	host = main;
    	setFocusable(true);
    	gridInicial();
        Teclado();
    }

   
    public void gridInicial() {
        list.removeAll(list);
        JPanel panel = new JPanel(new GridLayout(4,4));
        panel.setBackground(Color.GREEN);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(panel);
        
        //Gera as posições iniciais aleatoriamente
        Random gerador = new Random();          
        int posicao = gerador.nextInt(16);
        int posicao2 = gerador.nextInt(16);
        
        //Gera os números(2 ou 4) aleatoriamente
        int val = 0;
        int val2 = 0;
        
        do{
        val = gerador.nextInt(5);
        if(val == 2 || val == 4)
        {
            break;
        }
        }while(val != 2 || val !=4);
        
        do{
        val2 = gerador.nextInt(5);
        if(val2 == 2 || val2 == 4)
        {
            break;
        }
        }while(val2 != 2 || val2 !=4);
        
        
        
        //Gerando o tabuleiro com os números(2 ou 4) aleatoriamente
        for(int i = 0; i <  16; i++){           
            
           if(i == posicao){
               JLabel label = new JLabel(""+val,SwingConstants.CENTER);
               label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
               panel.add(label);
               list.add(label.getText());
           }
           if(i == posicao2){
               JLabel label = new JLabel(""+val2,SwingConstants.CENTER);
               label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
               panel.add(label);
               list.add(label.getText());
           }          
           if(i != posicao && i != posicao2)
           {
                JLabel label = new JLabel(" ",SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(label);
                list.add(label.getText());              
           }         
        }  
        
    }
    
    public void addEspacoVazio(){
        Random gerador = new Random();    
        int val = 0;
        
        //Gera valores até ser 2 ou 4
        do{
        val = gerador.nextInt(5);
        
        if(val == 2 || val == 4)
        {
            break;
        }
        }while(val != 2 || val !=4);
        
        
        int inserir = 0;
        do{
        //Gera uma posicao aleatoria do tabuleiro     
        int posicao = gerador.nextInt(16);       
        
        //Insere o valor gerado na posicao gerada se estiver vazia
            if(list.get(posicao) == " "){
                list.remove(posicao);
                list.add(posicao, Integer.toString(val));
                inserir = 1;
            }
        }while(inserir != 1);
        
        System.out.println(list);
        atualizaGrid();    
    }
    
    
    
    //Atualiza a imagem do Grid
    public void atualizaGrid(){
 
    JPanel panel = new JPanel(new GridLayout(4,4));
    panel.setBackground(Color.GREEN);
    panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    add(panel);
    
    for(int i =0;i<16;i++){
    String nome = list.get(i);
    JLabel label = new JLabel(""+nome,SwingConstants.CENTER);
    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.add(label);
    }
    
    setVisible(true);
    }
    
    //Faz a junção dos números se igual
    public String juntaNumeros(String val){
    if(val == "2"){
        val = "4";
    }
    if(val == "4"){
        val = "8";
    }
    if(val == "8"){
        val = "16";
    }
    if(val == "16"){
        val = "32";
    }
    if(val == "32"){
        val = "64";
    }
    if(val == "64"){
        val = "128";
    }
    if(val == "128"){
        val = "256";
    }
    if(val == "256"){
        val = "512";
    }
    if(val == "512"){
        val = "1024";
    }
    if(val == "1024"){
        val = "2048";
        System.out.println("Você Venceu!");
    }

    return val;
    }
    
    //função que verifica se as 16 posições estão ocupadas por números e se o jogador perdeu
    public void perdeu(){
    int cont = 0;
    for(int i = 0; i<list.size();i++)
    {
        if(list.get(i) != " "){
            cont++;
        }
    }
    if(cont == 16){
        System.out.println("Você perdeu!");
    }
    }
    
    
    //Faz a leitura do teclado
    public void Teclado(){
    
    addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e){
            int codigo = e.getKeyCode();
            
            if(codigo == KeyEvent.VK_UP){
                System.out.println("PARA CIMA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_DOWN){
                System.out.println("PARA BAIXO");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_LEFT){
                System.out.println("PARA ESQUERDA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_RIGHT){
                System.out.println("PARA DIREITA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_W){
                System.out.println("PARA CIMA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_S){
                System.out.println("PARA BAIXO");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_A){
                System.out.println("PARA ESQUERDA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_D){
                System.out.println("PARA DIREITA");
                
                addEspacoVazio();
                perdeu();
            }
            
            if(codigo == KeyEvent.VK_R){
                System.out.println("RESETANDO...");  
                gridInicial();
                atualizaGrid();
            }
            }
        });
    }

}   
