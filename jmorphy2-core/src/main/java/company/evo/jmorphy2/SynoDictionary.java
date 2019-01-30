package company.evo.jmorphy2;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SynoDictionary {

    static List<String> allSynos = new ArrayList<>();

    public static String pathToDict;


    public static void openFile() {


        File file = new File(pathToDict);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                allSynos.add(text);
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


            for (String syno : allSynos) {
                if (syno.contains(startWord)) {
                    return Arrays.asList(syno.split(","));

                }
            }
            return null;

    }


}
