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
    public final HashMap<String,Double> conversionsMapCUR = new HashMap<>();
    public String dateCUR;


    //Variables use for reading files related
    // to the distance converter.
    private Path TXTFileDIS = Paths.get("data/distanceConversionRates.txt");
    public HashMap<String,Double> conversionsMapDIS = new HashMap<>();



    /**
     * File loader for the currency converter.
     */
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
            this.conversionsMapCUR.put(keys[i].stripLeading(),Double.parseDouble(vals[i]));
        }
        this.dateCUR = vals[0];
    }


    /**
     * File loader for the distance conversions.
     */
    public void fileLoaderDIS(){
        String[] filler = {null,null};
        List<String> file = null;
        try{
            file = Files.readAllLines(this.TXTFileDIS);
            for(int i = 0; i<file.size();i++) {
                if (!file.get(i).contains("!EOF")) {
                    filler = file.get(i).split(",");
                    this.conversionsMapDIS.put(filler[0], Double.parseDouble(filler[1]));
                }else{
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Could not find file.");
        }
    }


    /**
     * Constructor function for the class;
     * automatically runs the required file
     * loaders.
     */
    public GenFileReader(){
        fileLoaderCUR();
        fileLoaderDIS();
    }
}