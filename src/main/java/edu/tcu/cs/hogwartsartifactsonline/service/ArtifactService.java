package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtifactService {

    private ArtifactDao artifactDao;

    // Spring will automatically inject an instance of ArtifactDao and an instance of IdWorker into this class
    public ArtifactService(ArtifactDao artifactDao) {
        this.artifactDao = artifactDao;
    }

    public List<Artifact> findAll() {
        return artifactDao.findAll();
    }

    public Artifact findById(String artifactId) {
        return artifactDao.findById(artifactId).get();
    }

    public void update(String artifactId, Artifact updatedArtifact) {
        updatedArtifact.setId(artifactId);
        artifactDao.save(updatedArtifact);
    }

    public void delete(String artifactId) {
        artifactDao.deleteById(artifactId);
    }
}
