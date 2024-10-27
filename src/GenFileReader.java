import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
        try{
            URI url = new URI("https://data-api.ecb.europa.eu/service/data/EXR/D..EUR.SP00.A?lastNObservations=1&detail=dataonly&format=csvdata");
            HttpURLConnection conn = (HttpURLConnection) url.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200){
                throw new RuntimeException("HTTPResponseCode: "+responseCode);
            } else {
                Scanner scanner = new Scanner(url.toURL().openStream());
                scanner.nextLine();
                while (scanner.hasNextLine()){
                    String[] fileLine = scanner.nextLine().split(",");
                    conversionsMapCUR.put(fileLine[2],Double.parseDouble(fileLine[7]));
                    this.dateCUR = fileLine[6];
                }
                scanner.close();
                System.out.print(conversionsMapCUR);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
     * automatically runs both required file
     * loaders.
     */
    public GenFileReader(){
        fileLoaderCUR();
        fileLoaderDIS();
    }


    /**
     * Constructor function that will let you choose between using the
     * file loader for the currencies or distances.
     * @param choice True is for currency, false is for distance.
     */
    public GenFileReader(boolean choice){
        if(choice){
            fileLoaderCUR();
        }else{
            fileLoaderDIS();
        }
    }
}