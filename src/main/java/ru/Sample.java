import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = "";

            try(BufferedReader br = new BufferedReader(new FileReader(args[i]))) {
                 // вынести за цикл
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    s = s + line + "\n"; // append
                }

                String[] words = s.split(
                    "\\s|\\(|\\)|\\.|\\[|\\]|,|\\+|;|\\\\|\"|!|\\||/|=|\\*|@|<|>"); // в константы вынести

//                ArrayList<String> uniqueWords = new ArrayList<>(); // set
//                for (int j = 0; j < words.length; j++) { //n
//                    String testedWord = words[j];
//                    int count = 0;
//                    for (int j1 = 0; j1 < words.length; j1++) { // n
//                        if (testedWord.equals(words[j1])) {
//                            count++;
//                        }
//                    }
//                    if (count == 1 && !uniqueWords.contains(testedWord)) {
//                        uniqueWords.add(testedWord);
//                    }
//                }

                Set<String> set = new HashSet<>(Arrays.asList(words)); //
                Map<String, Long> map = new TreeMap<>();

                for (String s2 : set) { // n
                    long countWord = Arrays.stream(words).filter(x -> x.equals(s2)).count(); // n
                    map.put(s2, countWord);
                }

                // for(Map.Entry<String, Long> m: )
                List<String> collect = map.entrySet().stream().sorted(Comparator.comparing(Entry::getValue))
                    .map(Entry::getKey).collect(Collectors.toList());

//                Collections.sort(uniqueWords);
//                for (int j = 0; j < uniqueWords.size(); j++) {
//                    System.out.println(uniqueWords.get(j));
//                }
                System.out.println(collect);


            } catch (IOException ex) {
                //невозможно
                ex.printStackTrace();
            }
        }
    }
}


/**
 * Дана таблица
 *
 * create table employee (
 *     surname text,
 *     department text,
 *     salary numeric
 * )
 *
 * Вывести список сотрудников  с максимальной зарплатой внутри подразделения для каждого подразделения
 * Если внутри отделения несколько сотрудников получают максимальную зарплату, вывести того, чья фамилия – первая по алфавиту
 *
 *
 * select * from ( employee oder by salary desc and order by surname asc limit 1) department
 * join
 *
 *
 * */

