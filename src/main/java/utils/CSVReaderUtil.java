package utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static Object[][] getData(String filePath) throws Exception {
    	CSVReader reader = new CSVReader(new FileReader(filePath));

        List<String[]> data = reader.readAll();
        reader.close();

        Object[][] obj = new Object[data.size()-1][data.get(0).length];

        for(int i=1;i<data.size();i++){
            obj[i-1] = data.get(i);
        }
        reader.close();;
        return obj;
    }
    public static List<String> getProducts(String path) throws Exception {

        CSVReader reader = new CSVReader(new FileReader(path));

        List<String[]> data = reader.readAll();
        List<String> products = new ArrayList<>();

        for(int i = 1; i < data.size(); i++) {
            products.add(data.get(i)[0]);
        }

        reader.close();

        return products;
    }
}