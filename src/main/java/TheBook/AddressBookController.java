package TheBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String addBuddy(@RequestBody BuddyInfo buddyInfo, @PathVariable long id, Model model) {
        AddressBook book = addressBookRepository.findById(id);
        book.addBuddy(buddyInfo);
        addressBookRepository.save(book);
        model.addAttribute("books", addressBookRepository.findById(id));
        return "addressbook";
    }

    @PostMapping(path = "/addressBooks/{addressid}/{buddyid}")
    public String deleteBuddy(@PathVariable long addressid, @PathVariable long buddyid, Model model) {
        AddressBook book = addressBookRepository.findById(addressid);
        book.removeBuddy(buddyid);
        addressBookRepository.save(book);
        buddyRepository.deleteById(buddyid);
        model.addAttribute("books", addressBookRepository.findById(addressid));
        return "addressbook";
    }

    @GetMapping("/addressbook")
    public String greeting(Model model) {
        model.addAttribute("books", addressBookRepository.findAll());
        return "addressbook";
    }

    @GetMapping(value = "/addressbook/{id}")
    public String displaybuddiesforaddressbook(@PathVariable long id, Model model) {
        model.addAttribute("books", addressBookRepository.findById(id));
        return "addressbook";
    }
}
