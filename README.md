# ProjetoMercado
Projeto de um Mercado para o trabalho de Programação Orientada a Objeto de 2022.1

## Resumo
A ideia do projeto é implementar funcionalidades de um sistema de mercado utilizando conceitos que foram ensinados em sala de aula ao longo do período. Dos conceitos vistos em sala, foi utilizado nesse projeto:
* Encapsulamento
* Herança
* Sobrecarga
* Sobrescrita
* Arquivos
* Enumeração
* Interface
* Métodos Estáticos
* Coleções
* Tratamento de Exceções

### [Encapsulamento:](https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991#:~:text=Encapsulamento%C2%A0vem%20de,poder%C3%A1%20ser%20manipulada.)
> Encapsulamento vem de encapsular, que em programação orientada a objetos significa separar o programa em partes, o mais isolado possível. A idéia é tornar o software mais flexível, fácil de modificar e de criar novas implementações. O Encapsulamento serve para controlar o acesso aos atributos e métodos de uma classe. É uma forma eficiente de proteger os dados manipulados dentro da classe, além de determinar onde esta classe poderá ser manipulada.

Snippet da classe [Pessoa](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Pessoa.java)
```Java
public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) { //construtor da classe Pessoa
        this.nome = nome;
        this.idade = idade;
    }
    
    //gets e sets dos atributos da classe

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
```

### [Herança:](https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991#:~:text=A%20heran%C3%A7a%20%C3%A9,vari%C3%A1veis%20e%20m%C3%A9todos.)
> A herança é um mecanismo da Orientação a Objeto que permite criar novas classes a partir de classes já existentes, aproveitando-se das características existentes na classe a ser estendida. Este mecanismo é muito interessante, pois promove um grande reuso e reaproveitamento de código existente.  Com a herança é possível criar classes derivadas, subclasses, a partir de classes bases, superclasses. As subclasses são mais especializadas do que as suas superclasses, mais genéricas. As subclasses herdam todas as características de suas superclasses, como suas variáveis e métodos.

Snippet da classe [Funcionario](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Funcionario.java)
```Java
public class Funcionario extends Pessoa implements Serializable {
    private int cadastro;
    private String tipoFuncionario;

    public Funcionario(String nome, int idade, int cadastro, String tipoFuncionario) { //construtor da classe Funcionario
        super(nome, idade);
        this.cadastro = cadastro;
        this.tipoFuncionario = tipoFuncionario;
    }
```

### [Sobrecarga:](https://www.devmedia.com.br/sobrecarga-e-sobreposicao-de-metodos-em-orientacao-a-objetos/33066#:~:text=A%20sobrecarga%20de,separa%C3%A7%C3%A3o%20dos%20mesmos.)
> A sobrecarga de métodos (overload) é um conceito do polimorfismo que consiste basicamente em criar variações de um mesmo método, ou seja, a criação de dois ou mais métodos com nomes totalmente iguais em uma classe. A Sobrecarga permite que utilizemos o mesmo nome em mais de um método contanto que suas listas de argumentos sejam diferentes para que seja feita a separação dos mesmos.

Snippet da classe [Produto](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Produto.java)
```Java
public class Produto {
    private String nome;
    private double preco;
    private Calendar validade = Calendar.getInstance();
    private int qtd;

    public Produto(String nome, double preco) { //construtor da classe Produto
        validade.add(Calendar.DATE, 3);
        this.nome = nome;
        this.preco = preco;
    }
    
    public Produto(String nome, double preco, int qtd) { //construtor da classe Produto para o Estoque (sobrecarga)
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
```

### [Sobrescrita:](https://www.devmedia.com.br/sobrecarga-e-sobreposicao-de-metodos-em-orientacao-a-objetos/33066#:~:text=A%20Sobreposi%C3%A7%C3%A3o%20de,mais%20ou%20n%C3%A3o.)
> A Sobreposição de métodos (override) é um conceito do polimorfismo que nos permite reescrever um método, ou seja, podemos reescrever nas classes filhas métodos criados inicialmente na classe pai, os métodos que serão sobrepostos, diferentemente dos sobrecarregados, devem possuir o mesmo nome, tipo de retorno e quantidade de parâmetros do método inicial, porém o mesmo será implementado com especificações da classe atual, podendo adicionar um algo a mais ou não.

Snippet da classe [Estoque](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Estoque.java)
```Java
    @Override
    public void printaProdutos(){
        System.out.println("\n\n------------------------------------------------------------------");
        System.out.println("                             ESTOQUE                              ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s | %-20s | %-20s\n", "Nome", "Preco", "Quantidade");
        System.out.println("------------------------------------------------------------------");
        for(Produto prod : produtosEstoque){
            System.out.printf("%-20s | %-20s | %-20s\n", prod.getNome(), prod.getPreco(), prod.getQtd());
        }
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        return this.produtosEstoque;
    }
```

