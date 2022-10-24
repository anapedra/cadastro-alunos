package com.familiaescolar.cadastroalunos.service;

import com.familiaescolar.cadastroalunos.model.Diciplinas;
import com.familiaescolar.cadastroalunos.repositorys.DiciplinaReposiry;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCiciplinaService {

    private final DiciplinaReposiry diciplinaReposiry;
    public CrudCiciplinaService(DiciplinaReposiry diciplinaReposiry) {
        this.diciplinaReposiry = diciplinaReposiry;
    }

    public void nune(Scanner scanner){
        Boolean isTrue= true;
        while (isTrue){
            System.out.println("Qual entidade voce que executar?\n" +
                    "PARA VOLTAR O MENU ANTERIOR DOGITE 0 \n 1-CADASTRAR NOVO Diciplina\n  2-ATUALIZAR DICIPLINA\n 3-Listar TODAS AS DICIPLINA" +
                    "\n 4-DELATAR DICIPLINA\n 5-BUSCAR DICIPLINA POR ID" );
            int opcao= scanner.nextInt();

            switch (opcao){
                case 1:
                    this.cadastrarDiciplina(scanner);
                    break;
                case 2:
                    this.atualizarDiciplina(scanner);
                    break;
                case 3:
                    this.ListarTodosDiciplinas();
                    break;
                case 4:
                    this.delatarDiciplina(scanner);
                    break;
                case 5:
                    this.buscarDiciplinaPorId(scanner);
                    break;
                default:
                    isTrue=false;
            }
        }
        System.out.println();
    }




    private void cadastrarDiciplina(Scanner scanner) {
        System.out.print("Digite o nome da diciplina: ");
        String name=scanner.next();
        System.out.print("Digite o semestre da diciplina: ");
        Integer semestre=scanner.nextInt();

        Diciplinas diciplinas =new Diciplinas();
        diciplinaReposiry.save(diciplinas);

        System.out.println("A diciplina "+ diciplinas.getNome() +" do semestre "+ diciplinas.getSemestre()+
                " foi salva com sucesso. O ID da diciplina é "+ diciplinas.getId()+"\n");
    }
    private void atualizarDiciplina(Scanner scanner) {
        System.out.print("Digite o id da diciplina: ");
        Long id=scanner.nextLong();

        Optional<Diciplinas> diciplinas= this.diciplinaReposiry.findById(id);

        if (diciplinas.isPresent()){
            System.out.print("Digite o nome da diciplina: ");
            String name=scanner.next();

            System.out.print("Digite o semetreda diciplina: ");
            Integer semestreo=scanner.nextInt();

            Diciplinas dicipli=diciplinas.get();
            dicipli.setNome(name);;
            dicipli.setSemestre(semestreo);

            diciplinaReposiry.save(dicipli);

            System.out.println("A diciplina "+ dicipli.getNome()+" do semestre "+ dicipli.getSemestre()+
                    " foi atualizada com sucesso. O ID da diciplina é "+ dicipli.getId()+"\n");

        }else {
            System.out.println("Id "+id+" da diciplina é invalido!\n");
        }

    }
    private void ListarTodosDiciplinas() {
        Iterable<Diciplinas>diciplinas=this.diciplinaReposiry.findAll();
        for (Diciplinas diciplina : diciplinas){
            System.out.println(diciplina);
        }
    }

    private void delatarDiciplina(Scanner scanner) {
        System.out.print("Digite o id da diciplina a ser deletada: ");
        Long id=scanner.nextLong();
        Optional<Diciplinas>diciplinas= this.diciplinaReposiry.findById(id);

        if (diciplinas.isPresent()){
            this.diciplinaReposiry.existsById(id);
            System.out.println("A diciplina foi delatada com sucesso!");

        }else{
            System.out.println("Professor não existe!");
        }
    }
    private void buscarDiciplinaPorId(Scanner scanner) {
        System.out.print("Digite o id da diciplina a ser buscado: ");
        Long id=scanner.nextLong();
        Optional<Diciplinas>diciplina= this.diciplinaReposiry.findById(id);

        if (diciplina.isPresent()){
            System.out.println(diciplina);
        }else {
            System.out.println("Diciplina não existe!");
        }
    }

}





