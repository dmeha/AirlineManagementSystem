package Database;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void checkThatTheConfigIsReturningProperConfig(){

        // to be checked
        Config cTest = new Config(Mode.TEST);
        Config cDev = new Config(Mode.DEV);
        Config cProd = new Config(Mode.PROD);


        String[] Testbits = cTest.getUrl().split("/");
        String TestDB = Testbits[Testbits.length-1];

        String[] Devbits = cDev.getUrl().split("/");
        String DevDB = Devbits[Devbits.length-1];

        String[] Prodbits = cProd.getUrl().split("/");
        String ProdDB = Prodbits[Prodbits.length-1];



        //assert DB
        assertEquals("CSCI5308_12_TEST",TestDB);
        assertEquals("CSCI5308_12_DEVINT",DevDB);
        assertEquals("CSCI5308_12_PRODUCTION",ProdDB);

        //assert User names
        String TestUser = cTest.getUser();
        String DevUser = cDev.getUser();
        String ProdUser = cProd.getUser();

        assertEquals("CSCI5308_12_TEST_USER",TestUser);
        assertEquals("CSCI5308_12_DEVINT_USER",DevUser);
        assertEquals("CSCI5308_12_PRODUCTION_USER",ProdUser);

        //assert Passwords
        String TestPass = cTest.getPassword();
        String DevPass = cDev.getPassword();
        String ProdPass = cProd.getPassword();

        assertEquals("EJaiqueigahNg6cu",TestPass);
        assertEquals("AR6aixaephie7voo",DevPass);
        assertEquals("iewavi5AiZee7mah",ProdPass);


    }




}