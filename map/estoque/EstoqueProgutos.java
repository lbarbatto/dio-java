package map.estoque;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProgutos {
    private Map<Long, Produto> estoqueProdutosMap;


    public EstoqueProgutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibeProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calculaValorTotalEstoque(){
        double valorTotal = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for (Produto produto : estoqueProdutosMap.values()) {
                valorTotal += produto.getPreco() * produto.getQuantidade();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = new Produto("", 0, 0);
        if(!estoqueProdutosMap.isEmpty()){
            for ( Produto produto : estoqueProdutosMap.values()){
                if (produto.getPreco() > produtoMaisCaro.getPreco()){
                    produtoMaisCaro = produto;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProgutos estoqueProgutos = new EstoqueProgutos();

        estoqueProgutos.exibeProdutos();

        estoqueProgutos.adicionarProduto(1L, "Produto A", 5.0, 13);
        estoqueProgutos.adicionarProduto(2L, "Produto B", 12.0, 8);
        estoqueProgutos.adicionarProduto(3L, "Produto C", 1.0, 10);

        estoqueProgutos.exibeProdutos();
        System.out.println("Total em estoque: " + estoqueProgutos.calculaValorTotalEstoque());


        estoqueProgutos.adicionarProduto(4L, "Produto D", 20.0, 1);
        estoqueProgutos.adicionarProduto(5L, "Produto E", 18.0, 4);

        estoqueProgutos.exibeProdutos();
        System.out.println("Total em estoque: " + estoqueProgutos.calculaValorTotalEstoque());
        System.out.println("Produto Mais caro: " + estoqueProgutos.obterProdutoMaisCaro());

    }
}
