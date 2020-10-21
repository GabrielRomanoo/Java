package br.com.alura.java.io.teste;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ok2 {

	public static void main(String[] args) {
		int maior = 0;
		int A[] = new int[7]; // inicializa o array com os valores padrões (no caso 0)
		// int A[] = new int[5];
//        A[0] = 3;
//        A[1] = 2;
//        A[2] = 3;
//        A[3] = 2;
//        A[4] = 3;
//		A[0] = 7;
//		A[1] = 4;
//		A[2] = -2;
//		A[3] = 4;
//		A[4] = -2;
//		A[5] = -9;
			A[0] = 7;
			A[1] = -5;
			A[2] = -5;
			A[3] = -5;
			A[4] = 7;
			A[5] = -1;
			A[6] = 7;
		List<Integer> intList = new ArrayList<Integer>(A.length);
		for (int i : A) {
			intList.add(i);
		}
		List<Integer> intList2 = new ArrayList<Integer>(A.length);
		int maior_comprimento = 0, count = 0;
		int marcador[] = new int[A.length];

		for (int i = 0; i < intList.size(); i++) {
			for (int j = i+1; j < intList.size(); j++) {
			if (A[i] == A[j]) {
				if (marcador[i] == -1) {
					intList2.remove(i);				
				} else {
					intList2.add(A[i]);
					marcador[i] = -1;
				}
				if (marcador[j] == -1) {
					intList2.remove(j);	
				} else {
					marcador[j] = -1;
					intList2.add(A[j]);
				}
			}
			}
		}
		if (intList2.size() == 1) {
			//return 1;
		}
		
		for (int i : intList2) {
			System.out.println(intList2);
		}

		int saida = intList2.size();
		System.out.println();
		

	}
}

//count += 2;
//if (marcador[i] == -1) {
//	count--;
//}
//if (marcador[i + 2] == -1) {
//	count--;
//}
//marcador[i] = -1;
//marcador[i + 2] = -1;
//}
//if (count > maior_comprimento) {
//maior_comprimento = count;
//}