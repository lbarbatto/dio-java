package map.agenda;

import java.util.HashMap;
import java.util.Map;

public class AgendaContato {
    private Map<String, String> agendaContatoMap;

    public AgendaContato() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato (String nome, String telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato (String nome) {
        if (!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public String pesquisarPorNome(String nome){
        String numeroTelefone = null;
        if(!agendaContatoMap.isEmpty()){
            numeroTelefone = agendaContatoMap.get(nome);
        }
        return numeroTelefone;    
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();
        agendaContato.adicionarContato("Leo", "123456789" );
        agendaContato.adicionarContato("Ana", "987654321" );

        agendaContato.exibirContatos();

        agendaContato.adicionarContato("Lia", "2233112233" );
        agendaContato.removerContato("Leo");

        agendaContato.exibirContatos();

        agendaContato.adicionarContato("Joao", "556667885" );
        agendaContato.adicionarContato("Igor", "333555777" );

        agendaContato.exibirContatos();

        System.out.println(agendaContato.pesquisarPorNome("Lia"));
    }
}
