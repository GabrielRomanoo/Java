/*
 * contrato Autenticavel
 * 		quem assinar esse contrato, precisa implementar
 * 		     metodo setSenha
 * 			 metodo autentica
 *
 * Ela � um contrato onde quem assina se responsabiliza
 * por implementar esses m�todos (cumprir o contrato)
 * 
 * TODOS os metodos de uma INTERFACE devem ser ABSTRATOS
 * dentro de uma interface nao pode ter nada concreto, tem que ser tudo abstrato
*/

public abstract interface Autenticavel  {
	
	public abstract void setSenha(int senha);
	
	public abstract boolean autentica(int senha);
}
