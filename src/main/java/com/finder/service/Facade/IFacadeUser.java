package com.finder.service.Facade;

import java.io.IOException;

/**
 * Created by jerem on 18/03/2018.
 */

public interface IFacadeUser {


    boolean verify(String mail, String password) throws IOException;
}
