package Tasks;
/*
 * Create a program that extracts product information, such as names, prices, and ratings, 
 * from an online e-commerce website and stores the data in a structured format like a CSV file.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
import java.util.ArrayList;
import java.util.List;

public class Prob4 
{
    public static void main(String args[]) 
    {
        String url = "https://www.meesho.com/search?q=men%27s%20kurta&searchType=manual&searchIdentifier=text_search";
        try 
        {
            Document doc = Jsoup.connect(url).get();
            Elements productNames = doc.select("div._3w8y9");
            Elements productPrices = doc.select("span._1bXc2Z");
            Elements productRatings = doc.select("span._1m7J83");
            List<String[]> productData = new ArrayList<>();
            productData.add(new String[]{"Product Name","Price","Rating"});
            for(int i=0;i<productNames.size();i++) 
            {
                String name = productNames.get(i).text();
                String price = i<productPrices.size()?productPrices.get(i).text():"N/A";
                String rating = i<productRatings.size()?productRatings.get(i).text():"N/A";
                productData.add(new String[]{name,price,rating});
            }
            try(CSVWriter writer = new CSVWriter(new FileWriter("Products.csv"))) 
            {
                writer.writeAll(productData);
                System.out.println("Data successfully written to Products.csv!");
            }
        } 
        catch(IOException e) 
        {
            System.err.println("Error fetching data from the URL.");
            e.printStackTrace();
        }
    }
}
