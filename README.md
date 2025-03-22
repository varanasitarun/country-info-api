# country-info-api

Purpose:
Interacts with an external API to fetch country data.
**Dependencies**:
RestTemplate: Used for making HTTP requests.
UriComponentsBuilder: Builds dynamic URLs for API calls.
CountryNotFoundException: Custom exception for errors.
**Configuration**:
Set country.api.url in application.properties.
**Methods**:
getAllCountries():
Fetches and returns all countries from the API.
Returns an empty list if no data is found.
getCountryByName(String name):
Searches for a country by its name.
Throws CountryNotFoundException if the country is not found.
**Exception Handling:**

Throws CountryNotFoundException when:
No country data is found.
The country is not found by the given name.
**Constructor Injection:**

Injects RestTemplate via constructor.
**Annotations**:

@Service: Marks the class as a Spring service.
@Autowired: Automatically injects RestTemplate.
@Value("${country.api.url}"): Injects the API URL from configuration.
