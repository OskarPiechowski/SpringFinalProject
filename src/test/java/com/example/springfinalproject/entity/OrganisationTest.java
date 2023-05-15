package com.example.springfinalproject.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganisationTest {

    @Test
    void setName1() {
        String expectedName = "Ex";
        Organisation organisation = new Organisation();
        organisation.setName(expectedName);

        String actualName = organisation.getName();

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void setName2() {
        String expectedName = "ExampleOrgExampleOrg";
        Organisation organisation = new Organisation();
        organisation.setName(expectedName);

        String actualName = organisation.getName();

        Assertions.assertEquals(expectedName, actualName);
    }

    //Ten test sprawdza, czy setter przyjmie nazwę dłuższą niż 20 znaków.
    //PRZYJMUJE!!!!!
    //Zapisy ograniczające są zapisami informacyjnymi, tylko co je używa?
    //Natomiast w bazie działa tylko wartość @Size(max = 20), bo ogranicza rozmiar pola w bazie,
    //ale @Size(min = 2) nie robi nic dla settera.
    //Aby skorzystać z tych ograniczeń, w klasach service należy dodać adnotację @Validated i wtedy
    //przed zapisem encji, w której występują te ograniczenia, będą one walidowane przez mechanizm Bean Validation,
    // ale to powoduje konieczność dodania obsługi błędów!!!! które mogą się pojawić przy zapisie encji.
    @Test
    void setName3() {
        String expectedName = "ExampleOrgExampleOrgExampleOrg";
        Organisation organisation = new Organisation();
        organisation.setName(expectedName);

        String actualName = organisation.getName();

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void setName4() {
        String expectedName = "E";
        Organisation organisation = new Organisation();
        organisation.setName(expectedName);

        String actualName = organisation.getName();

        Assertions.assertEquals(expectedName, actualName);
    }
}