package exercicio06.SistemaPagamentos.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller{
    @PostMapping("/transacoes")
    public ResponseEntity<Object> criarTransacao(@RequestBody Transacao transacao) { // depois será criado um model Transacao para esse objeto
        // lógica de criação de transação, etc.
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> visualizarTodasTransacoes() {
        // lógica para puxar a lista de transações, etc.
        return ResponseEntity.status(HttpStatus.OK).body(ListaTransacoes);
    }

    @GetMapping("/transacoes/{transacaoId}")
    public ResponseEntity<Transacao> visualizarTransacao(@PathVariable int transacaoId) {
        // lógica para puxar a transação,etc.
        return ResponseEntity.status(HttpStatus.OK).body(transacao);
    }

}