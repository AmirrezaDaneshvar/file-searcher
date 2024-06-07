

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class File extends Thread{
    private static final Set<String>  allWords=new HashSet<>();
    private final String filePath;
    private static int numberOfWords;
    private static String longestWordAtAll="";
    private static String shortestWordAtAll="Amirreza_Daneshvar";//A word that we can be sure is longer than the shortest word
    private static long lnethOfWords=0;
    public File(String filePath){
        this.filePath=filePath;
    }
    private static synchronized void setDetail(String word){
        allWords.add(word);
        numberOfWords++;
        lnethOfWords+=word.length();
        if((word.length())>longestWordAtAll.length()){
            longestWordAtAll=word;
        }
        if((word.length())<(shortestWordAtAll.length())){
            shortestWordAtAll=word;
        }
    }
    public static void print(){
        System.out.println("Total number of words without repetition:"+allWords.size());
        System.out.println("Total number of words with repetition:"+numberOfWords);
        System.out.println("The longest word:"+longestWordAtAll);
        System.out.println("The length of the longest word:"+longestWordAtAll.length());
        System.out.println("The shortest word:"+shortestWordAtAll);
        System.out.println("The length of the shortest word:"+shortestWordAtAll.length());
        System.out.println("Average word length:"+((lnethOfWords*1.0)/numberOfWords));
    }
    public void run(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                setDetail(word);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}