package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//REST = Representational State Transfer
// Eh um modelo de arquitetura para sistemas distribuidos. (Um sistema conversando com outro)
/*
*   GET para consultar
*   POST para cadastrar
*   PUT para alterar
*   DELETE para apagar
* */
@RestController // faz ser desnecessario o ResponseBody
@RequestMapping("/topicos") // tds os metodos da classe responderao aqui
public class TopicosController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    // nao eh uma boa retornar a classe de dominio, pois pode retornar info desnecessaria ou que quebre a seguranca
    // cria-se uma classe para retornar apenas os campos que se deve devolver. (Dto)

   // @RequestMapping(value="/topicos", method = RequestMethod.GET)// para receber param GET, basta pedir o param no metodo
    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
//        System.out.println(nomeCurso);
        // criando os topicos em memoria
//        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
//        Topico t = topico;
//        return TopicoDto.converter(Arrays.asList(topico, topico, topico));

        //aqui esta carregando todos os registros.
        if(nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }
        else{ // se criar o metodo com essa nomenclatura, findByCampo, o spring consegue gerar a query automaticamente.
            //List<Topico> topicos = topicoRepository.findByTitulo(nomeCurso);
            //curso eh a entidade de relacionamento e nome eh dentro de curso, assim vai
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            //nome do atributo do relacionamento -> nome do atributo no relacionamento
            /*por CursoNome, pode rolar ambiguidade, se dentro de Topico houver um atributo chamado CursoNome, e em Curso -> houver nome.
            Para resolver, vc pode usar underline, que diz ao Spring que eh dentro de curso!
            * */
            return TopicoDto.converter(topicos);
        }
    }
    // se fosse void, o Spring devolveria 200. o @Valid diz para rodar as validacoes do bean validation
    // se tiver errado, ne entra no metodo.
    @PostMapping // requestBody: Spring, pege do corpo da requisicao e nao por GET
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){


        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        //{id} entre chave p dizer que eh um campo dinamico
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
    @GetMapping("/{id}") // PathVariable diz que vem na URL e joga no param. tem q ser o msm nome (id, id)
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id){
        Optional topico = topicoRepository.findById(id);
        if(topico.isPresent())
            return ResponseEntity.ok(new DetalhesDoTopicoDto((Topico) topico.get()));

        return ResponseEntity.notFound().build();
    }
    // pd ser o put ou path
    // O put geralmente eh qnd quer sobreescrever o recurso inteiro.
    //o patch vc so quer alterar um ou alguns campos e n necessariamente todos.
    // Mas na aplicacao nao da p saber se eh 1 ou varios, so verificando
    // entao o pessoal usam  Put no geral.
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
        Optional<Topico> optional = topicoRepository.findById(id);
        if(optional.isPresent()) {
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional // td metodo que tem a alteracao de escrita
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> optional = topicoRepository.findById(id);
        if(optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
/*
* Dto -> sao dados que SAEM da API para o Cliente
* Form -> Sao dados que vem do cliente para a API. Eh um DTO, mas eh um padrao
* */
