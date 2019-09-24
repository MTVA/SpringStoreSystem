package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.resource;

import com.example.depositodeideias.repository.CityRepository;
import com.example.depositodeideias.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CitieAndStateResource {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @PostMapping(path = ServiceURIS.OPENSERVICES_AGREEMENT_UPDATECITIESANDSTATE)
    public ResponseEntity<ResponseFrameResource<Boolean>> populate(@RequestBody String json) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://servicodados.ibge.gov.br/api/v1/localidades/estados");

        ObjectMapper mapper = new ObjectMapper();


        HttpResponse response = client.execute(httpGet);
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        String jsonInString = result.toString();

        //Transformar o retorno da API numa lista de Estados
        List<StateDTO> listOfStates = mapper.readValue(jsonInString, new TypeReference<List<StateDTO>>() {
        });

        for (StateDTO state : listOfStates) {
            State newState = new State();
            newState.setId(Long.parseLong(state.getId()));
            newState.setName(state.getNome());
            newState.setUf(state.getSigla());

            stateRepository.save(newState);


            //Preencher Cidades
            HttpClient clientCity = HttpClientBuilder.create().build();
            httpGet = new HttpGet("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" +
                    state.getId() + "/municipios");


            response = clientCity.execute(httpGet);
            br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            result = new StringBuffer();
            line = "";
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            jsonInString = result.toString();

            //Transformar o retorno da API numa lista de Cidades
            List<CityDTO> listOfCities = mapper.readValue(jsonInString, new TypeReference<List<CityDTO>>() {
            });

            for (CityDTO city : listOfCities) {

                City newCity = new City();
                newCity.setId(Long.parseLong(city.getId()));
                newCity.setState(newState);
                newCity.setName(city.getNome());

                cityRepository.save(newCity);
            }
        }

        return new ResponseFrameResource(true).toResponseEntity(HttpStatus.OK);
    }
}
