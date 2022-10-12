package App.Service;

import App.DAO.FactsRepository;
import App.Model.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FactService {
    @Autowired
    FactsRepository factsRepository;

    public Fact postNewFact(Fact fact){
        return factsRepository.save(fact);

    }
    public void deleteFactById(int id){
        factsRepository.deleteById(id);

    }
    public Optional<Fact> getFactById(int id){
      return  factsRepository.findFactById(id);


    }
    public Fact updateFactLikesById(int id, Fact fact){
        Fact updatedFact = factsRepository.findFactById(id).get();
        updatedFact.setFact_likes(fact.getFact_likes());
        factsRepository.save(updatedFact);
        return updatedFact;

    }
    public List<Fact> getAllFacts(){
        return factsRepository.findAll();
    }

}
