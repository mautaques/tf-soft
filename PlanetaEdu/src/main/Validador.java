package main;

public class Validador {

    // Função para validar o CPF
    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
    }

    // Função para autenticar o usuário (verifica se o CPF e a senha são válidos)
    public static boolean autenticar(String usuario, String senha, Usuario usuarioObj) {
        return usuario.equals(usuarioObj.getUsuario()) && senha.equals(usuarioObj.getSenha());
    }

    // Função para validar o login
    public static boolean validarLogin(String cpf, String senha, Usuario usuarioObj) {
        if (!validarCPF(cpf)) {
            System.out.println("CPF inválido.");
            return false;
        }
        if (autenticar(cpf, senha, usuarioObj)) {
            return true;
        } else {
            System.out.println("Senha inválida.");
            return false;
        }
    }
}
