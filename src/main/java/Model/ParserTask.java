package Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ParserTask {

    public final String URL = "https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&platform=pc&limit=10&phase=1";
    public static final ArrayNode jsonResult = new ArrayNode(null);


    public void ParserTsk(){
        String postback = "";
        int offset = 0;
        int limit = 10;

        while (offset <= 10) {
            String response = Service.save.saveIs( URL + "&offset=" + offset * limit + postback);
            try {
                JsonNode jsonResponse = new ObjectMapper().readTree(response);
                if (postback.isEmpty()) {
                    postback = "&postback="+jsonResponse.get("postback").asText();
                }
                ArrayNode jsonNode = jsonResponse.withArray("results");
                jsonResult.addAll(jsonNode);
                offset++;
                System.out.println("How much offset= " + offset);
            } catch (JsonProcessingException e) {
                System.out.println("Invalid json object");
            }
        }
    }
}
