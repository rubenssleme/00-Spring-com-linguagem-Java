package avaliacao.hackathon.model.enuns;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContextStatus {

    INITIALIZED("incializado"),
    PAUSED("Em pausa"),
    Finalized("Finalizado");

    private final String status;
}
