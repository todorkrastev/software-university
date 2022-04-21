package com.manhattan.services.common;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SeedService {
    void seed() throws IOException, JAXBException;
}