### [Arquivos:](https://www.devmedia.com.br/leitura-e-escrita-de-arquivos-de-texto-em-java/25529#:~:text=A%20leitura%20e%20escrita%20de%20arquivos%20por%20um%20programa%20pode%20se%20muito%20%C3%BAtil%2C%20seja%20para%20servir%20como%20arquivo%20de%20configura%C3%A7%C3%B5es%20e%20evitar%20a%20necessidade%20de%20modifica%C3%A7%C3%A3o%20frequente%20do%20c%C3%B3digo%20fonte%20do%20pr%C3%B3prio%20programa%20para%20cada%20cen%C3%A1rio%20ou%20simplesmente%20para%20servir%20para%20entrada%20e%20sa%C3%ADda%20de%20dados.)
> A leitura e escrita de arquivos por um programa pode se muito útil, seja para servir como arquivo de configurações e evitar a necessidade de modificação frequente do código fonte do próprio programa para cada cenário ou simplesmente para servir para entrada e saída de dados.

Snippet da classe [Mercado](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Mercado.java)
```Java
public void leArqFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException, InvalidClassException{
        try{
            fis = new FileInputStream("funcionarios.dat");
            ois = new ObjectInputStream(fis); //metodos pra abrir arquivo pra ler
            while(fis.available() != 0){ //enquanto nao é o fim do arquivo
                Funcionario func = (Funcionario) ois.readObject(); //le objeto funcionario do arquivo
                 if(!this.funcionarios.contains(func)){ //se nao contem o funcionario no array de funcionarioS
                    this.funcionarios.add(func); //add o funcionario lido do arquivo ao array funcionarioS
                }
            }
        }catch(FileNotFoundException | InvalidClassException fnfex){ //trata as excessoes 
            
        }finally{
            if(fis != null){
                fis.close(); //fecha file input
            }
            if(ois != null){
                ois.close(); //fecha object input
            }
        }
    }
    
    public void escreveArqFuncionarios() throws FileNotFoundException, IOException{
        try{
            fos = new FileOutputStream("funcionarios.dat", false);
            oos = new ObjectOutputStream(fos); //metodos pra abrir o arquivo pra escrever
            for(Funcionario func : this.funcionarios){ //para cada funcionario no array funcionarioS
                oos.writeObject(func); //escreve no arquivo cada funcionario
            }
        }catch(FileNotFoundException fex){ //trata as excessoes
            
        }finally{
            if(fos != null){
                fos.close(); //fecha file output
            }
            if(oos != null){
                oos.close(); //fecha object output
            }
        }
    }
```

### [Enumeração:](https://www.devmedia.com.br/tipos-enum-no-java/25729#:~:text=S%C3%A3o%20tipos%20de%20campos%20que%20consistem%20em%20um%20conjunto%20fixo%20de%20constantes%20(static%20final)%2C%20sendo%20como%20uma%20lista%20de%20valores%20pr%C3%A9%2Ddefinidos.)
> São tipos de campos que consistem em um conjunto fixo de constantes (static final), sendo como uma lista de valores pré-definidos.

Snippet da classe [QTDProd](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/QTDProd.java)
```Java
public enum QTDProd {
    ESTOQUE(20),
    PRATELEIRA(10);
```

### [Interface:](https://www.devmedia.com.br/entendendo-interfaces-em-java/25502#:~:text=A%20interface%20%C3%A9,deve%20ser%20implementado.)
> A interface é um recurso muito utilizado em Java, bem como na maioria das linguagens orientadas a objeto, para “obrigar” a um determinado grupo de classes a ter métodos ou propriedades em comum para existir em um determinado contexto, contudo os métodos podem ser implementados em cada classe de uma maneira diferente. Pode-se dizer, a grosso modo, que uma interface é um contrato que quando assumido por uma classe deve ser implementado.

Snippet da classe [GerenciaProduto](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/GerenciaProduto.java)
```Java
public interface GerenciaProduto {
    public void printaProdutos();
    public void criaProdutos();
    public ArrayList<Produto> getProdutos();
}
```

### [Métodos Estáticos:](https://www.devmedia.com.br/trabalhando-com-metodos-em-java/25917#:~:text=Os%20m%C3%A9todos%20static,campos%20da%20classe.)
> Os métodos static ou métodos da classe são funções que não dependem de nenhuma variável de instância, quando invocados executam uma função sem a dependência do conteúdo de um objeto ou a execução da instância de uma classe, conseguindo chamar direto qualquer método da classe e também manipulando alguns campos da classe.

