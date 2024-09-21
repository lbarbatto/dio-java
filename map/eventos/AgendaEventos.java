package map.eventos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionareventos(LocalDate data, String nome, String atracao){
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventosTreeMap);
    }

    public LocalDate obterDataDoEvento(String nome) {
        AgendaEventos agendaEventoSelecionado = null;
        LocalDate dataDoEvento = null;
        if(!agendaEventosMap.isEmpty()){
            for(Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()){
                if (entry.getValue().getNome() == nome){
                    dataDoEvento = entry.getKey();
                }
            }
        }

        return dataDoEvento;
    }

    public Evento obterProximoEvento(){
        Map<LocalDate , Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        Evento proximoEvento = null;
        LocalDate dataAtual = LocalDate.now();
        if(!eventosTreeMap.isEmpty()){
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                    proximoEvento = entry.getValue();
                    break;
                }
            }
        }
        return proximoEvento;
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.exibirAgenda();

        agendaEventos.adicionareventos(LocalDate.now(), "RiR", "Kayt");
        agendaEventos.adicionareventos(LocalDate.of(2008, 12, 5), "ECO", "Kayt");
        agendaEventos.adicionareventos(LocalDate.of(2020, 10, 8), "After", "Kayt");
        agendaEventos.adicionareventos(LocalDate.of(2024, 10, 12), "Praia", "Kayt");
        agendaEventos.adicionareventos(LocalDate.of(2024, 11, 4 ), "Mudança", "Kayt");

        agendaEventos.exibirAgenda();
        System.out.println(agendaEventos.obterProximoEvento());
        System.out.println("O Próximo evento será: " + agendaEventos.obterDataDoEvento(agendaEventos.obterProximoEvento().getNome()));
    }
}
