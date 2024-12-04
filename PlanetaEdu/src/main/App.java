
 
package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Aula> aulas = new ArrayList<>();

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    public static List<Professor> getProfessores() {
        return professores;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Menu de opções iniciais (Login ou Cadastro)
        int opcaoInicial;
        do {
            System.out.println("=== Menu Inicial ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastro Aluno");
            System.out.println("3. Cadastro Professor");
            System.out.println("4. Cadastro Aula");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoInicial = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcaoInicial) {
                case 1: // Login
                    // Instancia o scanner para ler os dados

                    System.out.println("Informe seu CPF (somente números):");
                    String cpfInformado = scanner.nextLine();

                    System.out.println("Informe sua senha:");
                    String senhaInformada = scanner.nextLine();

                    // Tenta buscar o aluno e verificar a senha
                    Aluno alunoLogado = buscarAlunoPorCpf(cpfInformado);
                    if (alunoLogado != null && alunoLogado.getSenha().equals(senhaInformada)) {
                        System.out.println("Login bem-sucedido como Aluno!");
                        menuAposLogin(scanner); // Chama o menu após o login
                        break; // Sai do switch
                    }

                    // Tenta buscar o professor e verificar a senha
                    Professor professorLogado = buscarProfessorPorCpf(cpfInformado);
                    if (professorLogado != null && professorLogado.getSenha().equals(senhaInformada)) {
                        System.out.println("Login bem-sucedido como Professor!");
                        menuAposLogin(scanner); // Chama o menu após o login
                        break; // Sai do switch
                    }

                    // Se não encontrar o usuário ou a senha estiver errada
                    System.out.println("Login falhou. CPF ou senha incorretos.");
                    break;

                case 2: // Cadastro
                    // Criar novo usuário
                    cadastrarAluno(scanner);
                    break;
                case 3: // Cadastro
                    // Criar novo usuário
                    cadastrarProfessor(scanner);
                    break;

                case 4: // Cadastro de Aula
                    // Cadastra nova aula
                    cadastrarAula(scanner);
                    break;

                case 5: // Cadastrar Curso
                    // Cadastra novo curso
                    cadastrarCurso(scanner);
                    break;

                case 6: // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoInicial != 6); // Fim do loop principal
    }

    

    // Método para o menu pós-login
    public static void menuAposLogin(Scanner scanner) {
        int opcaoLogin;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Buscar");
            System.out.println("2. Atualizar");
            System.out.println("3. Deletar");
            System.out.println("4. Comprar");
            System.out.println("5. Avaliar");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoLogin = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcaoLogin) {
                case 1: // Buscar
                    menuBuscar(scanner);
                    break;
                case 2: // Atualizar
                    menuAtualizar(scanner);
                    break;
                case 3: // Deletar
                    menuDeletar(scanner);
                    break;
                case 4: // Comprar
                    menuComprar(scanner);
                    break;
                case 5: // Avaliar
                    avaliarAula(scanner);
                    break;
                case 6: // Sair do login
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoLogin != 6); // Fim do loop de opções pós-login
    }
    

    // Sub-menus para as opções
    public static void menuBuscar(Scanner scanner) {
        System.out.println("=== Menu de Busca ===");
        System.out.println("1. Buscar Aluno");
        System.out.println("2. Buscar Professor");
        System.out.println("3. Buscar Curso");
        System.out.println("4. Buscar Aula");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int buscarOpcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        switch (buscarOpcao) {
            case 1:
                buscarAluno(scanner);
                break;
            case 2:
                buscarProfessor(scanner);
                break;
            case 3:
                buscarCurso(scanner);
                break;
            case 4:
                buscarAula(scanner);
                break;
            case 5:
                menuAposLogin(scanner);
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuAtualizar(Scanner scanner) {
        System.out.println("=== Menu de Atualização ===");
        System.out.println("1. Atualizar Aluno");
        System.out.println("2. Atualizar Professor");
        System.out.print("Escolha uma opção: ");
        int atualizarOpcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        switch (atualizarOpcao) {
            case 1:
                atualizarAluno(scanner);
                break;
            case 2:
                atualizarProfessor(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuDeletar(Scanner scanner) {
        System.out.println("=== Menu de Deletar ===");
        System.out.println("1. Deletar Aluno");
        System.out.println("2. Deletar Professor");
        System.out.println("3. Deletar Curso");
        System.out.println("4. Deletar Aula");
        System.out.print("Escolha uma opção: ");
        int deletarOpcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        switch (deletarOpcao) {
            case 1:
                deletarAluno(scanner);
                break;
            case 2:
                deletarProfessor(scanner);
                break;
            case 3:
                deletarCurso(scanner);
                break;
            case 4:
                deletarAula(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuComprar(Scanner scanner) {
        System.out.println("=== Menu de Compra ===");
        System.out.println("1. Comprar Aula");
        System.out.println("2. Comprar Curso");
        System.out.print("Escolha uma opção: ");
        int comprarOpcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        switch (comprarOpcao) {
            case 1:
                comprarAula(scanner);
                break;
            case 2:
                comprarCurso(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.println("=== Cadastro de Aluno ===");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();
    
        if (!Validador.validarCPF(cpf)) {
            System.out.println("CPF inválido.");
            return;  // Retorna sem cadastrar, evitando adicionar dados inválidos
        }
    
        Aluno aluno = new Aluno(nome, cpf, email, telefone, endereco, usuario, senha, dataNascimento);
        alunos.add(aluno);  // Adiciona o aluno à lista
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor(Scanner scanner) {
        System.out.println("=== Cadastro de Professor ===");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Área de atuação: ");
        String area = scanner.nextLine();
        System.out.print("Comprovante de qualificação: ");
        String comprovante = scanner.nextLine();
        System.out.print("Conta bancária: ");
        String conta = scanner.nextLine();

        if (!Validador.validarCPF(cpf)) {
            System.out.println("CPF inválido.");
            return;
        }

        Professor professor = new Professor(nome, cpf, email, telefone, endereco, usuario, senha, area, comprovante, conta);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void cadastrarCurso(Scanner scanner) {
        System.out.println("=== Cadastro de Curso ===");
        
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();
        
        System.out.print("Descrição do curso: ");
        String descricaoCurso = scanner.nextLine();
        
        System.out.print("O curso é gratuito? (sim/não): ");
        String gratuitoInput = scanner.nextLine();
        boolean gratuito = gratuitoInput.equalsIgnoreCase("sim");
        
        double valorCurso = 0.0;
        if (!gratuito) {
            System.out.print("Valor do curso: ");
            valorCurso = scanner.nextDouble();
            scanner.nextLine(); // Consumir o newline após o double
        }

        // Criar o novo curso
        Curso curso = new Curso(nomeCurso, descricaoCurso, valorCurso, gratuito);
        
        // Solicitar o cadastro de um professor proprietário
        System.out.print("Digite o CPF do professor proprietário: ");
        String cpfProfessor = scanner.nextLine();
        
        Professor professor = buscarProfessorPorCpf(cpfProfessor);
        
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        // Verificar se o professor já não cadastrou o curso
        for (Curso c : cursos) {
            if (c.getNome().equalsIgnoreCase(nomeCurso)) {
                for (Professor p : c.getProfessores()) {
                    if (p.equals(professor)) {
                        System.out.println("Este professor já cadastrou este curso.");
                        return;
                    }
                }
            }
        }

        // Adicionar professor ao curso
        curso.adicionarProfessor(professor);
        cursos.add(curso);
        
        System.out.println("Curso cadastrado com sucesso!");
    }


    private static void cadastrarAula(Scanner scanner) {
        System.out.println("=== Cadastro de Aula ===");
        System.out.print("Nome da aula: ");
        String nome = scanner.nextLine();
        System.out.print("Área de ensino: ");
        String areaEnsino = scanner.nextLine();
        System.out.print("Aula é gratuita? (true/false): ");
        boolean gratuita = scanner.nextBoolean();
        double valor = 0;
        if (!gratuita) {
            System.out.print("Valor da aula: ");
            valor = scanner.nextDouble();
        }
        scanner.nextLine(); // Limpar buffer

        System.out.print("Digite o CPF do professor responsável: ");
        String cpfProfessor = scanner.nextLine();
        Professor professor = buscarProfessorPorCpf(cpfProfessor);  // Busca o professor pelo CPF

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        // Criação da aula com os dados fornecidos
        Aula aula = new Aula(nome, areaEnsino, gratuita, valor, professor);
        aulas.add(aula);  // Adiciona a aula à lista
        System.out.println("Aula cadastrada com sucesso!");
    }
    //Buscas
    private static void buscarAluno(Scanner scanner) {
        System.out.println("=== Buscar Aluno ===");
        System.out.print("Digite o nome ou CPF do aluno: ");
        String criterio = scanner.nextLine();
    
        // Verifica se há algum aluno cujo nome ou CPF contenha o critério
        List<Aluno> resultados = alunos.stream()
                .filter(aluno -> aluno.getNomeCompleto().contains(criterio) || aluno.getCpf().equals(criterio))
                .collect(Collectors.toList());
    
        if (resultados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            System.out.println("Alunos encontrados:");
            resultados.forEach(aluno -> System.out.println("- " + aluno.getNomeCompleto() + " (CPF: " + aluno.getCpf() + ")"));
        }
    }

    private static void buscarProfessor(Scanner scanner) {
        System.out.println("=== Buscar Professor ===");
        System.out.print("Digite o nome ou CPF do professor: ");
        String criterio = scanner.nextLine();

        List<Professor> resultados = professores.stream()
                .filter(professor -> professor.getNomeCompleto().contains(criterio) || professor.getCpf().equals(criterio))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("Nenhum professor encontrado.");
        } else {
            System.out.println("Professores encontrados:");
            resultados.forEach(professor -> System.out.println("- " + professor.getNomeCompleto() + " (CPF: " + professor.getCpf() + ")"));
        }
    }
    private static void buscarAula(Scanner scanner) {
        System.out.println("=== Buscar Aula ===");
        System.out.print("Digite o nome ou área de ensino da aula: ");
        String busca = scanner.nextLine();
        
        // Busca aula pelo nome ou área de ensino
        for (Aula aula : aulas) {
            if (aula.getNome().contains(busca) || aula.getAreaEnsino().contains(busca)) {
                System.out.println("Aula encontrada: " + aula.getNome() + " - " + aula.getAreaEnsino());
            }
        }
    }

    private static void buscarCurso(Scanner scanner) {
        System.out.println("=== Buscar Curso ===");
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.nextLine();

        List<Curso> resultados = cursos.stream()
                .filter(curso -> curso.getNome().contains(nomeCurso))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("Nenhum curso encontrado.");
        } else {
            System.out.println("Cursos encontrados:");
            resultados.forEach(curso -> System.out.println("- " + curso.getNome() + " (Gratuito: " + curso.isGratuito() + ")"));
        }
    }

    private static void comprarCurso(Scanner scanner) {
        System.out.println("=== Comprar Curso ===");
        System.out.print("Digite o nome do curso: ");
        String nomeCurso = scanner.nextLine();

        Curso curso = cursos.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCurso))
                .findFirst()
                .orElse(null);

        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Usuario usuario = buscarUsuarioPorCpf(cpf);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Curso comprado com sucesso!");
    }
    private static void comprarAula(Scanner scanner) {
        System.out.println("=== Comprar Aula ===");
        System.out.print("Digite o CPF do aluno: ");
        String cpfAluno = scanner.nextLine();
        Aluno aluno = buscarAlunoPorCpf(cpfAluno);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Digite o nome da aula que deseja comprar: ");
        String nomeAula = scanner.nextLine();
        
        Aula aulaCompra = null;
        for (Aula aula : aulas) {
            if (aula.getNome().equalsIgnoreCase(nomeAula)) {
                aulaCompra = aula;
                break;
            }
        }

        if (aulaCompra != null) {
            if (aulaCompra.isGratuita()) {
                System.out.println("Aula é gratuita! Você pode acessar sem custo.");
            } else {
                System.out.println("Aula custa " + aulaCompra.getValor() + ". Pagamento realizado com sucesso!");
            }
            System.out.println("Aula " + nomeAula + " comprada com sucesso.");
        } else {
            System.out.println("Aula não encontrada.");
        }
    }

    private static Usuario buscarUsuarioPorCpf(String cpf) {
        Usuario usuario = buscarAlunoPorCpf(cpf);
        if (usuario == null) {
            usuario = buscarProfessorPorCpf(cpf);
        }
        return usuario;
    }

    private static void atualizarProfessor(Scanner scanner) {
        System.out.println("=== Atualização de Professor ===");
        System.out.print("Digite o CPF do professor para atualizar: ");
        String cpf = scanner.nextLine();
    
        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        System.out.print("Novo email (atual: " + professor.getEmail() + "): ");
        String novoEmail = scanner.nextLine();
        professor.setEmail(novoEmail.isEmpty() ? professor.getEmail() : novoEmail);
    
        System.out.print("Nova área de atuação (atual: " + professor.getAreaAtuacao() + "): ");
        String novaArea = scanner.nextLine();
        professor.setAreaAtuacao(novaArea.isEmpty() ? professor.getAreaAtuacao() : novaArea);
    
        System.out.println("Professor atualizado com sucesso!");
    }


    private static void atualizarAluno(Scanner scanner) {
        System.out.println("=== Atualização de Aluno ===");
        System.out.print("Digite o CPF do aluno para atualizar: ");
        String cpf = scanner.nextLine();
    
        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
    
        System.out.print("Novo email (atual: " + aluno.getEmail() + "): ");
        String novoEmail = scanner.nextLine();
        aluno.email = novoEmail.isEmpty() ? aluno.getEmail() : novoEmail;
    
        System.out.print("Novo telefone (atual: " + aluno.telefone + "): ");
        String novoTelefone = scanner.nextLine();
        aluno.telefone = novoTelefone.isEmpty() ? aluno.telefone : novoTelefone;
    
        System.out.println("Aluno atualizado com sucesso!");
    }
    //AVALIAR
    private static void avaliarAula(Scanner scanner) {
        System.out.println("=== Avaliar Aula ===");
        System.out.print("Digite o CPF do usuário (aluno ou professor): ");
        String cpf = scanner.nextLine();
        Usuario usuario = buscarUsuarioPorCpf(cpf);
    
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
    
        System.out.print("Digite o nome da aula que deseja avaliar: ");
        String nomeAula = scanner.nextLine();
    
        Aula aula = aulas.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nomeAula))
                .findFirst()
                .orElse(null);
    
        if (aula == null) {
            System.out.println("Aula não encontrada.");
            return;
        }
    
        // Verifica se o usuário assistiu à aula
        if (!aula.usuarioAssistiu(usuario)) {
            System.out.println("Você não assistiu a esta aula. Assista antes de avaliá-la.");
            return;
        }
    
        // Coleta os dados da avaliação
        System.out.print("Digite a nota (0 a 5): ");
        int nota = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline após o número
        System.out.print("Digite seu comentário: ");
        String comentario = scanner.nextLine();
    
        // Adiciona a avaliação à aula
        try {
            Avaliacao avaliacao = new Avaliacao(usuario, nota, comentario);
            aula.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação registrada com sucesso!");
            System.out.println("Média da aula: " + aula.calcularMediaAvaliacoes());
            System.out.println("Nova avaliação geral do professor: " + aula.getProfessor().getAvaliacaoGeral());
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //DELETAR
    private static void deletarAluno(Scanner scanner) {
        System.out.println("=== Deletar Aluno ===");
        System.out.print("Digite o CPF do aluno para deletar: ");
        String cpf = scanner.nextLine();
    
        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
    
        alunos.remove(aluno);
        System.out.println("Aluno deletado com sucesso!");
    }
    
    
    private static void deletarProfessor(Scanner scanner) {
        System.out.println("=== Deletar Professor ===");
        System.out.print("Digite o CPF do professor para deletar: ");
        String cpf = scanner.nextLine();
    
        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }
    
        professores.remove(professor);
        System.out.println("Professor deletado com sucesso!");
    }

    private static void deletarAula(Scanner scanner) {
        System.out.println("=== Deletar Aula ===");
        System.out.print("Digite o nome da aula para deletar: ");
        String nomeAula = scanner.nextLine();
        
        Aula aulaRemover = null;
        for (Aula aula : aulas) {
            if (aula.getNome().equalsIgnoreCase(nomeAula)) {
                aulaRemover = aula;
                break;
            }
        }

        if (aulaRemover != null) {
            aulas.remove(aulaRemover);
            System.out.println("Aula " + nomeAula + " deletada com sucesso.");
        } else {
            System.out.println("Aula não encontrada.");
        }
    }

    private static void deletarCurso(Scanner scanner) {
        System.out.println("=== Deletar Curso ===");
        System.out.print("Digite o nome do curso para deletar: ");
        String nomeCurso = scanner.nextLine();
        
        Curso cursoRemover = null;
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nomeCurso)) {
                cursoRemover = curso;
                break;
            }
        }

        if (cursoRemover != null) {
            cursos.remove(cursoRemover);
            System.out.println("Curso " + nomeCurso + " deletado com sucesso.");
        } else {
            System.out.println("Curso não encontrado.");
        }
    }
    
    // Métodos auxiliares de busca
    public static Aluno buscarAlunoPorCpf(String cpf) {
        return alunos.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public static Professor buscarProfessorPorCpf(String cpf) {
        return professores.stream()
                .filter(professor -> professor.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}

