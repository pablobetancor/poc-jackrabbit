package com.autentia.pocjackrabbit.application;

import com.autentia.pocjackrabbit.ports.secondary.DocumentRepository;
import org.springframework.stereotype.Component;

@Component
public class AddDocument {

  private final DocumentRepository documentRepository;

  public AddDocument(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  public String add() {
    return documentRepository.add();
  }

}
