package tad.conjuntoDinamico;

import java.util.NoSuchElementException;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	
	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) { 
	if (item == null) {
		throw new IllegalArgumentException("Não pode ter entrada zero");
	}

	if (meusDados == null) {
		meusDados = new Integer[1];
		meusDados[0] = item;
	} 
	
	else {
		if (posInsercao >= meusDados.length) {
			Integer[] arrayMaior = aumentarArray();
			meusDados = arrayMaior;
		}
		meusDados[posInsercao] = item;
	}
	posInsercao++;
		
	}
	
	private Integer[] aumentarArray() {
		int novoTamanho = meusDados.length * 2;
		Integer[] novoArray = new Integer[novoTamanho];
		
		for (int i = 0; i < meusDados.length; i++) {
			novoArray[i] = meusDados[i];
		}
		
		return novoArray;
	}

	@Override
	public Integer remover(Integer item) {
		if (item == null) {
            throw new UnsupportedOperationException("Não pode ter entrada zero");
        }
        
        if (meusDados == null) {
			throw new NoSuchElementException("Conjunto dinâmico vazio");
        }

        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i].equals(item)) {
                Integer remove = meusDados[i];
                posInsercao--;
                meusDados[i] = meusDados[posInsercao];
                meusDados[posInsercao] = null;
                return remove;
            }
        }

		throw new NoSuchElementException("Elemento não encontrado");
		
	}

	@Override
	public Integer predecessor(Integer item) {
		if (item == null) {
			throw new IllegalArgumentException("Não pode ter entrada zero");
        }
        
        if (meusDados == null) {
			throw new UnsupportedOperationException("Conjunto dinâmico vazio");
        }

        Integer predecessor = null;
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i].equals(item)) {
                return predecessor;
            }
            predecessor = meusDados[i];
        }

        throw new UnsupportedOperationException("Elemento não encontrado");
	}

	@Override
	public Integer sucessor(Integer item) {
		if (item == null) {
            throw new IllegalArgumentException("Não pode ter entrada zero");
        }
        
        if (meusDados == null) {
			throw new UnsupportedOperationException("Conjunto dinâmico vazio");
        }

        boolean procuraElemento = false;
        for (int i = 0; i < posInsercao; i++) {
            if (procuraElemento)
                return meusDados[i];
            if (meusDados[i].equals(item))
			procuraElemento = true;
        }

        return null;
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		for(int i = 0; i < posInsercao; i++){
			if (meusDados[i] == item){
				return meusDados[i];
			}
		}
		throw new UnsupportedOperationException("Elemento não encontrado");
	}

	@Override
	public Integer minimum() {
		Integer menor;

		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto dinâmico Vazio");
		}
		else{
			menor = meusDados[0];
			for(Integer elemento : meusDados){
				if(elemento != null){
					if(elemento < menor){
						menor = elemento;
					}
				}	
			}	
		}
		return menor;
	}

	@Override
	public Integer maximum() {
		Integer maior;
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto dinâmico Vazio");
		}
		else{
			maior = meusDados[0];
			for(Integer elemento : meusDados){
				if(elemento != null){
					if(elemento > maior){
						maior = elemento;
					}
				}
				
			}	
		}
		return maior;
	}

}

