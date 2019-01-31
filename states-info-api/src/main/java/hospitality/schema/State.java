package hospitality.schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    @JsonProperty("id")
    private int id;
    @JsonProperty("country")
    private String country;
    @JsonProperty("name")
    private String name;
    @JsonProperty("abbr")
    private String abbr;
    @JsonProperty("area")
    private String area;
    @JsonProperty("largest_city")
    private String largest_city;
    @JsonProperty("capital")
    private String capital;

    public State() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbr;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbr = abbreviation;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLargestCity() {
        return largest_city;
    }

    public void setLargestCity(String largestCity) {
        this.largest_city = largestCity;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"country\":\"" + country + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"abbreviation\":\"" + abbr + '\"' +
                ", \"area\":\"" + area + '\"' +
                ", \"largestCity\":\"" + largest_city + '\"' +
                ", \"capital\":\"" + capital + '\"' +
                '}';
    }
}
