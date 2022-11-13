package pl.camp.it.Shop2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptionsProvider {
    public char readChar(String message) throws IOException {
        System.out.print(message);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        char readChared = (char) bufferedReader.read();
        return readChared;
    }

    public String readString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readedString = bufferedReader.readLine();

        return readedString;
    }
    public int readInt() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return Integer.parseInt(bufferedReader.readLine());

    }

}
