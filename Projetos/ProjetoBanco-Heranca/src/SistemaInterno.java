
public class SistemaInterno {
	
	private int senha = 2222;
	
	public void autentica(Autenticavel fa) { //todo mundo que tem implements Autenticavel
		boolean autenticou = fa.autentica(this.senha);
		if (autenticou) {
			System.out.println("pode entrar no sistema!");
		} else {
			System.out.println("não pode entrar no sistema!");
		}
	}

}
