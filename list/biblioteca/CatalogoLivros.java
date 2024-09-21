package list.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    public List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livroList.add(livro);
        System.out.println(livro + " adicionado com sucesso.");
    }


    public Livro pesquisaLivroPorTitulo(String titulo) {
        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }


    public List<Livro> pesquisaPorAutor(String autor) {
        List<Livro> catalogoDoAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    catalogoDoAutor.add(livro);
                }
            }
        }
        return catalogoDoAutor;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> catalogoPorPeriodo = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro livro : livroList) {
                if (livro.getAno() >= anoInicial && livro.getAno() <= anoFinal) {
                    catalogoPorPeriodo.add(livro);
                }
            }
        }
        return catalogoPorPeriodo;
    }


    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        Livro livro1 = new Livro("Mamão na mão", "Leopoldo", 1982);
        Livro livro2 = new Livro("Jacaré tem pé?", "José", 1999);
        Livro livro3 = new Livro("True or False", "Wallace", 2020);
        Livro livro4 = new Livro("O retorno", "José", 1990);
        catalogoLivros.adicionarLivro(livro1);
        catalogoLivros.adicionarLivro(livro2);
        catalogoLivros.adicionarLivro(livro3);
        catalogoLivros.adicionarLivro(livro4);
        catalogoLivros.adicionarLivro(new Livro("O pão", "José", 2001));
        System.out.println(catalogoLivros.livroList);
        System.out.println("Livros do José: " + catalogoLivros.pesquisaPorAutor("josé"));
        System.out.println("Livros no período: " + catalogoLivros.pesquisaPorIntervaloAnos(1980, 1999));
        System.out.println("Livro com o título: " + catalogoLivros.pesquisaLivroPorTitulo("Mamão na mão"));

    }
}
