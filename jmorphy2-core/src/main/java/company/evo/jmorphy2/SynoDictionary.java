package company.evo.jmorphy2;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SynoDictionary {

    private static HashMap<String, List> wordsTable1 = new HashMap<>();
    public static String pathToDict;


    public static void openFile() {


        File file = new File(pathToDict);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            List<String> textArr;
            String keyTable;

            while ((text = reader.readLine()) != null) {

                textArr = Arrays.asList(text.split(","));

                if (textArr.size() > 2) {
                    for (int i = 0; i < textArr.size(); i++) {
                        keyTable = textArr.get(i);

                        wordsTable1.put(keyTable, textArr);
                    }
                }
                if (textArr.size() == 2) {

                    wordsTable1.put(textArr.get(0), textArr);
                    wordsTable1.put(textArr.get(1), textArr);

                }

            }


        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public List<String> getSyno2(String startWord) {

        return wordsTable1.get(startWord);

    }

}
