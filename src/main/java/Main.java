import header.SKHeader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pojo.Sparkasse;

import java.nio.file.Files;
import java.nio.file.Paths;

//TODO: Refactor
//TODO: application.yml
//TODO: main args (filepath)
//TODO: json with fasterxml
//TODO: write tests
public class Main {

    public static void main(String[] args) throws Exception {
        String fileContent = new String(Files.readAllBytes(Paths.get("test.csv"))).trim();
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(SKHeader.class).withDelimiter(';').withQuote('"');
        CSVParser parser = CSVParser.parse(fileContent, csvFileFormat);
        Iterable<CSVRecord> records = parser.getRecords();
        int i = 0;
        for (CSVRecord record : records) {
            if (i != 0) {
                String betrag = record.get(SKHeader.Betrag).replaceAll(",", ".");
                String zweck = record.get(SKHeader.Verwendungszweck);
                zweck = formatLastChar(zweck);
                String datum = record.get(SKHeader.Valutadatum);
                double dBetrag = Double.parseDouble(betrag);
                Sparkasse pojo = null;
                if (isDoubleAnInt(dBetrag)) {
                    int iBetrag = (int) dBetrag;
                    pojo = new Sparkasse(iBetrag, zweck, datum);
                } else {
                    pojo = new Sparkasse(dBetrag, zweck, datum);
                }
                if (pojo.getdBetrag() != null) {
                    System.out.println(pojo.getdBetrag() + " - " + pojo.getZweck() + " - " + pojo.getDatum());
                }
                if (pojo.getiBetrag() != null) {
                    System.out.println(pojo.getiBetrag() + " - " + pojo.getZweck() + " - " + pojo.getDatum());
                }
            }
            i++;
        }
    }

    private static String formatLastChar(String in) {
        if (in.charAt(in.length() - 1) == ' ') {
            return in.substring(0, in.length() - 1);
        }
        return in;
    }

    private static boolean isDoubleAnInt(double in) {
        return (in == Math.floor(in)) && !Double.isInfinite(in);

    }


}
