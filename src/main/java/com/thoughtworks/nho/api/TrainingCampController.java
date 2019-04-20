package com.thoughtworks.nho.api;

import com.thoughtworks.nho.dto.TrainingCampDetail;
import com.thoughtworks.nho.service.TrainingCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/training_camp")
@RestController
public class TrainingCampController {

    @Autowired
    private TrainingCampService trainingCampService;

    @RequestMapping(value="/detail",method = RequestMethod.POST)
    public TrainingCampDetail getDetail(String id) {
        return trainingCampService.getTrainingCampDetailById(id);
    }
}
