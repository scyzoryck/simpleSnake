package sc.snake.controller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Store the
 */
public class ScoreRepository {
    private LinkedList<Score> scores;

    /**
     * Inits reposotory
     */
    ScoreRepository() {
        scores = new LinkedList<>();
        try {
            ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(getSavePath())));
            scores = (LinkedList<Score>) os.readObject();
            os.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            scores = new LinkedList<>();
        }
    }

    /**
     * Returns filepath where the scores are saved
     * It scores up to 10 best scores
     * @return String
     */
    private String getSavePath() {
        return "BestResults.sep";
    }

    /**
     * Adds new score into repository
     * @param score Score
     */
    public void add(Score score) {
        scores.add(score);
        scores.sort((o1, o2) -> o1.getScore() > o2.getScore() ? -1 : o1.getScore() == o1.getScore() ? 0 : 1);
        if (scores.size() > 10) {
            scores.removeLast();
        }
        save();
    }

    /**
     * Saves scores into file
     */
    private void save(){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(getSavePath())));
            os.writeObject(scores);
            os.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Returns top ten scores
     * @return List<Score>
     */
    public List<Score> getTop() {
        return scores;
    }
}
