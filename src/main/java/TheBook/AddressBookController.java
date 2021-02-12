package TheBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    private final BuddyInfoRepository buddyRepository;
    private final AddressBookRepository addressBookRepository;

    AddressBookController(BuddyInfoRepository buddyRepository, AddressBookRepository addressBookRepository) {
        this.buddyRepository = buddyRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @PostMapping(path = "/addressBooks/{id}/addBuddyInfo")
    public String addBuddy(@RequestBody BuddyInfo buddyInfo, @PathVariable long id) {
        AddressBook book = addressBookRepository.findById(id);
        book.addBuddy(buddyInfo);
        addressBookRepository.save(book);
        return "addressbook";
    }

//    @PostMapping(path = "/addressBooks/addAddressBook")
//    public String addAddressBook(@RequestBody AddressBook book) {
//        addressBookRepository.save(book);
//        return "addressbook";
//    }
//
//    @PostMapping(path = "/addressBooks/{addressid}/{buddyid}")
//    public AddressBook deleteBuddy(@PathVariable long addressid, long buddyid) {
//        AddressBook book = repository.findById(addressid);
//        book.removeBuddy(buddyid);
//        repository.save(book);
//        return book;
//    }

    @GetMapping("/addressbook")
    public String greeting(Model model) {
        model.addAttribute("books", addressBookRepository.findAll());
        return "addressbook";
    }

}
