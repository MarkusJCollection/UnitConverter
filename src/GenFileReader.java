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
        //Bad formatting, but as a basic idea it is fine for now.
        try{
                //Initialize the URI variable.
            URI url = new URI("https://data-api.ecb.europa.eu/service/data/EXR/D..EUR.SP00.A?lastNObservations=1&detail=dataonly&format=csvdata");
            HttpURLConnection conn = (HttpURLConnection) url.toURL().openConnection(); //Intialize connection variable.
            conn.setRequestMethod("GET"); //Connect as a GET for information.
            conn.connect(); //Connect to the API.

            int responseCode = conn.getResponseCode(); //Response code received, ECB has all available.

            if (responseCode != 200){
                    //If it fails to connect then it gives an exception.
                throw new RuntimeException("HTTPResponseCode: "+responseCode);
            } else {
                    //If the connection was successful, then a scanner starts
                    // grabbing all information received.
                Scanner scanner = new Scanner(url.toURL().openStream());
                    //Scans a line to skip.
                scanner.nextLine();
                    //While loop that goes through every line.
                while (scanner.hasNextLine()){
                        //Sets the line equal to an array.
                    String[] fileLine = scanner.nextLine().split(",");
                        //Adds the currency identifier (2) and rate (7) into the
                        // conversion hashmap.
                    conversionsMapCUR.put(fileLine[2],Double.parseDouble(fileLine[7]));
                        //Sets the date.
                    this.dateCUR = fileLine[6];
                }
                    //Closes the scanner after finishing.
                scanner.close();
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