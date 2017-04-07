package Model;

import View.WebShow;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ZMYang on 2017/4/1.
 */
public class Getter implements IResultGetter {
    ArrayList<File> arrayList;
    private String fileName;

    public Getter(ArrayList<File> arrayList , String fileName) {
        this.arrayList = arrayList;
        this.fileName = fileName;
    }

    @Override
    public void getResult(String result) {
            File file = new File(fileName + ".html");
            try {
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
                out.write(result);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        WebShow.happen(arrayList);
    }
}
