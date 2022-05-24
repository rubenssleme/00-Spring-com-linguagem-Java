package avaliacao.hackathon.model.enuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EvaluatorType {

    HARD("HARD"),
    SOFT("SOFT");

    private final String type;
}
