import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class ECBReader {
    private Path CSVFile = Paths.get("data/eurofxref.csv");
    public HashMap<String,Double> conversionsMap = new HashMap<>();
    public String date;

    private void fileLoader (){
        List<String> file = null;
        try{
            file = Files.readAllLines(this.CSVFile);
        }catch(IOException ex){
            System.out.println("Could not read file.");
        }

        String[] keys = file.get(0).split(",");
        String[] vals = file.get(1).split(",");

        for(int i=1;i<keys.length-1;i++){
            this.conversionsMap.put(keys[i].substring(1),Double.parseDouble(vals[i]));
        }
        this.date = vals[0];
    }


    public ECBReader(){
        fileLoader();
    }
}