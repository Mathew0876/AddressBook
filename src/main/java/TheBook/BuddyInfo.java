package TheBook;

import TheBook.AddressBook;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Mathew Smith
 * 101029870
 * SYSC 4806 L2
 *
 */

@Entity
public class BuddyInfo implements Serializable{

    @Id
    @GeneratedValue
    private long buddyid;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToOne
    private AddressBook addressBook;


    public BuddyInfo(){
    }

    public BuddyInfo(String string) {
        // TODO Auto-generated constructor stub
        setName(string);
    }

    public BuddyInfo(String strname, String stradd, String strnum) {
        name = strname;
        address = stradd;
        phoneNumber = strnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return buddyid;
    }

    public void setId(long id) {
        this.buddyid = id;
    }

    public AddressBook getAddressBook(){
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString(){
        return String.format(
                "Buddy[id=%d, name='%s', number='%s']",
                buddyid, name, phoneNumber);
    }
}
