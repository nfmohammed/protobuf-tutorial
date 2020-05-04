package example01;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;
import com.example.tutorial.AddressBookProtos.Person.PhoneNumber;

/**
 * In this tutorial, we will learn to use protobuf classes
 */
public class AddressBookRunner {

    public static void main(String[] args) {
        Person.Builder personBuilder = Person.newBuilder();

        final Person andy = personBuilder
                .setId(1)
                .setName("Andy")
                .setEmail("andy@gmail.com")
                .addPhones(PhoneNumber.newBuilder().setNumber("123-456-7890").setType(Person.PhoneType.MOBILE))
                .addPhones(PhoneNumber.newBuilder().setNumber("222-333-4444").setType(Person.PhoneType.WORK))
                .build();
        final Person blake = personBuilder
                .setId(2)
                .setName("Blake")
                .setEmail("blake@gmail.com")
                .addPhones(Person.PhoneNumber.newBuilder().setNumber("111-222-3333").setType(Person.PhoneType.MOBILE))
                .build();
        AddressBook.Builder addressBuilder = AddressBook.newBuilder();
        AddressBook friends = addressBuilder.addPeople(andy).addPeople(blake).build();
        System.out.println(friends.toString());
    }
}
