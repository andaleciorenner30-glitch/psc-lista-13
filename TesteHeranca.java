public class TesteHeranca {

    public static void main(String[] args) {
        
        System.out.println("--- 1. Testando a Classe Pessoa ---");
        Pessoa p = new Pessoa("Ana Costa", "111.111.111-11", 30);
        p.exibirDadosBasicos();
        System.out.println("\n");
        
        System.out.println("--- 2. Testando a Classe Funcionario ---");
        Funcionario f = new Funcionario("Bruno Silva", "222.222.222-22", 45, 4500.00, "Analista de TI");
        f.exibirDadosBasicos(); // Método herdado de Pessoa
        
        double salarioAnualFuncionario = f.calcularSalarioAnual();
        System.out.printf("Salário Anual: R$%.2f%n", salarioAnualFuncionario);
        System.out.println("\n");

        System.out.println("--- 3. Testando a Classe Gerente ---");
        Gerente g = new Gerente("Carla Souza", "333.333.333-33", 50, 12000.00, "Gerente de Projetos", "Desenvolvimento");
        
        // Método sobrescrito (@Override): Chama o método do pai + imprime os dados do Gerente
        g.exibirDadosBasicos(); 
        
        double salarioAnualGerente = g.calcularSalarioAnual(); // Método herdado de Funcionario
        System.out.printf("Salário Anual: R$%.2f%n", salarioAnualGerente);
    }
}

// ----------------------------------------------------
// 1. Superclasse: Pessoa
// ----------------------------------------------------
class Pessoa {
    protected String nome;
    protected String cpf;
    protected int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public void exibirDadosBasicos() {
        System.out.println("--- Dados Pessoais ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade + " anos");
    }
}

// ----------------------------------------------------
// 2. Subclasse Direta: Funcionario
// ----------------------------------------------------
class Funcionario extends Pessoa {

    private double salario;
    private String cargo; // Private, precisa de Getter para acesso externo/subclasses

    public Funcionario(String nome, String cpf, int idade, double salario, String cargo) {
        super(nome, cpf, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularSalarioAnual() {
        return this.salario * 12;
    }
    
    // CORREÇÃO: Getter para que a subclasse Gerente possa acessar o cargo.
    public String getCargo() {
        return this.cargo;
    }
}

// ----------------------------------------------------
// 3. Subclasse de Segundo Nível: Gerente
// ----------------------------------------------------
class Gerente extends Funcionario {

    private String departamento;

    public Gerente(String nome, String cpf, int idade, double salario, String cargo, String departamento) {
        super(nome, cpf, idade, salario, cargo);
        this.departamento = departamento;
    }

    @Override
    public void exibirDadosBasicos() {
        // 1. Chama o método da classe pai (Pessoa)
        super.exibirDadosBasicos(); 

        // 2. Imprime os dados específicos (acesso ao cargo via Getter corrigido)
        System.out.println("Cargo: " + this.getCargo()); 
        System.out.println("Departamento: " + this.departamento);
        System.out.println("----------------------");
    }
}