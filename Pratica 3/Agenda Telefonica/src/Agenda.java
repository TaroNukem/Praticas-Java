import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> listaContatos;
    private int quantidadeContatos;


    public Agenda() {
        listaContatos = new ArrayList<>();
        quantidadeContatos = 0;
    }

    public void adicionarContato(Contato contato) {
        listaContatos.add(contato);
        quantidadeContatos = listaContatos.size();
    }

    public boolean removerContato(String nome) {
        for (int i = 0; i < quantidadeContatos; i++) {
            if (listaContatos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaContatos.remove(i);
                quantidadeContatos = listaContatos.size();
                return true;
            }
        }
        return false;
    }

    public Contato buscarNome(String nome) {
        for (Contato contato : listaContatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarEmail(String email) {
        for (Contato contato : listaContatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarTelefone(String telefone) {
        for (Contato contato : listaContatos) {
            if (contato.getTelefone().equalsIgnoreCase(telefone)) {
                return contato;
            }
        }
        return null;
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }
}
