import Model.Csv;
import Model.ParserTask;

public class Main {

    public static void main(String[] args) {
        ParserTask parserTask = new ParserTask();
        Csv csv = new Csv();
        parserTask.ParserTsk();
        csv.csv();
    }
}
