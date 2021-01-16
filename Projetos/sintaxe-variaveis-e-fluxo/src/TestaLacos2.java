
public class TestaLacos2 {
	public static void main(String[] args) {
		int i, j;
		for (i = 0; i <= 10; i++) {
			for (j = 0; j <= i; j++) {
				//if (j > i)
					//break;

				System.out.print("*");
			}
			System.out.println(); // apenas pula linha
		}

	}
}
