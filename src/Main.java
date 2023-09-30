import java.io.*;
import java.util.*;

/*
Пока Маша была в отпуске, её коллеги организовали турнир по шахматам по олимпийской системе.
За отдыхом Маша не обращала особого внимания на информацию на эту затею, так что она еле может вспомнить,
кто с кем играл, и то не факт (про порядок игра даже речи не идёт). Внезапно Маше пришла в голову мысль,
что неплохо бы привезти из отпуска сувенир победителю турнира.
Она не знает, кто победил в финальной игре, но сможет без труда вычислить, кто в нём играл,
если только Маша правильно запомнила играющие пары.
Помогите ей проверить, так ли это, и вывести возможных кандидатов в победители.
Входные данные
В первой строке находится целое число n — количество прошедших игр. В последующих n
 строках — две фамилии игроков (латинские заглавные символы) через пробел.
 Фамилии игроков различны. Все фамилии уникальны, однофамильцев среди коллег нет.
Выходные данные
Выведите "NO SOLUTION", если Маша неправильно запомнила игры, и по этой сетке нельзя получить турнир
по олимпийской системе (без кавычек).
Если турнирная сетка возможна, выведите две фамилии в одной строке — фамилии
кандидатов на первое место (порядок не важен).
7
GORBOVSKII ABALKIN
SIKORSKI KAMMERER
SIKORSKI GORBOVSKII
BYKOV IURKOVSKII
PRIVALOV BYKOV
GORBOVSKII IURKOVSKII
IURKOVSKII KIVRIN
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt")); {
            int numberOfPairs = Integer.parseInt(reader.readLine()); // Число пар фамилий
            List<String> surnamesList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                surnamesList.add(line);
            }
            List<String> surnames=new ArrayList<>();
            Map<String, Integer> frequencies=new HashMap<>();
            splitNames(surnamesList,surnames);
            countFrequencies(surnames,frequencies);
            prediction(numberOfPairs,frequencies);
    }
    }
    public static List<String> splitNames(List<String> surnamesList, List<String> surnames){
        for (String str: surnamesList) {
            String[] names=str.split(" ");
            for (String s:names) {
                surnames.add(s);
            }
        }
        return surnames;
    }
    public static Map<String, Integer> countFrequencies(List<String> surnamesList,  Map<String, Integer> frequencies){
        for (String s: surnamesList) {
            int count=frequencies.getOrDefault(s,0);
            frequencies.put(s,count+1);
        }
        //печать для проверки
//        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
//            String surname = entry.getKey();
//            int frequency = entry.getValue();
//            System.out.println(surname + ": " + frequency);
//        }
        return frequencies;
    }
    public static void prediction(int numberOfPairs, Map<String, Integer> frequencies){
        int num= (int) Math.floor(numberOfPairs/2);
        int count=0;
        for (Map.Entry<String,Integer> entry:frequencies.entrySet()) {
            if (entry.getValue() == num) {
                count++;
                if (count <= 2) {
                    System.out.println(entry.getKey());
                } else {
                    System.out.println("NO SOLUTION");
                }

            }
        }
    }
}
