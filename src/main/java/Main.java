import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main( String[] args ) {


        //create list of animal names
        //
        List<String> animalList = Arrays.asList("cat", "dog", "rabbit", "elephant", "giraph", "cow", "sheep");
        Stream<String> animalStream = animalList.stream();
        Optional<String> maxCharacter = animalList.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted(Comparator.naturalOrder())
                //.forEach(sout);
                .max(( s1, s2 ) -> s1.length() - s2.length());
        if (maxCharacter.isPresent()) {
            System.out.println(maxCharacter.get());
        }
        //   FakeValuesService booksFakeValues = new FakeValuesService(new Locale("en-GB"), new RandomService());
        Faker faker = new Faker();
        String author = faker.book().author();
        System.out.println(author);

        Book book1 = new Book("Dune", "Frank Herbert", Genre.SCIFI, true, 55);
        Book book2 = new Book("Foundation", "Isaac Asimov", Genre.SCIFI, false, 42);
        Book book3 = new Book("SPQR", "Mary Beard", Genre.HISTORY, false, 22);
        Book book4 = new Book("Code Complete 2", "Steve McConnell", Genre.PROGRAMMING, true, 60);
        Book book5 = new Book("Java: The Complete Reference", "Herbert Schmidt", Genre.PROGRAMMING, true, 95);
        Book book6 = new Book("East of Eden", "John Steinbeck", Genre.FICTION, true, 12);
        Book book7 = new Book("Silmarillion", "J.R.R. Tolkien", Genre.FICTION, false, 39);
        Book book8 = new Book("The Stranger", "Albert Camus", Genre.FICTION, false, 78);
        Book book9 = new Book("Java in a Nutshell 7th Ed", "Ben Evans", Genre.PROGRAMMING, false, 45);
        Book book10 = new Book("Taiko", "Eiji Yoshikawa", Genre.SCIFI, false, 72);
        List<Book> bookList = Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
        //    Integer minRentalTimes = bookList.stream()
//                                        .max(( b1, b2) ->b1.getLoanedNumber() - b2.getLoanedNumber());
        Stream<Book> bookStream = bookList.stream();
        DescriptiveStatistics streamStatistics = new DescriptiveStatistics();
        List <Double> bookStatistics =bookStream
                .map(Book::getLoanedNumber)
                .collect(Collectors.toList());
        System.out.println(bookStatistics);
        for (int i = 0; i <bookStatistics.size(); i++) {
            streamStatistics.addValue(bookStatistics.get(i));
        }
        System.out.println("Max value is: " +streamStatistics.getMax()+"; Min value is: "+streamStatistics.getMin()+"; Average is: "+streamStatistics.getMean()+"; Sum of loaned books: "+streamStatistics.getSum());


    }
}
