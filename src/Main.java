import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<File> files=new ArrayList<>();
        String path="D:\\WorkSpace\\Java\\ApWorkShop09\\assets\\file_";
        for(int i=0;i<20;i++){
            String path2=path+(i+1);
            path2=path2+".txt";
            File toAdd=new File(path2);
            files.add(toAdd);
        }
        for(int i=0;i<20;i++){
            files.get(i).start();
        }
        for(int i=0;i<20;i++){
            files.get(i).join();
        }
        File.print();
    }
}