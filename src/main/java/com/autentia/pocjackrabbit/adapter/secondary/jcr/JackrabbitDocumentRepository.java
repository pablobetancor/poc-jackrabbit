package com.autentia.pocjackrabbit.adapter.secondary.jcr;

import com.autentia.pocjackrabbit.ports.secondary.DocumentRepository;
import java.util.UUID;
import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import org.apache.jackrabbit.commons.JcrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Repository
public class JackrabbitDocumentRepository implements DocumentRepository {

  private static final Logger logger = LoggerFactory.getLogger(JackrabbitDocumentRepository.class);

  private final Repository repository;

  public JackrabbitDocumentRepository() throws RepositoryException {
    repository = JcrUtils.getRepository();
  }

  @Override
  public String add() {

    Session session;
    try {
      session = repository.login(new GuestCredentials());
    } catch (RepositoryException e) {
      logger.error("Error login in repository with guest credentials");
      throw new RuntimeException(e);
    }
    try {
      String user = session.getUserID();
      String name = repository.getDescriptor(Repository.REP_NAME_DESC);
      logger.info("Logged in as [{}] to a [{}] repository.", user, name);
    } finally {
      session.logout();
    }

    return UUID.randomUUID().toString();
  }
}
