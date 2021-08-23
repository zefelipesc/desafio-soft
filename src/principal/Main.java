package principal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Pessoa> pessoas = new ArrayList<>();
    //static List<AtividadeFisica> atividadeFisicas = new ArrayList<>();

    public static void main(String[] args) {
        operacoes();
    }

    public static void operacoes() {
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:" +
                "\n1 para cadastrar uma pessoa" +
                "\n2 visualizar pessoas cadastradas" +
                "\n3 visualiar pessoas e suas atividades" +
                "\n4 para visualizar resumo" +
                "\n5 para editar uma pessoa" +
                "\n6 para excluir uma pessoa"));
               // "\n7 para visualizar relatório"));

        switch (operacao) {
            case 1:
                cadastrarPessoa();
                break;
            case 2:
                visualizarPessoa();
                break;
            case 3:
                visualizarPessoaEAtividade();
            case 4:
                resumo();
                break;
            case 5:
                editarPessoa();
                break;
            default:
                excluir();


        }
    }

    public static void cadastrarPessoa() {
        //int continuarCadastro = 0;
        //while (continuarCadastro == 0) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(JOptionPane.showInputDialog("Digite o nome da pessoa:"));
        pessoa.setSobreNome(JOptionPane.showInputDialog("Digite o sobrenome da pessoa:"));
        pessoa.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
        //pessoa.setDia(Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do nascimento:")));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do nascimento:"));
        while (dia < 1 || dia > 31) {
            JOptionPane.showMessageDialog(null, "o dia tem que ser de 1 a 31");
            dia = Integer.parseInt(JOptionPane.showInputDialog("Digite um dia válido:"));
        }
        if (dia > 1 || dia <= 31){
            pessoa.setDia(dia);
        }
        //pessoa.setMes(Integer.parseInt(JOptionPane.showInputDialog("Digite o mês do nascimento:")));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês do nascimento:"));
        while (mes < 1 || mes > 12) {
            JOptionPane.showMessageDialog(null, "o dia tem que ser de 1 a 12");
            mes = Integer.parseInt(JOptionPane.showInputDialog("Digite um mês válido:"));
        }
        if (mes > 1 || mes <= 12){
            pessoa.setMes(mes);
        }
       // pessoa.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do nascimento:")));
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do nascimento:"));
        while (ano > 2021){
            JOptionPane.showMessageDialog(null, "Ainda estamos em 2021, calma lá!");
            ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano válido:"));
        }
        if (ano <= 2021){
            pessoa.setAno(ano);
        }

        JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
        pessoas.add(pessoa);
        int continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma atividade física para " + pessoa.getNome(),
                "Continuar", JOptionPane.YES_NO_OPTION);
        if (continuar == 0) {
            pessoa.setAtividadeFisicas(cadastrarAtividadeFisica(pessoa));
        }
        operacoes();
    }

    public static String obterTipoExercicio(Integer tipoExercicio) {
        switch (tipoExercicio) {
            case 1:
                return "Aeróbico";
            case 2:
                return "Caminhada";
            case 3:
                return "Corrida";
            default:
                return "Bicicleta";

        }
    }

    public static List<AtividadeFisica> cadastrarAtividadeFisica(Pessoa pessoa) {
        List<AtividadeFisica> atividadeFisicas = new ArrayList<>();
        int continuar = 0;
        while (continuar == 0) {
            AtividadeFisica atividadeFisica = new AtividadeFisica();
            atividadeFisica.setDiaDoExercicio(Integer.parseInt(JOptionPane.showInputDialog("Qual o dia do treino?")));
            int tipoExercicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo de exercício:" +
                    "\n1 para aeróbico" +
                    "\n2 para caminhada" +
                    "\n3 para corrida" +
                    "\n4 para bicicleta"));
            if (tipoExercicio != 1) {
                atividadeFisica.setDistPercorrida(Float.parseFloat(JOptionPane.showInputDialog("Digite a distância percorrida em metros:")));
            }
            atividadeFisica.setFreqCardioMin(Float.parseFloat(JOptionPane.showInputDialog("Digite a frequencia cardíaca mínima:")));
            //atividadeFisica.setFreqCardioMax(Float.parseFloat(JOptionPane.showInputDialog("Digite a frequencia cardíaca máxima:")));
            atividadeFisica.setTempoExercicio(Float.parseFloat(JOptionPane.showInputDialog("Digite o tempo levado para realizar o exercício:")));
            atividadeFisica.setExercicio(tipoExercicio);
            JOptionPane.showMessageDialog(null, "Atividade cadastrada com sucesso!");
            atividadeFisicas.add(atividadeFisica);
            continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma atividade física para " + pessoa.getNome(),
                    "Continuar", JOptionPane.YES_NO_OPTION);
        }
        return atividadeFisicas;

    }

    public static void visualizarPessoa() {
        for (int i = 0; i < pessoas.size(); i++) {
            String saida = "-------------------- Pessoas Cadastradas --------------------" + "\n"
                    + "Nome: " + pessoas.get(i).getNome()
                    + " " + pessoas.get(i).getSobreNome() + "\n"
                    + "Data de nascimento: " + pessoas.get(i).getDia() + "/" + pessoas.get(i).getMes() + "/" + pessoas.get(i).getAno() + "\n";
            JOptionPane.showMessageDialog(null, saida);
        }
        int continuar = JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?",
                "Continuar", JOptionPane.YES_NO_OPTION);
        if (continuar == 0) {
            operacoes();
        }
    }


    public static void visualizarPessoaEAtividade() {
        String saida = " ";
        for (int i = 0; i < pessoas.size(); i++) {
            saida = "-------------------- Pessoas Cadastradas --------------------" + "\n"
                    + "Nome: " + pessoas.get(i).getNome()
                    + " " + pessoas.get(i).getSobreNome() + "\n"
                    + "Data de nascimento: " + pessoas.get(i).getDia() + "/" + pessoas.get(i).getMes() + "/" + pessoas.get(i).getAno() + "\n";
            for (int j = 0; j < pessoas.get(i).getAtividadeFisicas().size(); j++) {
                saida += "Frequência Máxima: " + pessoas.get(i).getAtividadeFisicas().get(j).frequenciaMax(pessoas.get(i).getIdade()) + "\n";
                JOptionPane.showMessageDialog(null, saida);
            }
        }
        int continuar = JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?",
                "Continuar", JOptionPane.YES_NO_OPTION);
        if (continuar == 0) {
            operacoes();
        }
    }

    public static void editarPessoa() {
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja editar: ");
        for (int i = 0; i < pessoas.size(); i++)
            if (pessoas.get(i).getNome().equals(nome)) {
                int editar = Integer.parseInt(JOptionPane.showInputDialog("Digite \n 1 - para editar o nome \n 2 - para editar o sobrenome \n 3 - para editar as Atividades"));
                if (editar == 1) {
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ");
                    pessoas.get(i).setNome(novoNome);
                    JOptionPane.showMessageDialog(null, "nome editado com sucesso");
                }
                if (editar == 2) {
                    String novoSobreNome = JOptionPane.showInputDialog("Digite o novo sobrenome: ");
                    pessoas.get(i).setSobreNome(novoSobreNome);
                    JOptionPane.showMessageDialog(null, " sobrenome editado com sucesso");
                }
                //visualizarPessoa();
                if (editar == 3) {
                    for (int j = 0; j < pessoas.get(i).getAtividadeFisicas().size(); j++) {
                        int editarATV = Integer.parseInt(JOptionPane.showInputDialog("Digite \n 1 - para editar a exercício " +
                                "\n 2 - para editar o tempo do exercício \n 3 - para editar a frequência cardíaca mínima \n 4 - para editar o tempo do exercício"));
                        if (editarATV == 1) {
                            int novaAtividade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nº do novo exercício: \n" +
                                    "1 - aeróbico \n 2 - caminhada \n 3 - corrida \n 4 - bicicleta"));
                            pessoas.get(i).getAtividadeFisicas().get(j).setExercicio(novaAtividade);
                        }
                        //falta implementar as outras 3 ccondições

                    }

                }
                visualizarPessoaEAtividade();
            }
    }

    public static void excluir() {
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja remover: ");
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equals(nome)) {
                int remover = JOptionPane.showConfirmDialog(null, "Deseja remover " + nome + "?");
                if (remover == 0) {
                    nome += pessoas.remove(i);
                } else {
                    operacoes();
                }
            }
            JOptionPane.showMessageDialog(null, " removido(a) com sucesso");
            int continuar = JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?",
                    "Continuar", JOptionPane.YES_NO_OPTION);
            if (continuar == 0) {
                operacoes();
            }
        }
    }


    public static void resumo() {
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja ver o resumo: ");
        String saida = " ";
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equals(nome)) {
                for (int j = 0; j < pessoas.get(i).getAtividadeFisicas().size(); j++) {
                    saida = "Dia do exercício: " + pessoas.get(i).getAtividadeFisicas().get(j).getDiaDoExercicio() + "\n"
                            + "Frequência Máxima: " + pessoas.get(i).getAtividadeFisicas().get(j).frequenciaMax(pessoas.get(i).getIdade()) + "\n";
                    JOptionPane.showMessageDialog(null, saida);
                }
                operacoes();
                if (pessoas.get(i).getNome() != nome) {
                    String saida2 = "Pessoa não cadastrada!";
                    JOptionPane.showMessageDialog(null, saida2);
                    operacoes();
                }

            }
        }
    }

}




