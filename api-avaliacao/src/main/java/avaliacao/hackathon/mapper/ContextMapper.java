package avaliacao.hackathon.mapper;

import avaliacao.hackathon.model.dto.ContextDTO;
import avaliacao.hackathon.model.entities.Context;
import avaliacao.hackathon.model.response.ContextResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContextMapper {

    Context contextDtoToContext(ContextDTO contextDTO);

    List<ContextResponse> contextDTOTOList(List<ContextDTO> context);
}
