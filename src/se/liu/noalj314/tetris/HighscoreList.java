package se.liu.noalj314.tetris;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class HighscoreList
{
    private List<Highscore> highscores;
    private static final String FILE_PATH = "scores.json";
    public HighscoreList() {
	this.highscores = readFromFile();
    }
    public void addHighscore(Highscore highscore){
	highscores.add(highscore);
	saveToFile();
    }

    public List<Highscore> getHighscoreList() {
	highscores.sort(new ScoreComparator());
	return highscores;
    }
    public void saveToFile(){
	Gson gson = new Gson();
	String json = gson.toJson(this.highscores);
	File tempFile = new File(FILE_PATH + ".tmp");

	try (FileWriter writer = new FileWriter(tempFile)) {
	    writer.write(json);
	    writer.close();

	    File originalFile = new File(FILE_PATH);
	    if (originalFile.delete()){
		if (!tempFile.renameTo(originalFile)){ //om döp om misslyckas skapa fel
		    System.err.println("Kunde inte döpa om den temporära filen till den ursprungliga filnamnet.");
		}
	    } else {
		// Om borttagning av den gamla filen misslyckas, signalera fel
		System.err.println("Kunde inte ta bort den gamla filen.");
	    }
	} catch (IOException e){
	    e.printStackTrace();
	}
    }
    public List<Highscore> readFromFile(){
	Gson gson = new Gson();
	try (FileReader reader = new FileReader(FILE_PATH)){
	    Type highscoreListType = new TypeToken<List<Highscore>>(){}.getType();
	    return gson.fromJson(reader, highscoreListType);
	} catch (IOException e){
	    e.printStackTrace();
	    return new ArrayList<>();
	}

    }
}
