package com.thoughtworks.nho.api;

import com.thoughtworks.nho.domain.TrainingCamp;
import com.thoughtworks.nho.dto.TrainingCampDetail;
import com.thoughtworks.nho.service.TrainingCampService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/training_camp")
@RestController
public class TrainingCampController {

    @Autowired
    private TrainingCampService trainingCampService;

    @GetMapping(value="/detail")
    public TrainingCampDetail getDetail(String id) {
        return trainingCampService.getTrainingCampDetailById(id);
    }


    @GetMapping("list")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingCamp> list() {
        return trainingCampService.findAllTrainingCamp();
    }


    @PostMapping("creat")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody TrainingCamp trainingCamp) {
        try {
            trainingCampService.saveTrainCamp(trainingCamp);
            return "success";
        } catch (Exception e) {
            log.error(e.toString());
            return "error";
        }

    }

    @PostMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestBody String id) {
        try {
            trainingCampService.deleteTrainCamp(id);
            return "success";
        } catch (Exception e) {
            log.error(e.toString());
            return "error";
        }

    }
}
