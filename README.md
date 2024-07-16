# POKEDEMO

Pokedemo is a project that exposes a SOAP endpoint to retrieve a list of Pokemon based on an offset and size (limit).
The list is obtained through the Pokemon API https://pokeapi.co/api/v2/pokemon.

The project has 3 layers: Controller/Endpoint - Service/Facade - Adapter/API. Between layers there is an interface to minimize code coupling and there are also converters to decouple the way data moves across the layers.

There are two design patterns implemented in a simple way following some clean architecture rules: 
- DTO: To transport information in service layer.
- Facade: To centralize and provide an abstraction for business logic and integrations.

There are two unit tests implemented: PokemonApiTest and PokedemoFacadeTest

### STEPS TO RUN IN LOCALHOST:

- Maven clean and install
- Run PokedemoApplication.java, the application server is embedded.
- The WSDL will be in http://localhost:8080/ws/pokemons.wsdl
- Consume WSDL with SOAPUI

SOAP REQUEST EXAMPLE

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://www.example.com/pokedemo">
<soapenv:Header/>
<soapenv:Body>
<pok:GetPokemonListRequest>
<pok:Limit>5</pok:Limit>
<pok:Offset>5</pok:Offset>
</pok:GetPokemonListRequest>
</soapenv:Body>
</soapenv:Envelope>

SOAP RESPONSE EXAMPLE

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
<ns2:GetPokemonListResponse xmlns:ns2="http://www.example.com/pokedemo">
<ns2:Pokemon>
<ns2:Name>charizard</ns2:Name>
<ns2:Url>https://pokeapi.co/api/v2/pokemon/6/</ns2:Url>
<ns2:Score>46</ns2:Score>
</ns2:Pokemon>
<ns2:Pokemon>
<ns2:Name>squirtle</ns2:Name>
<ns2:Url>https://pokeapi.co/api/v2/pokemon/7/</ns2:Url>
<ns2:Score>40</ns2:Score>
</ns2:Pokemon>
<ns2:Pokemon>
<ns2:Name>wartortle</ns2:Name>
<ns2:Url>https://pokeapi.co/api/v2/pokemon/8/</ns2:Url>
<ns2:Score>73</ns2:Score>
</ns2:Pokemon>
<ns2:Pokemon>
<ns2:Name>blastoise</ns2:Name>
<ns2:Url>https://pokeapi.co/api/v2/pokemon/9/</ns2:Url>
<ns2:Score>59</ns2:Score>
</ns2:Pokemon>
<ns2:Pokemon>
<ns2:Name>caterpie</ns2:Name>
<ns2:Url>https://pokeapi.co/api/v2/pokemon/10/</ns2:Url>
<ns2:Score>66</ns2:Score>
</ns2:Pokemon>
</ns2:GetPokemonListResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>