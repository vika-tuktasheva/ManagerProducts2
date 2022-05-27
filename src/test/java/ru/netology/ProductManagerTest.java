package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {

    //тест на проверку успешности удаления существующего товара
    @Test
    void removeIdSuccess() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product smartphone1 = new Smartphone(2, "Xiaomi", 40000, "China");

        Product[] expected = new Product[]{book1};
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(smartphone1);

        repository.removeId(2);

        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //тест на генерацию ошибки при удалении несуществующего товара
    @Test
    void removeIdErrorGeneration() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product smartphone1 = new Smartphone(2, "Xiaomi", 40000, "China");

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(smartphone1);

        assertThrows(NotFoundException.class, () -> {
            repository.removeId(3);
        });
    }
}