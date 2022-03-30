package com.manhattan.services.interfaces;

import com.manhattan.common.exceptions.ProblemNotFoundException;

public interface ServiceFactory {
    Service getService(int number) throws ProblemNotFoundException;
}
