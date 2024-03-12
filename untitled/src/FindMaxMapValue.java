import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMaxMapValue {
    public static void main(String[] args) {

     Opeional<String> map =  List.of("abc","xyz","ppp","jjj","xyz").stream()
               .collect(Collectors.groupingBy(data -> data, Collectors.counting()))
               .entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .findFirst()
             .map(data -> data.getKey())
               .get();

     System.out.println(map);
                
    }
}
