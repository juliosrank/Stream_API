import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 17, "São Paulo"),
                new Pessoa("Bruno", 22, "Rio de Janeiro"),
                new Pessoa("Carla", 30, "São Paulo"),
                new Pessoa("Diego", 15, "Curitiba"),
                new Pessoa("Eduarda", 25, "Curitiba"),
                new Pessoa("Felipe", 40, "Rio de Janeiro"),
                new Pessoa("Gustavo", 18, "São Paulo")
        );

        //Tarefas (usando Stream API)
        //Liste apenas os nomes das pessoas que são maiores de 18 anos, em ordem alfabética.
        System.out.println("Pessoas que são maiores de 18 anos em ordem alfabética: ");
        List<String> nomesMaiores18 = pessoas.stream()
                .filter(p -> p.idade() >= 18)
                .map(Pessoa::nome)
                .sorted()
                .toList();
        System.out.println(nomesMaiores18);

        //Mostre a média de idades das pessoas de São Paulo.
        System.out.println("Média de idades das pessoas de São Paulo: ");
        double mediaIdadesSP = pessoas.stream()
                .filter(p -> p.cidade().equals("São Paulo"))
                .mapToInt(Pessoa::idade)
                .average() //Média
                .orElse(0);
        System.out.println(mediaIdadesSP);

        //Crie uma lista apenas com as cidades distintas (sem repetição).
        System.out.println("Cidades distintas: ");
        List<String> cidadesDistintas = pessoas.stream()
                .map(Pessoa::cidade)
                .distinct() //Remove elementos duplicados
                .toList(); //Converte o stream em coleção
        System.out.println(cidadesDistintas);

        //Verifique se todas as pessoas têm mais de 16 anos
        System.out.println("Todas as pessoas têm mais de 16 anos? ");
        boolean todasMaiores16 = pessoas.stream()
                .allMatch(p -> p.idade() > 16); //Retorna true se todos satisfazem a condição
        System.out.println(todasMaiores16);

        //Pegue a pessoa mais velha e a mais nova.
        System.out.println("A pessoa mais velha e a mais nova: ");
        Optional<Pessoa> pessoaMaisVelha = pessoas.stream()
                .max(Comparator.comparingInt(Pessoa::idade));
        Optional<Pessoa> pessoaMaisNova = pessoas.stream()
                .min(Comparator.comparingInt(Pessoa::idade));
        pessoaMaisVelha.ifPresent(p -> System.out.println("Mais velha: " + p));
        pessoaMaisNova.ifPresent(p -> System.out.println("Mais nova: " + p));

    }
}