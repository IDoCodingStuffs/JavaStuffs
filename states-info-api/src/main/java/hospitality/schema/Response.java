package hospitality.schema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    @JsonProperty("RestResponse")
    private RestResponse restResponse;

    public Response() {
    }


    @Override
    public String toString() {
        return "{" +
                "\"RestResponse\":" + restResponse +
                '}';
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
