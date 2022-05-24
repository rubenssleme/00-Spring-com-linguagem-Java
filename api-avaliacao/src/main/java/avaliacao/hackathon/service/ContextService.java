package avaliacao.hackathon.service;

import avaliacao.base.utils.AuthUtil;
import avaliacao.hackathon.mapper.ContextMapper;
import avaliacao.hackathon.model.dto.ContextDTO;
import avaliacao.hackathon.model.entities.Context;
import avaliacao.hackathon.model.response.ContextOperationResponse;
import avaliacao.hackathon.model.response.ContextResponse;
import avaliacao.hackathon.repository.ContextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContextService {

    private final ContextRepository contestRepository;
    private final ContextMapper mapper;
    private final AuthUtil authUtil;

    public ContextOperationResponse createSimpleContext(ContextDTO dto) {

        //TODO: VALIDACOES, AUTH...
        Context context = mapper.contextDtoToContext(dto);
        context.setCreatedBy("faruque.braimo@briteris.com");
        context.setCreatedAt(LocalDateTime.now());
        context.setModifiedBy("faruque.braimo@briteris.com");
        context.setModifiedAt(LocalDateTime.now());

        contestRepository.save(context);

        return ContextOperationResponse.builder().operationSuccess(true).errorMessage(null).build();

    }

    public List<ContextResponse> getContexts() {
        return mapper.contextDTOTOList(contestRepository.getAllContexts());
    }

}
