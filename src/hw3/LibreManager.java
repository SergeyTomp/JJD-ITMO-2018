package hw3;

/*Сделать библиотеку, которая ведет учет книг.
Должно быть как минимум два класса: Book и Library.
Library имеет два метода: void put(Book book, int quantity) и int get(Book book, int quantity).
Каждой книге в библиотеке соответствует счетчик, показывающий количество хранящихся книг, при добавлении книги - счетчик увеличивается, при извлечении - уменьшается на число quantity.
Поля класса Book: author, title, pagesNum.
Библиотека хранит ограниченное число книг, сколько - на ваше усмотрение.*/

import java.util.Hashtable;
import java.util.Scanner;

//сделал немного по-другому, количество книг хранится в экземпляре класса книга, так проще вести учёт.
//геттеры/сеттеры делать не стал, сейчас не это главное

class Library {
    void put(Book book) {
        if (book.counter == book.max) {
            System.out.println("Этот экземпляр книги не из нашей библиотеки!");
        }
        else{
            book.counter += 1;
            System.out.println("Книг " + book.title + " в наличии " + book.counter + " из " + book.max);
        }
    }
    void get (Book book){
        if (book.counter == 0){
            System.out.println ("Все книги на руках, зайдите позже.");
        }
        else {
            book.counter -= 1;
            System.out.println ("Пожалуйста возьмите, таких книг у нас ещё осталось " + book.counter);
        }
    }
}

class Book  {
    String author;
    String title;
    int pagesNum;
    int counter;
    int max;

    Book (String aut, String tit, int pgs, int cntr) {
        author = aut;   //автор
        title = tit;    //название
        pagesNum = pgs; //количество страниц, не используется пока
        counter = cntr; //счётчик остатка
        max = cntr;     //максимальное кол-во таких книг в библиотке
    }
}

public class LibreManager {
    public static void main (String [] args) {
        String title;
        Scanner put_get = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        int action;
        boolean exit = false;
        Library library = new Library();
        Hashtable <String, Book> catalog = new Hashtable <>();//фишка Hashtable - в качестве индекса можно использовать объект
        Book book1 = new Book("Автор_1", "Название_1", 100, 10);
        Book book2 = new Book("Автор_2", "Название_2", 100, 10);
        Book book3 = new Book("Автор_3", "Название_3", 100, 10);
        Book book4 = new Book("Автор_4", "Название_4", 100, 10);
        Book book5 = new Book("Автор_5", "Название_5", 100, 10);
        catalog.put (book1.title, book1);
        catalog.put (book2.title, book2);
        catalog.put (book3.title, book3);
        catalog.put (book4.title, book4);
        catalog.put (book5.title, book5);

        while (!exit) {
            System.out.println("Введите 1, если хотите сдать книгу, 2 - если взять, 0 - выйти.");
            action = put_get.nextInt();
            switch (action) {
                case 0:
                    System.out.println("До свидания, заходите ещё!");
                    exit = true;
                    break;
                case 1:
                    System.out.println("Введите название книги, которую хотите вернуть");
                    title = choice.nextLine();
                    if (catalog.get(title) != null) {
                        library.put(catalog.get(title));
                    }
                    else {
                        System.out.println ("Это книга не из нашей библиотеки, извините");
                    }
                    break;
                case 2:
                    System.out.println("Введите название книги, которую хотите взять");
                    title = choice.nextLine();
                    if (catalog.get(title) != null) {
                        library.get(catalog.get(title));
                    }
                    else {
                        System.out.println ("Такой книги у нас нет, извините");
                    }
                    break;
            }
        }
    }
}