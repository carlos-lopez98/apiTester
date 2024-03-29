package com.solvd.apiTester.api;


import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.junit.jupiter.api.Test;

public class DogBreedAPITest implements IAbstractTest {
    private final static Logger LOGGER = LogManager.getLogger(DogBreedAPITest.class);


    @Test()
    public void getAll_retrievesAllBreeds(){
        LOGGER.info("test");
        GetAllBreeds getAllBreeds = new GetAllBreeds();
        getAllBreeds.callAPIExpectSuccess();
        getAllBreeds.validateResponseAgainstSchema("src/test/resources/breeds/_getAll/rs.schema");
    }

    @Test()
    public void getByBreed_retrievesBreed(){

    LOGGER.info("test");
    GetByBreed getByBreed    = new GetByBreed();
    getByBreed.callAPIExpectSuccess();
    getByBreed.validateResponseAgainstSchema("src/test/resources/breeds/_getByBreed/rs.schema");
    }

    @Test
    public void getBreedByNull_returnsError(){
        LOGGER.info("test");
        GetByBreed getByBreed = new GetByBreed();
        getByBreed.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getByBreed.validateResponseAgainstSchema("src/test/resources/breeds/_getByBreed/rs.schema");
    }

    @Test
    public void getRandomBreed_returnsRandom(){
        LOGGER.info("test");
        GetRandomBreed getByRandom = new GetRandomBreed();
        getByRandom.callAPIExpectSuccess();
        getByRandom.validateResponseAgainstSchema("src/test/resources/breeds/_getRandomBreed/rs.schema");
    }

    @Test
    public void getSubBreedByBreed_returnsSubBreedsInList(){
        LOGGER.info("test");
        GetSubBreedsByBreed getSubBreedsByBreed = new GetSubBreedsByBreed();
        getSubBreedsByBreed.callAPIExpectSuccess();
        getSubBreedsByBreed.validateResponseAgainstSchema("src/test/resources/breeds/_getSubBreedByBreed/rs.schema");
    }

    @Test
    public void getSubBreedByNull_returnsError(){
        LOGGER.info("test");
        GetSubBreedNull getSubBreedNull = new GetSubBreedNull();
        getSubBreedNull.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getSubBreedNull.validateResponseAgainstSchema("src/test/resources/breeds/_getSubBreedsByNull/rs.schema");
    }

}
