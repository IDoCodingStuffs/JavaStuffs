package hospitality.schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse {
    @JsonProperty("messages")
    private List<String> messages;
    @JsonProperty("result")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<State> states;

    @Override
    public String toString() {
        return "{" +
                //Make sure each message is wrapped in quotes
                "\"messages\":" + messages.stream()
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(", ")) +
                ", \"states\":" + states +
                '}';
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
