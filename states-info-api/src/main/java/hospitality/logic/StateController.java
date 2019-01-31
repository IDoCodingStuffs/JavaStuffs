package hospitality.logic;

import hospitality.schema.State;
import hospitality.util.exception.InvalidSearchQueryException;
import hospitality.util.exception.SearchResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class StateController {
    private Consumer consumer = new Consumer();

    @GetMapping("/info/states/get/{state}")
    public @ResponseBody
    ResponseEntity<String>
    getById(@PathVariable String state) throws Exception {
        return new ResponseEntity<String>(consumer.consumeState(state).toString(), HttpStatus.OK);
    }

    @GetMapping("/info/states/get/")
    public @ResponseBody
    ResponseEntity<String>
    getAll() throws Exception {
        return new ResponseEntity<String>(consumer.consumeAll().toString(), HttpStatus.OK);
    }

    @PostMapping(path = "/info/states/get/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> searchState(
            @RequestBody Map<String, List<String>> request) throws Exception{
        if(!request.keySet().contains("search"))
            throw new InvalidSearchQueryException("Invalid or no search query. Query format: '{search: []}'");

        //Get all of the states if the search query is empty
        if (request.get("search").isEmpty())
            return new ResponseEntity<String>(consumer.consumeAll().toString(), HttpStatus.OK);

        //If it is not empty filter the states by name
        else {
            List<State> states = consumer.consumeAll().getRestResponse().getStates()
                    .stream()
                    .filter(state ->
                            //Set all states in query to lowercase
                            request.get("search")
                            .stream()
                            .map(String::toLowerCase)
                            .collect(Collectors.toList())
                            .contains(state.getName().toLowerCase()))
                    .collect(Collectors.toList());

            //In case no results are found for a passed name, throw exception
            if (states.isEmpty())
                throw new SearchResultException("No results found with the given query.");
            return new ResponseEntity<String>(states.toString(), HttpStatus.OK);
        }
    }
}
