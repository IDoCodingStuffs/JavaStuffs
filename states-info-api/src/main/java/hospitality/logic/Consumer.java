package hospitality.logic;

import hospitality.schema.Response;
import org.springframework.web.client.RestTemplate;

public class Consumer {

    public Response consumeState(String state) throws Exception{
        final String sourceURL = "http://services.groupkt.com/state/get/USA/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(sourceURL + state,
                Response.class);
    }

    public Response consumeAll() throws Exception{
        final String sourceURL = "http://services.groupkt.com/state/get/USA/all";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(sourceURL,
                Response.class);
        }
}
