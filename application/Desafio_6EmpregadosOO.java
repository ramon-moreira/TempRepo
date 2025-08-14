package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department2;
import entities.Employee;

public class Desafio_6EmpregadosOO {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String deptName = sc.nextLine();

        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        Address address = new Address(email, phone);
        Department2 dept = new Department2(deptName, payDay, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee(name, salary);
            dept.addEmployee(emp);
        }

        showReport(dept);
        sc.close();
    }

    private static void showReport(Department2 dept) {
        System.out.println();
        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.printf("Departamento %s = R$ %.2f%n", dept.getName(), dept.payroll());
        System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
        System.out.println("Funcionários:");
        for (Employee emp : dept.getEmployee()) {
            System.out.println(emp.getName());
        }
        System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
    }
}