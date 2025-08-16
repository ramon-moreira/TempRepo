package application;

import entities.Lesson;
import entities.Video;
import entities.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio_7PlataformaDeEnsino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Lesson> lessons = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados da " + i + "a aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Título: ");
            String title = sc.nextLine();

            if (type == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                sc.nextLine();
                lessons.add(new Video(title, url, seconds));
            } else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                sc.nextLine();
                lessons.add(new Task(title, description, questionCount));
            }
        }

        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.duration();
        }

        System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");

        sc.close();
    }
}