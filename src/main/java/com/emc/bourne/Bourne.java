package com.emc.bourne;

import org.apache.log4j.Logger;
import org.graphwalker.Util;
import org.graphwalker.generators.PathGenerator;

import java.io.File;

public class Bourne extends org.graphwalker.multipleModels.ModelAPI {
    private static Logger logger = Util.setupLogger(Bourne.class);

    public Bourne(File model, boolean efsm, PathGenerator generator, boolean weight) {
        super(model, efsm, generator, weight);
    }


    /**
     * This method implements the Edge 'e_Initialize'
     *
     */
    public void e_Initialize() {
    }


    /**
     * This method implements the Edge 'e_StartEngine'
     *
     */
    public void e_StartEngine() {
    }


    /**
     * This method implements the Vertex 'v_INIT'
     *
     */
    public void v_INIT() {
    }


    /**
     * This method implements the Vertex 'v_Pending'
     *
     */
    public void v_Pending() {
    }


}
