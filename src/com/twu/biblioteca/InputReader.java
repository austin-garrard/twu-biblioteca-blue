package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class InputReader {
    private BufferedReader bufferedReader;

    public InputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int read() {
        int option = 0;
        try {
            option = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            return -1;
        }

        return option;
    }
}
