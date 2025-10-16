package app;

import java.time.LocalDateTime;

public record Evento(int id, LocalDateTime inicio, int duracao, String nome, String descricao) {
}
