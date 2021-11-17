package ExemplosExternos;

public class ExemplosSingleton {

    //Exemplo de aplicação de Singleton
    //Criação de um tabuleiro de Xadrez

    static private ExemplosSingleton instance = null;

    private ExemplosSingleton () {}
    static ExemplosSingleton getInstance() {
        if (instance == null)
            instance = new ExemplosSingleton();
        return instance;
    }

    public static void main (String args []) {
        ExemplosSingleton tabuleiro1 = ExemplosSingleton.getInstance();
        ExemplosSingleton tabuleiro2 = ExemplosSingleton.getInstance();

        System.out.println(tabuleiro1);
        System.out.println(tabuleiro2);
    }
}
