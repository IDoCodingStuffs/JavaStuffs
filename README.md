# JavaStuffs

This repository is to showcase some handy projects (i.e stuffs) I have implemented in Java. Master branch holds
some of the highlights while specific branches showcase implementations grouped by purpose

### Showcased Stuffs

This branch showcases some of the highlights of my practice with Java

#### State Info API

 This is an API built with Spring Boot to retrieve information about a given state or states
 either through a GET request through an URI endpoint, or a POST request with a query of
 a given number of states. I built it as part of the coding test that got me my current job
 as a Java developer.

 ```
 @PostMapping(path = "/info/states/get/", consumes = "application/json", produces = "application/json")
public @ResponseBody
ResponseEntity<String> searchState(
        @RequestBody Map<String, List<String>> request) throws Exception {  
    //Get all of the states if the search query is empty
    if (request.get("search").isEmpty())
        return new ResponseEntity<String>(consumer.consumeAll().toString(), HttpStatus.OK);
    else {
           List<State> states = consumer.consumeAll().getRestResponse().getStates()
                .stream()
                .filter(state -> request.get("search").contains(state.getName()))
                .collect(Collectors.toList());
        return new ResponseEntity<String>(states.toString(), HttpStatus.OK);
    }
}
```

##### Example Query

```
> curl -H "Content-type: application/json" -d "{"""search""":["""Alabama""","""California""","""Idaho"""]}" http://localhost:8080/info/states/get/  
[{"id":1, "country":"USA", "name":"Alabama", "abbreviation":"AL", "area":"135767SKM", "largestCity":"Birmingham", "capital":"Montgomery"}, {"id":5, "country":"USA", "name":"California", "abbreviation":"CA", "area":"423967SKM", "largestCity":"Los Angeles", "capital":"Sacramento"}, {"id":12, "country":"USA", "name":"Idaho", "abbreviation":"ID", "area":"82643SKM", "largestCity":"Boise", "capital":"Boise"}]
```
