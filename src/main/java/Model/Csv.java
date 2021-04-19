package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.FileWriter;
import java.io.IOException;

public class Csv{

    public final String FILE_NAME = "CsvParserAliExpress.csv";

    public void csv(){
        CsvSchema.Builder builder = CsvSchema.builder();
        ParserTask.jsonResult.get(0).fieldNames().forEachRemaining(builder::addColumn);
        CsvSchema schema = builder.build().withColumnSeparator(';').withHeader();

        CsvMapper mapper = new CsvMapper();
        try( FileWriter fileWriter = new FileWriter(FILE_NAME, false)){
            mapper.writerFor(JsonNode.class)
                    .with(schema)
                    .writeValuesAsArray(fileWriter)
                    .writeAll(ParserTask.jsonResult)
                    .flush();
        }
        catch (IOException e) {
            System.out.printf("Unable write data to file. Reason: %s%n", e.getMessage());
        }
    }
}
