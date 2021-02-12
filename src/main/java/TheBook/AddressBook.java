package TheBook;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Mathew Smith
 * 101029870
 * SYSC 4806 L2
 *
 */
@Entity
public class AddressBook implements Serializable {

    @Id
    @GeneratedValue
    private long id;
//    @JsonIgnore
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyInfos;
    private String name;

    public AddressBook(){}

    public AddressBook(String name1) {
        name = name1;
        buddyInfos= new ArrayList<BuddyInfo>();
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }

    //@OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<BuddyInfo> getBuddyInfos(){
        return buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    public void addBuddy(BuddyInfo name) {
        buddyInfos.add(name);
        name.setAddressBook(this);
    }

    public void removeBuddy(Long id) {
        Iterator<BuddyInfo> iter = buddyInfos.iterator();
        while(iter.hasNext()){
            BuddyInfo temp = iter.next();
            if(temp.getId() == id){
                iter.remove();
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Address book contains : %d", buddyInfos.size()));
        for(BuddyInfo b : getBuddyInfos()){
            sb.append(b.toString());
        }
        return sb.toString();
    }

}
