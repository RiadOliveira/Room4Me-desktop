package filter;

public class bubbleSort<T extends Comparable <?super T>> {
	public bubbleSort(T[]lista) {
		int tamanho = lista.length;
		
		while(tamanho > 0) {
			int ultimoModificado = 0;
			
			for (int i = 0; i < lista.length; i++) {
				if(lista[i-1].compareTo(lista[i])>0) {
					T aux = lista[i-1];
					lista[i-1] = lista[i];
					lista[i]=aux;
					
					ultimoModificado=i;
				}
			}
			tamanho = ultimoModificado;
		}
	}
}
