package utils;

import java.util.List;
import java.util.Map;

public class DataPrinter {

    public void printCategorized(Map<String, List<String>> data) {
        System.out.println("===========START============");
        for (String url : data.keySet()) {
            System.out.print(url + ":" + " [");
//            System.out.print("      [");
            List<String> categoriesList = data.get(url);
            int size = categoriesList.size();
            for (String categoryName : categoriesList) {
                if (size < 2) {
                    System.out.print("\"" + categoryName + "\"");
                } else {
                    System.out.print("\"" + categoryName + "\",");
                }

            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println("===========FINISH============");
    }

    public void print(Map<String, String> data) {
        System.out.println("===========START============");
        for (String url : data.keySet()) {
            System.out.println(url + ":");
            System.out.println(data.get(url));
        }
        System.out.println("===========FINISH============");
    }
}
