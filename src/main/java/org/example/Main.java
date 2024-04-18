package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Цехи:");
        Factory.AddDepartment("Производственный цех");
        Factory.AddDepartment("Химический цех");

        System.out.println("-----------------------------");

        System.out.println("Вы работаете?");
        char work = scan.next().charAt(0);

        boolean working = Factory.AreYouWorking(work);

        if (!working)
        {
            System.out.println("Будешь работать?");
            char workornot = scan.next().charAt(0);
            if (workornot == 'y')
            {
                System.out.println("Введите имя");
                String name = scan.next();

                System.out.println("Кем будете работать?");
                String job = scan.next();

                Factory emp = new Factory();
                var worker = emp.AddYourJob(name, job);
                System.out.println(worker[0] + " | "  + worker[1]);
            }
        }
        else {
            System.out.println("Молодец");
            var tools = Factory.Tools();

            System.out.println("Посмотреть инструменты?");
            char wtchtool = scan.next().charAt(0);

            if (wtchtool == 'y')
            {
                System.out.println("-----------------------------");
                for (var item : tools)
                {
                    System.out.println(item);
                }
                System.out.print("Выберите инструмент ");
                int index = scan.nextInt();
                if (index < tools.length && index >= 0)
                {
                    System.out.print("Сколько инструментов? ");
                    int amount = scan.nextInt();
                    Factory tool = new Factory();
                    tool.HowManyTools(amount, tools[index]);

                    System.out.print("-----------------------------");
                    tool.ToolsInGeneral(tools.length + amount);
                }

            }
        }
    }

}
class Factory
{
    static Scanner scan = new Scanner(System.in);
    public static void AddDepartment(String text)
    {
        System.out.println(text);
    }

    public static boolean AreYouWorking(Character str)
    {
        if (str == 'y')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String[] Tools()
    {
        System.out.println("Сколько инструментов добавить?");
        int amount = scan.nextInt();

        String [] tools = new String[amount];

        System.out.println("Добавьте их в ваш арсенал.");
        for (int i = 0; i < tools.length; i++)
        {
            String aTool = scan.next();
            tools[i] = aTool;
        }
        return tools;
    }

    public String[] AddYourJob(String name, String job)
    {
        String [] jobber = {name, job};
        return jobber;
    }

    public String HowManyTools(int amount, String tool)
    {
        String text = amount + " " + tool;
        return text;
    }

    public int ToolsInGeneral(int amount)
    {
        return amount;
    }
}