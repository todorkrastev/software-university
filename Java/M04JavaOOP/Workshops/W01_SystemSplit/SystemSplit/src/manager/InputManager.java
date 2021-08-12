package manager;

import interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager implements InputReader {
    private final BufferedReader read;

    public InputManager() {
        this.read = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String result = null;
        try {
            result = this.read.readLine().trim();
        } catch (IOException ignored) {

        }
        return result;
    }
}
