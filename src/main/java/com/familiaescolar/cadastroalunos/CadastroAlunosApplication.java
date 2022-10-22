package com.familiaescolar.cadastroalunos;

import com.familiaescolar.cadastroalunos.service.CrudCiciplinaService;
import com.familiaescolar.cadastroalunos.service.CrudProfessorServoce;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CadastroAlunosApplication implements CommandLineRunner {

   private final CrudProfessorServoce crudProfessorServoce;
   private final CrudCiciplinaService crudCiciplinaService;
    public CadastroAlunosApplication(CrudProfessorServoce crudProfessorServoce, CrudCiciplinaService crudCiciplinaService) {
        this.crudProfessorServoce = crudProfessorServoce;
        this.crudCiciplinaService = crudCiciplinaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CadastroAlunosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Boolean isTrue = true;
        while (isTrue) {
            System.out.println("Escolha uma opção que voce deseja interagir!");
            System.out.println(" 0 para sair\n 1 para interagir com o professorq\n 2 para interagir com a diciplina");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    this.crudProfessorServoce.nune(scanner);
                    break;
                case 2:
                    this.crudCiciplinaService.nune(scanner);
                    break;
                default:
                    isTrue=false;

                    break;
            }


        }

    }

}





