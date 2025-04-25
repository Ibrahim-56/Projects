package sdr;

public class loop {
    public int countLetters(String text) {
        int count = 0;

        // Counts each character except space
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}
