package com.team.build.mindtech.exception.error;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErro( String mensagem, List<CampoDetalheErro> detalhes, String uri, LocalDateTime horario) {
}
