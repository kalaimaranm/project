package in.springboot.springbootmongo.service;

import in.springboot.springbootmongo.collection.Person;
import in.springboot.springbootmongo.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepositoryImpl;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Person save(Person person) {

        return personRepositoryImpl.save(person);
    }

    @Override
    public String delete(Integer id) {

        personRepositoryImpl.deleteById(id);

        return "successfully deleted";
    }

    @Override
    public Person findPerson(Integer id) {
        System.out.println("inside service method()");

        return personRepositoryImpl.findById(id).get();

    }

    @Override
    public List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge) {

        return personRepositoryImpl.findPersonByAgeBetween(minAge, maxAge);
    }

    @Override
    public List<Person> findAllPerson() {

        return personRepositoryImpl.findAll();
    }

    @Override
    public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable) {

//        import must be from library core
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList();

        if (name != null && !name.isEmpty()) {
            criteria.add(Criteria.where("firstName").regex(name, "i"));

        }
        if (minAge != null && maxAge != null) {

            criteria.add(Criteria.where("age").gte(minAge).lte(maxAge));
        }
        if (city != null && !city.isEmpty()) {

            criteria.add(Criteria.where("addresses.city").is(city));
        }

        if (!criteria.isEmpty()) {

            query.addCriteria(new Criteria()
                    .andOperator(criteria.toArray(new Criteria[0])));
        }

        Page<Person> person = PageableExecutionUtils.getPage(mongoTemplate.find(query, Person.class),
                pageable, () -> mongoTemplate.count(query.skip(0).limit(0), Person.class));

        return person;
    }

}
