package com.emc.bourne;

import org.graphwalker.conditions.TestCaseLength;
import org.graphwalker.exceptions.StopConditionException;
import org.graphwalker.generators.RandomPathGenerator;
import org.graphwalker.multipleModels.ModelHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class BourneTest {

    @Test
    public void random() throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();

        // Get the model from resources
        URL url;
        url = BourneTest.class.getResource("/com/emc/bourne/Bourne.graphml");

        File file = new File(url.toURI());

        // Connect the model to a java class, and add it to graphwalker's modelhandler.
        // The model is to be executed using the following criteria:
        // EFSM:           Extended finite state machine is set to true, which means we are using the data domain
        //                 in the model
        // Generator:      random, walk through the model randomly
        // Stop condition: Let the sequence be 20 steps long (pairs of edges and vertices)
        modelhandler.add("Bourne", new Bourne(file, true, new RandomPathGenerator(new TestCaseLength(20)), false));

        // Start executing the test
        modelhandler.execute("Bourne");

        // Verify that the execution is complete, fulfilling the criteria from above.
        Assert.assertTrue(modelhandler.isAllModelsDone(), "Not all models are done");

        //Print the statistics from graphwalker
        String actualResult = modelhandler.getStatistics();
        System.out.println(actualResult);
    }

}