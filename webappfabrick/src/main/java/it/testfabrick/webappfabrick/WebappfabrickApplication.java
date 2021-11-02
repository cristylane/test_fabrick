package it.testfabrick.webappfabrick;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.testfabrick.webappfabrick.model.Account;
import it.testfabrick.webappfabrick.model.AccountResult;
import it.testfabrick.webappfabrick.model.AccountResultPayload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class WebappfabrickApplication {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		String GET_URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts?accountId=14537780";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("api-key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");

		ResponseEntity<String> response = restTemplate.exchange(GET_URL, HttpMethod.GET, new HttpEntity(headers), String.class);

		String result = response.getBody();

		System.out.println(result);

		try {
			AccountResult accountResult = new ObjectMapper().readValue(result, AccountResult.class);

			System.out.println(accountResult.getStatus());

			AccountResultPayload payload = accountResult.getPayload();
			List<Account> acountList = payload.getList();
			System.out.println("Payload size: " + acountList.size());

			acountList.forEach(a -> {
				System.out.println(a);
			});

		}catch (Exception ex) {
			System.out.println(ex);
		}


	}

}
