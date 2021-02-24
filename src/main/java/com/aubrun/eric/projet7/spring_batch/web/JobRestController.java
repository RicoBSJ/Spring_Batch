package com.aubrun.eric.projet7.spring_batch.web;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestController {

    private JobLauncher jobLauncher;
}
