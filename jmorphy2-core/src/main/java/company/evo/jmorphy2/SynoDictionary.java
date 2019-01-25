package company.evo.jmorphy2;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SynoDictionary {

    static List<String> allSynos = new ArrayList<>();
    // need rewrite path to file
    static final String pathToDict = "/home/maiky/Documents/jmorphy2_plugin/jmorphy2-core/src/main/resources/lang/ru/Syno_Dictionary.txt";


    final String filename = "Syno_Dictionary.txt";
    private String line = null;

    public static List<String> openFile() {


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


        return allSynos;

    }

    private List<String> getAllVar(String startWord, String allVars) {
        List<String> result = new ArrayList<String>();

        for (String s : allVars.split(",")) {
            if (!s.equals(startWord)) {
                result.add(s);
            }
        }

        return result;

    }

    public List<String> getSyno2(List<String> startWord){

        for (String word : startWord){
            for (String syno : allSynos){
                if (syno.contains(word)) {
                    return getAllVar(word, syno);

                }
            }
        }
        return null;
    }

    public List<String> getSyno(String startWord) {

        for (String syno : allSynos) {

            if (syno.contains(startWord)) {

                return getAllVar(startWord, syno);

            }

        }

        return null;
    }


}
