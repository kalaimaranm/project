package pkg01.java.logical.interview.question;

import java.io.InputStreamReader;
import java.io.IOException;

public class InputStreamReaders {

    public static void main(String[] args) {

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            System.out.println("Enter the data in character: ");
            int data = inputStreamReader.read();
            System.out.println("data in byte sream : " + data);

            while (inputStreamReader.ready()) {

                System.out.println( data);
                data = inputStreamReader.read();
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

}
