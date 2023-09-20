
package in.springboot.springbootmongo.service;

import in.springboot.springbootmongo.collection.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface PersonService {

       public Person save(Person person); 
       
       public String delete(Integer id);
       
       public Person findPerson(Integer id);
       
       public List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);
       
       public List<Person> findAllPerson();
       
       public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);
    
}
