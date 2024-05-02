import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class GenFileReader {
    //Variables used for reading files related
    // to the currency converter.
    private Path CSVFileCUR = Paths.get("data/eurofxref.csv");
    public HashMap<String,Double> conversionsMapCUR = new HashMap<>();
    public String dateCUR;


    //Variables use for reading files related
    // to the distance converter.
    private Path TXTFileDIS = Paths.get("data/eurofxref.csv");
    public HashMap<String,Double> conversionsMapDIS = new HashMap<>();



    private void fileLoaderCUR(){
        List<String> file = null;
        try{
            file = Files.readAllLines(this.CSVFileCUR);
        }catch(IOException ex){
            System.out.println("Could not read file.");
        }

        String[] keys = file.get(0).split(",");
        String[] vals = file.get(1).split(",");

        for(int i=1;i<keys.length-1;i++){
            this.conversionsMapCUR.put(keys[i].substring(1),Double.parseDouble(vals[i]));
        }
        this.dateCUR = vals[0];
    }


    public GenFileReader(){
        fileLoaderCUR();
    }
}