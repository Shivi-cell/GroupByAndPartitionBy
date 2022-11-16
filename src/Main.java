import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<MusicalInstruments> getInstruments()
    {
        List<MusicalInstruments> al = new ArrayList<>();
        al.add(new MusicalInstruments("Trumpet","brass",299.99));
        al.add(new MusicalInstruments("Tuba","brass",1149.0));
        al.add(new MusicalInstruments("Timpani","percussion",2339.0));
        al.add(new MusicalInstruments("Snare drum","percussion",325.00));
        al.add(new MusicalInstruments("Piano","keyboard",5179.99));
        al.add(new MusicalInstruments("Trombone","brass",775.79));

        return al;
    }
    public static void main(String[] args) {
        List<MusicalInstruments> musicalInstruments = Main.getInstruments();

        System.out.println("Musical instruments in our collection : ");
        System.out.println(musicalInstruments);


        // grouping the instruments according to their types
        System.out.println("Musical instruments group by type : ");
        Map<String, List<MusicalInstruments>> instrumentsByType = musicalInstruments.stream()
                .collect(Collectors.groupingBy(MusicalInstruments::getType));
        System.out.println(instrumentsByType);


        // partition by the instruments
        System.out.println("Partition by Affordable (less than or equal to $500) or Expensive (greater than $500) :");
        Map<Boolean, List<MusicalInstruments>> partitionBy = musicalInstruments.stream()
                .collect(Collectors.partitioningBy(musicalInstruments1 -> musicalInstruments1.getPrice() > 500));

        partitionBy.forEach((key,value)->{
            System.out.println((key?"Expensive ":"Affordable"));
            value.forEach(System.out::println);
        });
    }
}