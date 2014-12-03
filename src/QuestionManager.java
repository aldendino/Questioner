
import java.util.*;

/**
 * Manages an array of questions.
 */
public class QuestionManager {
    
    private ArrayList<Question> questions; // The array of questions.
    private int index; // The index of the current questions.

    private Random generator; // The random index generator.

    /**
     * Create a manager based on an array of questions.
     * @param questions
     */
    public QuestionManager(ArrayList<Question> questions) {
        if(questions != null) {
            this.questions = questions;
        }
        else {
            this.questions = new ArrayList<Question>();
        }
        index = 0;
        generator = new Random();
    }

    /**
     * Is the question array empty?
     * @return whether or not the question array is empty.
     */
    public boolean isEmpty() {
        if(questions != null) {
            return questions.size() == 0;
        }
        else {
            return true;
        }
    }

    /**
     * Get the index of the current question.
     * @return the index of the current question.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the current question.
     * @return the current question.
     */
    public Question getCurrentQuestion() {
        return questions.get(index);
    }

    /**
     * Move the index of the current question to the next position.
     */
    public void nextIndex() {
        index = (index + 1) % questions.size();
    }

    /**
     * Move the index of the current question to the previous position.
     */
    public void previousIndex() {
        if((index - 1) < 0) index = questions.size() - 1;
        else index = index - 1;
    }

    /**
     * Move the index of the current question to a random position.
     */
    public void generateIndex() {
        if(questions.size() > 1) {
            int last = index;
            int next = generator.nextInt(questions.size());
            while(next == last) { // Do not repeat a question.
                next = generator.nextInt(questions.size());
            }
            index = next;
        }
        else {
            index = generator.nextInt(questions.size());
        }
    }

}
