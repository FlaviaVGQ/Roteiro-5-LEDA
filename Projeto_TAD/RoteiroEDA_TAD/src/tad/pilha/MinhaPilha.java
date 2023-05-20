package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {

	private int tamanho = 10;
	private Integer[] meusDados = null;
	private int topo = -1;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		meusDados = new Integer[tamanho];
	}

	public MinhaPilha() {
		meusDados = new Integer[tamanho];
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
    if (meusDados == null) {
        meusDados = new Integer[tamanho];
    }

    if (topo + 1 >= tamanho) {
        throw new PilhaCheiaException();
    }

    topo++;
    meusDados[topo] = item;
}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Integer topoNum = meusDados[topo];
		meusDados[topo] = null;
		this.topo--;
		return topoNum;
	}

	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return this.meusDados[topo];
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (k < 0 || k > tamanho || k > topo + 1) {
			throw new IllegalArgumentException("Valor inválido para k");
		}
		PilhaIF<Integer> novaPilha = new MinhaPilha(k);
		int contador = 0;
		for (int i = topo; i >= 0 && contador < k; i--) {
			try {
				novaPilha.empilhar(meusDados[i]);
			} catch (PilhaCheiaException e) {
				// Tratamento opcional para exceção de pilha cheia
			}
			
		}
		return novaPilha;
	}

	
	@Override
	public boolean isEmpty() {
		if (this.topo == -1){
			return true;
		}
		else{
			return false;
		}
	}
}