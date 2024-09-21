package list.tarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada");
    }

    public void removeTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<Tarefa>();
        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(tarefa);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
        System.out.println("Tarefa removida");
    }

    public int numeroTotalTarefas() {
        return tarefaList.size();
    }


    public List<Tarefa> obterDescricoesTarefas() {
        return tarefaList;
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefa = new ListaTarefas();
        System.out.println("Total de Tarefas é: " + listaTarefa.numeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");
        System.out.println("Total de Tarefas é: " + listaTarefa.numeroTotalTarefas());
        System.out.println("Lista de tarefas: " + listaTarefa.obterDescricoesTarefas());

        listaTarefa.adicionarTarefa("Tarefa 3");
        listaTarefa.adicionarTarefa("Tarefa 3");
        listaTarefa.adicionarTarefa("Tarefa 3");
        System.out.println("Total de Tarefas é: " + listaTarefa.numeroTotalTarefas());
        System.out.println("Lista de Tarefas: " + listaTarefa.obterDescricoesTarefas());

        listaTarefa.removeTarefa("Tarefa 3");
        System.out.println("Total de Tarefas é: " + listaTarefa.numeroTotalTarefas());
        System.out.println("Lista de Tarefas: " + listaTarefa.obterDescricoesTarefas());
    }

}
