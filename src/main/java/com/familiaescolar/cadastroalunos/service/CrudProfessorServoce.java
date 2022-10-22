package com.familiaescolar.cadastroalunos.service;

import com.familiaescolar.cadastroalunos.model.Professor;
import com.familiaescolar.cadastroalunos.repositorys.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudProfessorServoce {

    private final ProfessorRepository professorRepository;
    public CrudProfessorServoce(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void nune(Scanner scanner){
        Boolean isTrue= true;
        while (isTrue){
            System.out.println("Qual entidade voce que executar?\n" +
                    "PARA VOLTAR O MENU ANTERIOR DOGITE 0 \n 1-CADASTRAR NOVO PROFEFFO\n 2-atualizar\n 3-Listar todos os professores" +
                    "\n 4-Delataraparofessor\n 5-findById" );
            int opcao= scanner.nextInt();

            switch (opcao){
                case 1:
                    this.cadastrarProfessor(scanner);
                    break;
                case 2:
                    this.atualizarProfessor(scanner);
                    break;
                case 3:
                    this.ListarTodosProfessores();
                    break;
                case 4:
                    this.delatarProfessor(scanner);
                    break;
                case 5:
                    this.buscarProfesorPorId(scanner);
                    break;
                default:
                    isTrue=false;
            }
        }
        System.out.println();
    }




    private void cadastrarProfessor(Scanner scanner) {
        System.out.print("Digite o nome do professor: ");
        String name=scanner.next();
        System.out.print("Digite o prontuario do professor: ");
        String prontuario=scanner.next();
        Professor professor=new Professor(name,prontuario);
        professorRepository.save(professor);
        System.out.println("O professor "+ professor.getName() +" de prontuario "+ professor.getProntuario()+
                " foi salvo com sucesso. O ID do professor é "+ professor.getId()+"\n");
    }
    private void atualizarProfessor(Scanner scanner) {
        System.out.print("Digite o id do professor: ");
        Long id=scanner.nextLong();

        Optional<Professor>professor= this.professorRepository.findById(id);

        if (professor.isPresent()){
            System.out.print("Digite o nome do professor: ");
            String name=scanner.next();

            System.out.print("Digite o prontuario do professor: ");
            String prontuario=scanner.next();

            Professor prof=professor.get();
            prof.setName(name);
            prof.setProntuario(prontuario);

            professorRepository.save(prof);

            System.out.println("O professor "+ prof.getName() +" de prontuario "+ prof.getProntuario()+
                    " foi atualizado com sucesso. O ID do professor é "+ prof.getId()+"\n");

        }else {
            System.out.println("Id "+id+" é invalido!\n");
        }

    }
    private void ListarTodosProfessores() {
      Iterable<Professor>professors=this.professorRepository.findAll();
        for (Professor professor:professors){
            System.out.println(professor);
        }
    }

    private void delatarProfessor(Scanner scanner) {
        System.out.print("Digite o id do professor a ser deletado: ");
        Long id=scanner.nextLong();
        Optional<Professor>professor= this.professorRepository.findById(id);

        if (professor.isPresent()){
            this.professorRepository.deleteById(id);
            System.out.println("Professor delatado com sucesso!");

        }else{
            System.out.println("Professor não existe!");
        }
    }
    private void buscarProfesorPorId(Scanner scanner) {
        System.out.print("Digite o id do professor a ser buscado: ");
        Long id=scanner.nextLong();
        Optional<Professor>professor= this.professorRepository.findById(id);

        if (professor.isPresent()){
            System.out.println(professor);
        }else {
            System.out.println("Professor não existe!");
        }
    }

}



