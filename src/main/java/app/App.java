package app;

import esd.ListaSequencial;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;

/*
Para testar seu programa, execute-e e então acesse o seguinte link:
http://localhost:8080/
 */

/** Classe que representa a aplicação. O nome dela obrigatoriamente deve ser App
 * @author Marcelo M. Sobral
 * @version 1.0
 */
public class App {

    // adicione aqui atributos necessários para esta aplicação
    // Se achar necessário, você pode criar novas classes ...

    /*
    Construtor da App: executa qualquer inicialização necessária em sua aplicação de agendas
    @throws            Dispara uma exceção InvalidParameterException se houver qualquer problema
     */
    public App() {
        // ???
    }

    /*
    Retorna todos os eventos da agenda
    @return uma lista contendo os eventos
     */
    public ListaSequencial<Evento> eventos() {
        return null;
    }


    /*
    Adiciona um evento à agenda
    @param evento  Um objeto Evento que descreve o evento a ser adicionado
    @return         número de identificação do evento
    @throws        Dispara uma exceção InvalidParameterException se evento não puder ser adicionado
     */
    public int adiciona_evento(Evento evento) {
        return -1;
    }

    /*
    Obtém o evento identificado pelo número "id"
    @return um objeto Evento com o evento encontrado
    @throws InvalidParameterException caso não exista
     */
    public Evento obtem_evento(int id) {
        throw new InvalidParameterException("inexistente");
    }

    /*
    Obtém os eventos cujos inícios ocorram entre "inicio" e "fim"
    @return uma lista de objetos Evento
     */
    public ListaSequencial<Evento> lista_eventos(LocalDateTime inicio, LocalDateTime fim) {
        return null;
    }

    /*
    Remove o evento identificado pelo número "id"
    @return o evento removido
    @throws InvalidParameter Exception se evento não existir
    */
    public Evento remove_evento(int id) {
        return null;
    }

    /* Modifica o evento identificado pelo objeto Evento. Isso pode alterar sua descrição, início e/ou duração
    @throws Dispara InvalidParmeterException se não puder modificar o evento (ex: novo início e/ou duração conflitam com outro evento)
     */
    public void edita_evento(Evento evento) {

    }

    /* Procura um horário em que caiba um novo envento que se deseja criar
        Os parãmetros inicio e fim são limites de tempo para o horário procurado, e duracao é a duração do evento.
        Este método não cria o evento no horário encontrado. Ele apenas sugere um horário encontrado.
        @return o horário sugerido, ou null caso não o encontre
     */
    public LocalDateTime procura_horario(LocalDateTime inicio, LocalDateTime fim, int duracao) {
        return null;
    }
}
