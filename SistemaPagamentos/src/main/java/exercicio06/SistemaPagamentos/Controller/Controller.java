package exercicio06.SistemaPagamentos.Controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller{
    @PostMapping("/transacoes")
    public ResponseEntity<Object> criarTransacao(@RequestBody Transacao request) {
        try{
            if(request.getContaOrigem() == null || request.getContaDestino() == null || request.getValor() <= 0) {
                throw new DadosInvalidosException("Dados da transação inválidos");
            }

            // Lógica de negócio para verificar saldo suficiente na conta de origem

            // Criar a transação

            // Retornar resposta de sucesso
            return ResponseEntity.status(HttpStatus.CREATED).body("Transação criada com sucesso");
        } catch (DadosInvalidosException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
        }
    }
    @GetMapping("/transacoes")
    public ResponseEntity<Object> criarTransacao() {
        return ResponseEntity.status(201).body(null);
    }
}