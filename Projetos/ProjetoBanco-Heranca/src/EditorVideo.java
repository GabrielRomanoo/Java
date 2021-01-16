
public class EditorVideo extends Funcionario { 
			
    public double getBonificacao() {
    	System.out.println("chamando o metodo de bonificacao do EditorVideo");
    	return 150;
		//return super.getBonificacao() + 100; 
		//super indica que o atributo/método é da classe de cima, do pai/mae
	}
	
	
}