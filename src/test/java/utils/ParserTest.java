package utils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class ParserTest {

    private static final String DATA_FOLDER = "data/";
    private static final String TEXT = "Mode Beauty Frisuren Stars Liebe Gewinnspiele Glamour Girlboss Reise Living Videos Horoskope Magazin Prämie Glamour Shopping App Glamour Podcast GLAMsetter Blog GLAM SLAM Blog Themen Spiele Beauty-School Die Redaktion Impressum Datenschutzerklärung AGB Werbung buchen RSS Cookies verwalten Glamour International Deutschland UK USA France Italy Netherlands Spain Russia Poland Bulgaria Romainia Brazil Hungary Mexico Latin America South Africa Mode Shopping-Week Mode-News Modetrends Mode-Accessoires Shopping Star-Style Mode Street-Style Labelfinder Beauty Body Positivity Beauty-School Beauty-News Make-up-Trends Nagellack Beauty-Tipps Star-Style Beauty Fitness-Special Food Frisuren Flechtfrisuren Trendfrisuren 2020 Starfrisuren How-to Haarfarben Frisuren für Locken Kurzhaarfrisuren Stars Star-News TV-Serien Musik Film Star-Quiz Oscar 2020 Liebe Männer verstehen Beziehung Sex-Tipps Kamasutra Singles & Dating Sex der Sternzeichen GLAMOUR Tarot Gewinnspiele Abo Mode Shopping-Week Mode-News Modetrends Mode-Accessoires Shopping Star-Style Mode Street-Style Labelfinder Beauty Body Positivity Beauty-School Beauty-News Make-up-Trends Nagellack Beauty-Tipps Star-Style Beauty Fitness-Special Food Frisuren Flechtfrisuren Trendfrisuren 2020 Starfrisuren How-to Haarfarben Frisuren für Locken Kurzhaarfrisuren Stars Star-News TV-Serien Musik Film Star-Quiz Oscar 2020 Liebe Männer verstehen Beziehung Sex-Tipps Kamasutra Singles & Dating Sex der Sternzeichen GLAMOUR Tarot Gewinnspiele Abo Alle Artikel Flechtfrisuren Trendfrisuren 2020 Starfrisuren How-to Haarfarben Frisuren für Locken Kurzhaarfrisuren Alle Artikel Flechtfrisuren Trendfrisuren 2020 Starfrisuren How-to Haarfarben Frisuren für Locken Kurzhaarfrisuren Home Frisuren Frisurenberatung Haarschnitte Die schönsten Haarschnitte 2020 von Anna Bader 23. März 2020, 12:38 Uhr © Instagram / anhcotran / krisforreal / _thefab3 ; Collage: Condé Nast Ob Kurzhaarschnitt, Frisuren für mittellanges oder langes Haar – hier finden Sie alle aktuell angesagten Frauen-Haarschnitte im Überblick. Plus: Testen Sie, welcher Haarschnitt zu Ihnen passt! Ein Haarschnitt unterstreicht unsere Persönlichkeit. Kein Wunder also, dass wir Frauen uns manchmal mit einer Veränderung ganz schön schwertun. Da macht es die Auswahl an unzähligen Haarschnitten, die gerade in Mode sind, auch nicht gerade leichter. Zum Glück gibt es Tests, die uns bei der Auswahl von Trends wie dem Pixie Cut oder Long Bob helfen und zeigen, welcher Haarschnitt am besten zu unserer Gesichtsform und auch Haarstruktur passt. Frisuren-Test: Diese Trend-Frisur passt 2020 zu Ihnen Sie sind sich noch unsicher, für welchen der zahlreichen Frisuren-Trends Sie sich entscheiden möchten? Dann machen Sie zunächst unseren Frisuren-Test: Bob, Pony oder Stufenschnitt? Welche Frisur steht mir wirklich? Unser Test verrät es Finden Sie heraus, welche Frisur zu Ihrer Gesichtsform passt Mehr lesen Perfekt! Jetzt wissen Sie zumindest schon einmal, welcher Cut Ihnen stehen würde. Im Überblick sehen Sie nun die passenden Frisuren für jede Haarlänge. Frisuren für kurze Haare Kurze Haare? Stehen für volle Power! 2020 sind vor allem zarte Frisuren wie der Pixie, aber auch der klassische Bob angesagt. Zudem erleben Pilzkopf & Co. aus den 90er-Jahren ein Revival. Kurzhaarfrisuren im Überblick: Nicht nur für Mutige! Diese Kurzhaarfrisuren tragen wir 2020 Nichts kann eine Typveränderung deutlicher zum Ausdruck bringen als Kurzhaarfrisuren Mehr lesen Frisuren für mittellanges Haar Wer 2020 frisurentechnisch up-to-date sein möchte, entscheidet sich am besten für einen mittellangen Haarschnitt. Die sehen nicht nur modern aus, sie sind auch was das Styling hinterher angeht, sehr flexibel. Angesagt sind dabei vor allem der Long Bob, aber auch Stufenschnitte oder 80ies-Cuts mit Pony. Die schönsten Frisuren für mittellange Haare im Überblick: Frisuren für mittellanges Haar Eine Länge, viele Möglichkeiten Mittellanges Haar bietet zahlreiche Styling-Varianten. Die schönsten Frisuren für Ihre Haarlänge Mehr lesen Frisuren für langes Haar Gerade lange Haare sind unglaublich wandelbar, was den Haarschnitt aber auch das Styling angeht. So kann man sie soft durchstufen lassen, auf einer Länge tragen oder mit Pony beziehungsweise Curtain Bangs den Look verändern. Die schönsten Frisuren für lange Haare im Überblick: Stufen, Pony & Co. Langhaarfrisuren: Die schönsten Haarschnitte für langes Haar Von wegen langes Haar ist nicht wandelbar: Auch hier kann man mit kleinen Schnittänderungen... Mehr lesen Frisuren mit Pony Nichts verändert eine Frisur so sehr wie ein Pony – dabei gibt es Kurzponys, schräge Ponys, lange gerade Ponys und Curtain Bangs. Diese kann man mit Haarschnitten fast jeder Länge kombinieren. Die schönsten Frisuren mit Pony im Überblick: So anders! Rihanna trägt plötzlich einen Pony Willkommen im Ponyclub! Das sind die schönsten Frisuren der Stars mit Pony Mehr lesen Trendfrisuren mit Curtain Bangs im Überblick: Vorhang auf! Curtain Bangs: Die neue Trendfrisur der Stars Darum liebt jetzt auch Schauspielerin Selena Gomez diesen fluffigen Pony Mehr lesen Frisuren für lockiges Haar Generell gilt: Locken fallen anders, als glattes oder nur sanft gewelltes Haar. Daher eignen sich manche Schnitte mehr, manche weniger für Krausen oder Locken. Die schönsten Haarschnitte für Locken im Überblick: Frisuren für Locken Sanfte Wellen und wilde Locken Inspirationen und Tricks für ganz besondere Looks Mehr lesen Trend-Alarm: Weitere Frisuren- und Beauty-Tipps finden Sie hier! Teilen x Direktlink: Mehr von GLAMOUR Top Stories 01 GLAMunity Forum Der Community Talk über Liebe und Partnerschaft 02 Trendfarben Frühjahr/Sommer 2020 Eins ist klar: Der Sommer wird bunt! 03 Dating-Verhalten Die nervigsten Dating-Trends im Überblick 04 Oralverkehr Der perfekte Blowjob 05 Dating: Er schreibt nie 10 Tricks, wenn er sich nie meldet Weitere Artikel Abo MAGAZIN abonnieren Themen 0...9 / A / B / C / D / E / F / G / H / I / J / K / L / M / N / O / P / Q / R / S / T / U / V / W / X / Y / Z Brands GQ Vogue AD";
    private static final String URL = "file:/mnt/Projects/Projects/siteСategorizer/target/test-classes/data/HTMLDocument";
    private static String webURL = null;
    private static Parser parser;

    private static String getFileUrl(String fileName) throws URISyntaxException {
        String URLString = null;
        ClassLoader classLoader = ParserTest.class.getClassLoader();
        URL resource = classLoader.getResource(DATA_FOLDER + fileName);
        assert resource != null;
        try {
            URLString = new File(resource.toURI()).toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return URLString;
    }

    @BeforeClass
    public static void setup(){
        try {
            webURL = getFileUrl("HTMLDocument");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        parser = new Parser(webURL);
    }

    @Test
    public void getTextFromUrlTest(){
        String url = webURL;
        String textFromUrl = null;
        try {
            textFromUrl = parser.getTextFromUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("The result isn't what was expected", TEXT, textFromUrl);
    }

    @Test
    public void callTest() throws IOException {
        Map<String, String> map = parser.call();
        String urlFromMap = null;
        String textFromMap = null;
        for (String url : map.keySet()){
            urlFromMap = url;
            textFromMap = map.get(url);
        }
        Assert.assertEquals("URL assertion", URL, urlFromMap);
        Assert.assertEquals("Text assertion", TEXT, textFromMap);
    }
}
