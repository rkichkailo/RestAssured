package com.it_academy.onliner.tests;

import com.academy.onliner.rest_utils.GetRequestUtils;
import com.academy.onliner.service.SushiveslaService;
import com.google.common.collect.ImmutableMap;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.academy.onliner.endpoints.OnlinerEndpoints.getSushiveslaEndPoint;
import static com.academy.onliner.rest_utils.ResponseBodyUtils.getStringValuesByJsonPath;
import static org.assertj.core.api.Assertions.assertThat;

public class APITest {

    @Test
    public void testOne() {
        var sushi = new SushiveslaService().getSushiveslaItems();
        assertThat(sushi)
                .as("Not each Sushi object has a name")
                .isNotEmpty()
                .allMatch(sushivesla -> !sushivesla.getName().isBlank());

        System.out.println(sushi);
    }

    @Test
    public void testTwo() {

        Map<String, Object> filterParams = ImmutableMap.of(
                "sushi_typ[0]", "roll",
                "sushi_typ[operation]", "union");

        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                getSushiveslaEndPoint(), null, filterParams);

        List<String> namePrefixes = getStringValuesByJsonPath(responseBody, "products.name_prefix");

        assertThat(namePrefixes)
                .as("Not each product in the API response has a name")
                .isNotEmpty()
                .allMatch(name -> name.equalsIgnoreCase("роллы"));
    }
}
