package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.QueryDto;
import com.example.footballquizproject.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class QueryController {

    private final QueryService queryService;
    @PostMapping("/admin/send-query")
    public ResponseEntity<?> sendQuery(@RequestBody QueryDto queryDto){

        queryService.save(queryDto);

        return ResponseEntity
                .ok()
                .body(queryDto);
    }
}
