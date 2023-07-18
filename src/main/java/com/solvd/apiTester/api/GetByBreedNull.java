package com.solvd.apiTester.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "{base_url}/breed//images", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "src/test/resources/breeds/_getByBreedNull/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetByBreedNull extends AbstractApiMethodV2 {

    public GetByBreedNull() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
