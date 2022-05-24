package avaliacao.hackathon.listeners;

import avaliacao.hackathon.model.entities.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class BaseEntityListener {

    // TODO: ATUALIZAR TAMBÉM O USUÁRIO RESPONSÁVEL PELA INSERÇÃO E ALTERAÇÃO

    @PrePersist
    public void onPrePersist(BaseEntity entity) {
        onPreUpdate(entity);
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity entity) {
        entity.setModifiedAt(LocalDateTime.now());
    }

}
