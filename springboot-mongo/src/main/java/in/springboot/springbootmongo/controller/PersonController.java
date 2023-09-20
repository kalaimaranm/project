package in.springboot.springbootmongo.controller;

import in.springboot.springbootmongo.collection.Person;
import in.springboot.springbootmongo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PersonController {

    @Autowired
    private PersonService personServiceImpl;

    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) {

        return ResponseEntity.ok(personServiceImpl.save(person));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> findPerson(@PathVariable Integer id) {
        System.out.println("inside controller....");

        return ResponseEntity.ok(personServiceImpl.findPerson(id));

    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> findAllPerson() {

        return ResponseEntity.ok(personServiceImpl.findAllPerson());
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        return ResponseEntity.ok(personServiceImpl.delete(id));

    }

    @GetMapping("/persons/{minAge}/{maxAge}")
    public ResponseEntity<List<Person>> findPersonAgeBetween(@PathVariable Integer minAge,
            @PathVariable Integer maxAge) {
        return ResponseEntity.ok(personServiceImpl.findPersonByAgeBetween(minAge, maxAge));
    }

    @GetMapping("/search")
    public Page<Person> searchPage(@RequestParam(required = false) String name,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(page, size);

        return personServiceImpl.search(name, minAge, maxAge, city, pageable);

    }

}
