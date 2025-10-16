package webrun;

import app.Evento;
import esd.ListaSequencial;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import app.App;

@RestController
@RequestMapping("/agenda/eventos")
public class EsdController {

    private App app = new App();

    @PostMapping("/")
    ResponseEntity<Integer> novo_evento(@RequestBody Evento evento) {
        ResponseEntity<Integer> result;

        try {
            int id = app.adiciona_evento(evento);
            result = new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            result = new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }

        return result;
    }

    @GetMapping("/")
    List<Evento> todos_eventos(@RequestParam(name="inicio", required=false)
                               @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
                               @RequestParam(name="fim", required=false)
                               @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        ListaSequencial<Evento> l_ev;
        if (inicio != null && fim != null) {
            l_ev = app.eventos();
        } else {
            l_ev = app.lista_eventos(inicio, fim);
        }
        ArrayList<Evento> result = new ArrayList<>();

        for (int j=0; j < l_ev.comprimento(); j++) {
            result.add(l_ev.obtem(j));
        }

        return result;
    }

    @GetMapping("/{id}")
    ResponseEntity<Evento> obtem_evento(@PathVariable int id) {
        ResponseEntity<Evento> r;

        try {
            r = new ResponseEntity<>(app.obtem_evento(id), HttpStatus.OK);
        }catch (InvalidParameterException e) {
            r = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return r;
    }

    @PutMapping("/{id}")
    void edita_evento(@PathVariable int id, @RequestBody Evento evento) {
        app.edita_evento(evento);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Evento> remove_evento(@PathVariable int id) {
        ResponseEntity<Evento> r;

        try {
            r = new ResponseEntity<>(app.remove_evento(id), HttpStatus.OK);
        }catch (InvalidParameterException e) {
            r = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return r;
    }

    @GetMapping("/sugestao")
    ResponseEntity<String> procura_horario(@RequestParam(name="inicio")
                                           @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
                                           @RequestParam(name="fim")
                                           @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
                                           @RequestParam int duracao) {
        ResponseEntity<String> result;

        LocalDateTime data_horario = app.procura_horario(inicio, fim, duracao);
        if (data_horario == null) {
            result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            result = new ResponseEntity<>(data_horario.toString(), HttpStatus.OK);
        }

        return result;
    }
}
