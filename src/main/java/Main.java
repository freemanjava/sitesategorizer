import category.CategoryInitializer;
import fetch.TextFetcher;
import lombok.extern.slf4j.Slf4j;
import models.Category;
import utils.Classifier;
import utils.DataPrinter;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args){

        Classifier classifier = new Classifier();
        DataPrinter printer = new DataPrinter();

        Category starWars = CategoryInitializer.initializeModel("Star Wars",
                Arrays.asList("star war", "starwars", "starwar", "star wars", "starwars", "r2d2", "may the force be with you"));

        Category basketball = CategoryInitializer.initializeModel("Basketball",
                Arrays.asList("basketball", "nba", "ncaa", "lebron james", "john stokton", "anthony davis"));
        Category cinema = CategoryInitializer.initializeModel("Cinema", Arrays.asList("movie", "Theaters", "Theater",
                "cinema", "Drama", "cast", "Horror", "Family"));

        List<Category> categories = new ArrayList<>();
        categories.add(starWars);
        categories.add(basketball);
        categories.add(cinema);

        List<String> urls = new ArrayList<>();
        urls.add("https://www.msn.com/en-nz/travel/tripideas/70-of-the-planets-most-breathtaking-sights/ss-AAIUpDp");
        urls.add("https://www.radiosport.co.nz/sport-news/radio-sport-to-stop-broadcasting");
        urls.add("https://www.glamour.de/frisuren/frisurenberatung/haarschnitte");
        urls.add("https://www.tvblog.it/post/1681999/valerio-fabrizio-salvatori-gli-inseparabili-chi-sono-pechino-express-2020");
        urls.add("https://www.bbc.com");
        urls.add("https://www3.forbes.com/business/2020-upcoming-hottest-new-vehicles/13/?nowelcome");
        urls.add("https://www.starwars.com");
        urls.add("https://www.imdb.com/movies-in-theaters/");
        urls.add("https://www.imdb.com/movies-coming-soon/?ref_=inth_cs");
        urls.add("http://edition.cnn.com");
        urls.add("https://www.moonactive.com/moonactive-position/?uid=B9.318");
        urls.add("https://proglib.io/p/algorithmic-tasks");
        urls.add("https://www.geeksforgeeks.org/largest-number-with-the-given-set-of-n-digits-that-is-divisible-by-2-3-and-5/");

        Map<String, List<String>> categorized = classifier.categorize(urls, categories);
        printer.printCategorized(categorized);
    }
}