Snippet da classe [Caixa](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Caixa.java)
```Java
public static double totalCompra(Cliente cli){
        valorTotalCompra = 0;
        for(Produto prod : cli.getCarrinho().getProdutos()){ //para cada produto no carrinho
            if(prod.getQtd() > 0){
                valorTotalCompra += (prod.getPreco() * prod.getQtd()); //valor total = soma de cada produto
            }
        }
        if(checaFidelidade(cli)){ //se cliente tem fidelidade, ganha 50% de desconto
            cli.setValorCompra(valorTotalCompra*0.5);
            return valorTotalCompra*0.5;
        }
        System.out.println("Cliente nao possui fidelidade, deseja criar? s/n"); //cai aqui se nao tiver fidelidade e pergunta se deseja criar
        in = input.nextLine();
        if(in.toLowerCase().equals("s")){ //se deseja criar fidelidade
            cli.criaFidelidade();
            cli.setValorCompra(valorTotalCompra*0.5); //criou fidelidade e ganhou desconto
            return valorTotalCompra*0.5;
        }
        cli.setValorCompra(valorTotalCompra); //seta valor total da compra (sem fidelidade) do cliente (metodo em Cliente)
        return valorTotalCompra; //retorna o valor (sem desconto de fidelidade)
    }
```

### [Coleções:](https://www.devmedia.com.br/quando-usar-java-collections-parte-i/5025#:~:text=%C3%A9%20uma%20cole%C3%A7%C3%A3o%3F-,Em%20Programa%C3%A7%C3%A3o%20orientada%20a%20objetos%2C%20%C3%A9%20comum%20trabalharmos%20n%C3%A3o%20apenas%20com,a%20isso%20uma%20cole%C3%A7%C3%A3o%20tamb%C3%A9m%20pode%20ser%20denominada%20como%20um%20container.,-Cole%C3%A7%C3%B5es%20s%C3%A3o%20usadas)
> Em Programação orientada a objetos, é comum trabalharmos não apenas com um objeto, mas sim com um conjunto deles. Com base nisso fica clara que uma collection é um objeto que agrupa múltiplos elementos (variáveis primitivas ou objetos) dentro de uma única unidade, devido a isso uma coleção também pode ser denominada como um container.

Snippet da classe [Estoque](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Estoque.java)
```Java
import java.util.ArrayList; 

public class Estoque implements GerenciaProduto {
    private ArrayList<Produto> produtosEstoque = new ArrayList<Produto>();
```

### [Tratamento de Exceções:](https://www.devmedia.com.br/tratando-excecoes-em-java/25514#:~:text=Uma%20maneira%20de%20tentar%20contornar%20esses%20imprevistos%20%C3%A9%20realizar%20o%20tratamento%20dos%20locais%20no%20c%C3%B3digo%20que%20podem%20vir%20a%20lan%C3%A7ar%20poss%C3%ADveis%20exce%C3%A7%C3%B5es%2C%20como%20por%20exemplo%2C%20campo%20de%20consulta%20a%20banco%20de%20dados%2C%20locais%20em%20que%20h%C3%A1%20divis%C3%B5es%2C%20consulta%20a%20arquivos%20de%20propriedades%20ou%20arquivos%20dentro%20do%20pr%C3%B3prio%20computador.)
> Uma maneira de tentar contornar esses imprevistos é realizar o tratamento dos locais no código que podem vir a lançar possíveis exceções, como por exemplo, campo de consulta a banco de dados, locais em que há divisões, consulta a arquivos de propriedades ou arquivos dentro do próprio computador.

Snippet da classe [Mercado](https://github.com/mfollypp/ProjetoMercado/blob/main/ProjetoMercado/src/main/java/Main/Mercado.java)
```Java
public void escreveArqFuncionarios() throws FileNotFoundException, IOException{
        try{
            fos = new FileOutputStream("funcionarios.dat", false);
            oos = new ObjectOutputStream(fos); //metodos pra abrir o arquivo pra escrever
            for(Funcionario func : this.funcionarios){ //para cada funcionario no array funcionarioS
                oos.writeObject(func); //escreve no arquivo cada funcionario
            }
        }catch(FileNotFoundException fex){ //trata as excessoes
            
        }finally{
            if(fos != null){
                fos.close(); //fecha file output
            }
            if(oos != null){
                oos.close(); //fecha object output
            }
        }
    }
```
