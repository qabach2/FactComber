package App.Controller;

import App.Model.Fact;
import App.Service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/Fact")
public class FactController {
    private final FactService factService;
    @Autowired
    public  FactController(FactService factService){
        this.factService = factService;
    }
    @PostMapping
    public Fact  PostNewFact(@RequestBody Fact fact){
        return factService.postNewFact(fact);
    }
    @GetMapping("/{id}")
    public Optional<Fact> getFactById(@PathVariable("id")int id ){
     return factService.getFactById(id);
    }
    @GetMapping
    public List<Fact> getAllFacts(){
        return factService.getAllFacts();

    }
    @PutMapping("likes/{id}")
    public Fact updateFactLikesById(@PathVariable("id") int id ,@RequestBody Fact fact){
        Fact updatedFact = factService.updateFactLikesById(id ,fact);
        return updatedFact;
    }

}
