package example02;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Random;

class AddPerson {

    // Main function:  Reads the entire address book from a file,
    //   adds one person, then writes it back out to the same file.
    public static void main(String[] args) throws Exception {

        String addressBookPath = System.getProperty("user.dir") + "/src/main/java/example02/address-book.txt";

        AddressBook.Builder addressBook = AddressBook.newBuilder();

        // Read the existing address book.
        try {
            addressBook.mergeFrom(new FileInputStream(addressBookPath));
        } catch (FileNotFoundException e) {
            System.out.println(": File not found.  Creating a new file.");
        }

        // Add an address.
        addressBook.addPeople(
                AddRandomPerson());
        System.out.println(System.getProperty("user.dir"));

        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(addressBookPath);
        addressBook.build().writeTo(output);
        output.close();

        System.out.println(addressBook.toString());
    }

    // This function fills in a Person message based on user input.
    static Person AddRandomPerson() throws IOException {
        Person.Builder person = Person.newBuilder();
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        person.setId(randomInt);
        person.setName("Mike"+randomInt);
        person.setEmail("mike"+randomInt+"@gmail.com");
        return person.build();
    }


}
