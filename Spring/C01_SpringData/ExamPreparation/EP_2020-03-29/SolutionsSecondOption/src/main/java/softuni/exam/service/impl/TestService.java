package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final Gson gson;

    @Autowired
    public TestService(Gson gson) {
        this.gson = gson;
    }
}
