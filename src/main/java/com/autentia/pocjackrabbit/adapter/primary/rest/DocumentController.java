package com.autentia.pocjackrabbit.adapter.primary.rest;

import com.autentia.pocjackrabbit.application.AddDocument;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {

  private final AddDocument addDocument;

  public DocumentController(AddDocument addDocument) {
    this.addDocument = addDocument;
  }

  @PostMapping
  public String addDocument() {
    return addDocument.add();
  }

}
